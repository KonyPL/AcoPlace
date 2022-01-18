package put.poznan.AcoPlaceBackend.repository;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.ObjectUtils;

import com.google.common.collect.Maps;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import put.poznan.AcoPlaceBackend.criteria.AnnouncementSearchCriteria;
import put.poznan.AcoPlaceBackend.dto.AnnouncementDto;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.repository.support.AcoJpaRepository;
import put.poznan.AcoPlaceBackend.repository.support.QueryCallback;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long>, AcoJpaRepository {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH)
    List<Announcement> findAll(@Nullable Specification<Announcement> spec);
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH)
    Optional<Announcement> findById(Integer id);

    default List<AnnouncementDto> findAnnouncements(AnnouncementSearchCriteria criteria) {
        return this.findAll(new QueryCallback<List<AnnouncementDto>>() {

            @SuppressWarnings("unchecked")
            @Override
            public List<AnnouncementDto> doWithEntityManager(EntityManager entityManager) {
                Map<String, Object> queryParams = criteria.buildQueryParameters();

                StringBuilder builder = new StringBuilder();
                // SELECT
                builder.append("SELECT " + System.lineSeparator());
                builder.append("  a.id as a_id, a.title, a.country, a.state, a.city, " + System.lineSeparator());
                builder.append("  a.district, a.property_type, a.price, a.currency," + System.lineSeparator());
                builder.append("  a.available_from " + System.lineSeparator());

                // FROM
                builder.append("FROM public.announcement a " + System.lineSeparator());
                if (queryParams.get("detailsPresent") != null || queryParams.get("internetSpeed") != null ) {
                    builder.append("  INNER JOIN public.announcement_details a_d ON a.id = a_d.announcement_id " + System.lineSeparator());
                }

                // WHERE
                builder.append("WHERE 1 = 1 " + System.lineSeparator());
                if (queryParams.get("priceMin") != null) {
                    builder.append("  AND a.price between :priceMin AND :priceMax " + System.lineSeparator());
                }
                if (queryParams.get("availableFrom") != null) {
                    builder.append("  AND a.available_from <= :availableFrom " + System.lineSeparator());
                }
                if (queryParams.get("title") != null) {
                    builder.append("  AND a.title ilike :title " + System.lineSeparator());
                }
                if (queryParams.get("propertyType") != null) {
                    builder.append("  AND a.property_type like :propertyType " + System.lineSeparator());
                }
                if (queryParams.get("livingSpace") != null) {
                    builder.append("  AND a.living_space >= :livingSpace " + System.lineSeparator());
                }
                if (queryParams.get("internetSpeed") != null) {
                    builder.append("  AND a_d.internet_speed >= :internetSpeed " + System.lineSeparator());
                }

                String[] detailParamsToBuild = {"bath","shower","microwave","oven","petsAllowed","elevator","nearPark"};

                for(String param : detailParamsToBuild){
                    if (queryParams.get(param) != null) {
                        String dbField = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, param);
                        builder.append("  AND a_d." + dbField + " = :" + param + " " + System.lineSeparator());
                    }
                }


                // Create query
                String nativeQuery = builder.toString();
                Query query = entityManager.createNativeQuery(nativeQuery, "AnnouncementDtoMapping");

                // Set query parameters
                if (queryParams.get("priceMin") != null) {
                    query.setParameter("priceMin", queryParams.get("priceMin"));
                    query.setParameter("priceMax", queryParams.get("priceMax"));
                }

                String[] possibleParams = {"availableFrom","title","propertyType","livingSpace","internetSpeed","bath",
                        "shower", "microwave","oven","petsAllowed","elevator","nearPark"};

                //Set all params specified in possibleParams
                for(String param : possibleParams){
                    if (queryParams.get(param) != null) {
                        query.setParameter(param, queryParams.get(param));
                    }
                }

                return query.getResultList();
            }
        });
    }
}

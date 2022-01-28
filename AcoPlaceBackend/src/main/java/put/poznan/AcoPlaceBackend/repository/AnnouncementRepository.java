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
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer>, AcoJpaRepository {

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
                if (queryParams.get("detailsPresent") != null || queryParams.get("internetSpeed") != null) {
                    builder.append(" INNER JOIN public.announcement_details a_d ON a.id = a_d.announcement_id " + System.lineSeparator());
                }
                if (queryParams.get("propertyType") == "ROOM") {
                    builder.append(" INNER JOIN public.room_details r_d ON a.id = r_d.announcement_id " + System.lineSeparator());
                } else if (queryParams.get("propertyType") == "FLAT") {
                    builder.append(" INNER JOIN public.flat_details f_d ON a.id = f_d.announcement_id " + System.lineSeparator());
                } else if (queryParams.get("propertyType") == "HOUSE") {
                    builder.append(" INNER JOIN public.house_details h_d ON a.id = h_d.announcement_id " + System.lineSeparator());
                }

                // WHERE
                builder.append("WHERE 1 = 1 AND a.active = true " + System.lineSeparator());
                if (queryParams.get("priceMin") != null) {
                    builder.append("  AND a.price between :priceMin AND :priceMax " + System.lineSeparator());
                }
                if (queryParams.get("availableFrom") != null) {
                    builder.append("  AND a.available_from <= :availableFrom " + System.lineSeparator());
                }
                if (queryParams.get("title") != null) {
                    builder.append("  AND a.title ilike :title " + System.lineSeparator());
                }
                if (queryParams.get("country") != null) {
                    builder.append("  AND a.country ilike :country " + System.lineSeparator());
                }
                if (queryParams.get("state") != null) {
                    builder.append("  AND a.state ilike :state " + System.lineSeparator());
                }
                if (queryParams.get("city") != null) {
                    builder.append("  AND a.city ilike :city " + System.lineSeparator());
                }
                if (queryParams.get("district") != null) {
                    builder.append("  AND a.district ilike :district " + System.lineSeparator());
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

                if (queryParams.get("propertyType") == "ROOM"){
                    if (queryParams.get("floor") != null) {
                        builder.append("  AND r_d.floor <= :floor " + System.lineSeparator());
                    }
                    if (queryParams.get("bedsInRoom") != null) {
                        builder.append("  AND r_d.beds_in_room = :bedsInRoom " + System.lineSeparator());
                    }
                    if (queryParams.get("numberOfFlatmates") != null) {
                        builder.append("  AND r_d.numberOfFlatmates <= :numberOfFlatmates " + System.lineSeparator());
                    }
                    if (queryParams.get("bathrooms") != null) {
                        builder.append("  AND r_d.bathrooms >= :bathrooms " + System.lineSeparator());
                    }
                } else if (queryParams.get("propertyType") == "FLAT"){
                    if (queryParams.get("basement") != null) {
                        builder.append("  AND f_d.basement = :basement " + System.lineSeparator());
                    }
                    if (queryParams.get("floor") != null) {
                        builder.append("  AND f_d.floor <= :floor " + System.lineSeparator());
                    }
                    if (queryParams.get("bedrooms") != null) {
                        builder.append("  AND f_d.bedrooms >= :bedrooms " + System.lineSeparator());
                    }
                    if (queryParams.get("bathrooms") != null) {
                        builder.append("  AND f_d.bathrooms >= :bathrooms " + System.lineSeparator());
                    }
                    if (queryParams.get("flatParking") != null) {
                        builder.append("  AND f_d.flatParking >= :flatParking " + System.lineSeparator());
                    }
                    if (queryParams.get("balcony") != null) {
                        builder.append("  AND f_d.balcony >= :balcony " + System.lineSeparator());
                    }
                } else if (queryParams.get("propertyType") == "HOUSE"){
                    if (queryParams.get("basement") != null) {
                        builder.append("  AND h_d.basement = :basement " + System.lineSeparator());
                    }
                    if (queryParams.get("parking") != null){
                        builder.append("  AND h_d.parking = :parking " + System.lineSeparator());
                    }
                    if (queryParams.get("floors") != null){
                        builder.append("  AND h_d.floors >= :floors " + System.lineSeparator());
                    }
                    if (queryParams.get("bedrooms") != null){
                        builder.append("  AND h_d.bedrooms >= :bedrooms " + System.lineSeparator());
                    }
                    if (queryParams.get("bathrooms") != null){
                        builder.append("  AND h_d.bathrooms >= :bathrooms " + System.lineSeparator());
                    }
                    if (queryParams.get("lotSize") != null){
                        builder.append("  AND h_d.lotSize >= :lotSize " + System.lineSeparator());
                    }
                    if (queryParams.get("balcony") != null){
                        builder.append("  AND h_d.balcony >= :balcony " + System.lineSeparator());
                    }
                }

                String[] detailParamsToBuild = {"bath","shower","microwave","oven","petsAllowed","elevator","nearPark",
                        "fenced", "nearTram","nearBus","wifi","ethernetOutlets","internet","tv","dishwasher",
                        "clothesDryer", "nearShoppingMall","nearBakery","nearFoodMarket","nearSupermarket"};

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

                String[] possibleParams = {"availableFrom","title","country","state","city","district","propertyType",
                        "livingSpace","internetSpeed","bath",
                        "shower", "microwave","oven","petsAllowed","elevator","nearPark","fenced",
                        "nearTram","nearBus","wifi","ethernetOutlets","internet","tv","dishwasher","clothesDryer",
                        "nearShoppingMall","nearBakery","nearFoodMarket","nearSupermarket","basement","parking"};

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


    @org.springframework.data.jpa.repository.Query(value="SELECT * FROM Announcement a WHERE a.web_user_id = ?1 and a.active='true'", nativeQuery = true) // dodac active
    List<Announcement> getActiveForUser(int i );

    @org.springframework.data.jpa.repository.Query(value="SELECT * FROM Announcement a WHERE a.web_user_id = ?1 and a.active='false'", nativeQuery = true) // dodac active
    List<Announcement> getInactiveForUser(Integer id);

    @org.springframework.data.jpa.repository.Query(value="SELECT * FROM Announcement a WHERE a.id=?1", nativeQuery = true) // dodac active
    Optional<Announcement> findAnnouncementById(Integer id);

    @org.springframework.data.jpa.repository.Query(value="DELETE FROM Announcement a WHERE a.id =?1", nativeQuery = true) // dodac active
    void deleteAnnouncementById(Integer id);
}

//    @org.springframework.data.jpa.repository.Query(value="SELECT * FROM announcement WHERE announcement.web_user_id=?1") // dodac active
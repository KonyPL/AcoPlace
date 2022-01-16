//package put.poznan.AcoPlaceBackend.filter;
//
//import org.springframework.data.jpa.domain.Specification;
//import put.poznan.AcoPlaceBackend.criteria.AnnouncementSearchCriteria;
//import put.poznan.AcoPlaceBackend.model.Announcement;
//import put.poznan.AcoPlaceBackend.model.Announcement_;
//
//import java.sql.Date;
//import java.util.Optional;
//
//public final class AnnouncementSpecifications {
//    private AnnouncementSpecifications() {}
//    public static Specification<Announcement> createAnnouncementSpecifications(AnnouncementSearchCriteria searchCriteria) {
//        return priceBetween(searchCriteria.getPriceMin(), searchCriteria.getPriceMax())
//                .and(availableFrom(searchCriteria.getAvailableFrom()))
//                .and(titleLike(searchCriteria.getTitle()))
//                .and(propertyTypeEquals(searchCriteria.getPropertyType()))
//                .and(livingSpaceGreaterThan(searchCriteria.getLivingSpace()));
//    }
//
//    public static Specification<Announcement> priceBetween(Optional<Double> priceMin, Optional<Double> priceMax){
//        return (root, query, builder) -> {
//            return priceMin.map(min -> {
//                return priceMax.map(max -> builder.between(root.get(Announcement_.price), min, max)
//                ).orElse(null);
//            }).orElse(null);
//        };
//    }
//
//    public static Specification<Announcement> availableFrom(Optional<Date> availableDate){
//        return (root, query, builder) -> {
//            return availableDate.map(avDate -> builder.lessThanOrEqualTo(root.get(Announcement_.availableFrom), avDate)
//                ).orElse(null);
//        };
//    }
//
//    public static Specification<Announcement> titleLike(Optional<String> anTitle){
//        return (root, query, builder) -> {
//            return anTitle.map(title -> builder.like(root.get(Announcement_.title), '%'+title+'%')
//            ).orElse(null);
//        };
//    }
//
//    public static Specification<Announcement> propertyTypeEquals(Optional<String> propertyType){
//        return (root, query, builder) -> {
//            return propertyType.map(pType -> builder.equal(root.get(Announcement_.propertyType), pType)
//            ).orElse(null);
//        };
//    }
//
//    public static Specification<Announcement> livingSpaceGreaterThan(Optional<Integer> livingSpace){
//        return (root, query, builder) -> {
//            return livingSpace.map(space -> builder.greaterThanOrEqualTo(root.get(Announcement_.livingSpace), space)
//            ).orElse(null);
//        };
//    }
//}

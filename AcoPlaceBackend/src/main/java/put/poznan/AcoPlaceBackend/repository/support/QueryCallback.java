package put.poznan.AcoPlaceBackend.repository.support;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface QueryCallback<T> {

    T doWithEntityManager(EntityManager entityManager);
}

package put.poznan.AcoPlaceBackend.repository.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface AcoJpaRepository {

    <T> T findOne(QueryCallback<T> callback);

    <T> List<T> findAll(QueryCallback<List<T>> callback);

    <T> Page<T> findAll(Pageable pageable, QueryCallback<Page<T>> callback);
}

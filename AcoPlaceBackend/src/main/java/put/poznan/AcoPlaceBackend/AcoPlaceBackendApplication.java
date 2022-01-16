package put.poznan.AcoPlaceBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import put.poznan.AcoPlaceBackend.repository.support.AcoSimpleJpaRepository;

@SpringBootApplication
@EnableJpaRepositories(
		repositoryBaseClass = AcoSimpleJpaRepository.class
)
@EnableTransactionManagement
public class AcoPlaceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcoPlaceBackendApplication.class, args);
	}

}

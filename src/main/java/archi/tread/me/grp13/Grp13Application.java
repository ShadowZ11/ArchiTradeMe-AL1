package archi.tread.me.grp13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Grp13Application {

	public static void main(String[] args) {
		SpringApplication.run(Grp13Application.class, args);
	}

}

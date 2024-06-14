package business.company.autoservice;

import business.company.autoservice.repository.InMemoryAutoserviceDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoserviceApplication.class, args);
	}

}

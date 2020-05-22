package ProductOffering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ProductOffering.dao.LoginRepository;
import ProductOffering.entities.User;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.setProperty("java.security.auth.login.config", "src/main/resources/jaas.login.config");
	}
	 @Bean
	  public CommandLineRunner demo(LoginRepository repository) {
	    return (args) -> {
	      // save a few customers
	     /* repository.save(new User("Yatin", "Chauhan"));
	      repository.save(new User("Rohit", "Mittal"));
	      repository.save(new User("Gorav", "Agarwal"));
	      repository.save(new User("Nipun", "Gupta"));
	      repository.save(new User("Anusha", "Verma"));

	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (User user : repository.findAll()) {
	        log.info(user.toString());
	      }
	      log.info("");

	      User customer = repository.findById(1L);
	      log.info("Customer found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(customer.toString());
	      log.info("");

	      log.info("Customer found with findByLastName('Chauhan'):");
	      log.info("--------------------------------------------");
	      repository.findByLastName("Chauhan").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      
	      log.info("");
	      */
	    };
	    
	  }
}
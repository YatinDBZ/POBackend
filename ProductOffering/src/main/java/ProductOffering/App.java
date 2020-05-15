package ProductOffering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ProductOffering.dao.LoginDAO;
import ProductOffering.entities.User;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	 @Bean
	  public CommandLineRunner demo(LoginDAO repository) {
	    return (args) -> {
	      // save a few customers
	      repository.save(new User("Yatin", "Chauhan"));
	      repository.save(new User("Rohit", "Mittal"));
	      repository.save(new User("Gorav", "Agarwal"));
	      repository.save(new User("Nipun", "Gupta"));
	      repository.save(new User("Anusha", "Verma"));

	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (User user : repository.findAll()) {
	        log.info(user.toString());
	      }
	      log.info("");

	      // fetch an individual customer by ID
	      User customer = repository.findById(1L);
	      log.info("Customer found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(customer.toString());
	      log.info("");

	      // fetch customers by last name
	      log.info("Customer found with findByLastName('Chauhan'):");
	      log.info("--------------------------------------------");
	      repository.findByLastName("Chauhan").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      
	      log.info("");
	    };
	  }
}
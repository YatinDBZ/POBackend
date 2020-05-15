package ProductOffering.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ProductOffering.entities.User;

public interface LoginRepository extends CrudRepository<User, Long> {

	List<User> findByLastName(String lastName);

	User findById(long id);
}
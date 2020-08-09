package gabriela.Examen.repositories;

import org.springframework.data.repository.CrudRepository;

import gabriela.Examen.models.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
}

package gabriela.dojos.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import gabriela.dojos.models.Dojo;
import gabriela.dojos.models.Ninja;


public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long> {
	List<Ninja> findAll();
	Optional<Ninja> findById(Long id);
	List<Ninja> findAllNinjaByDojo(Dojo dojo);
}

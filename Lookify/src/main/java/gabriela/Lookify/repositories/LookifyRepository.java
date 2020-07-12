package gabriela.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gabriela.Lookify.models.Lookify;


public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	List<Lookify> findAll();
	List<Lookify> findByArtist(String artist);
}

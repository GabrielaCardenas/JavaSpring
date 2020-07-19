package gabriela.listaEstudiantes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gabriela.listaEstudiantes.models.Clase;
import gabriela.listaEstudiantes.models.Students;


public interface ClaseRepository extends CrudRepository<Clase, Long> {
	List<Clase> findAll();
	Optional<Clase> findById(Long id);
	List<Clase> findByStudentsNotContains(Students estudiante);
}

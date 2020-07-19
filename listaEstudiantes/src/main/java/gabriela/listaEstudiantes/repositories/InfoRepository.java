package gabriela.listaEstudiantes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gabriela.listaEstudiantes.models.Info;
import gabriela.listaEstudiantes.models.Students;


public interface InfoRepository extends CrudRepository<Info, Long> {
	List<Info> findAll();
	Optional<Info> findById(Long id);
	Info findByStudents(Students students);
}

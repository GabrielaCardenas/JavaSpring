package gabriela.listaEstudiantes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gabriela.listaEstudiantes.models.Dorms;
import gabriela.listaEstudiantes.models.Students;

public interface StudentRepository extends CrudRepository<Students, Long> {
	List<Students> findAll();
	Optional<Students> findById(Long id);
	List<Students> findAllStudentsByDorms(Dorms dorm);
}

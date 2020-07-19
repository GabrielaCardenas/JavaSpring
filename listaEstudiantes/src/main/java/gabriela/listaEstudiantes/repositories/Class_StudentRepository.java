package gabriela.listaEstudiantes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gabriela.listaEstudiantes.models.Class_Student;


public interface Class_StudentRepository extends CrudRepository<Class_Student, Long> {
	List<Class_Student> findAll();
	Optional<Class_Student> findById(Long id);
	List<Class_Student> findByClaseId(Long id);
	Class_Student findByStudentIdAndClaseId(Long studentId, Long classId);
}

package gabriela.listaEstudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gabriela.listaEstudiantes.models.Dorms;

public interface DormRepository extends CrudRepository<Dorms, Long> {
	List<Dorms> findAll();
}

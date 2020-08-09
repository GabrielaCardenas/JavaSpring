package gabriela.dojos.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gabriela.dojos.models.Dojo;
import gabriela.dojos.models.Ninja;
import gabriela.dojos.repositories.DojoRepository;
import gabriela.dojos.repositories.NinjaRepository;

@Service
@Transactional
public class ApiService {
	private final DojoRepository dojoRepository;
    
    public ApiService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    
    @Autowired
    private NinjaRepository ninjaRepository;
    
    //la variable estática establece el número de ninjas que queremos mostrar por página.
    private static final int PAGE_SIZE = 5;
    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // Obtener todas las páginas de ninjas y clasificarlas en orden ascendente por apellido.
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(Sort.Direction.ASC,"dojo.name"));
        return ninjaRepository.findAll(pageRequest);
    }

    
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        }
        else {
            return null;
        }
	}

	public List<Ninja> findNinjas(Dojo dojo) {
		return ninjaRepository.findAllNinjaByDojo(dojo);
	}
    
    
}

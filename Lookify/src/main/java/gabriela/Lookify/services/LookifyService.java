package gabriela.Lookify.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gabriela.Lookify.models.Lookify;
import gabriela.Lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	
    private final LookifyRepository lookifyRepository;
    
    public LookifyService(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }
    //Devolviendo todos las canciones.
    public List<Lookify> allSongs() {
        return lookifyRepository.findAll();
    }
    //Creando una canción.
    public Lookify createSongs(Lookify leng) {
        return lookifyRepository.save(leng);
    }
    //Obteniendo la información de una canción
    public Lookify findSong(Long id) {
        Optional<Lookify> optionalLook = lookifyRepository.findById(id);
        if(optionalLook.isPresent()) {
            return optionalLook.get();
        } else {
            return null;
        }
    }
    
    public Lookify updateLookify(Lookify song) {
		return lookifyRepository.save(song);
	}
    
    public List<Lookify> deleteSong(Long id) {
    	Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
        
    	if(optionalLookify.isPresent()) {
        	lookifyRepository.deleteById(id);;
        	return lookifyRepository.findAll();
        }
        else {
        	return null;
        }
    }
    
    public List<Lookify> topTen() {
    	List<Lookify> topTen = (List<Lookify>) lookifyRepository.findAll();
    	Collections.sort(topTen, (o1, o2) -> o2.getRanking().compareTo(o1.getRanking()));
    	return topTen;
    }
    
	public List<Lookify> getSearchSongs(String artist) {
		return lookifyRepository.findByArtist(artist);
	}


}

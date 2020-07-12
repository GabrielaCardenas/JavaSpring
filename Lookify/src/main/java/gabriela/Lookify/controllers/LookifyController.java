package gabriela.Lookify.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gabriela.Lookify.models.Lookify;
import gabriela.Lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;

    public LookifyController(LookifyService lookService) {
        this.lookifyService = lookService;
    }
    
    @RequestMapping("/")
    public String index() {
        return "/index.jsp";
    }
    
    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        List<Lookify> songs = lookifyService.allSongs();
        model.addAttribute("songs", songs);
        return "/dashboard.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Lookify song) {
        return "/new.jsp";
    }
    
    @RequestMapping(value="/dashboard", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            lookifyService.createSongs(song);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping("/songs/{id}")
    public String showSong(@PathVariable("id") Long id, Model model) {
    	Lookify song = lookifyService.findSong(id);
    	model.addAttribute("song", song);
    	return "show.jsp";
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        lookifyService.deleteSong(id);
        return "redirect:/dashboard";
    }
    
    @RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@Valid @ModelAttribute("artist") String artist, BindingResult result, Model model) {
		List<Lookify> songs = lookifyService.getSearchSongs(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "artist.jsp";
	}
    
    @RequestMapping("/search/topTen")
    public String topTen(Model model) {
    	List<Lookify> songs = lookifyService.topTen();
    	model.addAttribute("songs", songs);
    	return "topTen.jsp";
    }

}

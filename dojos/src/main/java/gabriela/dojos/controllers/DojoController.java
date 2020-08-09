package gabriela.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gabriela.dojos.models.Dojo;
import gabriela.dojos.models.Ninja;
import gabriela.dojos.services.ApiService;


@Controller
public class DojoController {
	private final ApiService apiService;

    public DojoController(ApiService apiService) {
        this.apiService = apiService;
    }
    
    @RequestMapping("/pages/{pageNumber}")
    public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
        //Tenemos que restar 1 porque las páginas iterables empiezan con índice 0. Esto es para que nuestros enlaces puedan mostrarse desde 1...maxPage(última página) 
        Page<Ninja> ninjas = apiService.ninjasPerPage(pageNumber - 1);
        //Total número de páginas que tenemos
        int totalPages = ninjas.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("ninjas", ninjas);
        return "ninjas.jsp";
    }
    
    @RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
    	return "newDojo.jsp";
    }
    
    @RequestMapping(value="/dojo", method=RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
    	if (result.hasErrors()) {
            return "newDojo.jsp";
        } else {
            apiService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }
    
    @RequestMapping("ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
    	List<Dojo> dojoList = apiService.allDojos();
    	model.addAttribute("dojoList", dojoList);
    	return "newNinja.jsp";
    }
    
    @RequestMapping(value="/ninja", method=RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            return "newNinja.jsp";
        } else {
            apiService.createNinja(ninja);
            Dojo dojo = ninja.getDojo();
            model.addAttribute("dojo", dojo);
            return "redirect:/dojos/" + dojo.getId();
        }
    }
    
    @RequestMapping("/dojos/{id}")
    public String showDojo(Model model, @PathVariable("id") Long id) {
    	Dojo dojo = apiService.findDojo(id);
    	model.addAttribute("dojo", dojo);
    	List<Ninja> ninjaList = apiService.findNinjas(dojo);
    	model.addAttribute("ninjaList", ninjaList);
    	return "view.jsp";
    }
    
}

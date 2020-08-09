package gabriela.Examen.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gabriela.Examen.models.Customer;
import gabriela.Examen.models.Paquete;
import gabriela.Examen.models.User;
import gabriela.Examen.services.ApiService;
import gabriela.Examen.validator.UserValidator;


@Controller
public class HomeController {
	private final ApiService apiService;
	private final UserValidator userValidator;
    
    public HomeController(ApiService apiService, UserValidator userValidator) {
        this.apiService = apiService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/home")
    public String registerForm(@ModelAttribute("user") User user) {
    	apiService.createPaquete((long) 1, "Basico", 10, "Available");
        return "index.jsp";
    }
    
    
    @PostMapping(value="/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "index.jsp";
    	}
    	User u = apiService.registerUser(user);
    	session.setAttribute("userId", u.getId());
    	Paquete paquete = apiService.findPaqueteById(1);
    	if(u.getId()==1) {
        	return "redirect:/packages";
    	}
    	else {    		
    		//agregar usuario a customer
    		String nameCustomer = user.getName();
    		Calendar date = Calendar.getInstance();
    		date.add(Calendar.MONTH, 5);
    		Date dueDate = date.getTime();
    		
    		Customer customer = new Customer(user.getId(), nameCustomer, dueDate, paquete, u);
    		Customer newCustomer = apiService.createCustomer(customer);
    		session.setAttribute("customer", newCustomer);
        	return "redirect:/users/"+u.getId();
    	}
    
    }
    
    @PostMapping(value="/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = apiService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User user = apiService.findByEmail(email);
    		session.setAttribute("userId", user.getId());
    		if(user.getId()==1) {
    			return "redirect:/packages";
    		}
    		else {
    			
    			Long customerId = user.getCustomer().getId();
    			Customer customer = apiService.findCustomerById(customerId);        		
        		session.setAttribute("customer", customer);
    			return "redirect:/users/"+user.getId();
    		}
    	}
    	else {
    		model.addAttribute("error", "Invalid Credentials. Please try again.");
    		return "index.jsp";
    	}
    }
    
    @RequestMapping("/packages")
    public String admin(HttpSession session, Model model, @ModelAttribute("paquete") Paquete paquete) {
        Long userId = (Long) session.getAttribute("userId");
        User u = apiService.findUserById(userId);
        model.addAttribute("user", u);
        
        List<Paquete> paqueteList = (List<Paquete>) apiService.findAllPaquetes();
        model.addAttribute("paqueteList", paqueteList);
        
        List<Customer> customerList = apiService.findAllCutomer();
        model.addAttribute("customerList", customerList);
        
        return "packages.jsp";
    }
    
    @PostMapping("/newPackage")
	public String createPackage(@ModelAttribute("paquete") Paquete paquete, BindingResult result, Model model) {
		apiService.createPackage(paquete);
		return "redirect:/packages";
	}
    
    @RequestMapping("/users/{id}")
    public String users(HttpSession session, Model model, @ModelAttribute("paquetes") Paquete paquete) {
    	 Long userId = (Long) session.getAttribute("userId");
         User u = apiService.findUserById(userId);
         model.addAttribute("user", u);
        
        
        Customer customer =  u.getCustomer();
        model.addAttribute("customer", customer);
        
        List<Paquete> paqueteList = (List<Paquete>) apiService.findAllPaquetes();
        model.addAttribute("paqueteList", paqueteList);
        return "users.jsp";
    }
    
    @PostMapping("/changePaquete")
    public String changePaquete(@Valid @ModelAttribute("paquetes") Paquete paquete, BindingResult result, HttpSession session, @RequestParam("customerId") Long customerId, @RequestParam("userId") Long userId) {
    	if(result.hasErrors()) {
    		return "users.jsp";
    	}
    	
    	Customer customer = apiService.findCustomerById(customerId);
    	customer.setPaquetes(paquete);
    	apiService.updateCustomer(customer);
    	
    	return "redirect:/users/"+userId;
    }
    
    @RequestMapping("/packages/{paqueteId}/edit")
    public String edit(@PathVariable("paqueteId") Long paqueteId, Model model, @ModelAttribute("paquetes") Paquete paquete) {
    	Paquete newpaquete = apiService.findPaqueteById(paqueteId);
    	model.addAttribute("paquete", newpaquete);
    	return "edit.jsp";
    }
    
    @PostMapping("/editCost")
    public String editCost(@ModelAttribute("paquetes") Paquete paquete) {
    	apiService.updatePaquete(paquete);
    	return "redirect:/packages";
    }
    
    @PostMapping("/delete")
    public String delete(@ModelAttribute("paquetes") Paquete paquete) {
    	apiService.deletePaquete(paquete);
    	return "redirect:/packages";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
    
    
}

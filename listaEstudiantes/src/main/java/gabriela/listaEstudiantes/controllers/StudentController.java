package gabriela.listaEstudiantes.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gabriela.listaEstudiantes.models.Clase;
import gabriela.listaEstudiantes.models.Class_Student;
import gabriela.listaEstudiantes.models.Dorms;
import gabriela.listaEstudiantes.models.Info;
import gabriela.listaEstudiantes.models.Students;
import gabriela.listaEstudiantes.services.ApiService;


@Controller
public class StudentController {
	private final ApiService apiService;

    public StudentController(ApiService apiService) {
        this.apiService = apiService;
    }
    
    @RequestMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Students student) {
        return "newStudent.jsp";
    }
    
    @RequestMapping(value="/student", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("student") Students student, BindingResult result) {
        if (result.hasErrors()) {
            return "newStudent.jsp";
        } else {
            apiService.createStudent(student);
            return "redirect:/contact/new";
        }
    }
    
    @RequestMapping("/contact/new")
    public String newContact(Model model, @ModelAttribute("contact") Info contact) {
    	List<Students> studentList = apiService.allStudents();
    	model.addAttribute("studentList", studentList);
        return "newInfo.jsp";
    }
    
    @RequestMapping(value="/contact", method=RequestMethod.POST)
    public String createContact(@Valid @ModelAttribute("contact") Info contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "newInfo.jsp";
        }
        else {
        	apiService.createInfo(contact);
            return "redirect:/students";
        }
    }
    
    @RequestMapping("/students")
    public String show(Model model) {
    	List<Students> studentList = apiService.allStudents();
    	model.addAttribute("studentList", studentList);
    	
    	ArrayList<Info> contactList = new ArrayList<Info>();
    	for(int i=0;i<studentList.size();i++) {
    		Students student = studentList.get(i);
    		Info studentContact = apiService.getSearch(student);
    		contactList.add(studentContact);
    	}
    	
    	model.addAttribute("contactList", contactList);
    	
        return "view.jsp";
    }
    
    @RequestMapping("/dorms")
    public String dorms(@ModelAttribute("dorm") Dorms dorm, Model model) {
    	List<Dorms> dormList = apiService.allDorms();
    	model.addAttribute("dormList", dormList);
        return "listDorms.jsp";
    }
    
    @RequestMapping("/dorms/create")
    public String newDorm(@ModelAttribute("dorm") Dorms dorm) {
        return "newDorm.jsp";
    }
    
    @RequestMapping(value="/dorms/create", method=RequestMethod.POST)
    public String createDorm(@Valid @ModelAttribute("dorm") Dorms dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "newDorm.jsp";
        } else {
            apiService.createDorm(dorm);
            return "redirect:/dorms/" + dorm.getId();
        }
    }
    
    @RequestMapping("/dorms/{id}")
    public String showDorm(Model model, @PathVariable("id") Long dormId, @ModelAttribute("student") Students student) {
    	Dorms dorm = apiService.findDorm(dormId);
    	model.addAttribute("dorm", dorm);
    	List<Students> studentList = apiService.allStudents();
    	model.addAttribute("studentList", studentList);
    	List<Students> studentDorm = dorm.getStudents();
    	model.addAttribute("studentDorm", studentDorm);
    	return "viewDorms.jsp";
    }
    
    @RequestMapping(value="/dorms/{id}/add", method=RequestMethod.POST)
    public String addStudent(@PathVariable("id") Long dormId, @Valid @ModelAttribute("student") Students student, BindingResult result) {
    	if (result.hasErrors()) {
            return "viewDorms.jsp";
        }
        else {
        	//en el objeto student solo se envío el id por formulario
            apiService.updateStudent(student, dormId);
            return "redirect:/dorms/" + dormId;
        }
    }
    
    @RequestMapping(value="/dorms/{id}/remove", method=RequestMethod.POST)
    public String removeStudent(@PathVariable("id") Long dormId, @Valid @ModelAttribute("student") Students student, BindingResult result) {
    	if (result.hasErrors()) {
            return "viewDorms.jsp";
        }
        else {
        	apiService.removeStudent(student);
        	return "redirect:/dorms/" + dormId;
        }
    }
    
    
    
    
    @GetMapping("/classes/new")
	public String newClass(@ModelAttribute("classeObject") Clase clase) {
		return "newClass.jsp";
	}
	
	@RequestMapping(value = "/classes/new", method = RequestMethod.POST)
	public String addClass(@Valid @ModelAttribute("classeObject") Clase clase, BindingResult result) {
		if (result.hasErrors()) {
			return "newClass.jsp";
		}
		else {
			apiService.addClass(clase);
			return "redirect:/students";
		}
		
	}
	
	@GetMapping("students/{idStudent}")
	public String showStudent(@PathVariable("idStudent") Long idStudent, Model model, @ModelAttribute("classStudent") Class_Student class_Student) {
		Students estudiante = this.apiService.findStudent(idStudent);
		model.addAttribute("estudiante",estudiante );
		
		List<Clase> classes = apiService.dispClassesForStudent(estudiante);
		model.addAttribute("classes",classes);
		
		
		List<Clase> studentClasses = estudiante.getClases();
		model.addAttribute("studentClasses", studentClasses);
		return "addClassToStudent.jsp";
	}
	
	
	@RequestMapping(value = "/classStudent/add", method = RequestMethod.POST)
	public String addClassToStudent(@ModelAttribute("classStudent") Class_Student class_Student) {
		Class_Student classStudent = apiService.addClassToStudent(class_Student);
		return "redirect:/students/"+classStudent.getStudent().getId();
	}
	
	@GetMapping("classes/{idClass}")
	public String showClase(@PathVariable("idClass") Long idClass, Model model) {
		Clase clase = apiService.findClass(idClass);
		model.addAttribute("clase", clase);
		
		ArrayList<Students> studentsList = apiService.getAllStudent(clase);
		model.addAttribute("studentsList",studentsList);
		return "infoClass.jsp";
	}
	
	@RequestMapping("/classes")
    public String showClasses(Model model) {
    	List<Clase> classesList = apiService.getAllClasses();
    	model.addAttribute("classesList", classesList);
    	return "viewClasses.jsp";
    }
	
	@RequestMapping(value = "/{studentId}/drop", method = RequestMethod.POST)
    public String dropClass(@ModelAttribute("classStudent") Class_Student class_Student2, @PathVariable("studentId") Long studentId) {
		Long classId = class_Student2.getClase().getId();
		Class_Student classStudent2 = apiService.findClassStudent(studentId, classId);
		apiService.dropClassToStudent(classStudent2);
        return "redirect:/students/"+studentId;
	}
	
}

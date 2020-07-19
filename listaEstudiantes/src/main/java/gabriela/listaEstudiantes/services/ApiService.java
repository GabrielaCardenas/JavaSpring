package gabriela.listaEstudiantes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriela.listaEstudiantes.models.Clase;
import gabriela.listaEstudiantes.models.Class_Student;
import gabriela.listaEstudiantes.models.Dorms;
import gabriela.listaEstudiantes.models.Info;
import gabriela.listaEstudiantes.models.Students;
import gabriela.listaEstudiantes.repositories.ClaseRepository;
import gabriela.listaEstudiantes.repositories.Class_StudentRepository;
import gabriela.listaEstudiantes.repositories.DormRepository;
import gabriela.listaEstudiantes.repositories.InfoRepository;
import gabriela.listaEstudiantes.repositories.StudentRepository;


@Service
public class ApiService {
	private final StudentRepository studentRepository;
    
    public ApiService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @Autowired
    private InfoRepository infoRepository;
    
    @Autowired
    private DormRepository dormRepository;
    
    @Autowired
    private Class_StudentRepository class_studentRepository;
    
    @Autowired
    private ClaseRepository claseRepository;
    
    //Devolviendo todos los estudiantes.
    public List<Students> allStudents() {
        return studentRepository.findAll();
    }
    
    //Creando un estudiante.
    public Students createStudent(Students student) {
        return studentRepository.save(student);
    }
    
    //Obteniendo la información de un estudiante
    public Students findStudent(Long id) {
        Optional<Students> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        else {
            return null;
        }
    }
    
    //Devolviendo todas las informaciones de estudiantes.
    public List<Info> allInfo() {
        return infoRepository.findAll();
    }
    
    //Creando info de un estudiante.
    public Info createInfo(Info info) {
        return infoRepository.save(info);
    }
    
    //Obteniendo la info de un estudiante
    public Info findInfo(Long id) {
        Optional<Info> optionalInfo = infoRepository.findById(id);
        if(optionalInfo.isPresent()) {
            return optionalInfo.get();
        }
        else {
            return null;
        }
    }
    
    //Buscar info por id de la persona
  	public Info getSearch(Students student) {
  		return infoRepository.findByStudents(student);
  	}

	public Dorms createDorm(Dorms dorm) {
		return dormRepository.save(dorm);
	}

	public Dorms findDorm(Long id) {
		Optional<Dorms> optionalDorm = dormRepository.findById(id);
        if(optionalDorm.isPresent()) {
            return optionalDorm.get();
        }
        else {
            return null;
        }
	}

	public List<Students> findStudent(Dorms dorm) {
		return studentRepository.findAllStudentsByDorms(dorm);
	}
	
	//actualizar un estudiante.
    public Students updateStudent(Students student, Long dormId) {
    	//Encuentro estudiante con el id enviado en el objeto student
    	Students studentSelect = findStudent(student.getId());
    	//instancio un objeto dorm y le agrego el id enviado dormId
    	Dorms dorm = new Dorms();
    	dorm.setId(dormId);
    	
    	Dorms dorm_id = studentSelect.getDorms();
    	if(dorm_id==null) {
    		//al objeto student seleccionado le envío el dorm seleccionado
        	studentSelect.setDorms(dorm);
        	//actualizo student guardando studentSelect que contiene el objeto dorm con el dorm_id
            return studentRepository.save(studentSelect);
    	}
    	else {
    		return null;
    	}
    }

	public Students removeStudent(Students student) {
		Students studentSelect = findStudent(student.getId());
		studentSelect.setDorms(null);
		return studentRepository.save(studentSelect);
	}
    
	public List<Dorms> allDorms() {
        return dormRepository.findAll();
    }
	
	public Class_Student addClassToStudent(Class_Student class_student) {
    	return class_studentRepository.save(class_student);
    }
	
	public Clase addClass(Clase clase) {
        return claseRepository.save(clase);
    }

    public List<Clase> getAllClasses() {
    	return claseRepository.findAll();
    }
    
    public List<Class_Student> findAllStudent(Clase clase){
        return this.class_studentRepository.findByClaseId(clase.getId());
    }

	public Clase findClass(Long idClass) {
		Optional<Clase> optionalClase = claseRepository.findById(idClass);
        if(optionalClase.isPresent()) {
            return optionalClase.get();
        }
        else {
            return null;
        }	
	}

	public ArrayList<Students> getAllStudent(Clase clase) {
		List<Class_Student> classStudents = findAllStudent(clase);
		ArrayList<Students> studentsList = new ArrayList<Students>();
		for(int i=0;i<classStudents.size();i++) {
			Students student = classStudents.get(i).getStudent();
			studentsList.add(student);
		}
		return studentsList;
	}
	
	public List<Clase> dispClassesForStudent(Students estudiante) {
		return claseRepository.findByStudentsNotContains(estudiante);
	}

	public void dropClassToStudent(Class_Student class_Student2) {
		class_studentRepository.delete(class_Student2);
	}

	public Class_Student findClassStudent(Long studentId, Long classId) {
		return class_studentRepository.findByStudentIdAndClaseId(studentId, classId);
		
	}

	

}

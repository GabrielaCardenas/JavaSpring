package gabriela.Examen.services;

import java.util.List;
import java.util.Optional;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriela.Examen.models.Customer;
import gabriela.Examen.models.Paquete;
import gabriela.Examen.models.User;
import gabriela.Examen.repositories.CustomerRepository;
import gabriela.Examen.repositories.PaqueteRepository;
import gabriela.Examen.repositories.UserRepository;


@Service
public class ApiService {
	private final UserRepository userRepository;
    
    public ApiService(UserRepository eventosRepository) {
        this.userRepository = eventosRepository;
    }
    
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PaqueteRepository paqueteRepository;
    
    
    // registrar el usuario y hacer Hash a su password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // encontrar un usuario por su email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // encontrar un usuario por su id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // autenticar usuario
    public boolean authenticateUser(String email, String password) {
        // primero encontrar el usuario por su email
        User user = userRepository.findByEmail(email);
        // si no lo podemos encontrar por su email, retornamos false
        if(user == null) {
            return false;
        } else {
            // si el password coincide devolvemos true, sino, devolvemos false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}

	public Paquete createPaquete(Paquete paquete) {
		return paqueteRepository.save(paquete);
		
	}

	public Paquete createPaquete(Long id, String name, int cost, String avaliable) {
		Paquete paquete = new Paquete();
		paquete.setId(id);
		paquete.setName(name);
		paquete.setAvaliable(avaliable);
		paquete.setCost(cost);
		return paqueteRepository.save(paquete);
	}

	public Paquete findPaqueteById(long id) {
		Optional<Paquete> paquete = paqueteRepository.findById(id);
        if(paquete.isPresent()) {
            return paquete.get();
        }
        else {
            return null;
        }
	}

	public Customer findCustomerById(Long userId) {
		Optional<Customer> customer = customerRepository.findById(userId);
        if(customer.isPresent()) {
            return customer.get();
        }
        else {
            return null;
        }
	}

	public Iterable<Paquete> findAllPaquetes() {
		return paqueteRepository.findAll();
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Paquete createPackage(Paquete paquete) {
		return paqueteRepository.save(paquete);
		
	}

	public List<Customer> findAllCutomer() {
		return (List<Customer>) customerRepository.findAll();
	}

	public Paquete updatePaquete(Paquete paquete) {
		return paqueteRepository.save(paquete);
	}

	public void deletePaquete(Paquete paquete) {
		paqueteRepository.delete(paquete);
	}
    
}

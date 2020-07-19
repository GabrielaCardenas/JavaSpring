package gabriela.listaEstudiantes.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="clases")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;

	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "class_student",
			joinColumns = @JoinColumn(name = "clase_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
	)
	private List<Students> students;
	
	
	public Clase() {
	}
	
	public Clase(Long id, String name, List<Students> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		setCreatedAt(new Date());
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	

	//Getters and Setters
	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


}

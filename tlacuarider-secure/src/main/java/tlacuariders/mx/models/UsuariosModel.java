package tlacuariders.mx.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="usuarios")
public class UsuariosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false, length = 100, name= "name")
	private String name;
	
	@Column(nullable = false, length = 255)
	private String alias;
	
	@Column(nullable = false, length = 100)
	private String apellidos;
	
	@Column(nullable = false, length=100, unique=true)
	private String email;
	
	@Column(nullable = false, length = 100)
	private String username;

	@JsonProperty(access= Access.WRITE_ONLY)
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 255)
	private String direccion;
	
	@Column(nullable = false, length = 12)
	private String telefono;
	
	@Column(nullable = false, length = 1)
	private int genero;
	
	@ManyToOne
    private CodigoPostalModel codigo_postal;
	
	//@OneToMany(targetEntity = VentasModel.class, mappedBy = "usuario")
	//@JsonManagedReference
	//private List<VentasModel> ventas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public CodigoPostalModel getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(CodigoPostalModel codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	
	//@OneToMany(targetEntity = PedidosModel.class, mappedBy = "user")
	//@JsonManagedReference
	//private List<PedidosModel> post;
	
	
}

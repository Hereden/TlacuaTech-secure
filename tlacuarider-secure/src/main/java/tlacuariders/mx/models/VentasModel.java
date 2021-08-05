package tlacuariders.mx.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ventas")
public class VentasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@OneToMany(targetEntity = PedidosModel.class, mappedBy = "venta")
	@JsonManagedReference
	private List<PedidosModel> pedido;
	
	//@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<PedidosModel> pedidos;
	
	
	@Column(nullable = false)
	private float precio_total;
	
	@ManyToOne
    @JoinColumn(name = "USUARIO_KEY")
    private UsuariosModel usuario;
	//private List<PedidosModel> pedidos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PedidosModel> getPedido() {
		return pedido;
	}

	public void setPedido(List<PedidosModel> pedido) {
		this.pedido = pedido;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	public UsuariosModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosModel usuario) {
		this.usuario = usuario;
	}

	

	
	

}

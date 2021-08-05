package tlacuariders.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="pedidos")
public class PedidosModel {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(nullable = false)
	private float precio_total;
	
	@ManyToOne
	private ArticulosModel articulos;
	
	
	//@ManyToOne
    //@JoinColumn(name = "VENTA_KEY")
    //private VentasModel venta;
	
	@ManyToOne
	@JsonBackReference
	private VentasModel venta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	public ArticulosModel getArticulos() {
		return articulos;
	}

	public void setArticulos(ArticulosModel articulos) {
		this.articulos = articulos;
	}

	public VentasModel getVenta() {
		return venta;
	}

	public void setVenta(VentasModel venta) {
		this.venta = venta;
	}
	
	//@OneToMany(targetEntity = VentasModel.class)
	//private VentasModel venta;

	
		
	
}

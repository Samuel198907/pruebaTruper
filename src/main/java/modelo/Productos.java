package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTOS")
public class Productos {
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_ORDEN"))
	private Ordenes orden;
	
	@Column(name = "PRODUCTOID")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productoId;
	
	@Column(name = "CODIGO")
	private String codigo;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "PRECIO")
	private Double precio;

	public Ordenes getOrden() {
		return orden;
	}

	public void setOrden(Ordenes orden) {
		this.orden = orden;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}

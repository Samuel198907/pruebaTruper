package modelo;

import java.util.Date;

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
@Table(name = "ORDENES")
public class Ordenes {
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_SUCURSAL"))
	private Sucursales sucursal;
	
	@Column(name = "ORDENID")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ordenId;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "TOTAL")
	private Double total;

	public Sucursales getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursales sucursal) {
		this.sucursal = sucursal;
	}

	public Integer getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(Integer ordenId) {
		this.ordenId = ordenId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	
}

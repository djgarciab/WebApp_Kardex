package Modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "productos" )
public class Producto {

	
	@Id
	private String prodreferencia;
	@Column
	private String tiporeferencia;
	@Column
	private String prodnombre;
	@Column
	private String proddescripcion;
	
	
	public String getProdreferencia() {
		return prodreferencia;
	}
	public void setProdreferencia(String prodreferencia) {
		this.prodreferencia = prodreferencia;
	}
	public String getTiporeferencia() {
		return tiporeferencia;
	}
	public void setTiporeferencia(String tiporeferencia) {
		this.tiporeferencia = tiporeferencia;
	}
	public String getProdnombre() {
		return prodnombre;
	}
	public void setProdnombre(String prodnombre) {
		this.prodnombre = prodnombre;
	}
	public String getProddescripcion() {
		return proddescripcion;
	}
	public void setProddescripcion(String proddescripcion) {
		this.proddescripcion = proddescripcion;
	}
	
	@Override
	public String toString() {
		return "Producto [prodreferencia=" + prodreferencia + ", tiporeferencia=" + tiporeferencia + ", prodnombre="
				+ prodnombre + ", proddescripcion=" + proddescripcion + "]";
	}
	
	
	
	
}

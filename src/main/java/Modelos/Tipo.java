package Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tipos" )
public class Tipo {
	
	@Id
	private String tiporeferencia;
	@Column
	private String tiponombre;
	
	public String getTiporeferencia() {
		return tiporeferencia;
	}
	public void setTiporeferencia(String tiporeferencia) {
		this.tiporeferencia = tiporeferencia;
	}
	public String getTiponombre() {
		return tiponombre;
	}
	public void setTiponombre(String tiponombre) {
		this.tiponombre = tiponombre;
	}
	
	
	@Override
	public String toString() {
		return "tipo [tiporeferencia=" + tiporeferencia + ", tiponombre=" + tiponombre + "]";
	}
	
	
	
	
}

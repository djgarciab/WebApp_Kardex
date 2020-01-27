package Controladores;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import DAO.TipoDAO;
import Modelos.Tipo;

@ManagedBean (name = "tipoBean")
@RequestScoped
public class TipoBean {

	public String nuevo() {
		Tipo t = new Tipo();
		Map<String , Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("tipo", t);
		return "/faces/tipo/crear.xhtml";
	}
	
	public String guardar( Tipo tipo) {
		TipoDAO tipoDAO = new TipoDAO();
		tipoDAO.guardar(tipo);
		return "/faces/tipo/listar.xhtml";
	}
	
	public List<Tipo> obtenerTipos(){
		
		TipoDAO tipoDAO = new TipoDAO();	
		System.out.println("en obtener tipos");
		return tipoDAO.obtenerLista();

	}
	
	public String editar(String id) {
		TipoDAO tipoDAO = new TipoDAO();
		Tipo t = new Tipo();
		t = tipoDAO.buscar(id);
		System.out.println("---------------------");
		System.out.println(t);
		
		Map<String , Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("tipo", t);
		return "/faces/tipo/editar.xhtml";
		
	}
	
	public String actualizar( Tipo tipo) {
		TipoDAO tipoDAO = new TipoDAO();
		tipoDAO.editar(tipo);
		return "/faces/tipo/listar.xhtml";
	}
	//Eliminar un tipo
	public String eliminar(String t) {
		TipoDAO tipoDAO = new TipoDAO();
		tipoDAO.eliminar(t);
		System.out.println("Tipo de Producto eliminado--------------");
		return "/faces/tipo/listar.xhtml";
	}
}

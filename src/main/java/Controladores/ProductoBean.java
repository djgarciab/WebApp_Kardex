package Controladores;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import DAO.ProductoDAO;
import Modelos.Producto;


@ManagedBean (name = "productoBean")
@RequestScoped

public class ProductoBean {
	

	public String nuevo() {
		Producto p = new Producto();
		Map<String , Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", p);
		return "/faces/producto/crear.xhtml";
	}
	
	public String guardar( Producto producto) {
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.guardar(producto);
		return "/faces/producto/listar.xhtml";
	}
	
	public List<Producto> obtenerProductos(){
		
		ProductoDAO productoDAO = new ProductoDAO();	
		System.out.println("en obtener productos");
		return productoDAO.obtenerLista();

	}
	
	public String editar(String id) {
		ProductoDAO productoDAO = new ProductoDAO();	
		Producto p = new Producto();
		p = productoDAO.buscar(id);
		System.out.println("---------------------");
		System.out.println(p);
		
		Map<String , Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", p);
		return "/faces/producto/editar.xhtml";
		
	}
	
	public String actualizar( Producto producto) {
		ProductoDAO productoDAO = new ProductoDAO();	
		productoDAO.editar(producto);
		return "/faces/producto/listar.xhtml";
	}
	//Eliminar un tipo
	public String eliminar(String p) {
		ProductoDAO productoDAO = new ProductoDAO();	
		productoDAO.eliminar(p);
		System.out.println("Producto eliminado--------------");
		return "/faces/producto/listar.xhtml";
	}

}

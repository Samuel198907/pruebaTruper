package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import modelo.Ordenes;
import modelo.Productos;
import modelo.Sucursales;
import servicio.ServicioSucursales;

@RestController
public class Controller {
	
	@Autowired
	ServicioSucursales servicio;
	@GetMapping(path = "consulta/sucursales")
	public List<Sucursales> consultarSucursales(){
		return servicio.consultarSucursales();
	}
	
	@GetMapping(path = "consulta/productos")
	public List<Productos> consultarProductos(){
		return servicio.consultarProductos();
	}
	
	@GetMapping(path = "consulta/orden")
	public Ordenes consultarOrden(@RequestParam Integer ordenId){
		return servicio.consultarOrden(ordenId);
	}
	
	@PutMapping(path = "modifica/precio", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Boolean modificar(@RequestBody Productos producto){
		return servicio.modificarProducto(producto);
	}
	
	

	
	
	@PostMapping(path = "guardar/orden" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public Integer guadarOrden(@RequestBody List<Productos> listaProductos){
		return servicio.guardarOrden(listaProductos);
	}
}

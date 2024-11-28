package servicio;

import java.util.List;

import modelo.Ordenes;
import modelo.Productos;
import modelo.Sucursales;

public interface ServicioSucursales {

	List<Sucursales> consultarSucursales();

	Integer guardarOrden(List<Productos> listaProductos);

	List<Productos> consultarProductos();

	Ordenes consultarOrden(Integer ordenId);

	Boolean modificarProducto(Productos producto);
}

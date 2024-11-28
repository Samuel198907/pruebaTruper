package dao;

import java.util.List;

import modelo.Ordenes;
import modelo.Productos;

public interface ProductosDao {
	Boolean guardar(List<Productos> lista, Ordenes orden);

	List<Productos> consulta();

	Boolean modificar(Productos producto);

	Productos buscarPorCodigo(String codigo);
}

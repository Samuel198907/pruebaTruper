package dao;

import java.util.List;

import modelo.Ordenes;

public interface OrdenesDao {
	Ordenes guardar(Ordenes orden);

	List<Ordenes> consulta();

	Ordenes consultarOrden(Integer ordenId);
}

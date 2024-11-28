package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import modelo.Ordenes;

@Repository
public class OrdenesDaoImpl implements OrdenesDao{

	@Autowired
	OrdenenesJpaSpring jpa;
	
	@Override
	public Ordenes guardar(Ordenes orden) {		
		jpa.save(orden);	
		return orden;
	}

	@Override
	public List<Ordenes> consulta() {
		return jpa.findAll();
	}

	@Override
	public Ordenes consultarOrden(Integer ordenId) {
		return jpa.findById(ordenId).get();
	}

}

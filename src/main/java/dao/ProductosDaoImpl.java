package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import modelo.Ordenes;
import modelo.Productos;

@Repository
public class ProductosDaoImpl implements ProductosDao{

	@Autowired
	ProductosJpaSpring jpa;
	
	@Override
	public Boolean guardar(List<Productos> lista, Ordenes orden) {
		for(Productos pro : lista ) {
			pro.setOrden(orden);
			jpa.save(pro);
		}
		return true;
	}

	@Override
	public List<Productos> consulta() {
		return jpa.findAll();
	}

	@Override
	public Boolean modificar(Productos producto) {
		jpa.save(producto);
		return true;
	}

	@Override
	public Productos buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return jpa.findByCodigo(codigo);
		
	}

}

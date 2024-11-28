package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import modelo.Sucursales;

@Repository
public class SucursalesDaoImpl implements SucursalesDao{

	
	@Autowired
	SucursalesJpaSpring jpa;


	@Override
	public List<Sucursales> consulta() {
		return jpa.findAll();
	}

}

package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Productos;

public interface ProductosJpaSpring extends JpaRepository<Productos, Integer>{

	Productos findByCodigo(String codigo);

}

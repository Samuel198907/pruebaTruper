package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Ordenes;

public interface OrdenenesJpaSpring extends JpaRepository<Ordenes, Integer>{

}

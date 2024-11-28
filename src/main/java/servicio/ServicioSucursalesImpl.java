package servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrdenesDao;
import dao.ProductosDao;
import dao.SucursalesDao;
import modelo.Ordenes;
import modelo.Productos;
import modelo.Sucursales;

@Service
public class ServicioSucursalesImpl implements ServicioSucursales{

	@Autowired
	SucursalesDao dao;
	@Autowired
	ProductosDao daoPro;
	@Autowired
	OrdenesDao daoOrd;
	
	@Override
	public List<Sucursales> consultarSucursales() {
		return dao.consulta();
	}
	@Override
	public Integer guardarOrden(List<Productos> listaProductos) {
		// TODO Auto-generated method stub
		 Ordenes orden = new Ordenes();
		 orden.setFecha(new Date());
		 Sucursales sucursal = new Sucursales();
		 sucursal.setSucursalId(1);
		 orden.setSucursal(sucursal );
		 orden.setTotal(listaProductos.stream().mapToDouble(p->p.getPrecio()).sum()); 
		 Ordenes ordenSave = daoOrd.guardar(orden);
		 daoPro.guardar(listaProductos, ordenSave);
		return ordenSave.getOrdenId();
	}
	
	@Override
	public List<Productos> consultarProductos() {
		return daoPro.consulta();
	}
	
	@Override
	public Ordenes consultarOrden(Integer ordenId) {
		return daoOrd.consultarOrden(ordenId);
	}
	@Override
	public Boolean modificarProducto(Productos producto) {
		Productos proMod = daoPro.buscarPorCodigo(producto.getCodigo());
		if(proMod!=null) {
			proMod.setPrecio(producto.getPrecio());
			return daoPro.modificar(proMod);
		}			
			
		else return false; ///No existe return falase
	}

}

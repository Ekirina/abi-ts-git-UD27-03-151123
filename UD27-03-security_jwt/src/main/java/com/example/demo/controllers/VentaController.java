package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Venta;
import com.example.demo.services.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {
	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/venta")
	public List<Venta> listarVenta(){
		return ventaServiceImpl.listar();
	}
	@PostMapping("/venta")
	public Venta salvarVenta(@RequestBody Venta venta) {
		
		return ventaServiceImpl.guardar(venta);
	}
	@GetMapping("/venta/{id}")
	public Venta productosXID(@PathVariable(name="id")int id) {
		Venta Venta_xid = new Venta();
		Venta_xid = ventaServiceImpl.porIdentificador(id);
		System.out.println("Venta XID: "+Venta_xid);
		return Venta_xid;
	}
	@PutMapping("/venta/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")int id, @RequestBody Venta venta) {
		Venta Venta_seleccionado= new Venta();
		Venta Venta_actualizado= new Venta();

		Venta_seleccionado= ventaServiceImpl.porIdentificador(id);

		Venta_seleccionado.setCajeros(venta.getCajeros());
		Venta_seleccionado.setProductos(venta.getProductos());
		Venta_seleccionado.setMaquinas_registradoras(venta.getMaquinas_registradoras());

		Venta_actualizado = ventaServiceImpl.actualizar(Venta_seleccionado);

		System.out.println("La venta actualizada es: "+ Venta_actualizado);

		return Venta_actualizado;
	}
	@DeleteMapping("/venta/{id}")
	public void eliminarVenta(@PathVariable(name="id")int id) {
		ventaServiceImpl.eliminar(id);
	}
}

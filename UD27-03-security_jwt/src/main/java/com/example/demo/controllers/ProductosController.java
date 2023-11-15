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

import com.example.demo.dto.Productos;
import com.example.demo.services.ProductosServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductosController {
	@Autowired
	ProductosServiceImpl productosServiceImpl;
	
	@GetMapping("/productos")
	public List<Productos> listarProductos(){
		return productosServiceImpl.listar();
	}
	@PostMapping("/productos")
	public Productos salvarProductos(@RequestBody Productos productos) {
		
		return productosServiceImpl.guardar(productos);
	}
	@GetMapping("/productos/{id}")
	public Productos productosXID(@PathVariable(name="codigo_producto")int codigo_producto) {
		Productos Productos_xid = new Productos();
		Productos_xid = productosServiceImpl.porIdentificador(codigo_producto);
		System.out.println("Productos XID: "+Productos_xid);
		return Productos_xid;
	}
	@PutMapping("/productos/{id}")
	public Productos actualizarProductos(@PathVariable(name="codigo_productos")int codigo_productos, @RequestBody Productos productos) {
		Productos Productos_seleccionado= new Productos();
		Productos Productos_actualizado= new Productos();

		Productos_seleccionado= productosServiceImpl.porIdentificador(codigo_productos);

		Productos_seleccionado.setNombre(productos.getNombre());
		Productos_seleccionado.setPrecio(productos.getPrecio());

		Productos_actualizado = productosServiceImpl.actualizar(Productos_seleccionado);

		System.out.println("El producto actualizado es: "+ Productos_actualizado);

		return Productos_actualizado;
	}
	@DeleteMapping("/productos/{id}")
	public void eliminarProductos(@PathVariable(name="codigo_productos")int codigo_productos) {
		productosServiceImpl.eliminar(codigo_productos);
	}
}

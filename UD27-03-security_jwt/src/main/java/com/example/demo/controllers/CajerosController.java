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

import com.example.demo.dto.Cajeros;
import com.example.demo.services.CajerosServiceImpl;

@RestController
@RequestMapping("/api")
public class CajerosController {
	@Autowired
	CajerosServiceImpl cajerosServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajeros> listarCajeros(){
		return cajerosServiceImpl.listar();
	}
	@PostMapping("/cajeros")
	public Cajeros salvarCajeros(@RequestBody Cajeros cajeros) {
		
		return cajerosServiceImpl.guardar(cajeros);
	}
	@GetMapping("/cajeros/{id}")
	public Cajeros cajerosXID(@PathVariable(name="codigo")int codigo) {
		Cajeros Cajeros_xid = new Cajeros();
		Cajeros_xid = cajerosServiceImpl.porIdentificador(codigo);
		System.out.println("Cajeros XID: "+Cajeros_xid);
		return Cajeros_xid;
	}
	@PutMapping("/cajeros/{id}")
	public Cajeros actualizarCajeros(@PathVariable(name="codigo")int codigo, @RequestBody Cajeros cajeros) {
		Cajeros Cajeros_seleccionado= new Cajeros();
		Cajeros Cajeros_actualizado= new Cajeros();

		Cajeros_seleccionado= cajerosServiceImpl.porIdentificador(codigo);

		Cajeros_seleccionado.setNom_apels(cajeros.getNom_apels());

		Cajeros_actualizado = cajerosServiceImpl.actualizar(Cajeros_seleccionado);

		System.out.println("El cajero actualizado es: "+ Cajeros_actualizado);

		return Cajeros_actualizado;
	}
	@DeleteMapping("/cajeros/{id}")
	public void eliminarCajeros(@PathVariable(name="codigo")int codigo) {
		cajerosServiceImpl.eliminar(codigo);
	}
}

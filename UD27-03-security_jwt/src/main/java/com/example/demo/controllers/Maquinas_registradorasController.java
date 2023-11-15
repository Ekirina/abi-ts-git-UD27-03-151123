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

import com.example.demo.dto.Maquinas_registradoras;
import com.example.demo.services.Maquinas_registradorasServiceImpl;

@RestController
@RequestMapping("/api")
public class Maquinas_registradorasController {
	@Autowired
	Maquinas_registradorasServiceImpl maquinas_registradorasServiceImpl;
	
	@GetMapping("/maquinas_registradoras")
	public List<Maquinas_registradoras> listarMaquinas(){
		return maquinas_registradorasServiceImpl.listar();
	}
	@PostMapping("/maquinas_registradoras")
	public Maquinas_registradoras salvarMaquinas(@RequestBody Maquinas_registradoras maquinas_registradoras) {
		
		return maquinas_registradorasServiceImpl.guardar(maquinas_registradoras);
	}
	@GetMapping("/maquinas_registradoras/{id}")
	public Maquinas_registradoras maquinasXID(@PathVariable(name="codigo_maquina")int codigo_maquina) {
		Maquinas_registradoras Maquinas_xid = new Maquinas_registradoras();
		Maquinas_xid = maquinas_registradorasServiceImpl.porIdentificador(codigo_maquina);
		System.out.println("Maquinas XID: "+Maquinas_xid);
		return Maquinas_xid;
	}
	@PutMapping("/maquinas_registradoras/{id}")
	public Maquinas_registradoras actualizarMaquinas(@PathVariable(name="codigo_maquina")int codigo_maquina, @RequestBody Maquinas_registradoras maquinas_registradoras) {
		Maquinas_registradoras Maquinas_seleccionado= new Maquinas_registradoras();
		Maquinas_registradoras Maquinas_actualizado= new Maquinas_registradoras();

		Maquinas_seleccionado= maquinas_registradorasServiceImpl.porIdentificador(codigo_maquina);

		Maquinas_seleccionado.setPiso(maquinas_registradoras.getPiso());

		Maquinas_actualizado = maquinas_registradorasServiceImpl.actualizar(Maquinas_seleccionado);

		System.out.println("La maquina registradora actualizada es: "+ Maquinas_actualizado);

		return Maquinas_actualizado;
	}
	@DeleteMapping("/maquinas_registradoras/{id}")
	public void eliminarMaquinas(@PathVariable(name="codigo_maquina")int codigo_maquina) {
		maquinas_registradorasServiceImpl.eliminar(codigo_maquina);
	}
}

package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Maquinas_registradoras;


public interface IMaquinas_registradorasService {
	
	public List<Maquinas_registradoras> listar(); //Listar All 
	
	public Maquinas_registradoras guardar(Maquinas_registradoras maquinas_registradoras);	//Guarda 
	
	public Maquinas_registradoras porIdentificador(int codigo_maquina); //Leer datos 
	
	public Maquinas_registradoras actualizar(Maquinas_registradoras maquinas_registradoras); //Actualiza datos 
	
	public void eliminar(int codigo_maquina);// Elimina datos
}

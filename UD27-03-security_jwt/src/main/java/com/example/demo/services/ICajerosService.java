package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Cajeros;

public interface ICajerosService {
	//Métodos del CRUD
public List<Cajeros> listar(); //Listar All 
	
	public Cajeros guardar(Cajeros cajeros);	//Guarda 
	
	public Cajeros porIdentificador(int codigo); //Leer datos 
	
	public Cajeros actualizar(Cajeros cajeros); //Actualiza datos 
	
	public void eliminar(int codigo);// Elimina datos
}

package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Productos;


public interface IProductosService {
	//Métodos del CRUD
public List<Productos> listar(); //Listar All 
	
	public Productos guardar(Productos productos);	//Guarda 
	
	public Productos porIdentificador(int codigo_producto); //Leer datos 
	
	public Productos actualizar(Productos productos); //Actualiza datos 
	
	public void eliminar(int codigo_producto);// Elimina datos
}


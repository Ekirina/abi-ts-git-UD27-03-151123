package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Venta;


public interface IVentaService {
public List<Venta> listar(); //Listar All 
	
	public Venta guardar(Venta venta);	//Guarda 
	
	public Venta porIdentificador(int id); //Leer datos 
	
	public Venta actualizar(Venta venta); //Actualiza datos 
	
	public void eliminar(int id);// Elimina datos

}

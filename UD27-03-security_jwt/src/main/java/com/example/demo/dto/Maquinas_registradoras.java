package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "maquinas_registradoras")
public class Maquinas_registradoras {
	@Id
	private int codigo_maquina;
	@Column(name="piso")
	private int piso;
	
	@OneToMany
	@JoinColumn(name="codigo_maquina")
	private List <Venta> venta;
	
	//Constrctores
	public Maquinas_registradoras() {
		
	}

	public Maquinas_registradoras(int codigo_maquina, int piso, List<Venta> venta) {
		//super();
		this.codigo_maquina = codigo_maquina;
		this.piso = piso;
		this.venta = venta;
	}
	//Getters y setters

	public int getCodigo_maquina() {
		return codigo_maquina;
	}

	public void setCodigo_maquina(int codigo_maquina) {
		this.codigo_maquina = codigo_maquina;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Ventas")
	public List<Venta> getVentas() {
		return venta;
	}

	public void setVentas(List<Venta> ventas) {
		this.venta = ventas;
	}
	
	//Método String
	
	@Override
	public String toString() {
		return "Maquinas_registradoras [codigo_maquina=" + codigo_maquina + ", piso=" + piso + "]";
	}
	

}

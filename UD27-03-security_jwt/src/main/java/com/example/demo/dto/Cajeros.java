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
@Table(name="cajeros")
public class Cajeros {
	//Atributos de los cajeros
	@Id
	private int codigo;
	@Column(name="nom_apels")
	private String nom_apels;
	
	@OneToMany
	@JoinColumn(name="codigo_cajero")
	private List<Venta> venta;
	
	//Constructores
	public Cajeros() {
		
	}

	public Cajeros(int codigo, String nom_apels, List<Venta> venta) {
		//super();
		this.codigo = codigo;
		this.nom_apels = nom_apels;
		this.venta = venta;
	}
	//Getters y setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNom_apels() {
		return nom_apels;
	}

	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	
	//Método String
	@Override
	public String toString() {
		return "Cajeros [codigo=" + codigo + ", nom_apels=" + nom_apels + "]";
	}
	
	
	
	
}

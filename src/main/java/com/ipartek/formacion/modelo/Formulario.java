package com.ipartek.formacion.modelo;

public class Formulario {

	private String nombre;
	private float pMin;
	private float pMax;
	private int idFabricante;
	
	public Formulario() {
		super();
		this.nombre="";
		this.pMin=0;
		this.pMax=0;
		this.idFabricante=0;

	}
	

	public Formulario(String nombre,String pMin, String pMax, String idFabricante) {
		this();
		this.setNombre(nombre);
		this.setpMin(pMin);
		this.setpMax(pMax);
		this.setIdFabricante(idFabricante);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre==null) {
			this.nombre = "";		
		}else {
			this.nombre=nombre.trim();
		}
	
	}

	public float getpMin() {
		return pMin;
	}

	public void setpMin(float pMin) {
		this.pMin = pMin;
	}
	public void setpMin(String pMin) {
		if (pMin==null) {
			this.pMin = 0;	
		}else if("".equals(pMin)) {
			this.pMin = 0;	
		}else {
			this.pMin = Float.parseFloat(pMin);
		}
		
		
	}

	public float getpMax() {
		return pMax;
	}

	public void setpMax(float pMax) {
		this.pMax = pMax;
	}
	public void setpMax(String pMax) {
		if (pMax==null) {
			this.pMax = 0;	
		}else if("".equals(pMax)) {
			this.pMax = 0;	
		}else {
			this.pMax = Float.parseFloat(pMax);	
		}
		
		
		
	}

	public int getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}
	
	public void setIdFabricante(String idFabricante) {
		if (idFabricante==null) {
			this.idFabricante = 0;	
		}else if("".equals(idFabricante)) {
			this.idFabricante=0;
		}else {
			this.idFabricante = Integer.parseInt(idFabricante);
		}
		
		
	}
	
	
}

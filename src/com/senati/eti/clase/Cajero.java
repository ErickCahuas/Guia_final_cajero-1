package com.senati.eti.clase;

import java.util.ArrayList;

public class Cajero {
	
	
	private String tarjetas;
	private int contrase�as;
	private String nombre;
	private float saldo;
	private ArrayList<Cajero>Cuentas = new ArrayList<Cajero>();
	

	
	public String getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(String tarjetas) {
		this.tarjetas = tarjetas;
	}

	public int getContrase�as() {
		return contrase�as;
	}

	public void setContrase�as(int contrase�as) {
		this.contrase�as = contrase�as;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}


	public Cajero() {
	}

	public Cajero(String tarjetas, int contrase�as, String nombre, float saldo) {
		this.tarjetas = tarjetas;
		this.contrase�as = contrase�as;
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public String Tarjeta () {
		return this.tarjetas;
	}
	
	public String Codigo (String n_tarj, ArrayList<Cajero>Cuentas) {
        String r = "";
	    
        for(int f = 0; f < Cuentas.size(); f++) {
            if(Cuentas.get(f).Tarjeta().equals(n_tarj))
                r = Cuentas.get(f).Tarjeta();
        }
        return r;
	}
	
	public int Contrase�a() {
		return this.contrase�as;
	}
	
	public int pass(String n_tarj, ArrayList<Cajero>Cuentas) {
        
		int r = 0;
	    
        for(int f = 0; f < Cuentas.size(); f++) {
            if(Cuentas.get(f).Tarjeta().equals(n_tarj))
            	r = Cuentas.get(f).Contrase�a();
        }
        return r;
	}
	
	public int cambio_contra(String n_tarj,int new_pass, ArrayList<Cajero>Cuentas) {
        int r = 0;
	    
        for(int f = 0; f < Cuentas.size(); f++) {
            if(Cuentas.get(f).Tarjeta().equals(n_tarj)) {
            	Cuentas.get(f).setContrase�as(new_pass);
                r = Cuentas.get(f).Contrase�a();
            }}
        return r;
        
	}
	
	
	
	
	
	public String Titular() {
		return this.nombre;
	}
	
	
	 public String nom (String n_tarj, ArrayList<Cajero>Cuentas ) {
	        
			String r = "";
		    
	        for(int f = 0; f < Cuentas.size(); f++) {
	            if(Cuentas.get(f).Tarjeta().equals(n_tarj))
	                r = Cuentas.get(f).Titular();
	        }
	        return r;
		}
	
	public float Saldo_actual() {
		return this.saldo;
	}
	 
	
	 public float saldo_actual(String n_tarj, ArrayList<Cajero>Cuentas) {
		 float r = 0;
		    
	        for(int f = 0; f < Cuentas.size(); f++) {
	            if(Cuentas.get(f).Tarjeta().equals(n_tarj))
	            r = Cuentas.get(f).Saldo_actual();
	             }
	        return r;
	}
	
	
	 public float retiro(String n_tarj, float descuento, ArrayList<Cajero>Cuentas) {
	        float r = 0;
	        for(int f = 0; f < Cuentas.size(); f++) {
	            if(Cuentas.get(f).Tarjeta().equals(n_tarj)) {
	            	Cuentas.get(f).setSaldo(Cuentas.get(f).Saldo_actual() - descuento);
	            	r = Cuentas.get(f).Saldo_actual();
	            }
	            
	        }
	        return r;
		}
	
	 public float deposito(String n_tarj, float aumento, ArrayList<Cajero>Cuentas) {
	        float r = 0;
	        for(int f = 0; f < Cuentas.size(); f++) {
	            if(Cuentas.get(f).Tarjeta().equals(n_tarj)) {
	            	Cuentas.get(f).setSaldo(Cuentas.get(f).Saldo_actual() + aumento);
	            	r = Cuentas.get(f).Saldo_actual();
	            }
	            
	        }
	        return r;
		}
	
	 
	
	
	
}
	
	
	
	
	

	
package com.senati.eti.clase;
import java.util.ArrayList;

public class Clases_cajero2 {
	

	

		private String[] tarjetas; 
		private String[] contrase�a;
		private String[] nombre;
		private ArrayList<Float>Saldo = new ArrayList<Float>();
		

		public String[] getTarjetas() {
			return tarjetas;
		}

		

		public ArrayList<Float> getSaldo() {
			return Saldo;
		}



		public void setSaldo(ArrayList<Float> saldo) {
			Saldo = saldo;
		}



		public void setTarjetas(String[] tarjetas) {
			this.tarjetas = tarjetas;
		}

		public String[] getContrase�a() {
			return contrase�a;
		}

		public void setContrase�a(String[] contrase�a) {
			this.contrase�a = contrase�a;
		}

		
		public String[] getNombre() {
			return nombre;
		}

		public void setNombre(String[] nombre) {
			this.nombre = nombre;
		}

		public Clases_cajero2() {
		}
		
		public Clases_cajero2(String[] tarjetas, String[] contrase�a, String[] nombre, ArrayList<Float> saldo) {
			this.tarjetas = tarjetas;
			this.contrase�a = contrase�a;
			this.nombre = nombre;
			Saldo = saldo;
		}
		public String Codigo (String n_tarj) {
	        String r = "";
		    
	        for(int f = 0; f < tarjetas.length; f++) {
	            if(tarjetas[f].equals(n_tarj))
	                r = this.tarjetas[f];
	        }
	        return r;
		}
		
		public String pass(String n_tarj) {
	        
			String r = "";
		    
	        for(int f = 0; f < tarjetas.length; f++) {
	            if(tarjetas[f].equals(n_tarj))
	                r = this.contrase�a[f];
	        }
	        return r;
		}

	    public String nom (String n_tarj) {
	        
			String r = "";
		    
	        for(int f = 0; f < tarjetas.length; f++) {
	            if(tarjetas[f].equals(n_tarj))
	                r = this.nombre[f];
	        }
	        return r;
		}
	    
	    public float saldo_actual(String n_tarj) {
			 float r = 0;
			    
		        for(int f = 0; f < tarjetas.length; f++) {
		            if(tarjetas[f].equals(n_tarj))
		            r = Saldo.get(f);
		             }
		        return r;
		}
	    

		public float retiro(String n_tarj, float descuento) {
			
	        float r = 0;
		    
	        for(int f = 0; f < tarjetas.length; f++) {
	            if(tarjetas[f].equals(n_tarj)) {
	              Saldo.set(f, saldo_actual(n_tarj) - descuento);
	               r = Saldo.get(f);
	        }
	        }
	        return r;
	        
		}

		public float deposito(String n_tarj, float aumento) {
			
	        float r = 0;
		    
	        for(int f = 0; f < tarjetas.length; f++) {
	            if(tarjetas[f].equals(n_tarj)) {
	              Saldo.set(f, saldo_actual(n_tarj) + aumento);
	               r = Saldo.get(f);
	        }
	        }
	        return r;
		}
	

}

package com.senati.eti;
import java.util.ArrayList;
import java.util.Scanner;
import com.senati.eti.clase.Clases_cajero;

public class Cajero_auto {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Clases_cajero cc = new Clases_cajero();
		
		
		String[] arrtarjeta = {"981-189", "125-485", "123-798", "369-852"};
		String[] arrnombre = { "Victor Marquina", "Angel Flores", "Juan Benavides", "Israel Montes"};
		String[] arrcontra = { "2478", "7845", "1265", "7891"};
		
		ArrayList<Float>saldo = new ArrayList<Float>();
		saldo.add(0, 500f);
		saldo.add(1, 800f);
		saldo.add(2, 920f);
		saldo.add(3, 131f);
		
		
		cc.setTarjetas(arrtarjeta);
		cc.setContraseña(arrcontra);
		cc.setNombre(arrnombre);
		cc.setSaldo(saldo);

		String n_tarjeta = "";
		String contra = "";
		
		System.out.println("\n------------------------------------");
		System.out.println("<<<<<<<<<<CAJERO AUTOMATICO>>>>>>>>>");
		System.out.println("------------------------------------");
		
		
		System.out.print("Ingrese número de tarjeta: ");
		n_tarjeta = entrada.nextLine();
		
		if (!(n_tarjeta.equals(cc.Codigo(n_tarjeta))))
			System.out.print("Tarjeta incorrecta......");
		
		
		int contador = 0;
		do {
		if (n_tarjeta.equals(cc.Codigo(n_tarjeta))) {
			System.out.print("\nIngrese su contraseña: ");
		    contra = entrada.nextLine();
		
		    if(contra.equals(cc.pass(n_tarjeta))) {
		    	System.out.print("\nNombre del titular....: " + cc.nom(n_tarjeta));
		    
		    int bandera = 0;
			int seleccion = 0;
			
				do {
					System.out.println("\n");
					System.out.println("\nPor favor seleccione una opción");
					System.out.println("         1. Consulta de cuenta");
					System.out.println("         2. Retiro en efectivo");
					System.out.println("         3. Deposito en efectivo");
					System.out.println("         4. Salir");
					System.out.print("\nOpción: " );
					seleccion = entrada.nextInt();
					
					float retiro = 0, deposito = 0;
					
					switch(seleccion) {
					case 1:
						System.out.print("Titular....: " + cc.nom(n_tarjeta));
						System.out.println("\nSaldo disponible: " + cc.saldo_actual(n_tarjeta));
						break;
					case 2:
						System.out.print("¿Cuanto desea retirar? : ");
						retiro = entrada.nextFloat();
						if(retiro < cc.saldo_actual(n_tarjeta)) {
							System.out.println("Usted a retirado: " + retiro);
						    System.out.println("Su nuevo saldo es: "+ cc.retiro(n_tarjeta, retiro));
						}else 
							System.out.println("Saldo insuficiente.....");
						break;
					
					case 3:
						System.out.print("¿Cuanto desea depositar? : ");
						deposito = entrada.nextFloat();
							System.out.println("Usted a depositado: " + deposito);
						    System.out.println("Su nuevo saldo es: "+ cc.deposito(n_tarjeta, deposito));
						    break;
					case 4:
						System.out.println("¡Gracias! vuelva pronto tulon");
						break;
						}
					if(seleccion < 1 || seleccion > 4) {
						
						
						System.out.println("-----------------------------------------------------");
						System.out.println("Opción no disponible, vuelva a intentar por favor....");
						System.out.println("-----------------------------------------------------");
					}
				
					entrada.nextLine();
					String rpta = "";
					do {
					if (seleccion != 4) {
						System.out.print("\n¿Desea realizar otra operación[S|N]: ");
					    rpta = entrada.nextLine();
					    if (!rpta.toUpperCase().equals("S") && !rpta.toUpperCase().equals("N"))
					    System.out.println("Opción no valida.........");
					}
					}while(!rpta.toUpperCase().equals("S") && !rpta.toUpperCase().equals("N"));
					
					
					if ("S".equals(rpta.toUpperCase()))
						seleccion = 5;
					else
						break;
					
					if("N".equals(rpta.toUpperCase())) 
						seleccion = 4;
					
				} while (seleccion < 1 || seleccion > 4);
		
		    }else {
             System.out.print("Contraseña no valida.....");
		    
		    contador++;
		
		    
		    }}}while(contador > 0 && contador != 3) ;
		 
			
			
		
		}
	}
		
		
		
	

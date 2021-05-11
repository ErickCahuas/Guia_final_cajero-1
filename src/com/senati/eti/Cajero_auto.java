package com.senati.eti;
import java.util.ArrayList;
import java.util.Scanner;
import com.senati.eti.clase.Cajero;
import com.senati.eti.clase.Suministros;



public class Cajero_auto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Transferencias, Cambio de clave ,cambio a dolar
		
		int min = 100, max = 999;
		
		Cajero objCu1 = new Cajero("981-189",2478, "Victor Marquina", 500);
		Cajero objCu2 = new Cajero("125-485",7845,"Angel Flores", 800);
		Cajero objCu3 = new Cajero("123-798", 1265,"Juan Benavides", 920);
		Cajero objCu4 = new Cajero("369-852", 7891,"Israel Montes", 131);
		
		Cajero cc = new Cajero();
		String rpta = "";
		int opc = 0, numDigits=0;
		int seleccion = 0;

		// Variable del Array
		String tarjeta = "", nombre = "";
		int contraseña = 0;
		float Saldo = 0;

		ArrayList<Cajero>Cuentas = new ArrayList<Cajero>();
	
		Cajero objCu5 = null;
		Cuentas.add(objCu1);
		Cuentas.add(objCu2);
		Cuentas.add(objCu3);
		Cuentas.add(objCu4);
		
		Suministros sm = new Suministros();
		ArrayList<Suministros>Sum = new ArrayList<Suministros>();
		Suministros Sum1 = new Suministros(35.50f, 45.40f, 1234567, 2345678);
		Suministros Sum2 = new Suministros(132f, 98.60f, 7654321 , 8765432);
		Sum.add(Sum1);
		Sum.add(Sum2);

		// Lectura de datos
		String n_tarjeta = "";
		int contra = 0;
		
		
		System.out.println("\n------------------------------------");
		System.out.println("<<<<<<<<<<CAJERO AUTOMATICO>>>>>>>>>");
		System.out.println("------------------------------------");
		
	
		do {
			
		System.out.println("¿Que desea realizar?");
		System.out.println("\n1. Crear una cuenta ");
		System.out.println("2. Acceder a su cuenta");
		System.out.println("3. Salir");
		System.out.print("\nElija una opcion: ");
		opc= sc.nextInt();
		if(opc == 1) {
			do {
				System.out.println("*****************");
				System.out.println("REGISTRO DE DATOS");
				System.out.println("*****************");
				sc.nextLine();
				System.out.print("TItular: ");
				nombre = sc.nextLine();
				System.out.print("N° Tarjeta: ");
				int tarj1 = (int)Math.floor(Math.random()*(max-min+1)+min);
				int tarj2 = (int)Math.floor(Math.random()*(max-min+1)+min);
				tarjeta = tarj1 + "-" + tarj2;
				System.out.println(tarjeta);
				do {
				System.out.print("Contraseña(4 digitos): ");
				contraseña = sc.nextInt();
				 numDigits = String.valueOf(contraseña).length();
				
				if(numDigits != 4)
					System.out.println("Contraseña no valida, intente nuevamente");
				}while(numDigits != 4);
				Saldo = 0;
				objCu5 = new Cajero (tarjeta, contraseña, nombre, Saldo);
				Cuentas.add(objCu5);

					 sc.nextLine();
					 
					 do {
						System.out.print("\n¿Desea crear otra cuenta?: ");
					    rpta = sc.nextLine();
					    if (!rpta.toUpperCase().equals("S") && !rpta.toUpperCase().equals("N"))
					    System.out.println("<<<<<<<<Opción no valida>>>>>>>>");
					
					}while(!rpta.toUpperCase().equals("S") && !rpta.toUpperCase().equals("N"));
				}while(rpta.toUpperCase().equals("S"));
		
		}else if(opc == 2){
			
			sc.nextLine();
		System.out.print("Ingrese número de tarjeta: ");
		n_tarjeta = sc.nextLine();
		if (!(n_tarjeta.equals(cc.Codigo(n_tarjeta, Cuentas)))) {
			System.out.println("Tarjeta incorrecta......");
			System.out.println("-----------------------------------------------------");
			System.out.println("<<<<<<<<<< MUCHAS GRACIAS, VUELVA PRONTO >>>>>>>>>>");
			System.out.println("-----------------------------------------------------");
			return;
		}
		
		int contador = 0;
		do {
		if (n_tarjeta.equals(cc.Codigo(n_tarjeta, Cuentas))) {
			System.out.print("\nIngrese su contraseña: ");
		    contra = sc.nextInt();
		
		    if(contra == (cc.pass(n_tarjeta, Cuentas))) {
		    	System.out.println("\nBIENVENIDO A LA PLATAFORMA");
		    	System.out.println("****************************");
		    	System.out.print("\nNombre del titular....: " + cc.nom(n_tarjeta, Cuentas));
		    	System.out.println("\nSaldo disponible: " + cc.saldo_actual(n_tarjeta, Cuentas));
		    
			
			
				do {
					System.out.println("\n");
					System.out.println("   \n¿Que operación desea realizar?");
					System.out.println("    1. Consulta de cuenta");
					System.out.println("    2. Retiro en efectivo");
					System.out.println("    3. Deposito en efectivo");
					System.out.println("    4. Pago de servicio");
					System.out.println("    5. Transferencia");
					System.out.println("    8. Salir");
					System.out.print("\nSeleccione una opción: " );
					seleccion = sc.nextInt();
					
					float retiro = 0, deposito = 0;
					
					switch(seleccion) {
					case 1:
						System.out.println("\n");
						System.out.println("<<<<<<<CONSULTA DEL SALDO>>>>>>>");
						System.out.print("\nTitular....: " + cc.nom(n_tarjeta, Cuentas));
						System.out.println("\nSaldo disponible: " + cc.saldo_actual(n_tarjeta, Cuentas));
						break;
					case 2:
						System.out.println("\n");
						System.out.println("<<<<<<<RETIRO>>>>>>>");
						System.out.print("\n¿Cuanto desea retirar? : ");
						retiro = sc.nextFloat();
						if(retiro <= cc.saldo_actual(n_tarjeta, Cuentas)) {
							System.out.println("Usted a retirado: " + retiro);
						    System.out.println("Su nuevo saldo es: "+ cc.retiro(n_tarjeta, retiro, Cuentas));
						}else 
							System.out.println("Saldo insuficiente.....");
						break;
					
					case 3:
						System.out.println("\n");
						System.out.println("<<<<<<<DEPOSITO>>>>>>>");
						System.out.print("\n¿Cuanto desea depositar? : ");
						deposito = sc.nextFloat();
							System.out.println("Usted a depositado: " + deposito);
						    System.out.println("Su nuevo saldo es: "+ cc.deposito(n_tarjeta, deposito, Cuentas));
						    break;
					case 4:
						System.out.println("¿Que servicio desea pagar?");
						System.out.println("      1. Agua");
						System.out.println("      2. Luz");
						System.out.print("Elija una opcion: ");
						 int serv = sc.nextInt();
						 
						 switch(serv) {
						 case 1:
							 int n_sum = 0;
					
							 System.out.print("Ingrese número de suministro (7 digitos): ");
							 n_sum = sc.nextInt();
							 if(sm.SumA(n_sum, Sum) == n_sum) {
							 System.out.println("Su deuda total es de: " + sm.PagoAgua(n_sum, Sum));
							 System.out.println("  \n1. Pagar el servicio");
							 System.out.println("    2. Salir");
							 System.out.print("\nElija: ");
							 int elecc = sc.nextInt();
							 if(elecc == 1) {
								 retiro = sm.PagoAgua(n_sum, Sum);
								 if(retiro <= cc.saldo_actual(n_tarjeta, Cuentas)) {
										System.out.println("<<<<<<<PAGO REALIZADO>>>>>>>");
									    System.out.println("Su nuevo saldo es: "+ cc.retiro(n_tarjeta, retiro, Cuentas));
									    sm.Agua_actual(n_sum, Sum);
									}else 
										System.out.println("Saldo insuficiente.....");
								 
							 }
						}else
							 System.out.println("Suministro erroneo");
						  break;
						
						 case 2:
							 int n_sum2 = 0;
								
							 System.out.print("Ingrese número de suministro (7 digitos): ");
							 n_sum2 = sc.nextInt();
							 if(sm.SumL(n_sum2, Sum) == n_sum2) {
							 System.out.println("Su deuda total es de: " + sm.PagoLuz(n_sum2, Sum));
							 System.out.println("  \n1. Pagar el servicio");
							 System.out.println("    2. Salir");
							 System.out.print("\nElija: ");
							 int elecc = sc.nextInt();
							 if(elecc == 1) {
								 retiro = sm.PagoLuz(n_sum2, Sum);
								 if(retiro <= cc.saldo_actual(n_tarjeta, Cuentas)) {
										System.out.println("<<<<<<<PAGO REALIZADO>>>>>>>");
									    System.out.println("Su nuevo saldo es: "+ cc.retiro(n_tarjeta, retiro, Cuentas));
									    sm.Luz_actual(n_sum2, Sum);
									}else 
										System.out.println("Saldo insuficiente.....");
								 
							 }
						}else
							 System.out.println("Suministro erroneo");
							 break;
						 }
						 break;
						 
					case 5:
						System.out.println("\n");
						System.out.println("<<<<<<<Transferencia>>>>>>>");
						sc.nextLine();
						System.out.println("Ingrese número de tarjeta: ");
						String n_tarjeta2 = sc.nextLine();
						System.out.print("\nIngrese el monto a transferir: ");
						retiro = sc.nextFloat();
						if(retiro <= cc.saldo_actual(n_tarjeta, Cuentas)) {
							System.out.println("Usted a transferido: " + retiro);
						    System.out.println("Su nuevo saldo es: "+ cc.retiro(n_tarjeta, retiro, Cuentas));
						cc.deposito(n_tarjeta2, retiro, Cuentas);
						}else 
							System.out.println("Saldo insuficiente.....");
						
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						/*System.out.println("-----------------------------------------------------");
						System.out.println("<<<<<<<<<< MUCHAS GRACIAS, VUELVA PRONTO >>>>>>>>>>");
						System.out.println("-----------------------------------------------------");*/
						break;
						}
					
					if(seleccion < 1 || seleccion > 8) {
						
						System.out.println("-----------------------------------------------------");
						System.out.println("Opción no disponible, vuelva a intentar por favor....");
						System.out.println("-----------------------------------------------------");
					}
					sc.nextLine();
					
					do {
					if (seleccion != 8) {
						System.out.print("\n¿Desea realizar otra operación[S|N]: ");
					    rpta = sc.nextLine();
					    if (!rpta.toUpperCase().equals("S") && !rpta.toUpperCase().equals("N"))
					    System.out.println("<<<<<<<<Opción no valida>>>>>>>>");
					}
					}while(!rpta.toUpperCase().equals("S") && !rpta.toUpperCase().equals("N"));
					
					sc.nextLine();
					
					if ("S".equals(rpta.toUpperCase()))
						seleccion = 9;
					else if("N".equals(rpta.toUpperCase())) 
						seleccion = 8;
					
				} while (seleccion < 1 || seleccion > 8);
		
		    }else {
             System.out.println("Contraseña no valida.....");
             System.out.println("Quedan " + ((contador - 2)* -1) + " intentos");
             contador++;
		    
		    }}}while(contador > 0 && contador != 3);
		
		System.out.println("-----------------------------------------------------");
		System.out.println("<<<<<<<<<< MUCHAS GRACIAS, VUELVA PRONTO >>>>>>>>>>");
		System.out.println("-----------------------------------------------------");	
		return;
		
		}else if(opc == 3) {
			System.out.println("-----------------------------------------------------");
			System.out.println("<<<<<<<<<< MUCHAS GRACIAS, VUELVA PRONTO >>>>>>>>>>");
			System.out.println("-----------------------------------------------------");
		}
		else
			System.out.println("Operacion no valida, intente nuevamente");
		sc.nextLine();
		}while(opc != 3);

		}
}
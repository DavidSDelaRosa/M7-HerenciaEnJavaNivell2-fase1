package com.vehicles.project;

import java.util.*;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("¿Qué quieres crear? \n1. Un coche\n2. Una moto\n3. Un camion");
		int eleccion = sc.nextInt();
		sc.nextLine();
		
		if(eleccion==1) {
			
			System.out.println("Introduce la matrícula del coche: ");
			String matriculaCoche = sc.nextLine();
			
			System.out.println("Introduce ahora la marca: ");
			String marcaCoche = sc.nextLine();
			
			System.out.println("Especifica el color del coche: ");
			String colorCoche = sc.nextLine();
			
			Car car = new Car(matriculaCoche, marcaCoche, colorCoche);
			
			System.out.println("Ahora vamos a ponerle las ruedas delanteras...");
			Wheel ruedaDelantera = pedirRueda();
			
			System.out.println("Vamos con las traseras...");
			Wheel ruedaTrasera = pedirRueda();
			
			List<Wheel> ruedasDelanteras = new ArrayList<>();
			ruedasDelanteras.add(ruedaDelantera);
			ruedasDelanteras.add(ruedaDelantera);
			
			List<Wheel> ruedasTraseras = new ArrayList<>();
			ruedasTraseras.add(ruedaTrasera);
			ruedasTraseras.add(ruedaTrasera);
			
			car.addWheels(ruedasDelanteras, ruedasTraseras);
			
			System.out.println(car.toString());
			
		}else if(eleccion==2) {
			
			System.out.println("Introduce la matrícula de la moto: ");
			String matriculaMoto = sc.nextLine();
			
			System.out.println("Introduce la marca: ");
			String marcaMoto = sc.nextLine();
			
			System.out.println("Color de la moto: ");
			String colorMoto = sc.nextLine();
			
			Bike bike = new Bike(matriculaMoto, marcaMoto, colorMoto);
			
			System.out.println("Ahora vamos a ponerle las ruedas delanteras...");
			Wheel ruedaDelantera = pedirRueda();
			
			System.out.println("Vamos con las traseras...");
			Wheel ruedaTrasera = pedirRueda();
			
			bike.addWheels(ruedaDelantera, ruedaTrasera);
			
			System.out.println(bike.toString());
			
		}else if(eleccion==3){
			
			System.out.println("Introduce la matrícula del camión: ");
			String matriculaCamion = sc.nextLine();
			
			System.out.println("Introduce ahora la marca: ");
			String marcaCamion = sc.nextLine();
			
			System.out.println("Especifica el color del camión: ");
			String colorCamion = sc.nextLine();
			
			Truck truck = new Truck(matriculaCamion, marcaCamion, colorCamion);
			
			System.out.println("Cuántas ruedas tiene el camión: 4, 6, 8, 10 ó 12 ?");
			
			int ruedasTotalesCamion = sc.nextInt();
			sc.nextLine();
			
			List<Wheel> ruedasCamion = new ArrayList<>();
			
			System.out.println("Necesitaré la marca y diámetro de las ruedas... ");
			
			for(int i=0;i<ruedasTotalesCamion/2;i++) {
				
				System.out.println("Pidiendo par de ruedas nº " + (i+1));
				Wheel rueda = pedirRueda();
				ruedasCamion.add(rueda);
				ruedasCamion.add(rueda);
			}
			
			truck.addWheels(ruedasCamion);
			
			System.out.println("Número correcto de ruedas: " + truck.suitableNumberOfWheels());
			
		}else {
			System.err.println("Sólo hay tred opciones válidas: [1 -> Coche | 2 -> Moto | 3 -> Camion]");
		}
		
		sc.close();
	}
	
	public static Wheel pedirRueda() throws InvalidWheelDiameterException {
		
		Wheel rueda;
		
		System.out.println("De qué marca quieres la rueda: ");
		String marcaRueda = sc.nextLine();
		
		System.out.println("Diámetro de la rueda trasera: ");
		double diametroRueda = sc.nextDouble();
		sc.nextLine();
		
		rueda = new Wheel(marcaRueda, diametroRueda);
		
		return rueda;
	}
}

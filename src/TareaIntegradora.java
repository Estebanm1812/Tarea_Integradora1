import java.util.Scanner;
public class TareaIntegradora{
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[]args){	
		int quantity = 0;
	
		if( quantity < 1){
			System.out.println("cuantos productos va a utilizar?");
			quantity = sc.nextInt();
			sc.nextLine();
		}
		
		String [] productsNames = new String[quantity]; 
		double [] productsQuantity = new double[quantity];
		double [] productsPriceHomeCenter = new double[quantity];
		double [] productsPriceInTheCenter = new double[quantity];
		double [] productsPriceInTheNeightborhood = new double[quantity];
		WorkType [] useOfTheMaterial = new WorkType[quantity];
		double [] productPriceInHomeCenter = new double[quantity];
		double [] productPriceInTheCenter = new double[quantity];
		double [] productPriceInTheNeightborhodd = new double[quantity];
		String homeCenter = "Homecenter";
		String center = "Ferreteria del Centro";
		String neighborhood = "Ferreteria del Barrio";
		
		productsNames = getNames(quantity);
		productsQuantity = quantityToUse(productsNames);
		productsPriceHomeCenter = toKnowPriceInHomecenter(productsNames);
		productsPriceInTheCenter = toKnowPriceInTheCenter(productsNames);
		productsPriceInTheNeightborhood = toKnowPrinceInTheNeighborHood(productsNames);
		useOfTheMaterial = toKnowInWhatWillBeUse(productsNames);
		productPriceInHomeCenter = toKnowFullPrice(productsNames,productsQuantity,productsPriceHomeCenter,homeCenter);
		productPriceInTheCenter = toKnowFullPrice(productsNames,productsQuantity,productsPriceInTheCenter,center);
		productPriceInTheNeightborhodd = toKnowFullPrice(productsNames,productsQuantity,productsPriceInTheNeightborhood,neighborhood);
	}
	
	public static String [] getNames(int valor){
		
		String [] arrayNames  = new String[valor];
		for(int i=0; i < valor; i++){
		
			System.out.println("Ingrese el nombre del producto");
			arrayNames[i] = sc.nextLine();
		}
		return arrayNames;
	}
	
	public static double [] quantityToUse (String [] names){
		
		double [] arrayHowMuchWillBeUsed = new double[names.length];
		for(int i=0; i < names.length; i++){
		
		System.out.println("cuanto necesidad del material: " + names[i] + " ?");
			arrayHowMuchWillBeUsed[i] = sc.nextDouble();
			sc.nextLine();
		}
	return arrayHowMuchWillBeUsed;	
	} 
	public static double [] toKnowPriceInHomecenter (String [] names){
		double [] priceInHomeCenter = new double[names.length];
		for(int i=0; i <names.length; i++){
			
			System.out.println("cual es el precio en Homecenter del material: " + names[i] + " ?");
			priceInHomeCenter[i] = sc.nextDouble();
			sc.nextLine();
		}
		return priceInHomeCenter;
	} 
	public static double [] toKnowPriceInTheCenter (String [] names){
		
		double [] priceInTheCenter = new double[names.length];
		for(int i=0; i <names.length;i++){
			
			System.out.println("cual es el precio en la ferreteria del barrio del material: " + names[i] + "?");
			priceInTheCenter[i] = sc.nextDouble();
			sc.nextLine();
		}
		
	return priceInTheCenter;
	}
	public static double [] toKnowPrinceInTheNeighborHood (String [] names){
		
		double [] priceInTheNeighborHood = new double[names.length];
		for(int i=0; i <names.length; i++){
			
			System.out.println("ingrese el precio del material en la ferreteria del barrio: " + names[i] + " ?");
			priceInTheNeighborHood[i] = sc.nextDouble();
			sc.nextLine();
			
		}
	return priceInTheNeighborHood;	
	}
	public static WorkType [] toKnowInWhatWillBeUse (String [] names){
		
		WorkType [] useOfTheMaterial = new WorkType[names.length];
		for(int i=0; i <names.length; i++){
			int choice=0;
			System.out.println("Cual es el uso para el material " + names[i] + " ?\n 1: Obra Negra \n 2: Obra Blanca \n 3: Pintura ");
			while(!((choice ==1)||(choice ==2)||(choice ==3))){ 
				choice = sc.nextInt();
				sc.nextLine();
				if(!((choice ==1)||(choice ==2)||(choice ==3))) System.out.println("numero invalido, intente de nuevo");
			}
				switch (choice){
					
					case 1: useOfTheMaterial[i] = WorkType.BLACK;
					break;
					case 2: useOfTheMaterial[i] = WorkType.WHITE;
					break;
					case 3: useOfTheMaterial[i] = WorkType.PAINT;
					break;
					 
			
				}
				System.out.println(useOfTheMaterial[i]);
			
				
		}
		return useOfTheMaterial;	
	}
	public static double [] toKnowFullPrice(String [] names, double [] quantity, double [] price, String place){
		
	double [] priceTotal = new double[names.length];
	for(int i=0; i < names.length;i++){
		
		priceTotal[i] = quantity[i] * price[i];
		System.out.println("el precio total del producto: " + names[i] + " en: " + place + "es de: " + price[i]);
		
	}
	
		
		
	return priceTotal;
	}
	
}


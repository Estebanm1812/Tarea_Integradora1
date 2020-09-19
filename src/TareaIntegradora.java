import java.util.Scanner;
public class TareaIntegradora{
	
	public static Scanner sc = new Scanner(System.in);
	public static final String HOMECENTER = "Homecenter";
	public static final String CENTER = "Ferreteria del Centro";
	public static final String NEIGHBORHOOD = "Ferreteria del Barrio";
	public static final int BLACK = 1300000;
	public static final int WHITE = 2600000;
	public static final int PAINT = 980000;

	

	public static void main(String[]args){	
	
	int constructionPlace=0;
	constructionPlace = toKnowTheUbication();	
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
		double totalPriceInHomeCenterWithtoutLabour =0;
		double totalPriceInTheCenterWithoutLabour =0;
		double totalPriceInTheNeighborhoodWithoutLabour =0;
		double totalPriceInHomeCenterWithDelivery =0;
		double totalPriceInTheCenterWithDelivery =0;
		double totalPriceInTheNeighborhoodWithDelivery=0;
		String [] bestChoiceforEachProduct = new String[quantity];
		double totalPriceWithLabourAndDeliveryInHomeCenter =0;
		double totalPriceWithLabourAndDeliveryInCenter =0;
		double totalPriceWithLabourAndDeliveryInNeighborhood =0;
		
		
		productsNames = getNames(quantity);
		
		productsQuantity = quantityToUse(productsNames);
		//Precios segun el local
		productsPriceHomeCenter = toKnowPriceInHomecenter(productsNames);
		
		productsPriceInTheCenter = toKnowPriceInTheCenter(productsNames);
		
		productsPriceInTheNeightborhood = toKnowPrinceInTheNeighborHood(productsNames);
		
		useOfTheMaterial = toKnowInWhatWillBeUse(productsNames);
		//precio por producto segun el local
		productPriceInHomeCenter = toKnowFullPrice(productsNames,productsQuantity,productsPriceHomeCenter,HOMECENTER);
		
		productPriceInTheCenter = toKnowFullPrice(productsNames,productsQuantity,productsPriceInTheCenter,CENTER);
		
		productPriceInTheNeightborhodd = toKnowFullPrice(productsNames,productsQuantity,productsPriceInTheNeightborhood,NEIGHBORHOOD);
		//precio por local sin domicilio
		totalPriceInHomeCenterWithtoutLabour = fullPriceInPlaceWithoutLabour(productPriceInHomeCenter,HOMECENTER);
		
		totalPriceInTheCenterWithoutLabour = fullPriceInPlaceWithoutLabour(productPriceInTheCenter,CENTER);
		
		totalPriceInTheNeighborhoodWithoutLabour = fullPriceInPlaceWithoutLabour(productPriceInTheNeightborhodd,NEIGHBORHOOD);
		//mejor eleccion de local por producto
		bestChoiceforEachProduct = toKnowBestPriceForEachProduct(productsNames, productPriceInHomeCenter, productPriceInTheCenter, productPriceInTheNeightborhodd);
		//precio por local con domicilio
		totalPriceInHomeCenterWithDelivery = toKnowPriceWithDelivery(totalPriceInHomeCenterWithtoutLabour, HOMECENTER, constructionPlace);
		
		totalPriceInTheCenterWithDelivery = toKnowPriceWithDelivery(totalPriceInTheCenterWithoutLabour, CENTER, constructionPlace);
		
		totalPriceInTheNeighborhoodWithDelivery = toKnowPriceWithDelivery(totalPriceInTheNeighborhoodWithoutLabour, NEIGHBORHOOD, constructionPlace);
		//precio total por local con mano de obra y domicilio
		totalPriceWithLabourAndDeliveryInHomeCenter = toKnowFullPriceWithLabour(totalPriceInHomeCenterWithDelivery, useOfTheMaterial, HOMECENTER);
		totalPriceWithLabourAndDeliveryInCenter = toKnowFullPriceWithLabour(totalPriceInTheCenterWithDelivery, useOfTheMaterial, CENTER);
		totalPriceWithLabourAndDeliveryInNeighborhood = toKnowFullPriceWithLabour(totalPriceInTheNeighborhoodWithDelivery, useOfTheMaterial, NEIGHBORHOOD);
	}
	
	public static int toKnowTheUbication(){
		
		int choice=0;
		System.out.println("ingrese la ubicacion del inmueble" + "\n :1 Norte \n 2: Centro \n 3:Sur");
		while(!((choice ==1)||(choice ==2)||(choice ==3))){ 
				choice = sc.nextInt();
				sc.nextLine();
				if(!((choice ==1)||(choice ==2)||(choice ==3))) System.out.println("numero invalido, intente de nuevo");
		}
		return choice;	
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
		System.out.println("el precio total del producto: " + names[i] + " en: " + place + " es de: " + price[i]);
		
	}
	
		
		
	return priceTotal;
	}
	public static double fullPriceInPlaceWithoutLabour(double [] prices, String place){
		
		double totalPrice = 0;
		for(int i=0; i < prices.length;i++){
			
			totalPrice+= prices[i];
			
		}
		System.out.println("el precio total de todos los materiales en:" + place +" fue de: " + totalPrice);
	return totalPrice;
	}
	public static String [] toKnowBestPriceForEachProduct(String [] names, double [] homecenter, double [] center, double [] neightbord){
		
	String [] option = new String[names.length];
		for(int i=0; i < names.length; i++){
			
			if((homecenter[i] <= center[i])&&(homecenter[i] <= neightbord[i])){ 
			option[i] = "La mejor opcion para comprar el producto: " + names[i] + " es en Homecenter por un precio de: " + homecenter[i] + " sin incluir envio"; 
			}else if((center[i] <= homecenter[i]) && (center[i] <= neightbord[i])){
				
			option[i] = "la mejor opcion para comprar el producto: " + names[i] + " es en la Ferreteria del centro por un precio de: " + center[i] + " sin incluir envio";
			}else if((neightbord[i] <= center[i]) && (neightbord[i] <= homecenter[i])){
				
			option[i] = "la mejor opcion para comprar el producto: " + names[i] + " es en la Ferreteria del barrio por un precio de: " + neightbord[i] + " sin incluir envio";	
			} 
		System.out.println(option[i]);	
		}
		
	return option;	
	}
	public static double toKnowPriceWithDelivery(double priceWithoutDelivery, String name, int whereItIs){
		
		double priceWithDelivery =0;
		switch(whereItIs){
			
			case 1:
			if(priceWithoutDelivery <= 80000){
				
			priceWithDelivery = priceWithoutDelivery + 120000;	
			
			}else if((priceWithoutDelivery>=80000)&&(priceWithoutDelivery<300000)){
				
			priceWithDelivery = priceWithoutDelivery + 28000;			
				
			}else if(priceWithoutDelivery>=300000){
			
			priceWithDelivery = priceWithoutDelivery;	
				
			}
			break;
			case 2:
			if(priceWithoutDelivery <= 80000){
				
			priceWithDelivery = priceWithoutDelivery + 50000;	
			
			}else if((priceWithoutDelivery>=80000)&&(priceWithoutDelivery<300000)){
				
			priceWithDelivery = priceWithoutDelivery;			
				
			}else if(priceWithoutDelivery>=300000){
			
			priceWithDelivery = priceWithoutDelivery;
		}
			case 3:
			if(priceWithoutDelivery <= 80000){
				
			priceWithDelivery = priceWithoutDelivery + 120000;	
			
			}else if((priceWithoutDelivery>=80000)&&(priceWithoutDelivery<300000)){
				
			priceWithDelivery = priceWithoutDelivery + 55000;			
				
			}else if(priceWithoutDelivery>=300000){
			
			priceWithDelivery = priceWithoutDelivery;
		
		
	}
	}
	System.out.println("el precio con domicilio en: " + name + " es de: " + priceWithDelivery );
	return priceWithDelivery;
	}
	public static double toKnowFullPriceWithLabour(double  price, WorkType [] materialType, String place  ){
		
		
		boolean blackFound = false;
		for(int i=0; (i < materialType.length)&&(blackFound==false);i++){
			if(materialType[i] == WorkType.BLACK) blackFound = true;
			
		}
		boolean whiteFound = false;
		for(int i=0; (i < materialType.length)&&(whiteFound==false);i++){
			if(materialType[i] == WorkType.WHITE) whiteFound = true;
		}
		boolean paintFound = false;
		for(int i=0; (i < materialType.length)&&(paintFound==false);i++){
			if(materialType[i] == WorkType.PAINT) paintFound = true;
		}
		if(blackFound)price+=BLACK;
		if(whiteFound)price+=WHITE;
		if(paintFound)price+=PAINT;
		System.out.println("El precio total con mano de obra y envio en: " + place + " es de:" + price);
		return price;
	}
	
	
	
	
	//public static toShowWhichUseWillHave(String [] names,)
}



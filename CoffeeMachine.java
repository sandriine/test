package main;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

	public static void main(String[] args) {
		
		//First Iteration
		//Drink maker makes 1 tea with 1 sugar and a stick
		Commande c1 = new Commande(new Tea(), 1);
		c1.ajoutStick();
		System.out.println(c1.toString());
		
		//Drink maker makes 1 chocolate with no sugar - and therefore no stick
		Commande c2 = new Commande(new Chocolate());
		c2.ajoutStick();
		System.out.println(c2.toString());
		
		//Drink maker makes 1 coffee with 2 sugars and a stick
		Commande c3 = new Commande(new Coffee(), 2);
		c3.ajoutStick();
		System.out.println(c3.toString());
		
		//Drink maker forwards any message received onto the coffee machine interface for the customer to see
		Message m1 = new Message("message-content");
		System.out.println(m1.toString());
		
		//Second Iteration
		//order a tea and give 40 cents
		Commande c4 = new Commande(new Tea(), 1);
		System.out.println(c4.passerCommande(0.4)); 

		//order a tea and give 20 cents
		Commande c5 = new Commande(new Tea());
		System.out.println(c5.passerCommande(0.2));
		
		//Third Iteration
		//Drink maker will make one orange juice
		Commande c6 = new Commande(new OrangeJuice());
		System.out.println(c6.passerCommande(0.6));
		
		//Drink maker will make an extra hot coffee with no sugar
		Commande c7 = new Commande(new Coffee());
		c7.reglerTemperature("h");
		System.out.println(c7.passerCommande(0.6));
		
		//Drink maker will make an extra hot chocolate with one sugar and a stick
		Commande c8 = new Commande(new Chocolate(), 1);
		c8.reglerTemperature("h");
		System.out.println(c8.passerCommande(0.5));

		//The drink maker will make an extra hot tea with two sugar and a stick
		Commande c9 = new Commande(new Tea(), 2);
		c9.reglerTemperature("h");
		System.out.println(c9.passerCommande(0.4));
		
		//Fourth Iteration
		//Initialisation du stock de la machine à café
		Map<String, Integer> boissons = new HashMap<String, Integer>(); 
	    boissons.put("C", 20);
	    boissons.put("T", 20);
	    boissons.put("O", 1);
		StockMachine s = new StockMachine(boissons, 0);
		//Passage de la commande avec calcul des gain et maj du stock
		Commande c10 = new Commande(new Coffee(), 1);
		c10.passerCommandeEtMajLeStock(0.6, s);
		Commande c11 = new Commande(new Tea());
		c11.passerCommandeEtMajLeStock(0.4, s);
		Commande c12 = new Commande(new Tea(), 1);
		c12.passerCommandeEtMajLeStock(0.4, s);
		//Affichage du compte rendu
		s.compteRenduStock();
		
		//Fifth iteration
		Commande c13 = new Commande(new OrangeJuice());
		System.out.println(c13.passerCommandeEtMajLeStock(0.6, s));
		//Stocke de un seul jus donc message de pénurie
		Commande c14 = new Commande(new OrangeJuice());
		System.out.println(c14.passerCommandeEtMajLeStock(0.6, s));
		//Pas de stock de chocolate
		Commande c15 = new Commande(new Chocolate());
		System.out.println(c15.passerCommandeEtMajLeStock(0.5, s));
		
	}

}

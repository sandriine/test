package main;

import java.util.HashMap;

public class Commande implements OperationsCommande{
	
	public Boisson boisson;
	public int sucre;
	public String stick;
	public String temperature;
	

	public Commande(Boisson boisson, int sucre) {
		super();
		this.boisson = boisson;
		this.sucre = sucre;
	}
	
	public Commande() {
		super();
	}

	public Commande(Boisson boisson) {
		super();
		this.boisson = boisson;
	}
	
	public Boisson getBoisson() {
		return boisson;
	}
	
	public void setBoisson(Boisson boisson) {
		this.boisson = boisson;
	}
	
	public int getSucre() {
		return sucre;
	}
	
	public void setSucre(int sucre) {
		this.sucre = sucre;
	}
	
	public String getStick() {
		return stick;
	}
	
	public void setStick(String stick) {
		this.stick = stick;
	}
	
	public String getTemperature() {
		return temperature;
	}

	/**
	 * Construit la commande retournée à l'utilisateur.
     * 
     * @param monnaie
     * La monnaie que fournit l'utilisateur à la machine
     * 
     * @return String
     * Le récapitulatif de la commande passée
     */
	public String passerCommande(double monnaie) {
		if(monnaie >= boisson.getPrix()) {
			this.ajoutStick();
			return this.toString();
		}else {
			int monnaieManquante = (int) ((boisson.getPrix() - monnaie) * 100);
			Message m = new Message("Missing " + monnaieManquante + " cents");
			return m.toString();
		}
	}
	
	/**
	 * Construit la commande retournée à l'utilisateur et met à jour le stock de la machine.
     * 
     * @param monnaie, stock
     * La monnaie que fournit l'utilisateur à la machine
     * Le stock de la machine à café
     * 
     * @return String
     * Le récapitulatif de la commande passée
     */
	//Fonction pour l'itération 4 et le calcul du stock
	public String passerCommandeEtMajLeStock(double monnaie, StockMachine stock) {
		if(monnaie >= boisson.getPrix()) {
			this.ajoutStick();
			boolean empty = stock.isEmpty(boisson.getName());
			if(empty) {
				Message m = new Message();
				m.notifyMissingDrink(boisson.getName());
				return m.getContent();
			}else {
				stock.calculGain(monnaie);
				stock.majStock(boisson.getName(), 1);
				return this.toString();
			}
		}else {
			int monnaieManquante = (int) ((boisson.getPrix() - monnaie) * 100);
			Message m = new Message("Missing " + monnaieManquante + " cents");
			return m.toString();
		}
	}

	/**
	 * Construit le récapitulatif de la commande qui sera fournit à l'utilisateur
	 * 
     * @return String
     * Le récapitulatif de la commande passée
     */
	@Override
	public String toString() {
		return this.boisson.getName() + ":" + (sucre > 0 ? sucre : "") + ":" + stick;
	}

	/**
	 * Ajout du stick à la commande en fonction du nb de sucre
     */
	@Override
	public void ajoutStick() {
		if(sucre > 0) {
			this.setStick("0");
		}else {
			this.setStick("");
		}
		
	}

	/**
	 * Règle la température de la boisson commandée
     * 
     * @param temperature
     * La température choisie de la boisson, par exemple h pour hot
     */
	@Override
	public void reglerTemperature(String temperature) {
		this.temperature = temperature;
		this.boisson.setName(this.boisson.getName().concat(temperature));	
	}

	
}

package main;

import java.util.HashMap;
import java.util.Map;

public class StockMachine implements BeverageQuantityChecker{
	Map<String, Integer> stockBoisson = new HashMap<String, Integer>();
	Map<String, Integer> boissonsVendues = new HashMap<String, Integer>();
	double montantGain = 0;

	public StockMachine(Map<String, Integer> stockBoisson, int montantGain) {
		super();
		this.stockBoisson = stockBoisson;
		this.montantGain = montantGain;
	}

	public Map<String, Integer> getBoissonsVendues() {
		return boissonsVendues;
	}

	public void setBoissonsVendues(Map<String, Integer> boissonsVendues) {
		this.boissonsVendues = boissonsVendues;
	}

	public Map<String, Integer> getStockBoisson() {
		return stockBoisson;
	}

	public void setStockBoisson(Map<String, Integer> stockBoisson) {
		this.stockBoisson = stockBoisson;
	}
	
	
	public double getMontantGain() {
		return montantGain;
	}

	public void setMontantGain(double montantGain) {
		this.montantGain = montantGain;
	}

	public void majStock(String boisson, int quantite) {
		Map<String, Integer> nouveauStock = this.getStockBoisson();
		int quantiteStock = nouveauStock.get(boisson);
		quantiteStock -= quantite;
		nouveauStock.replace(boisson, quantiteStock);
		this.setStockBoisson(nouveauStock);
		
		int quantiteBoisson = 0;
		Map<String, Integer> boissonVenduesInitiales = this.getBoissonsVendues();
		if(boissonVenduesInitiales.get(boisson) != null) {
			quantiteBoisson = boissonVenduesInitiales.get(boisson);
		}
		
		quantiteBoisson += quantite;
		boissonVenduesInitiales.put(boisson, quantiteBoisson);
		this.setBoissonsVendues(boissonVenduesInitiales);
	}
	
	public void calculGain(double montant) {
		double nouveauMontant = this.getMontantGain() + montant;
		this.setMontantGain(nouveauMontant);
	}
	
	public void compteRenduStock() {
		System.out.println("Boissons vendues: ");
		System.out.println(this.boissonsVendues.entrySet());
		System.out.println("Gain: " + montantGain);
	}

	@Override
	public boolean isEmpty(String drink) {
		Map<String, Integer> stock = this.getStockBoisson();
		if(stock.get(drink) != null) {
			int quantite = stock.get(drink);
			if(quantite == 0) {
				return true;
			}
		}else if(stock.get(drink) == null) {
			return true;
		}
		return false;
	}
}

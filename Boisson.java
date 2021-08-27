package main;

public abstract class Boisson {
	public String name;
	public double prix;

	public Boisson(String name, double prix) {
		super();
		this.name = name;
		this.prix = prix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	
}

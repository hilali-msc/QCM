package fr.eni.bean;

public class Promotion {

	private int id_promo;
	private String libelle;
	
	public Promotion()
	{
		super();
	}
	
	public Promotion(int id_promo, String libelle) {
		super();
		this.id_promo = id_promo;
		this.libelle = libelle;
	}
	public int getId_promo() {
		return id_promo;
	}
	public void setId_promo(int id_promo) {
		this.id_promo = id_promo;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}

package fr.eni.bean;

public class Statut {

	private int id_statut;
	private String libelle;
	
	public Statut()
	{
		super();
	}
	
	public Statut(int id_statut, String libelle) {
		super();
		this.id_statut = id_statut;
		this.libelle = libelle;
	}
	public int getId_statut() {
		return id_statut;
	}
	public void setId_statut(int id_statut) {
		this.id_statut = id_statut;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}

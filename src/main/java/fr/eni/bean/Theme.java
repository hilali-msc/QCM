package fr.eni.bean;

public class Theme {

	private int id_theme;
	private String libelle;
	
	public Theme()
	{
		super();
	}
	
	public Theme(int id_theme, String libelle) {
		super();
		this.id_theme = id_theme;
		this.libelle = libelle;
	}
	public int getId_theme() {
		return id_theme;
	}
	public void setId_theme(int id_theme) {
		this.id_theme = id_theme;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}

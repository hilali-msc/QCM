package fr.eni.bean;

public class Test {

	private int id_test;
	private String nom;
	private int duree_test;
	private int seuil_en_cours;
	private int seuil_acquis;
	
	public Test()
	{
		super();
	}
	
	public Test(int id_test, String nom, int duree_test, int seuil_en_cours,
			int seuil_acquis) {
		super();
		this.id_test = id_test;
		this.nom = nom;
		this.duree_test = duree_test;
		this.seuil_en_cours = seuil_en_cours;
		this.seuil_acquis = seuil_acquis;
	}
	public int getId_test() {
		return id_test;
	}
	public void setId_test(int id_test) {
		this.id_test = id_test;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDuree_test() {
		return duree_test;
	}
	public void setDuree_test(int duree_test) {
		this.duree_test = duree_test;
	}
	public int getSeuil_en_cours() {
		return seuil_en_cours;
	}
	public void setSeuil_en_cours(int seuil_en_cours) {
		this.seuil_en_cours = seuil_en_cours;
	}
	public int getSeuil_acquis() {
		return seuil_acquis;
	}
	public void setSeuil_acquis(int seuil_acquis) {
		this.seuil_acquis = seuil_acquis;
	}
	
	
}

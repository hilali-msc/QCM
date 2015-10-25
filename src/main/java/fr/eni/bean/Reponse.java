package fr.eni.bean;

public class Reponse {

	private int id_reponse;
	private String libelle;
	private boolean est_correct;
	private int id_question;
	
	public Reponse()
	{
		super();
	}
	
	public Reponse(int id_reponse, String libelle, boolean est_correct,
			int id_question) {
		super();
		this.id_reponse = id_reponse;
		this.libelle = libelle;
		this.est_correct = est_correct;
		this.id_question = id_question;
	}
	public int getId_reponse() {
		return id_reponse;
	}
	public void setId_reponse(int id_reponse) {
		this.id_reponse = id_reponse;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public boolean isEst_correct() {
		return est_correct;
	}
	public void setEst_correct(boolean est_correct) {
		this.est_correct = est_correct;
	}
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	
	
	
}

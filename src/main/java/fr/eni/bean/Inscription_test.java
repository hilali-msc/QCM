package fr.eni.bean;

import java.util.Date;

public class Inscription_test {

	private int id_inscription;
	private int id_test;
	private Date date_inscription;
	private int id_user;
	private Date date_debut;
	private int temps_restant;
	private int nb_incident;
	private int position_question;
	
	public Inscription_test()
	{
		super();
	}
	
	public Inscription_test(int id_inscription, int id_test,
			Date date_inscription, int id_user, Date date_debut,
			int temps_restant, int nb_incident, int position_question) {
		super();
		this.id_inscription = id_inscription;
		this.id_test = id_test;
		this.date_inscription = date_inscription;
		this.id_user = id_user;
		this.date_debut = date_debut;
		this.temps_restant = temps_restant;
		this.nb_incident = nb_incident;
		this.position_question = position_question;
	}
	public int getId_inscription() {
		return id_inscription;
	}
	public void setId_inscription(int id_inscription) {
		this.id_inscription = id_inscription;
	}
	public int getId_test() {
		return id_test;
	}
	public void setId_test(int id_test) {
		this.id_test = id_test;
	}
	public Date getDate_inscription() {
		return date_inscription;
	}
	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public int getTemps_restant() {
		return temps_restant;
	}
	public void setTemps_restant(int temps_restant) {
		this.temps_restant = temps_restant;
	}
	public int getNb_incident() {
		return nb_incident;
	}
	public void setNb_incident(int nb_incident) {
		this.nb_incident = nb_incident;
	}
	public int getPosition_question() {
		return position_question;
	}
	public void setPosition_question(int position_question) {
		this.position_question = position_question;
	}
	
	
}

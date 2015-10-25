package fr.eni.bean;

public class Reponse_Candidats {

	private int id_reponse;
	private int id_test;
	private int id_user;
	private int id_question;
	private int id_inscription;
	
	public Reponse_Candidats()
	{
		super();
	}
	
	public Reponse_Candidats(int id_reponse, int id_test, int id_user,
			int id_question, int id_inscription) {
		super();
		this.id_reponse = id_reponse;
		this.id_test = id_test;
		this.id_user = id_user;
		this.id_question = id_question;
		this.id_inscription = id_inscription;
	}
	public int getId_reponse() {
		return id_reponse;
	}
	public void setId_reponse(int id_reponse) {
		this.id_reponse = id_reponse;
	}
	public int getId_test() {
		return id_test;
	}
	public void setId_test(int id_test) {
		this.id_test = id_test;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	public int getId_inscription() {
		return id_inscription;
	}
	public void setId_inscription(int id_inscription) {
		this.id_inscription = id_inscription;
	}
	
	
}

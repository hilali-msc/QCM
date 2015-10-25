package fr.eni.bean;

public class Select_Question {

	private int id_test;
	private int id_question;
	private int id_user;
	private int id_inscription;
	private boolean est_repondu;
	private boolean est_marque;
	
	public Select_Question()
	{
		super();
	}
	
	public Select_Question(int id_test, int id_question, int id_user,
			int id_inscription, boolean est_repondu, boolean est_marque) {
		super();
		this.id_test = id_test;
		this.id_question = id_question;
		this.id_user = id_user;
		this.id_inscription = id_inscription;
		this.est_repondu = est_repondu;
		this.est_marque = est_marque;
	}
	public int getId_test() {
		return id_test;
	}
	public void setId_test(int id_test) {
		this.id_test = id_test;
	}
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_inscription() {
		return id_inscription;
	}
	public void setId_inscription(int id_inscription) {
		this.id_inscription = id_inscription;
	}
	public boolean isEst_repondu() {
		return est_repondu;
	}
	public void setEst_repondu(boolean est_repondu) {
		this.est_repondu = est_repondu;
	}
	public boolean isEst_marque() {
		return est_marque;
	}
	public void setEst_marque(boolean est_marque) {
		this.est_marque = est_marque;
	}
	
}

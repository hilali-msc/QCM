package fr.eni.bean;

public class Section {

	private int id_test;
	private int id_theme;
	private int nb_question;
	
	public Section()
	{
		super();
	}
	
	public Section(int id_test, int id_theme, int nb_question) {
		super();
		this.id_test = id_test;
		this.id_theme = id_theme;
		this.nb_question = nb_question;
	}
	public int getId_test() {
		return id_test;
	}
	public void setId_test(int id_test) {
		this.id_test = id_test;
	}
	public int getId_theme() {
		return id_theme;
	}
	public void setId_theme(int id_theme) {
		this.id_theme = id_theme;
	}
	public int getNb_question() {
		return nb_question;
	}
	public void setNb_question(int nb_question) {
		this.nb_question = nb_question;
	}
	
	
	
}

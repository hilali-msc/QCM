package fr.eni.bean;

public class Question {

	private int id_question;
	private int id_theme;
	private String enonce;
	private boolean est_archive;
	private String url_image;
	
	public Question()
	{
		super();
	}
	
	public Question(int id_question, int id_theme, String enonce,
			boolean est_archive, String url_image) {
		super();
		this.id_question = id_question;
		this.id_theme = id_theme;
		this.enonce = enonce;
		this.est_archive = est_archive;
		this.url_image = url_image;
	}
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	public int getId_theme() {
		return id_theme;
	}
	public void setId_theme(int id_theme) {
		this.id_theme = id_theme;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public boolean isEst_archive() {
		return est_archive;
	}
	public void setEst_archive(boolean est_archive) {
		this.est_archive = est_archive;
	}
	public String getUrl_image() {
		return url_image;
	}
	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}
	
	
}

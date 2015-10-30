package fr.eni.bean;

public class Utilisateur {

	private int id_user;
	private String nom;		
	private String prenom;
	private int id_promo;
	private int id_statut;
	private Boolean est_archive;
	private String password;
	private String login;
	private String email;
	private String libellePromo;

	public String getLibellePromo() {
		return libellePromo;
	}

	public void setLibellePromo(String libellePromo) {
		this.libellePromo = libellePromo;
	}

	public Utilisateur(){
		
	}

	public Utilisateur(int id_user, String nom, String prenom, int id_promo,
			int id_statut, Boolean est_archive, String password, String login,
			String email) {
		
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.id_promo = id_promo;
		this.id_statut = id_statut;
		this.est_archive = est_archive;
		this.password = password;
		this.login = login;
		this.email = email;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId_promo() {
		return id_promo;
	}

	public void setId_promo(int id_promo) {
		this.id_promo = id_promo;
	}

	public int getId_statut() {
		return id_statut;
	}

	public void setId_statut(int id_statut) {
		this.id_statut = id_statut;
	}

	public Boolean getEst_archive() {
		return est_archive;
	}

	public void setEst_archive(Boolean est_archive) {
		this.est_archive = est_archive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

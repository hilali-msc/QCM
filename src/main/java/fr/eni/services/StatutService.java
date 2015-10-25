package fr.eni.services;

import java.sql.SQLException;
import java.util.Vector;

import fr.eni.bean.Statut;
import fr.eni.dao.StatutDAO;

public class StatutService {

	public static Vector<Statut> importerListe() {

		Vector<Statut> listePromo = new Vector<Statut>();
		listePromo = StatutDAO.importerListe();
		return listePromo;

	}

	public static void insert(Statut statut) throws SQLException {

		try {
			StatutDAO.insert(statut);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void update(Statut statut) throws SQLException {

		try {
			StatutDAO.update(statut);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void delete(Statut statut) throws SQLException {

		try {
			StatutDAO.delete(statut);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}

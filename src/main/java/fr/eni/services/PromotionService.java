package fr.eni.services;

import java.sql.SQLException;
import java.util.Vector;

import fr.eni.bean.Promotion;
import fr.eni.dao.PromotionDAO;

public class PromotionService {

	public static Vector<Promotion> importerListe(){
		
		Vector<Promotion> listePromo = new Vector<Promotion>();
		listePromo = PromotionDAO.importerListe();
		return listePromo;
		
	}
	
	public static void insert(Promotion promo) throws SQLException {

		try {
			PromotionDAO.insert(promo);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void update(Promotion promo) throws SQLException {

		try {
			PromotionDAO.update(promo);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void delete(Promotion promo) throws SQLException {

		try {
			PromotionDAO.delete(promo);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
}

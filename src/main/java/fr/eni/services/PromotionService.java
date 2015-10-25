package fr.eni.services;

import java.sql.SQLException;
import java.util.List;

import fr.eni.bean.Promotion;
import fr.eni.dao.PromotionDAO;

public class PromotionService {

	public static List<Promotion> importerListe() throws Exception{
		
		try {
			return PromotionDAO.importerListe();
		} catch (Exception e) {
			throw new Exception(e);
		}
		
		
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

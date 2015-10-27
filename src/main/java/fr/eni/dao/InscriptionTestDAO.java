package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Inscription_test;

public class InscriptionTestDAO {

	/*
	 * Liste les inscriptions par ID user ou lister toutes les inscriptions
	 */
	public static List<Inscription_test> getTests(Inscription_test inscriptionTest) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		ArrayList<Inscription_test> listeInscriptionsTests = new ArrayList<Inscription_test>();
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("select * "
					+ "from INSCRIPTION_TEST ");	
//			rqt.setString(1, test.getNom());
			rs=rqt.executeQuery();
			while (rs.next()){
				inscriptionTest = new Inscription_test(
									rs.getInt("id_inscription"),
									rs.getInt("id_test"),
									rs.getDate("date_inscription"),
									rs.getInt("id_user"),
									rs.getDate("date_debut"),
									rs.getInt("temps_restant"),
									rs.getInt("nb_incident"),
									rs.getInt("position_question")
						);
				listeInscriptionsTests.add(inscriptionTest);				
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeInscriptionsTests;
	}
	
	
	
	
}
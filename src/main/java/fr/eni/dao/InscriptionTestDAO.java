package fr.eni.dao;

import java.sql.Connection;
import java.sql.Date;
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
	
	
	public static void insert(Inscription_test inscription) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		Date date_debut = new Date(inscription.getDate_debut().getTime());
		Date date_inscription = new Date(inscription.getDate_inscription().getTime());
		
		try{		
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("insert into inscription_test(id_test, date_inscription, id_user, "
					+ "dateDebutTest, tempsRestant, nbIncident, positionQuestion) "
					+ "values(?, ?, ?, ?, ?, ?, ?) ");
			rqt.setInt(1, inscription.getId_test());
			rqt.setDate(2, date_inscription);
			rqt.setInt(3, inscription.getId_user());
			rqt.setDate(4, date_debut);
			rqt.setInt(5, inscription.getTemps_restant());
			rqt.setInt(6, inscription.getNb_incident());
			rqt.setInt(7, inscription.getPosition_question());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste d'inscription : ");
			e.printStackTrace();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	
	public static List<Inscription_test> getInscriptionTestByUser(int id_user) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		ArrayList<Inscription_test> listeInscriptionsTests = new ArrayList<Inscription_test>();
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("select * "
					+ "from INSCRIPTION_TEST "
					+ "where id_user = ? ");	
			rqt.setInt(1, id_user);;
			rs=rqt.executeQuery();
			while (rs.next()){
				listeInscriptionsTests.add(new Inscription_test(
									rs.getInt("id_inscription"),
									rs.getInt("id_test"),
									rs.getDate("date_inscription"),
									rs.getInt("id_user"),
									rs.getDate("dateDebutTest"),
									rs.getInt("tempsRestant"),
									rs.getInt("nbIncident"),
									rs.getInt("positionQuestion")
						));		
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeInscriptionsTests;
	}
	
}
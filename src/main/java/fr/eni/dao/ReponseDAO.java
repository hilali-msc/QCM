package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Reponse;

public class ReponseDAO {

	public static ArrayList<Reponse> getReponses(Reponse reponse) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		ArrayList<Reponse> listeReponse = new ArrayList<Reponse>();
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("select * "
					+ "from QUESTION "
					+ "where id_reponse = ? ");	
			rqt.setInt(1, reponse.getId_reponse());
			rs=rqt.executeQuery();
			while (rs.next()){
				reponse = new Reponse(
									rs.getInt("id_reponse"),
									rs.getString("libelle"),
									rs.getBoolean("est_correct"),
									rs.getInt("id_question")
						);
				listeReponse.add(reponse);				
			}
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeReponse;
	}
	
	public static void insert(Reponse reponse) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("insert into QUESTION "
					+ "values(?, ?, ?) ");
			rqt.setString(1, reponse.getLibelle());
			rqt.setBoolean(2, reponse.isEst_correct());
			rqt.setInt(3, reponse.getId_question());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void update(Reponse reponse) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("update QUESTION "
					+ "set libelle  = ?, "
					+ "est_correct = ?, "
					+ "id_question = ?");
			rqt.setString(1, reponse.getLibelle());
			rqt.setBoolean(2, reponse.isEst_correct());
			rqt.setInt(3, reponse.getId_question());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void delete(Reponse reponse) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("delete from QUESTION "
					+ "where id_reponse = ? ");
			rqt.setInt(1, reponse.getId_reponse());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
}

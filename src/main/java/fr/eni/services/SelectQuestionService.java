package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Select_Question;
import fr.eni.dao.SelectQuestionDAO;

public class SelectQuestionService {

	public static ArrayList<Select_Question> getSelectQuestions(Select_Question selectQuestion) throws SQLException {

		try {
			ArrayList<Select_Question> listSelectQuestion = new ArrayList<Select_Question>();		
			listSelectQuestion = SelectQuestionDAO.getSelectQuestions(selectQuestion);
			return listSelectQuestion;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void insert(Select_Question selectQuestion) throws SQLException {

		try {
			SelectQuestionDAO.insert(selectQuestion);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Select_Question selectQuestion) throws SQLException {

		try {
			SelectQuestionDAO.update(selectQuestion);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void delete(Select_Question selectQuestion) throws SQLException {

		try {
			SelectQuestionDAO.delete(selectQuestion);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
}

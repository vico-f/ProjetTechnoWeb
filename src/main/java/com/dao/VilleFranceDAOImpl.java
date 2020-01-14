package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.config.JDBCConfigurationSol1;
import com.dto.LieuMission;
import com.dto.Mission;
import com.dto.VilleFrance;

public class VilleFranceDAOImpl implements VilleFranceDAO{
	@Override
	public ArrayList<VilleFrance> getVille() {
		ArrayList<Mission> listMission = new ArrayList<Mission>();
		ArrayList<VilleFrance> listVille = new ArrayList<VilleFrance>();

		try {
			// solution 1
			Connection con = JDBCConfigurationSol1.getConnection();
			// solution 2
			// Connection con = JDBCConfigurationSol2.getConnection();
			Statement statement = con.createStatement();

			// execute la requete
			ResultSet resultSet = statement.executeQuery("SELECT * FROM info_train");

			// parcourt des éléments de réponse
			while (resultSet.next()) {
				Mission mission = new Mission();
				VilleFrance ville = new VilleFrance();
				
				ville.setCodeCommuneInsee(resultSet.getString("codeCommuneInsee"));
				ville.setCodePostal(resultSet.getString("codePostal"));
				ville.setLattitude(resultSet.getString("lattitude"));
				ville.setLibelleAcheminement(resultSet.getString("libelleAcheminement"));
				ville.setLigne5(resultSet.getString("ligne5"));
				ville.setLongitude(resultSet.getString("longitude"));
				ville.setNomCommune(resultSet.getString("nomCommune"));


				listMission.add(mission);
			}

			// close de la connexion
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVille;

	}
}

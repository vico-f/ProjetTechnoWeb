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
	 private static final String SQL_INSERT = "INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, "
	            + "Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) " + "VALUES (";
	 private static final String SQL_SELECT_WHERE = "SELECT Code_commune_INSEE, Nom_commune, Code_postal, "
	            + "Libelle_acheminement, " + "Ligne_5, Latitude, Longitude FROM ville_france";
	 
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ville_france");

			// parcourt des éléments de réponse
			while (resultSet.next()) {
				VilleFrance ville = new VilleFrance();
				
				ville.setCodeCommuneInsee(resultSet.getString("codeCommuneInsee"));
				ville.setCodePostal(resultSet.getString("codePostal"));
				ville.setLattitude(resultSet.getString("lattitude"));
				ville.setLibelleAcheminement(resultSet.getString("libelleAcheminement"));
				ville.setLigne5(resultSet.getString("ligne5"));
				ville.setLongitude(resultSet.getString("longitude"));
				ville.setNomCommune(resultSet.getString("nomCommune"));


				listVille.add(ville);
			}

			// close de la connexion
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVille;

	}

	@Override
	public void deleteVille(VilleFrance ville) throws SQLException {
		// solution 1
					Connection con = JDBCConfigurationSol1.getConnection();
					// solution 2
					// Connection con = JDBCConfigurationSol2.getConnection();
					Statement statement = con.createStatement();

					// execute la requete
					try {
						ResultSet resultSet = statement.executeQuery("DELETE FROM ville_france WHERE "
						+ "Code_Commune_INSEE LIKE '%" + ville.getCodeCommuneInsee() + "%'");
						
						resultSet.close();
						statement.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	}

	@Override
	public void putVille(VilleFrance ville) throws SQLException {
		Connection con = JDBCConfigurationSol1.getConnection();
		// solution 2
		// Connection con = JDBCConfigurationSol2.getConnection();
		Statement statement = con.createStatement();
		
		ResultSet resultSet = statement.executeQuery(SQL_INSERT+ "'" + ville.getCodeCommuneInsee()
        + "', " + "'" + ville.getNomCommune() + "', " + "'" + ville.getCodePostal()
        + "', " + "'" + ville.getLibelleAcheminement() + "', " + "'" + ville.getLigne5()
        + "', " + "'" + ville.getLattitude() + "', " + "'" + ville.getLongitude() + "')");
		
		resultSet.close();
		statement.close();
	}

	@Override
	public ArrayList<VilleFrance> findVille(VilleFrance ville) throws SQLException {
		ArrayList<VilleFrance> villeFranceListe = new ArrayList<VilleFrance>();
		Connection con = JDBCConfigurationSol1.getConnection();
		// solution 2
		// Connection con = JDBCConfigurationSol2.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_SELECT_WHERE + " WHERE Code_Postal LIKE '%" + ville.getCodePostal() + "%'");
		while (resultSet.next()) {
			VilleFrance villeCherche = new VilleFrance();
			
			ville.setCodeCommuneInsee(resultSet.getString("codeCommuneInsee"));
			ville.setCodePostal(resultSet.getString("codePostal"));
			ville.setLattitude(resultSet.getString("lattitude"));
			ville.setLibelleAcheminement(resultSet.getString("libelleAcheminement"));
			ville.setLigne5(resultSet.getString("ligne5"));
			ville.setLongitude(resultSet.getString("longitude"));
			ville.setNomCommune(resultSet.getString("nomCommune"));


			villeFranceListe.add(villeCherche);
        }
		resultSet.close();
		statement.close();
		return villeFranceListe;
	}
	@Override
	public void modifyVille(VilleFrance ville) throws SQLException {
		ArrayList<VilleFrance> villeFranceListe = new ArrayList<VilleFrance>();
		Connection con = JDBCConfigurationSol1.getConnection();
		// solution 2
		// Connection con = JDBCConfigurationSol2.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("UPDATE ville_france SET Nom_Commune = '" + ville.getNomCommune()
                + "', Code_postal = '" + ville.getCodePostal() + "', Libelle_acheminement = '"
                + ville.getLibelleAcheminement() + "', Ligne_5 = '" + ville.getLigne5()
                + "', Latitude = '" + ville.getLattitude() + "', Longitude = '"
                + ville.getLongitude() + "' WHERE Code_Commune_INSEE LIKE '%"
                + ville.getCodeCommuneInsee() + "%'");
		resultSet.close();
		statement.close();
	}
}

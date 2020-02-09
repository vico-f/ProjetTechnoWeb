package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfigurationSol1;
import com.dto.VilleFrance;

@Repository
public class VilleFranceDAOImpl implements VilleFranceDAO{
	 private static final String SQL_INSERT = "INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, "
	            + "Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) " + "VALUES (";
	 private static final String SQL_SELECT_WHERE = "SELECT Code_commune_INSEE, Nom_commune, Code_postal, "
	            + "Libelle_acheminement, " + "Ligne_5, Latitude, Longitude FROM ville_france";
	 
	 @Override
	public ArrayList<VilleFrance> getVille() {
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
				
				ville.setCodeCommuneInsee(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne5(resultSet.getString("Ligne_5"));
				ville.setLattitude(resultSet.getString("Latitude"));
				ville.setLongitude(resultSet.getString("Longitude"));
				
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
						PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM ville_france WHERE "
						+ "Code_Commune_INSEE LIKE '%" + ville.getCodeCommuneInsee() + "%'");
						preparedStatement.executeUpdate();
						preparedStatement.close();
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
		PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT+ "'" + ville.getCodeCommuneInsee()
        + "', " + "'" + ville.getNomCommune() + "', " + "'" + ville.getCodePostal()
        + "', " + "'" + ville.getLibelleAcheminement() + "', " + "'" + ville.getLigne5()
        + "', " + "'" + ville.getLattitude() + "', " + "'" + ville.getLongitude() + "')");
		preparedStatement.executeUpdate();
		preparedStatement.close();
		statement.close();
	}

	@Override
	public ArrayList<VilleFrance> findVille(VilleFrance villeParam) {
		ArrayList<VilleFrance> listVille = new ArrayList<VilleFrance>();

		try {
			// solution 1
			Connection con = JDBCConfigurationSol1.getConnection();
			// solution 2
			// Connection con = JDBCConfigurationSol2.getConnection();
			Statement statement = con.createStatement();

			
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_WHERE + " WHERE Code_Postal LIKE '%" + villeParam.getCodePostal() + "%'");

			while (resultSet.next()) {
				VilleFrance ville = new VilleFrance();
				
				ville.setCodeCommuneInsee(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne5(resultSet.getString("Ligne_5"));
				ville.setLattitude(resultSet.getString("Latitude"));
				ville.setLongitude(resultSet.getString("Longitude"));
				
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
	public void modifyVille(VilleFrance villeP) throws SQLException {
		Connection con = JDBCConfigurationSol1.getConnection();
		// solution 2
		// Connection con = JDBCConfigurationSol2.getConnection();
		Statement statement = con.createStatement();
		PreparedStatement preparedStatement = con.prepareStatement("UPDATE ville_france SET Nom_Commune = '" + villeP.getNomCommune()
        + "', Code_postal = '" + villeP.getCodePostal() + "', Libelle_acheminement = '"
        + villeP.getLibelleAcheminement() + "', Ligne_5 = '" + villeP.getLigne5()
        + "', Latitude = '" + villeP.getLattitude() + "', Longitude = '"
        + villeP.getLongitude() + "' WHERE Code_Commune_INSEE LIKE '%"
        + villeP.getCodeCommuneInsee() + "%'");
        preparedStatement.executeUpdate();

        preparedStatement.close();
		statement.close();
	}
}

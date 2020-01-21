package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MissionDAO;
import com.dao.VilleFranceDAO;
import com.dto.Mission;
import com.dto.VilleFrance;

@Service
public class VilleFranceBLOImpl implements VilleFranceBLO {

	@Autowired
	private VilleFranceDAO villeDAO;

	@Override
	public ArrayList<VilleFrance> getInfoVille(VilleFrance ville) throws VilleFranceException, SQLException {
		ArrayList<VilleFrance> listVille;

		// dans le cas ou numTrain est null ou vide = récupération de l'ensemble des
		// informations
		if (ville.getCodePostal() == null || "".equalsIgnoreCase(ville.getCodePostal())) {
			listVille = villeDAO.getVille();
		} else {
			listVille = villeDAO.findVille(ville);
		}
		System.out.println("Nombre de villes récupéré : " + listVille.size());

		return listVille;
	}

	@Override
	public void ajoutVille(String ville) throws SQLException {
		 VilleFrance villeFrance = new VilleFrance();
		villeFrance=formalismePasFou(ville);
		villeDAO.putVille(villeFrance);
		
	}

	@Override
	public void postVille(String ville) throws SQLException {
		 VilleFrance villeFrance = new VilleFrance();
		villeFrance=formalismePasFou(ville);
		villeDAO.modifyVille(villeFrance);
		
	}

	@Override
	public void deleteVille(String codeCommuneInsee) throws SQLException {
		VilleFrance villeFrance = new VilleFrance();
		villeFrance.setCodeCommuneInsee(codeCommuneInsee);
		villeDAO.deleteVille(villeFrance);
	}
	
	public VilleFrance formalismePasFou(String requete) {
		 VilleFrance villeFrance = new VilleFrance();
		 System.out.println(requete);
	        int debutDepart = requete.indexOf("codeCommuneInsee=");
	        int finDepart = requete.indexOf(", nomCommune=");

	        if (debutDepart < 0) {
	            debutDepart = -2;
	        }

	        String codeCommuneInsee = requete.substring(debutDepart + 17, finDepart);

	        debutDepart = requete.indexOf("nomCommune=");
	        finDepart = requete.indexOf(", codePostal=");

	        String nomCommune = requete.substring(debutDepart + 11, finDepart);

	        debutDepart = requete.indexOf("codePostal=");
	        finDepart = requete.indexOf(", libelleAcheminement=");

	        String codePostal = requete.substring(debutDepart + 11, finDepart);

	        debutDepart = requete.indexOf("libelleAcheminement=");
	        finDepart = requete.indexOf(", ligne5=");

	        String libelleAcheminement = requete.substring(debutDepart + 20, finDepart);

	        debutDepart = requete.indexOf("ligne5=");
	        finDepart = requete.indexOf(", lattitude=");

	        String ligne5 = requete.substring(debutDepart + 7, finDepart);

	        debutDepart = requete.indexOf("lattitude=");
	        finDepart = requete.indexOf(", longitude=");

	        String latitude = requete.substring(debutDepart + 10, finDepart);

	        debutDepart = requete.indexOf("longitude=");
	        finDepart = requete.indexOf("]");

	        String longitude = requete.substring(debutDepart + 10, finDepart);

	        villeFrance.setCodeCommuneInsee(codeCommuneInsee);
	        villeFrance.setCodePostal(codePostal);
	        villeFrance.setLattitude(latitude);
	        villeFrance.setLibelleAcheminement(libelleAcheminement);
	        villeFrance.setLongitude(longitude);
	        villeFrance.setNomCommune(nomCommune);
	        villeFrance.setLigne5(ligne5);
	        return villeFrance;
	}

	

}

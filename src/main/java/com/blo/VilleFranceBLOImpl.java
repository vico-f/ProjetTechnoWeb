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
	public void ajoutVille(VilleFrance ville) throws SQLException {
		villeDAO.putVille(ville);
		
	}

	@Override
	public void postVille(String ville) throws SQLException {
		 VilleFrance villeFrance = new VilleFrance();
	        int debutDepart = ville.indexOf("codeCommuneInsee=");
	        int finDepart = ville.indexOf(", nomCommune=");

	        if (debutDepart < 0) {
	            debutDepart = -2;
	        }

	        String codeCommuneInsee = ville.substring(debutDepart + 17, finDepart);

	        debutDepart = ville.indexOf("nomCommune=");
	        finDepart = ville.indexOf(", codePostal=");

	        String nomCommune = ville.substring(debutDepart + 11, finDepart);

	        debutDepart = ville.indexOf("codePostal=");
	        finDepart = ville.indexOf(", libelleAcheminement=");

	        String codePostal = ville.substring(debutDepart + 11, finDepart);

	        debutDepart = ville.indexOf("libelleAcheminement=");
	        finDepart = ville.indexOf(", ligne5=");

	        String libelleAcheminement = ville.substring(debutDepart + 20, finDepart);

	        debutDepart = ville.indexOf("ligne5=");
	        finDepart = ville.indexOf(", lattitude=");

	        String ligne5 = ville.substring(debutDepart + 7, finDepart);

	        debutDepart = ville.indexOf("lattitude=");
	        finDepart = ville.indexOf(", longitude=");

	        String latitude = ville.substring(debutDepart + 10, finDepart);

	        debutDepart = ville.indexOf("longitude=");
	        finDepart = ville.indexOf("]");

	        String longitude = ville.substring(debutDepart + 10, finDepart);

	        villeFrance.setCodeCommuneInsee(codeCommuneInsee);
	        villeFrance.setCodePostal(codePostal);
	        villeFrance.setLattitude(latitude);
	        villeFrance.setLibelleAcheminement(libelleAcheminement);
	        villeFrance.setLongitude(longitude);
	        villeFrance.setNomCommune(nomCommune);
	        villeFrance.setLigne5(ligne5);
		villeDAO.modifyVille(villeFrance);
		
	}

	

}

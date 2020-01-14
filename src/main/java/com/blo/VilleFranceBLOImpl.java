package com.blo;

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
	public ArrayList<VilleFrance> getInfoVille(String nomCommune) throws MissionException {
		ArrayList<VilleFrance> listVille;

		// dans le cas ou numTrain est null ou vide = récupération de l'ensemble des
		// informations
		if (nomCommune == null || "".equalsIgnoreCase(nomCommune)) {
			listVille = villeDAO.getVille();
		} else {
			listVille = villeDAO.getVille();
		}
		System.out.println("Nombre de villes récupéré : " + listVille.size());

		return listVille;
	}

}

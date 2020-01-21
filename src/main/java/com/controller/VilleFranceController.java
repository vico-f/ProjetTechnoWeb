package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.MissionBLO;
import com.blo.MissionException;
import com.blo.VilleFranceBLO;
import com.blo.VilleFranceException;
import com.dao.VilleFranceDAO;
import com.dao.VilleFranceDAOImpl;
import com.dto.VilleFrance;

@RestController
//@RequestMapping("/path")
class VilleFranceController {
	@Autowired
	//MissionBLO missionService;
	VilleFranceBLO villeService;

	// Methode GET
	@RequestMapping(value = "/villeFrance", method = RequestMethod.GET)
	@ResponseBody
	public String recover(@RequestParam(required = false, value = "codePostal") String codePostal) throws MissionException, VilleFranceException, SQLException {
		System.out.println("Appel GET");
		VilleFrance vf= new VilleFrance();
		vf.setCodePostal(codePostal);
		ArrayList<VilleFrance> listVille = villeService.getInfoVille(vf);
		return listVille.toString();
	}
	

	// Methode POST
	//TODO
	@RequestMapping(value = "/villeFrancePost", method = RequestMethod.POST)
	@ResponseBody
	public String post(@RequestParam(required = false, value = "value") String ville) throws SQLException {
		System.out.println("Appel POST");
		villeService.postVille(ville);
		return null;
	}
		
	// Methode PUT
	@RequestMapping(value = "/villeFrancePut", method = RequestMethod.PUT)
	@ResponseBody
	public String Put(@RequestParam(required = false, value = "value") String codeCommuneInsee,
            String nomCommune, String codePostal, String libelle, String ligne, String lat,
            String lon) throws MissionException, VilleFranceException, SQLException {
		System.out.println("Appel PUT");
		VilleFrance vf= new VilleFrance();
		vf.setCodeCommuneInsee(codeCommuneInsee);
		vf.setNomCommune(nomCommune);
		vf.setCodePostal(codePostal);
		vf.setLibelleAcheminement(libelle);
		vf.setLigne5(ligne);
		vf.setLattitude(lat);
		vf.setLongitude(lon);
		villeService.ajoutVille(vf);
		return "ville ajouté dans la BDD";
	}
}

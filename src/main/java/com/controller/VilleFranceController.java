package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public String recover(@RequestParam(required = false, value = "codePostal") String codePostal) throws VilleFranceException, SQLException {
		System.out.println("Appel GET");
		VilleFrance vf= new VilleFrance();
		vf.setCodePostal(codePostal);
		ArrayList<VilleFrance> listVille = villeService.getInfoVille(vf);
		return listVille.toString();
	}
	

	// Methode POST
	// /villeFrancePost?value=[codeCommuneInsee=01000, nomCommune=L ABERGEMENT CLEMENCIAT, codePostal=01400, libelleAcheminement=L ABERGEMENT CLEMENCIAT, ligne5=, lattitude=46.1331001556, longitude=4.99858455549]
	@RequestMapping(value = "/villeFrance", method = RequestMethod.POST)
	@ResponseBody
	public String post(@RequestParam(required = false, value = "value") String ville) throws SQLException {
		System.out.println("Appel POST");
		villeService.postVille(ville);
		return null;
	}
		
	// Methode PUT
	// /villeFrancePut?value=[codeCommuneInsee=00001, nomCommune=TEST, codePostal=00001, libelleAcheminement=TEST, ligne5=, lattitude=0.00, longitude=0.00]
	@RequestMapping(value = "/villeFrance", method = RequestMethod.PUT)
	@ResponseBody
	public String put(@RequestParam(required = false, value = "value") String villeAjout) throws VilleFranceException, SQLException {
		System.out.println("Appel PUT");
		villeService.ajoutVille(villeAjout);
		return "ville ajouté dans la BDD";
	}
	
	//Methode DELETE
	// /villeFranceDelete?codeCommuneInsee=00001
	@RequestMapping(value = "/villeFrance", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam(required = false, value = "codeCommuneInsee") String codeCommuneInsee) throws VilleFranceException, SQLException {
		System.out.println("Appel DELETE");
		villeService.deleteVille(codeCommuneInsee);
		return "ville supprimé de la BDD";
	}
}

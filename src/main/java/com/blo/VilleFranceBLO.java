package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.VilleFrance;

public interface VilleFranceBLO {


	ArrayList<VilleFrance> getInfoVille(VilleFrance ville) throws  VilleFranceException, SQLException;
	void ajoutVille(String ville) throws SQLException;
	void postVille(String ville) throws SQLException;
	void deleteVille(String codeCommuneInsee) throws SQLException;


}

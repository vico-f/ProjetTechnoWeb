package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Mission;
import com.dto.VilleFrance;

public interface VilleFranceBLO {


	ArrayList<VilleFrance> getInfoVille(VilleFrance ville) throws MissionException, VilleFranceException, SQLException;
	void ajoutVille(VilleFrance ville) throws SQLException;
	void postVille(String ville) throws SQLException;
	


}

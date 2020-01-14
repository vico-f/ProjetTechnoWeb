package com.blo;

import java.util.ArrayList;

import com.dto.Mission;
import com.dto.VilleFrance;

public interface VilleFranceBLO {

	
	public ArrayList<VilleFrance> getInfoVille(String nomCommune) throws VilleFranceException;


}

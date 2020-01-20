package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.VilleFrance;

public interface VilleFranceDAO {
	public ArrayList<VilleFrance> getVille();
	public void deleteVille(VilleFrance ville) throws SQLException;
	public void putVille(VilleFrance ville) throws SQLException;
	public ArrayList<VilleFrance> findVille(VilleFrance ville) throws SQLException;
	void modifyVille(VilleFrance ville) throws SQLException;
}


package com.blo;

public class VilleFranceBLO {

	    private String codeCommuneInsee;
	    private String nomCommune;
	    private String codePostal;
	    private String libelleAcheminement;
	    private String ligne5;
	    private String lattitude;
	    private String longitude;
	    
	    /**
	     * Constructeur
	     * @param codeCommuneInsee
	     * @param nomCommune
	     * @param codePostal
	     * @param libelleAcheminement
	     * @param ligne5
	     * @param lattitude
	     * @param longitude
	     */
	    public VilleFranceBLO(String codeCommuneInsee,String nomCommune,String codePostal,String libelleAcheminement,String ligne5,String lattitude,String longitude) {
	    	 this.codeCommuneInsee = codeCommuneInsee;
	    	 this.nomCommune = nomCommune;
	    	 this.codePostal = codePostal;
	    	 this.libelleAcheminement = libelleAcheminement;
	    	 this.ligne5 = ligne5;
	    	 this.lattitude = lattitude;
	    	 this.longitude = longitude;
	    }
	    public VilleFranceBLO() {
	    	
	    }

	    public String getCodeCommuneInsee() {
	        return codeCommuneInsee;
	    }

	    public void setCodeCommuneInsee(String codeCommuneInsee) {
	        this.codeCommuneInsee = codeCommuneInsee;
	    }

	    public String getNomCommune() {
	        return nomCommune;
	    }

	    public void setNomCommune(String nomCommune) {
	        this.nomCommune = nomCommune;
	    }

	    public String getCodePostal() {
	        return codePostal;
	    }

	    public void setCodePostal(String codePostal) {
	        this.codePostal = codePostal;
	    }

	    public String getLibelleAcheminement() {
	        return libelleAcheminement;
	    }

	    public void setLibelleAcheminement(String libelleAcheminement) {
	        this.libelleAcheminement = libelleAcheminement;
	    }

	    public String getLigne5() {
	        return ligne5;
	    }

	    public void setLigne5(String ligne5) {
	        this.ligne5 = ligne5;
	    }

	    public String getLattitude() {
	        return lattitude;
	    }

	    public void setLattitude(String lattitude) {
	        this.lattitude = lattitude;
	    }

	    public String getLongitude() {
	        return longitude;
	    }

	    public void setLongitude(String longitude) {
	        this.longitude = longitude;
	    }

	    @Override
	    public String toString() {
	        return "Ville_France [codeCommuneInsee=" + this.codeCommuneInsee + ", nomCommune=" + this.nomCommune
	                + ", codePostal=" + this.codePostal + ", libelleAcheminement=" + this.libelleAcheminement + ", ligne5="
	                + this.ligne5 + ", lattitude=" + this.lattitude + ", longitude=" + this.longitude + "]";
	    }

	}




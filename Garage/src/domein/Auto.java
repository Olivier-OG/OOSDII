package domein;

import java.util.Objects;

public class Auto implements Comparable<Auto> {
	
	private String nummerplaat;
    private String merk;
    private String model;
    private int aantalOnderhoudsbeurten;

    public Auto(String nummerplaat, String merk, String model) {
    	this(nummerplaat,merk,model,0);
    }
    
    public Auto(String nummerplaat, String merk, String model, int aantalOnderhoudsbeurten) {
    	setNummerplaat(nummerplaat);
		setMerk(merk);
		setModel(model);
		setAantalOnderhoudsbeurten(aantalOnderhoudsbeurten);
    }

    public String getMerk() {
        return merk;
    }

    private void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    private void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }
    
    

    public int getAantalOnderhoudsbeurten() {
		return aantalOnderhoudsbeurten;
	}

	public void setAantalOnderhoudsbeurten(int aantalOnderhoudsbeurten) {
		this.aantalOnderhoudsbeurten = aantalOnderhoudsbeurten;
	}

	public void voegOnderhoudToe()
    {
    	this.aantalOnderhoudsbeurten++;
    }
    
    @Override
	public String toString() {
		return String.format("%s %s met nummerplaat %s, %d onderhoudsbeurt(en)", merk, model, nummerplaat, aantalOnderhoudsbeurten);
	}
    
	// Twee auto zijn gelijk als dezelfde nummerplaat hebben
	// Override de methodes equals en hashCode uit Object
	// Zorg ook dat deze klasse de interface Comparable implementeert,
	// auto worden op natuurlijke wijze gesorteerd op nummerplaat (alfabetisch)

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nummerplaat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auto other = (Auto) obj;
        return Objects.equals(this.nummerplaat, other.nummerplaat);
    }
    
    @Override
	public int compareTo(Auto o) {
		return this.nummerplaat.compareTo(o.nummerplaat);
	}
}

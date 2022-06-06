package domein;

public class Container implements Comparable<Container> {

    private final Integer serialNumber;
    private String eigenaar;
    private int volume;
    private int massa;

    public Container(String eigenaar, int volume, int massa, int serialNumber) {
        setEigenaar(eigenaar);
        setVolume(volume);
        setMassa(massa);

        controleerSerialNumber(serialNumber);
        this.serialNumber = serialNumber;
    }

    public int compareTo(Container m) {
        return serialNumber.compareTo(m.serialNumber);
    }

    public String getEigenaar() {
        return eigenaar;
    }

    private void setEigenaar(String eigenaar) {
        if (eigenaar == null || eigenaar.isEmpty()) {
            throw new IllegalArgumentException("Er moet een eigenaar opgegeven worden.");
        }
        this.eigenaar = eigenaar;
    }

    public int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Geen geldig volume opgegeven.");
        }
        this.volume = volume;
    }

    public int getMassa() {
        return massa;
    }

    private void setMassa(int massa) {
        if (massa <= 0) {
            throw new IllegalArgumentException("Geen geldige massa opgegeven.");
        }
        this.massa = massa;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    private void controleerSerialNumber(Integer serialNumber) {
        if (serialNumber <= 0) {
            throw new IllegalArgumentException("Ongeldig serienummer!");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Container other = (Container) obj;
        if (serialNumber == null) {
            return other.serialNumber == null;
        } else return serialNumber.equals(other.serialNumber);
    }
}




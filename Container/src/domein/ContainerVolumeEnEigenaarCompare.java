package domein;

public class ContainerVolumeEnEigenaarCompare extends ContainerEigenaarCompare {
    @Override
    public int compare(Container c1, Container c2) {
        int res = Integer.compare(c1.getVolume(), c2.getVolume());
        return res == 0 ? super.compare(c1, c2) : res;
    }
}

package domein;

public class ContainerVolumeEnEigenaarCompare extends ContainerEigenaarCompare
{
	@Override
    public int compare(Container c1, Container c2) {
		int res = Integer.compare(c1.getVolume(),c2.getVolume());
		if (res == 0)
			return super.compare(c1, c2);
		return res;
	}
}

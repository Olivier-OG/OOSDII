package domein;

import java.util.Comparator;

public class ContainerMassaCompare implements Comparator<Container> {
	@Override
    public int compare(Container c1, Container c2) {
        if (c1.getMassa() < c2.getMassa()) {
            return -1;
        }
        if (c1.getMassa() > c2.getMassa()) {
            return 1;
        } else {
            return 0;
        }
    }
}
package ui;

import domein.Container;
import domein.ContainerVolumeEnEigenaarCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContainerApplicatie {

    public static void main(String[] args) {
        List<Container> containers = new ArrayList<>();

        containers.add(new Container("Antwerpen", 60, 150, 1234));
        containers.add(new Container("Rotterdam", 70, 110, 2568));
        containers.add(new Container("Calais", 80, 90, 8569));
        containers.add(new Container("Brugge", 70, 100, 8564));

        System.out.printf("Containers bij natuurlijk sorteren: %n");
        Collections.sort(containers);
        for (Container container : containers) {
            System.out.printf("%d - %s - %dkg - %dm³%n",
                    container.getSerialNumber(), container.getEigenaar(),
                    container.getMassa(), container.getVolume());
        }

        System.out.printf("%nContainers bij sorteren op massa: %n");
        containers.sort(new Comparator<Container>() {
            @Override
            public int compare(Container o1, Container o2) {
                return Integer.compare(o1.getMassa(), o2.getMassa());
            }
        });
        for (Container container : containers) {
            System.out.printf("%dkg - %s - %dm³%n",
                    container.getMassa(),
                    container.getEigenaar(),
                    container.getVolume());
        }

        System.out.printf("%nContainers bij sorteren op eigenaar: %n");
        containers.sort(((o1, o2) -> o1.getEigenaar().compareTo(o2.getEigenaar())));
        for (Container container : containers) {
            System.out.printf("%s - %dm³ - %dkg%n",
                    container.getEigenaar(),
                    container.getVolume(),
                    container.getMassa());
        }

        System.out.printf("%nContainers bij sorteren op volume en dan op eigenaar: %n");
        containers.sort(new ContainerVolumeEnEigenaarCompare());
        for (Container container : containers) {
            System.out.printf("%dm³ - %s - %dkg%n",
                    container.getVolume(),
                    container.getEigenaar(),
                    container.getMassa());
        }

        Container nieuweContainer = new Container("Antwerpen", 70, 75, 8564);
        boolean isReedsToegevoegd = false;
        for (Container container : containers) {
            isReedsToegevoegd = container.equals(nieuweContainer);
            if (isReedsToegevoegd)
                break;
        }

        System.out.printf("%n%s%n",
                isReedsToegevoegd ?
                        "Fout: De container was reeds aanwezig in de lijst."
                        :
                        "De container is toegevoegd aan de lijst.");

        System.out.printf("%nContainers bij sorteren op serienummer: %n");
        containers.sort(Comparator.comparing(Container::getSerialNumber).reversed());
        for (Container container : containers) {
            System.out.printf("%s - %s - %dm³ - %dkg%n",
                    container.getSerialNumber(),
                    container.getEigenaar(),
                    container.getVolume(),
                    container.getMassa());
        }

    }
}
package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import domein.Container;
import domein.ContainerEigenaarCompare;
import domein.ContainerMassaCompare;
import domein.ContainerVolumeEnEigenaarCompare;

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
        ContainerMassaCompare massaCompare = new ContainerMassaCompare();
        Collections.sort(containers, massaCompare);
        for (Container container : containers) {
            System.out.printf("%dkg - %s - %dm³%n",
                     container.getMassa(),
                     container.getEigenaar(),
                     container.getVolume());
        }

        System.out.printf("%nContainers bij sorteren op eigenaar: %n");
        ContainerEigenaarCompare eigenaarCompare = new ContainerEigenaarCompare();
        Collections.sort(containers, eigenaarCompare);
        for (Container container : containers) {
            System.out.printf("%s - %dm³ - %dkg%n",
                    container.getEigenaar(),
                    container.getVolume(),
                    container.getMassa());
        }
        
        System.out.printf("%nContainers bij sorteren op volume en dan op eigenaar: %n");
        ContainerVolumeEnEigenaarCompare volumeEnEigenaarCompare = new ContainerVolumeEnEigenaarCompare();
        Collections.sort(containers, volumeEnEigenaarCompare);
        for (Container container : containers) {
            System.out.printf("%dm³ - %s - %dkg%n", 
                    container.getVolume(),
                    container.getEigenaar(),
                    container.getMassa());
        }
        
        Container nieuweContainer = new Container("Antwerpen", 70, 75, 8564);
        boolean isReedsToegevoegd = false;
        
        for (Container container : containers) {
            if (container.equals(nieuweContainer))
            {
                isReedsToegevoegd = true;
                break;
            }
        }
        
        System.out.printf("%n%s%n",
                isReedsToegevoegd ? 
                        "Fout: De container was reeds aanwezig in de lijst."
                        :
                        "De container is toegevoegd aan de lijst.");
    }
}
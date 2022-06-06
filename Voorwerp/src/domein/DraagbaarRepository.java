package domein;

import java.util.ArrayList;
import java.util.List;


public class DraagbaarRepository {
    private final List<Draagbaar> collectie;

    public DraagbaarRepository() {
        collectie = new ArrayList<>();
    }

    public void voegDraagbaarToe(Draagbaar draagbaar) {
        collectie.add(draagbaar);
    }

    public String geefOverzicht() {
        if (collectie.isEmpty())
            return "collectie is leeg";
        StringBuilder overzicht = new StringBuilder();
        for (Draagbaar draagbaar : collectie)
            overzicht.append(draagbaar).append("\n");
        return overzicht.toString();
    }

}

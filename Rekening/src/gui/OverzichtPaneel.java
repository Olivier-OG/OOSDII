package gui;

import domein.DomeinController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.List;

// Dit paneel toont een overzicht van de bestaande rekeningen
// De hoofdlayout is een VBox
public class OverzichtPaneel extends VBox {

    private final DomeinController controller;
    // Dit DetailPaneel wordt verwittigd wanneer de selectie wijzigt
    private final DetailPaneel details;
    // Een ListView is een component die een lijst kan tonen.
    private ListView<String> lijst;

    // Een OverzichtPaneel heeft zowel een controller als een DetailPaneel nodig
    // Deze komen binnen als argumenten in de constructor
    public OverzichtPaneel(DomeinController controller, DetailPaneel details) {
        this.controller = controller;
        this.details = details;
        buildGui();
    }

    private void buildGui() {
        this.setPadding(new Insets(20, 10, 50, 10));
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        Label lblOverzicht = new Label("Overzicht:");
        this.getChildren().add(lblOverzicht);

        lijst = new ListView<>();

        // Een ListView is een complexe component. We vullen de lijst met inhoud
        // De tussenstap met 'observableList' zorgt ervoor dat de ListView 
        // synchroon blijft met de lijst in de controller. 
        // Als de controller een rekening toevoegt, zal de ListView die rekening  
        // meteen tonen.
        String[] rekeningen = controller.geefAlleRekeningen();
        List<String> lijstVanRekeningen = Arrays.asList(rekeningen);
        lijst.setItems(FXCollections.observableList(lijstVanRekeningen));

        // Hier zie je hoe je een event handler kan instellen die wordt 
        // aangeroepen wanneer de gebruiker een rekening selecteert in de lijst.
        lijst.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        int indexGeselecteerdeRekening
                                = lijst.getSelectionModel().getSelectedIndex();
                        details.setIndexVanDeRekening(indexGeselecteerdeRekening);
                        details.update();
                    }

                });

        this.getChildren().add(lijst);
    }
}

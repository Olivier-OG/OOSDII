module FXRodeDraadDeel2Oplossing {
    exports persistentie;
    exports gui;
    exports main;
    exports domein;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;

    opens gui to javafx.graphics;
}
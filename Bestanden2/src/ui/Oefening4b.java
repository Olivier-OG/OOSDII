package ui;

import domein.DomeinController;

import java.io.File;
import java.util.Arrays;

public class Oefening4b
{
    public Oefening4b(DomeinController dc)
    {
        System.out.println(Arrays.toString(dc.deSerialiseerVolledigeLijst("src\\bestanden\\oef2b.ser")));
    }
}

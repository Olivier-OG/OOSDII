package persistentie;

import domein.Speler;
import domein.Wapen;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;

public class SpelerMapper {

    public List<Speler> leesTekstBestand(String bestandsnaam) {
        List<Speler> spelers = new ArrayList<>();
        int kracht;
        String type, wapens;
        try (Scanner input = new Scanner(Files.newInputStream(Paths.get(bestandsnaam)))) {

            while (input.hasNext()) {
                kracht = input.nextInt();
                type = input.next();
                wapens = input.nextLine();
                spelers.add(voegSpelerToe(kracht, type, wapens));
            }

        } catch (InvalidPathException ie) {
            System.err.println("Error finding file");
            System.exit(1);
        } catch (IOException io) {
            System.err.println("Error opening file");
            System.exit(1);
        } catch (InputMismatchException ime) {
            System.err.println("Error reading file");
            System.exit(1);
        } catch (NoSuchElementException nsee) {
            System.err.println("Error missing element");
            System.exit(1);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }
        return spelers;
    }

    private Speler voegSpelerToe(int kracht, String type, String wapens) {
        wapens = wapens.trim();
        String[] split = wapens.split("\\s+");
        Wapen[] wapensArray = new Wapen[split.length];

        for (int i = 0; i < split.length; i++) {
            wapensArray[i] = new Wapen(vervangUnderscores(split[i]));
        }

        return new Speler(kracht, type, wapensArray);
    }

    public void schrijfNaarTekstBestand(List<Speler> spelerslijst, String bestandsnaam) {
        try (Formatter output = new Formatter(Files.newOutputStream(Paths.get(bestandsnaam)))) {

            for (Speler speler : spelerslijst) {

                output.format("%d\t%s\t", speler.getKracht(), speler.getType());

                for (Wapen wapen : speler.getWapens()) {
                    output.format("%s ", vervangSpaties(wapen.getSoort()));
                }
                output.format("%n");
            }

        } catch (InvalidPathException ie) {
            System.err.println("Error finding file");
            System.exit(1);
        } catch (IOException io) {
            System.err.println("Error opening file");
            System.exit(1);
        }
    }

    public void serialiseerObjectPerObject(List<Speler> spelerslijst, String bestandsnaam) {
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(bestandsnaam)))) {

            for (Speler speler : spelerslijst)
                output.writeObject(speler);

        } catch (InvalidPathException ie) {
            System.err.println("Error finding file");
            System.exit(1);
        } catch (IOException io) {
            System.err.println("Error opening file");
            System.exit(1);
        }
    }

    public void serialiseerVolledigeLijst(List<Speler> spelerslijst, String bestandsnaam) {
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(bestandsnaam)))) {

            output.writeObject(spelerslijst);

        } catch (InvalidPathException ie) {
            System.err.println("Error finding file");
            System.exit(1);
        } catch (IOException io) {
            System.err.println("Error opening file");
            System.exit(1);
        }
    }

    public List<Speler> deSerialiseerObjectPerObject(String bestandsnaam) {

        Speler speler = null;
        List<Speler> spelerLijst = new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(bestandsnaam)))) {

            while (true) {
                speler = (Speler) input.readObject();
                spelerLijst.add(speler);
            }

        } catch (EOFException eof) {

        } catch (InvalidPathException ie) {
            System.err.println("Error finding file");
            System.exit(1);
        } catch (IOException io) {
            System.err.println("Error opening file");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return spelerLijst;
    }

    public List<Speler> deSerialiseerVolledigeLijst(String bestandsnaam) {
        List<Speler> spelerLijst = null;

        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(bestandsnaam)))) {

            spelerLijst = (List<Speler>) input.readObject();

        } catch (InvalidPathException ie) {
            System.err.println("Error finding file");
            System.exit(1);
        } catch (IOException io) {
            System.err.println("Error opening file");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return spelerLijst;
    }

    private String vervangSpaties(String tekst) {
        return tekst.replace(" ", "_");
    }

    private String vervangUnderscores(String tekst) {
        return tekst.replace("_", " ");
    }
}

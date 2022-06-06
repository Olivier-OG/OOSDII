package ui;

import domein.OrderRecord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;

public class RapportApplicatie {
    public static final String INNAAM = "Bestanden1/order.txt";
    public static final String UITNAAM = "Bestanden1/korting.txt";
    public static final int MINAANTAL = 11;
    private Scanner input;
    private Formatter output;

    public static void main(String[] args) {
        RapportApplicatie app = new RapportApplicatie();
        app.openFiles();
        app.kopieerKlantenMetKorting();
        app.closeFiles();
    }

    private void openFiles() {
        try {
            input = new Scanner(Files.newInputStream(Paths.get(INNAAM)));
        } catch (InvalidPathException ie) {
            System.err.println("Error kan order niet vinden");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error kan order niet openen");
            System.exit(1);
        }
        try {
            output = new Formatter(Files.newOutputStream(Paths.get(UITNAAM)));
        } catch (InvalidPathException ie) {
            System.err.println("Error kan korting niet vinden");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error kan korting niet openen");
            System.exit(1);
        }
    }

    private void kopieerKlantenMetKorting() {
        try {
            while (input.hasNext()) {
                OrderRecord record = new OrderRecord();
                record.setNaam(input.next());
                record.setProduct(input.next());
                record.setAantal(input.nextInt());
                record.setPrijs(input.nextDouble());
                if (record.getAantal() >= MINAANTAL)
                    record.setPrijs(record.getPrijs() * 0.95);
                output.format("%-15s%20s%8d%10.2f%n", record.getNaam(), record.getProduct(), record.getAantal(),
                        record.getPrijs());

            }
        } catch (InputMismatchException e) {
            System.err.println("Error ongeldige gegevens");
            closeFiles();
            System.exit(1);
        } catch (FormatterClosedException e) {
            System.err.println("Error formatter gesloten");
            System.exit(1);
        } catch (NoSuchElementException elementException) {
            System.err.println("Error Element ontbreekt");
            closeFiles();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error bij inlezen file");
            closeFiles();
            System.exit(1);
        }
    }

    private void closeFiles() {
        if (input != null)
            input.close();
        if (output != null)
            output.close();
    }
}

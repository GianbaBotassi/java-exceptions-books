package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creo array di libri
        Book[] biblioteca = new Book[50];
        //counter per implementare iterazione array libri
        int counterBiblioteca = 0;
        //flag per uscire dal ciclo con digit 2
        boolean flagExit = true;

        while (flagExit) {
            int choice = 0;

            //try catch per risolvere un input stringa
            try {
                System.out.println("Vuoi inserire un libro? Digita:\n" +
                        "1 - Inserisci un libro.\n" +
                        "2 - Vedi la tua biblioteca.");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Seleziona un'opzione valida.\n");
            }

            if (choice == 1) {
                try {
                    System.out.println("Inserisci il titolo.");
                    String titolo = scanner.nextLine();
                    System.out.println("Inserisci l'autore.");
                    String autore = scanner.nextLine();
                    System.out.println("Inserisci l'editore.");
                    String editore = scanner.nextLine();
                    int numPag = 0;
                    //Try catch nel caso viene inserito stringa anzichè numero
                    try {
                        System.out.println("Inserisci il numero di pagine.");
                        numPag = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Inserisci un numero di pagine corretto.");
                    }
                    //Creo libro
                    biblioteca[counterBiblioteca] = new Book(titolo, autore, editore, numPag);
                    //Aumento counter per iterazione successiva
                    counterBiblioteca++;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + "\n");
                }
            } else if (choice == 2) {
                flagExit = false;
            } else {
                //Se inserisci numero diverso
                System.out.println("Seleziona un'opzione valida.\n");
            }

        }
        //Chiudo scanner tastiera
        scanner.close();

        //Filewriter null fuori dal try catch causa scope (nel finally non lo legge)
        FileWriter biblioWriter = null;
        try {

            //Controllo se file esiste già, se si lo elimino
            File biblioFile = new File("./biblioteca.txt");
            if (biblioFile.exists()) {
                biblioFile.delete();
            }

            //Apro il writer per inserire i libri
            biblioWriter = new FileWriter("./biblioteca.txt", true);
            for (Book book : biblioteca
            ) {
                if (book != null) {
                    biblioWriter.write(book.getTitolo() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (biblioWriter != null) {

                try {
                    //se biblioWriter non esiste potrebbe sollevarsi un'eccezione prima della chiusura
                    biblioWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Per il reader non si sollevano IOException, quindi si gestisce se il file non esiste
        Scanner reader = null;
        try {
            File biblioReader = new File("./biblioteca.txt");
            reader = new Scanner(biblioReader);
            int counterBooks = 1;
            System.out.println("Ecco la tua biblioteca: ");

            //ciclo che va di riga in riga
            while (reader.hasNextLine()) {
                String riga = reader.nextLine();
                System.out.println(counterBooks + ") " + riga);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Il file non esiste.");
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}

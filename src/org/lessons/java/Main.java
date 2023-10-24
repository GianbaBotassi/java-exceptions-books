package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] biblioteca = new Book[50];
        int counterBiblioteca = 0;
        boolean flagExit = true;

        while (flagExit) {
            int choice = 0;
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
                    try {
                        System.out.println("Inserisci il numero di pagine.");
                        numPag = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Inserisci un numero di pagine corretto.");
                    }
                    biblioteca[counterBiblioteca] = new Book(titolo, autore, editore, numPag);
                    counterBiblioteca++;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + "\n");
                }
            }
            if (choice == 2) {
                flagExit = false;
            }
        }

        scanner.close();

        FileWriter biblioWriter = null;
        try {
            File biblioFile = new File("./biblioteca.txt");
            if(biblioFile.exists()){
                biblioFile.delete();
            }

            biblioWriter = new FileWriter("./biblioteca.txt", true);
            for (Book book : biblioteca
            ) {
                if (book != null) {
                    biblioWriter.write(book.getTitolo() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                biblioWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Scanner reader = null;
        try {
            File biblioReader = new File("./biblioteca.txt");
            reader = new Scanner(biblioReader);
            int counterBooks = 1;
            System.out.println("Ecco la tua biblioteca: ");
            while(reader.hasNextLine()){
                String riga = reader.nextLine();
                System.out.println(counterBooks + ") " + riga);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Il file non esiste.");
        }finally {
        reader.close();
        }




    }
}

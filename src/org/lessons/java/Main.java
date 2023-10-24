package org.lessons.java;

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
                System.out.println("Ecco la tua biblioteca");
                for (Book book : biblioteca
                ) {
                    if (book != null) {
                        System.out.println(book.toString());
                    }
                }
            }


        }
        biblioteca[0].setTitolo("");
        scanner.close();

    }
}

package org.lessons.java;

public class Book {
    //Attributi
    private String titolo;
    private String autore;
    private String editore;
    private int numPag;

    //Costruttore
    public Book(String titolo, String autore, String editore, int numPag) throws IllegalArgumentException{
        if(titolo == null || titolo.isEmpty() || autore == null || autore.isEmpty() || editore == null || editore.isEmpty()){
            throw new IllegalArgumentException("Il dato inserito non può essere vuoto.");
        } else if (numPag <= 0) {
            throw new IllegalArgumentException("Il libro deve avere almeno una pagina.");
        }

        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
        this.numPag = numPag;
    }

    //Metodi

    @Override
    public String toString() {
        return "Book{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", editore='" + editore + '\'' +
                ", numPag=" + numPag +
                '}';
    }

    //Getters and Setters
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws IllegalArgumentException{
        try {
            if(titolo.isEmpty()){
                throw new IllegalArgumentException("Hai provato a modificare il titolo ma non può essere vuoto.");
            }
            this.titolo = titolo;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) throws IllegalArgumentException {

        try {
            if(autore.isEmpty()){
                throw new IllegalArgumentException("Hai provato a modificare l'autore ma non può essere vuoto.");
            }
            this.autore = autore;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) throws IllegalArgumentException{
        try {
            if(editore.isEmpty()){
                throw new IllegalArgumentException("Hai provato a modificare l'autore ma non può essere vuoto.");
            }
            this.editore = editore;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) throws IllegalArgumentException {
        try {
            if(numPag <= 0){
                throw new IllegalArgumentException("Il libro deve avere almeno una pagina.");
            }
            this.numPag = numPag;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

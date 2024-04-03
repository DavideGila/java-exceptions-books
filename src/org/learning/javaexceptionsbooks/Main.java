package org.learning.javaexceptionsbooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quanti libri vuoi inserire? ");
        int numBooks = Integer.parseInt(scanner.nextLine());

        Book[] books = new Book[numBooks];

        for (int i = 0; i < numBooks; i++) {
            System.out.println("\nInserisci i dati del libro " + (i + 1) + ":");
            try {
                System.out.print("Titolo: ");
                String title = scanner.nextLine();

                System.out.print("Numero di pagine: ");
                int numberOfPages = Integer.parseInt(scanner.nextLine());


                System.out.print("Autore: ");
                String author = scanner.nextLine();

                System.out.print("Editore: ");
                String publisher = scanner.nextLine();

                books[i] = new Book(title, numberOfPages, author, publisher);
            } catch (IllegalArgumentException e) {
                // getMessage() è un un metodo definito nella un metodo definito nella classe Throwable che
                // restituisce una stringa che descrive il messaggio associato all'eccezione.
                System.out.println("Errore: " + e.getMessage());

                System.out.println("Inserisci nuovamente i dati per il libro " + (i + 1));

                // Torno indietro per reinserire i dati del libro corrente
                i--;
            }
        }

        scanner.close();

        try (FileWriter writer = new FileWriter("books.txt")) {
            for (Book book : books) {
                if (book != null) {
                    writer.write("Titolo: " + book.getTitle() + " - Numero di pagine: " + book.getNumberOfPages()
                            + " - Autore: " + book.getAuthor() + " - Editore: " + book.getPublisher() + "\n");
                }
            }
            System.out.println("Dati dei libri scritti nel file.");
        } catch (IOException e) {
            // IOException è una classe di eccezioni che viene utilizzata per gestire le eccezioni correlate all'I/O
            // (Input/Output)
            System.out.println("Si è verificato un errore durante la scrittura nel file: " + e.getMessage());
        }

        try (Scanner fileReader = new Scanner(new File("books.txt"))) {
            System.out.println("\nDati dei libri letti dal file:");

            while (fileReader.hasNextLine()) {
                // hasNextLine controlla se ci sono ancora righe da leggere nel file
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

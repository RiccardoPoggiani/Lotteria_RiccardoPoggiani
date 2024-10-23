package lotteria;

/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;*/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lotteria {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        try {
            System.out.println("Inserisci il numero di righe e colonne della matrice di numeri da estrarre: ");
            int n = Scanner.nextInt();

            /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                N = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            
            
            Estrazione e = new Estrazione(n, 4);
            
            System.out.println("Inizio lotteria...");
            e.start();

            try {
                e.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            
            Giocatore g1 = new Giocatore(1, "Riccardo",n, e);
            Giocatore g2 = new Giocatore(2, "Giulia", n,  e);
            Giocatore g3 = new Giocatore(3, "Alessio", n, e);
            Giocatore g4 = new Giocatore(4, "Elisa", n, e);
        
            g1.start();
            try {
                g1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            }
            g2.start();
            try {
                g2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            g3.start();
            try {
                g3.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            }

            g4.start();
            try {
                g4.join();
                } catch (InterruptedException ex) {
                Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            }

            e.stampaNumeriEstratti();  // Stampa la matrice dei numeri estratti
            
            e.stampaVincitoriEstrazione();  // Stampa i vincitori
            
            System.out.println("Fine della lotteria...");

            Scanner.close();

        } catch (InputMismatchException e) {
            System.out.println("Numero non valido");
        }
    }
}
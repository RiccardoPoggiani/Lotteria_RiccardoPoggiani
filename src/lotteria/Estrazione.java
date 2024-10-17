package lotteria;

import java.util.Random;

//@author Riccardo Poggiani 

public class Estrazione extends Thread {
    //Attributi
    private int numeroEstratto;
    private int[][] numeriEstratti;
    private int N;
    private Giocatore[] vincitori;
    private Random Random;
    
    //Metodo costruttore
    public Estrazione(int N, int nGiocatori) {
        this.N = N;
        numeriEstratti = new int[N][N];
        vincitori = new Giocatore[nGiocatori];
        Random = new Random();
    }

    //Metodo per visualizzare la matrice dei numeri estratti
    public synchronized void stampaNumeriEstratti() {
        System.out.print("I numeri estratti fino ad ora sono: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (numeriEstratti[i][j] != 0)
                    System.out.print(numeriEstratti[i][j] + ", ");
            }
        }
        System.out.println();
    }
    
    //Metodo per visualizzare i vincitori dell'estrazione
    public synchronized void stampaVincitoriEstrazione() {
       System.out.print("I giocatori vincitori dell'estrazione sono: ");
       for(Giocatore vincitore : vincitori){
           if (vincitore != null) {
                System.out.print(vincitore.getNomeGiocatore() + ", ");
            }
       }
       System.out.println();
    }
    
    public String getVincitore(int num){
        for (int i = 0; i < N; i++) {
            if (num == i){
                return vincitori[i].getNomeGiocatore();
            }
        }
        return "";
    }

    // Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    public synchronized void verifica(Giocatore giocatore, int numeroScelto) {
        if (numeroScelto == numeroEstratto) {
            System.out.println(giocatore.getNomeGiocatore() + " ha scelto il numero " + numeroScelto + ", ha vinto l'estrazione!");
            for (int i = 0; i < vincitori.length; i++) {
                if (vincitori[i] == null) {
                    vincitori[i] = giocatore;
                    break;
                }
            }
        } else {
            System.out.println(giocatore.getNomeGiocatore() + " non ha scelto il numero " + numeroEstratto + ", ha perso l'estrazione!");
        }
    }

    // Metodo per verificare se il numero è già stato estratto
    private boolean numeroGiaEstratto(int numero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (numeriEstratti[i][j] == numero) {
                    return true;  // Il numero è già stato estratto
                }
            }
        }
        return false;  // Numero non estratto
    }
    

    //Metodo per eseguire il thread
    public synchronized void run() {
        
        System.out.println("Inizio dell'estrazione...");
        
        boolean numeroValido = false;
        while (numeroValido == false) {
            numeroEstratto = Random.nextInt(9); // Genera numero da 0 a 9
            if (numeroGiaEstratto(numeroEstratto) == false) {
                numeroValido = true;  // Numero non estratto in precedenza
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (numeriEstratti[i][j] == 0) {
                    numeriEstratti[i][j] = numeroEstratto;
                    break;
                }
            }
        }
        
        System.out.println("Il numero estratto è " + numeroEstratto);
        System.out.println("Fine dell'estrazione...");
    }
}
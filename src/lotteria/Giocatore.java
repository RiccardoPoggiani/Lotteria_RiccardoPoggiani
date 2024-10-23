/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

//@author Riccardo Poggiani

public class Giocatore extends Thread{
    // attributi
    private int idGiocatore;
    private String nomeGiocatore;
    private Estrazione estrazione;
    private int N;
    private Random Random;
      
    //Metodo costruttore
    public Giocatore(int idGiocatore,String nomeGiocatore, int N, Estrazione estrazione) {
        this.idGiocatore = idGiocatore;
        this.nomeGiocatore = nomeGiocatore;
        this.estrazione = estrazione;
        this.N = N;
        Random = new Random();
    }

    //Metodo per eseguire il thread
    public void run() {

        // scelta del numero da giocare
        int numeroScelto = Random.nextInt(N*N);
        System.out.println("Il numero scelto dal giocatore " + nomeGiocatore + " è " + numeroScelto);

        for(int i=3; i>0; i--){
            System.out.println(i);
            try {
                Giocatore.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore sleep");
            }
        }
       
       // verifica del risultato
       estrazione.verifica(this, numeroScelto);

       System.out.println("Fine verifica per il giocatore " + nomeGiocatore);
    }

    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

}

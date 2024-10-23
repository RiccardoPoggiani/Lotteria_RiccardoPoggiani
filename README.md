# Lotteria

Poggiani Riccardo
5AINF
A.S.: 2024/25

---

### Scopo del Progetto
Il progetto **Lotteria** è una simulazione di un'estrazione della lotteria in cui vengono estratti numeri casuali e verificati i vincitori. Ogni giocatore sceglie un numero e, se questo coincide con il numero estratto, vince. L'obiettivo del progetto è creare un ambiente multi-thread in cui i giocatori e l'estrazione agiscono in parallelo. Il programma utilizza thread per gestire sia l'estrazione dei numeri sia la partecipazione dei giocatori.

---

### Principali Classi Usate

1. **Estrazione**: Classe che simula l'estrazione di numeri. Estende la classe `Thread` per eseguire l'estrazione in parallelo con i giocatori.
    - **Attributi principali**:
      - `numeroEstratto`: Numero corrente estratto.
      - `numeriEstratti`: Matrice 2D che tiene traccia dei numeri estratti.
      - `vincitori`: Array che tiene traccia dei giocatori vincenti.
      - `N`: Dimensione della matrice di numeri estratti.
      
    - **Metodi principali**:
      - `stampaNumeriEstratti()`: Stampa i numeri estratti fino a quel momento.
      - `stampaVincitoriEstrazione()`: Stampa i giocatori che hanno vinto.
      - `verifica(Giocatore giocatore, int numeroScelto)`: Metodo che verifica se il numero scelto dal giocatore coincide con quello estratto. Se il numero coincide, il giocatore è considerato vincitore.
      - `run()`: Metodo eseguito dal thread per estrarre un numero casuale e verificarne la validità.
      
2. **Giocatore**: Classe che rappresenta i giocatori partecipanti alla lotteria. Anch'essa estende la classe `Thread`, permettendo a ogni giocatore di agire in parallelo con l'estrazione.
    - **Attributi principali**:
      - `idGiocatore`: ID del giocatore.
      - `nomeGiocatore`: Nome del giocatore.
      - `estrazione`: Riferimento alla classe `Estrazione` per verificare il numero scelto.
      
    - **Metodi principali**:
      - `run()`: Metodo che gestisce la partecipazione del giocatore, scegliendo un numero casuale e verificandolo con l'estrazione.

3. **Lotteria**: Classe che gestisce l'intero flusso dell'applicazione, dalla creazione dei thread (estrazione e giocatori) alla stampa dei risultati finali.

---

### Dettaglio del Metodo `verifica()` nella Classe Estrazione

Il metodo `verifica(Giocatore giocatore, int numeroScelto)` si occupa di controllare se il numero scelto da un giocatore coincide con quello estratto durante il thread di `Estrazione`. Se il numero coincide, il giocatore viene aggiunto alla lista dei vincitori. Di seguito una descrizione dettagliata del metodo:

- **Parametri**:
  - `Giocatore giocatore`: L'oggetto `Giocatore` che ha scelto un numero da verificare.
  - `int numeroScelto`: Il numero scelto dal giocatore.

- **Funzionamento**:
  1. Controlla se `numeroScelto` coincide con `numeroEstratto`.
  2. Se coincidono, il giocatore ha vinto e viene aggiunto al primo posto disponibile nell'array `vincitori`.
  3. Se non coincidono, il giocatore ha perso.
  
- **Thread-safety**: Essendo il metodo `verifica()` sincronizzato, previene che più thread accedano contemporaneamente alla verifica e all'aggiornamento dei vincitori.

---

### Librerie Utilizzate

Il progetto si basa sulle librerie standard di Java:
- `java.util.Random`: Utilizzata per generare numeri casuali, sia per l'estrazione sia per la scelta dei numeri dei giocatori.
- `java.util.Scanner`: Utilizzata per leggere l'input dell'utente all'inizio del programma.
- `java.util.logging`: Utilizzata per gestire eventuali eccezioni.

---

### Scenari Alternativi di Funzionamento

1. **Nessun Vincitore**: Se nessuno dei giocatori sceglie il numero estratto, il programma segnala che tutti hanno perso.
2. **Numero già estratto**: Il metodo `numeroGiaEstratto()` controlla se il numero è già stato estratto in precedenza, evitando così duplicati durante il gioco.
3. **Interruzioni nei Thread**: Se un thread viene interrotto (ad esempio, durante il `join()`), viene gestito attraverso blocchi `try-catch`, e viene loggato un messaggio di errore.
4. **Matrice non rettangolare**: Se l'utente inserisce una dimensione non valida per la matrice dei numeri, il programma potrebbe non comportarsi correttamente. Tuttavia, in questo caso, il progetto si affida alla validità dell'input inserito dall'utente.

---

### Commento sull'Esecuzione

1. Il programma chiede all'utente di inserire la dimensione della matrice dei numeri da estrarre.
2. Una volta avviata l'estrazione, il numero estratto viene verificato rispetto ai numeri scelti dai quattro giocatori.
3. L'estrazione avviene in un thread separato, così come la partecipazione di ciascun giocatore.
4. Al termine del gioco, vengono stampati i vincitori e l'estrazione si conclude.

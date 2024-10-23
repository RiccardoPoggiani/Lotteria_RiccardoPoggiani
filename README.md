# Lotteria
Poggiani Riccardo

5AINF

A.S.: 2024/25

---
<<<<<<< HEAD

### Scopo del Progetto
Il progetto **Lotteria** è una simulazione di un'estrazione della lotteria in cui vengono estratti numeri casuali (in un range definito dall'utente) e verificati i vincitori. Ogni giocatore sceglie un numero generato casualmente e, se questo coincide con il numero estratto, vince l'estrazione. L'obiettivo del progetto è creare un ambiente multi-thread in cui i giocatori e l'estrazione agiscono in concorrenza. 

---

### Classi Principali

1. **Estrazione**: Gestisce l'estrazione di numeri casuali.
   - **Attributi**:
     - `numeroEstratto`: Numero attualmente estratto.
     - `numeriEstratti`: Matrice che memorizza tutti i numeri estratti fino ad ora.
     - `vincitori`: Array con i giocatori dell'estrazione vincenti.
     - `N`: Dimensione della matrice (Matrice ha N*N elementi).
     - `Random`: Attributo per la generazione di numeri casuali.
   - **Metodi**:
     - `stampaNumeriEstratti()`: Stampa la matrice dei numeri estratti fino ad ora.
     - `stampaVincitoriEstrazione()`: Stampa i giocatori dell'estrazione vincenti.
     - `verifica(Giocatore giocatore, int numeroScelto)`: Verifica se il numero scelto da un giocatore corrisponde a quello estratto correntemente. In caso positivo il giocatore entra a far parte dei vincitori.
     - `run()`: Gestisce l'estrazione del numero casuale in un thread.

2. **Giocatore**: Rappresenta i giocatori che partecipano alla lotteria.
   - **Attributi**:
     - `idGiocatore`: ID del giocatore.
     - `nomeGiocatore`: Nome del giocatore.
     - `estrazione`: Riferimento all'oggetto `Estrazione` per verificare il numero scelto.
     - `N`: Dimensione della matrice di numeri estratti.
     - `Random`: Attributo per la generazione di numeri casuali.
   - **Metodi**:
     - `run()`: Gestisce la partecipazione del giocatore e la verifica del numero scelto in un thread.
     - `getIdGiocatore()`: Restituisce il nome del giocatore (visibilità private).
=======
>>>>>>> e2696ad52f5264cf643b6d91ec4fb79c7d8526e4

### Scopo del Progetto
Il progetto **Lotteria** è una simulazione di un'estrazione della lotteria in cui vengono estratti numeri casuali e verificati i vincitori. Ogni giocatore sceglie un numero e, se questo coincide con il numero estratto, vince. L'obiettivo del progetto è creare un ambiente multi-thread in cui i giocatori e l'estrazione agiscono in parallelo. Il programma utilizza thread per gestire sia l'estrazione dei numeri sia la partecipazione dei giocatori.

<<<<<<< HEAD
3. **Lotteria**: Coordina l'intero processo di estrazione, partecipazione e verifica dei numeri dei giocatori.

---

### Dettagli del Metodo `verifica()` nella Classe Estrazione

Il metodo `verifica()` controlla se il numero scelto da un giocatore coincide con quello estratto. Se sì, il giocatore viene aggiunto all'array `vincitori`. In entrambi gli esiti si avverte con una stampa a schermo della perdita o della vittoria del giocatore.

- **Parametri**:
  - `Giocatore giocatore`: Il giocatore che ha scelto il numero che si ddve verificare.
  - `int numeroScelto`: Il numero scelto dal giocatore.
  
- **Funzionamento**:
  1. Se `numeroScelto` corrisponde a `numeroEstratto`, il giocatore è vincitore.
  2. Tramite un ciclo for che scorre l'array `vincitori` si aggiunge il giocatore nella prima cella libera.
  3. 
=======
---

### Principali Classi Usate

1. **Estrazione**: Classe che simula l'estrazione di numeri. Estende la classe `Thread` per eseguire l'estrazione in parallelo con i giocatori.
    - **Attributi**:
       - `numeroEstratto`: Numero corrente estratto.
       - `numeriEstratti`: Matrice 2D che tiene traccia dei numeri estratti.
       - `vincitori`: Array che tiene traccia dei giocatori vincenti.
       - `N`: Dimensione della matrice di numeri estratti.
      
    - **Metodi**:
       - `stampaNumeriEstratti()`: Stampa i numeri estratti fino a quel momento.
       - `stampaVincitoriEstrazione()`: Stampa i giocatori che hanno vinto.
       - `verifica(Giocatore giocatore, int numeroScelto)`: Metodo che verifica se il numero scelto dal giocatore coincide con quello estratto. Se il numero coincide, il giocatore è considerato vincitore.
       - `run()`: Metodo eseguito dal thread per estrarre un numero casuale e verificarne la validità.
      
2. **Giocatore**: Classe che rappresenta i giocatori partecipanti alla lotteria. Anch'essa estende la classe `Thread`, permettendo a ogni giocatore di agire in parallelo con l'estrazione.
    - **Attributi**:
        - `idGiocatore`: ID del giocatore.
        - `nomeGiocatore`: Nome del giocatore.
        - `estrazione`: Riferimento alla classe `Estrazione` per verificare il numero scelto.
      
    - **Metodi**:
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
>>>>>>> e2696ad52f5264cf643b6d91ec4fb79c7d8526e4

---

### Librerie Utilizzate
<<<<<<< HEAD
Il progetto utilizza le seguenti librerie standard di Java:
- `java.util.Random`: Per generare numeri casuali.
- `java.util.Scanner`: Per l'input dell'utente.
- `java.util.logging`: Per la gestione degli errori e delle eccezioni.
- `java.util.level`: Fornisce i diversi livelli di gravità per i messaggi di log.
- `java.util.InputMismatchException`: Gestire l'eccezione che si verifica quando l'input dell'utente non corrisponde al tipo di dato atteso.

---

### Flusso di Esecuzione

1. L'utente inserisce la dimensione della matrice di numeri estratti.
2. Viene avviata l'estrazione del numero corrente (deve essere diverso da quelli estratti precedentemente), che viene aggiunto all'insieme dei numeri estratti.
3. Ogni giocatore, eseguito in un proprio thread uno dopo l'altro, sceglie un numero casuale e verifica se corrisponde con il numero estratto. In caso affermativo il giocatore fa parte dei vincitori.
4. Al termine dell'estrazione e delle verifiche, vengono stampati i numeri estratti e i vincitori.

---

### Scenari Alternativi

1. **Nessun Vincitore**: Se nessun giocatore sceglie il numero estratto, viene comunicata la mancanza di vincitori.
2. **Numero già estratto**: La funzione `numeroGiaEstratto()` evita duplicati di numeri estratti.
3. **Gestione degli errori**: Se un thread viene interrotto, l'errore viene gestito con blocchi `try-catch`. Le eccezioni gestite includono:
  - `InterruptedException`: Si verifica quando un thread è interrotto mentre sta aspettando di completare un'operazione, ad esempio durante il metodo join(). In questo caso, viene registrato un messaggio di errore e l'applicazione continua a funzionare.
  - `InputMismatchException`: Si verifica quando l'utente inserisce un input non valido (come una lettera al posto di un numero) durante la lettura dell'input con Scanner. Questa eccezione è gestita per chiedere nuovamente all'utente un valore valido.

---

### Esempio di Esecuzione

1. L'utente inserisce la dimensione della matrice: ad esempio, 3 per una matrice 3x3.
2. Viene avviato il thread dell'estrazione e un numero casuale viene estratto in un range di 9 (= 3*3).
3. 4 giocatori scelgono ciascuno un numero casuale in un range di 9 e verificano se hanno vinto.
4. Viene stampata la matrice dei numeri estratti e i vincitori.
5. Il programma si conclude.
=======

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
>>>>>>> e2696ad52f5264cf643b6d91ec4fb79c7d8526e4

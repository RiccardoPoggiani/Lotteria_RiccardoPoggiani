# Lotteria
Poggiani Riccardo

5AINF

A.S.: 2024/25

---

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
  3. In entrambi i casi si stampa a schermo una stringa che indica se il giocatore ha vinto o perso.

---

### Librerie Utilizzate
Il progetto utilizza le seguenti librerie standard di Java:
- `java.util.Random`: Per generare numeri casuali.
- `java.util.Scanner`: Per l'input dell'utente.
- `java.util.logging`: Per la gestione degli errori e delle eccezioni.
- `java.util.level`: Fornisce i diversi livelli di gravità per i messaggi di log.
- `java.util.InputMismatchException`: Gestisce l'eccezione che si verifica quando l'input dell'utente non corrisponde al tipo di dato atteso.

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
  - `InputMismatchException`: Si verifica quando l'utente inserisce un input non valido (come una lettera al posto di un numero) durante la lettura dell'input con Scanner.

---

### Esempio di Esecuzione

1. L'utente inserisce la dimensione della matrice: ad esempio, 3 per una matrice 3x3.
2. Viene avviato il thread dell'estrazione e un numero casuale viene estratto in un range di 9 (= 3*3).
3. 4 giocatori scelgono ciascuno un numero casuale in un range di 9 e verificano se hanno vinto.
4. Viene stampata la matrice dei numeri estratti e i vincitori.
5. Il programma si conclude.

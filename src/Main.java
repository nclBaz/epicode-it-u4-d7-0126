import entities.User;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

		List<User> usersList = new LinkedList<>(); // ✅ questa tecnica di dichiarare List a sx dell'uguale (invece di LinkedList o ArrayList)
		// 	mi consente in futuro di poter agilmente sostituire una LinkedList con un ArrayList (o viceversa) in maniera molto semplice. Utilizzo
		// questa tecnica quando so già con anticipo che mi basteranno i metodi in comune tra AL e LL

		// LinkedList<User> usersList = new LinkedList<>();  // Se invece so per certo che avrò bisogno di metodi che solo le LinkedList hanno, allora
		// non potrò usare questa tecnica
		// usersList.poll(); // .poll() è un metodo esclusivo delle LinkedList (non ce l'hanno le ArrayList)

		// *************************************** ADD *******************************
		System.out.println("La lista ha: " + usersList.size() + " elementi");
		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(0, giacomo);
		// usersList.addFirst(giacomo); // Alternativa alla riga precedente

		System.out.println("La lista ha: " + usersList.size() + " elementi");
		System.out.println(usersList);
//
//		for (User user : usersList) {
//			System.out.println(user);
//		}

		// *************************************** GET *******************************
		try {
			User fromList = usersList.get(20); // <-- rischio di IndexOutOfBoundsException
			System.out.println(fromList);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}


		// *************************************** INDEX OF *******************************
		int aldoIndex = usersList.indexOf(aldo);
		System.out.println("L'indice di Aldo è: " + aldoIndex);


		// *************************************** CONTAINS *******************************

		/*
		.contains() torna un booleano che ci dice se un elemento è presente o meno nella lista

		Dietro le quinte utilizza il metodo .equals() che tutti gli oggetti hanno. Però sappiamo
		che se non facciamo l'override del metodo verranno comparate le celle di memoria
		Se invece facciamo l'override verranno confrontati i valori (es. nome e cognome)
		*/


//		if (usersList.contains(giovanni)) {
//			System.out.println("Giovanni è nella lista");
//		} else {
//			System.out.println("Giovanni NON è nella lista");
//		}

		User giovanni2 = new User("Giovanni", "Storti");

		if (usersList.contains(giovanni2)) { // se non faccio l'override di equals mi darà FALSE
			// facendolo invece mi darà TRUE
			System.out.println("Giovanni2 è nella lista");
		} else {
			System.out.println("Giovanni2 NON è nella lista");
		}

		// *************************************** REMOVE *******************************
		usersList.remove(giacomo);
		usersList.remove(0); // uguale a removeFirst()
		usersList.removeLast();

		System.out.println(usersList);

		// *************************************** INIZIALIZZAZIONE CON ELEMENTI *******************************
		ArrayList<User> usersList2 = new ArrayList<>(List.of(aldo, giovanni, giacomo));
		// Inizializziamo la lista con 3 elementi (passiamo una lista come parametro)
		ArrayList<User> usersList3 = new ArrayList<>(Arrays.asList(aldo, giovanni, giacomo, new User("Ajeje", "Brazorf")));
		// Inizializziamo la lista con 3 elementi (passiamo una array convertito in lista come parametro)

		// *************************************** ADD ALL *******************************
		usersList.addAll(usersList2);
		usersList.addAll(usersList3);

		System.out.println(usersList);

		// *************************************** REMOVE ALL *******************************
		// Non svuota interamente la lista, ma mi consente di specificare la lista degli elementi da rimuovere
		usersList.removeAll(usersList2);

		System.out.println(usersList);


		// *************************************** SET *******************************
		// il metodo .set() rimpiazza un elemento alla posizione specificata
		// .add() invece aggiunge e sposta gli altri
		usersList.add(aldo);
		usersList.add(giovanni);
		System.out.println(usersList);

		usersList.set(0, new User("Ajeje", "Brazorf")); // <-- Occhio all'IndexOutOfBoundsException
		// Rimpiazza l'elemento nella posizione specificata con il secondo parametro
		System.out.println(usersList);


		// *************************************** CLEAR & ISEMPTY *******************************
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		usersList.clear();
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		System.out.println("La lista ha " + usersList.size() + " elementi");

		// *************************************** COLLECTIONS & TIPI PRIMITIVI *********************************
		// ArrayList<int> interi = new ArrayList<>(); // Non posso creare collections con tipi primitivi
		ArrayList<Integer> interi = new ArrayList<>();
		// Ogni tipo primitivo ha una sua classe corrispondente chiamate WRAPPER CLASSES
		// int -> Integer
		// double -> Double
		// long -> Long
		// boolean -> Boolean
		interi.add(1);
		interi.add(2);
		System.out.println(interi);


		// *************************************** SET *********************************
		// I SET sono degli insiemi di dati in cui NON SONO AMMESSI DUPLICATI
		// Questa caratteristica nasconde un costo computazionale importante. Ogniqualvolta useremo il metodo per aggiungere elementi
		// esso dietro le quinte dovrà andare a controllare ELEMENTO PER ELEMENTO se il nuovo elemento è già presente. Se abbiamo tanti
		// elementi, il costo diventa elevato

		HashSet<User> usersSet = new HashSet<>();
		// HashSet è il SET più comune ma non garantisce di mantenere l'ordinamento dei dati in base all'inserimento ma è rapido
		// LinkedHashSet è un po' più lento di sopra ma mantiene l'ordinamento dei dati in base all'inserimento
		// TreeSet è molto più lento degli altri perché oltre a non ammettere duplicati, ad ogni aggiunta ri-ordina tutti gli elementi
		// in base a un criterio tipo numerico/alfabetico/custom

		// Non è che sia vietato aggiungere 2 volte lo stesso elemento, il metodo mi torna un booleano
		// che mi dirà se è riuscito ad aggiungere o meno l'elemento
		System.out.println(usersSet.add(aldo)); // TRUE
		System.out.println(usersSet.add(giovanni)); // TRUE
		System.out.println(usersSet.add(giacomo)); // TRUE
		System.out.println(usersSet.add(aldo)); // FALSE

		System.out.println(usersSet);

		TreeSet<String> alphabet = new TreeSet<>();

		alphabet.add("z");
		alphabet.add("c");
		alphabet.add("e");
		alphabet.add("a");
		alphabet.add("w");

		System.out.println(alphabet);


	}
}

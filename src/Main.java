import entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

		ArrayList<User> usersList = new ArrayList<>();

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


	}
}

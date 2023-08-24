package com.mycompany.pokemongame_project;

import javax.swing.JOptionPane;

public class Player {

    private String name;
    Nodo primero;
    Nodo ultimo;
    CPU_Player CPU;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public void insert_Pokemon(Pokemon p) {
        if (getSize() < 4) {
            // Verificamos primero si el Pokémon ya existe en la lista
            Nodo aux = primero;
            while (aux != null) {
                if (aux.getPokemon().equals(p)) {
                    // Si el Pokémon ya está en la lista, no se realiza la inserción por lo tanto se
                    // rompre el metodo
                    System.out.println("Ya existe " + aux.getPokemon().getName() + " pokemon en la pokedex");
                    return;
                }
                aux = aux.getNext();
            }

            // Si el Pokémon no existe en la lista, se realiza la inserción
            Nodo nuevoNodo = new Nodo(p);
            if (primero == null) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else {
                ultimo.setNext(nuevoNodo);
                nuevoNodo.setBack(ultimo);
                ultimo = nuevoNodo;
            }
        } else {
            System.out.println("|No es posible tener mas de 4 Pokemones en la pokedex");
        }
    }

    public void imprimirDesdeInicio() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getPokemon() + "\n");
            actual = actual.getNext();
        }
        System.out.println();
    }

    public void removeFirstPokemon() {
        if (primero == null) {
            // La lista está vacía, no hay nada que eliminar
            return;
        }

        primero = primero.getNext();
    }

    public void intercambiarNodos(Nodo nodo1, Nodo nodo2) {
        if (primero == null || primero.getNext() == null) {
            JOptionPane.showMessageDialog(null, "Tus Pokemon han sido derrotados");
         
        }

        if (nodo1 == null || nodo2 == null) {
            return;
        }

        // Actualizar enlace del nodo anterior a nodo1
        if (nodo1.getBack() != null) {
            nodo1.getBack().setNext(nodo2);
        } else {
            primero = nodo2;

        }

        // Actualizar enlace del nodo siguiente a nodo1
        if (nodo1.getNext() != null) {
            nodo1.getNext().setBack(nodo2);
        } else {
            ultimo = nodo2;
        }

        // Actualizar enlace del nodo anterior a nodo2
        if (nodo2.getBack() != null) {
            nodo2.getBack().setNext(nodo1);
        } else {
            primero = nodo1;
        }

        // Actualizar enlace del nodo siguiente a nodo2
        if (nodo2.getNext() != null) {
            nodo2.getNext().setBack(nodo1);
        } else {
            ultimo = nodo1;
        }

        // Realizar el intercambio de enlaces entre los nodos
        Nodo tempSiguiente = nodo1.getNext();
        Nodo tempAnterior = nodo1.getBack();
        nodo1.setNext(nodo2.getNext());
        nodo1.setBack(nodo2.getBack());
        nodo2.setNext(tempSiguiente);
        nodo2.setBack(tempAnterior);
    }

    public void intercambiarCabezaConSiguiente() {
        if (primero == null || primero.getNext() == null) {
            JOptionPane.showMessageDialog(null, "Tus Pokemon han sido derrotados");
            JOptionPane.showMessageDialog(null, CPU.getName() + " Es el Ganador");
            return;
        }

        Nodo Cabeza = primero;
        Nodo siguienteCabeza = Cabeza.getNext();

        // Actualizar enlaces para la primero y su nodo siguiente
        Cabeza.setNext(siguienteCabeza.getNext());
        siguienteCabeza.setNext(Cabeza);

        Cabeza.setBack(siguienteCabeza);
        siguienteCabeza.setBack(null);

        // Actualizar el primero si la primero original era el primero
        if (Cabeza == primero) {
            primero = siguienteCabeza;
        }
    }

    public void imprimirLista() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getPokemon() + "\n ");
            actual = actual.getNext();
        }
        System.out.println();
    }

    public int getSize() {
        int count = 0;
        Nodo aux = primero;
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        Nodo aux = primero;
        String s = "--> Jugador: " + name + "\n";

        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }

        return s;
    }
}

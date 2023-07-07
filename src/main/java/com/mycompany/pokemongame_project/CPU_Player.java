package com.mycompany.pokemongame_project;

import java.util.Random;

public class CPU_Player {
    private String name;
    private Nodo cabeza;

    public CPU_Player(String name) {
        this.name = name;
    }

    public CPU_Player() {
    }

    public void insert_Pokemon(Pokemon p) {
        // Verificamos primero si el Pokémon ya existe en la lista
        Nodo aux = cabeza;
        while (aux != null) {
            if (aux.getPokemon().equals(p)) {
                // El Pokémon ya está en la lista, no se realiza la inserción por lo tanto se
                // rompre el metodo
                return;
            }
            aux = aux.getNext();
        }

        // El Pokémon no existe en la lista, se realiza la inserción
        Nodo newNode = new Nodo(p);

        if (cabeza == null) {
            cabeza = newNode;
        } else {
            aux = cabeza;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void Remove_Pokemon(Pokemon p) {
        if (cabeza == null) {
            // La lista está vacía, no hay nada que eliminar
            return;
        }

        if (cabeza.getPokemon() == p) {
            // El primer nodo contiene el Pokémon a eliminar
            cabeza = cabeza.getNext();
            return;
        }

        Nodo aux = cabeza;
        while (aux.getNext() != null) {
            if (aux.getNext().getPokemon() == p) {
                // El siguiente nodo contiene el Pokémon a eliminar
                aux.setNext(aux.getNext().getNext());
                return;
            }
            aux = aux.getNext();
        }

        // Si llegamos a este punto, significa que el Pokémon no se encontró en la lista
        System.out.println("|El Pokémon " + p.getName() + " no está en la lista.");
    }

    public Pokemon selectActivePokemon() {
        // Seleccionar un Pokémon activo al azar de la lista
        Random random = new Random();
        // Generamos un numero randon apartir del get_size que nos trae la cantidad de
        // elementos que haya en la lista
        int index = random.nextInt(getSize());
        // Creamos un nodo auxiliar igualado a cabeza
        Nodo aux = cabeza;
        // Recorremos la lista con el index random
        for (int i = 0; i < index; i++) {
            // Alcanzamos al nodo que conincide con el index random generado
            aux = aux.getNext();
        }
        // Devolvemos el pokemon que se selecciono de manera aleatoria
        return aux.getPokemon();
    }

    public int getSize() {
        int count = 0;
        Nodo aux = cabeza;
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        Nodo aux = cabeza;
        StringBuilder sb = new StringBuilder(name + ": ");
        while (aux != null) {
            sb.append(aux).append(" » ");
            aux = aux.getNext();
        }
        return sb.toString();
    }
}
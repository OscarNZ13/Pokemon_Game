package com.mycompany.pokemongame_project;

public class Player {

    private String name;
    Nodo cabeza;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }
    
    public void insert_Pokemon(Pokemon p) {
        if (getSize() < 4) {
            // Verificamos primero si el Pokémon ya existe en la lista
            Nodo aux = cabeza;
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
        } else {
            System.out.println("|No es posible tener mas de 4 Pokemones en la pokedex");
        }
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

    public int getSize() {
        int count = 0;
        Nodo aux = cabeza;
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
        Nodo aux = cabeza;
        String s = "--> Jugador: " + name + "\n";

        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }

        return s;
    }
}

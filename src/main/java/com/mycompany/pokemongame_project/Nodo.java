package com.mycompany.pokemongame_project;

public class Nodo {
    private Pokemon pokemon;
    private Nodo next;
    private Nodo back;

    public Nodo(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Nodo() {
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Nodo getBack() {
        return back;
    }

    public void setBack(Nodo back) {
        this.back = back;
    }



    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + pokemon + "";
    }
}

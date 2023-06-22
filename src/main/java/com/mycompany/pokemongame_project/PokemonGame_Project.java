package com.mycompany.pokemongame_project;

public class PokemonGame_Project {

    public static void main(String[] args) {
        Pokemon P1 = new Pokemon("Charizard", 150, 75, 60, PokemonType.Fire, PokemonType.Fire, PokemonType.Water);
        System.out.println(P1.getType());
    }
}

package com.mycompany.pokemongame_project;

public class Rattata_N extends Pokemon implements IPokemon_Actions{

    public Rattata_N(AllPokemons Name, int HP, int Attack, int Defense, PokemonType Type, PokemonType Strong, PokemonType Weak) {
        super(Name, HP, Attack, Defense, Type, Strong, Weak);
    }

    @Override
    public void SpecialAttack() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void SpecialDefense() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

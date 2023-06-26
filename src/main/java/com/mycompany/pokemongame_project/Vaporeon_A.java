package com.mycompany.pokemongame_project;

public class Vaporeon_A extends Pokemon implements IPokemon_Actions{

    public Vaporeon_A(AllPokemons Name, int HP, int Attack, int Defense, PokemonType Type, PokemonType Strong, PokemonType Weak) {
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

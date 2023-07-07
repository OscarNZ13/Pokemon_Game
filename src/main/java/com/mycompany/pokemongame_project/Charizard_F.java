package com.mycompany.pokemongame_project;

public class Charizard_F extends Pokemon implements IPokemon_Actions {

    public Charizard_F(AllPokemons Name, int HP, int Attack, int Defense, int SpecialAttack, int SpecialDefense, PokemonType Type, PokemonType Strong, PokemonType Weak) {
        super(Name, HP, Attack, Defense, SpecialAttack, SpecialDefense, Type, Strong, Weak);
    }

    @Override
    public void Attack(Pokemon p) {
        int damage = getAttack() - p.getDefense(); //restar el atque a la defense del pokemon
        int rest = p.getHP() - damage;
        p.setHP(rest);
        System.out.println("Tu oponente" + getName() + "ha atacado a tu Pokemon" + p.getName() + "con un daño de" + damage);
    }

    @Override
    public void Defense(Pokemon p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void SpecialAttack(Pokemon p) {
        int damage = getSpecialAttack() - p.getSpecialDefense(); //restar el atque a la defense del pokemon
        int rest = p.getHP() - damage;
        System.out.println("Tu oponente" + getName() + "ha atacado a tu Pokemon con un ataque Especial" + p.getName() + "con un daño de" + damage);
    }

    @Override
    public void SpecialDefense(Pokemon p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

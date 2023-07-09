package com.mycompany.pokemongame_project;

public class Gastrodon_A extends Pokemon implements IPokemon_Actions {

    public Gastrodon_A(AllPokemons Name, int HP, int Attack, int Defense, int SpecialAttack, int SpecialDefense, PokemonType Type, PokemonType Strong, PokemonType Weak) {
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
        int demage = p.getAttack() - getDefense();
        int rest = getHP() - demage;
        setHP(rest);
        System.out.println("Tu Pokemon" + getName() + "ha atacado al oponente" + p.getName() + "con un daño de" + rest);
    }

    @Override
    public void SpecialAttack(Pokemon p) {
        int damage = getSpecialAttack() - p.getSpecialDefense(); //restar el atque a la defense del pokemon
        int rest = p.getHP() - damage;
        p.setHP(rest);
        System.out.println("Tu oponente" + getName() + "ha atacado a tu Pokemon con un ataque Especial" + p.getName() + "con un daño de" + damage);
    }

    @Override
    public void SpecialDefense(Pokemon p) {
        int demage = p.getSpecialDefense() - getSpecialDefense();
        int rest = p.getHP() - demage;
        setHP(rest);
        System.out.println("Tu Pokemon" + getName() + "ha utilizado una defense especial contra el ataque de" + p.getName() + "con un daño de" + rest);
    }

}

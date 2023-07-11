package com.mycompany.pokemongame_project;

public class Vaporeon_A extends Pokemon implements IPokemon_Actions {

    public Vaporeon_A(AllPokemons Name, int HP, int Attack, int Defense, int SpecialAttack, int SpecialDefense, PokemonType Type, PokemonType Strong, PokemonType Weak) {
        super(Name, HP, Attack, Defense, SpecialAttack, SpecialDefense, Type, Strong, Weak);
    }
// getAttack trae el ataque/defensa del Pokemon de la clase, en este caso Charizard
// p.getAttack traera el ataque/defensa del pokemon que escogera el CPU para iniciar la batalla 
    @Override
    public void Attack(Pokemon p) {
        int damage = getAttack() - p.getDefense(); //restar el ataque a la defense del pokemon
        int rest = p.getHP() - damage;
        p.setHP(rest);
        System.out.println("Tu Pokemon" + getName() + "ha atacado al Pokemon" + p.getName() + "con un daño de" + damage);
    }

    @Override
    public void Defense(Pokemon p) {
        int demage = p.getAttack() - getDefense();
        int rest = getHP() - demage;
        setHP(rest);
        System.out.println("Tu Pokemon" + getName() + "ha lanzado su defensa al oponente" + p.getName() + "con un daño de" + rest);
    }

    @Override
    public void SpecialAttack(Pokemon p) {
        int damage = getSpecialAttack() - p.getSpecialDefense(); //restar el atque a la defense del pokemon
        int rest = p.getHP() - damage;
        p.setHP(rest);
        System.out.println("Tu Pokemon" + getName() + "ha atacado al Pokemon oponente con un ataque Especial" + p.getName() + "con un daño de" + damage);
    }

    @Override
    public void SpecialDefense(Pokemon p) {
        int demage = p.getSpecialDefense() - getSpecialDefense();
        int rest = p.getHP() - demage;
        setHP(rest);
        System.out.println("Tu Pokemon" + getName() + "ha utilizado una defensa especial contra el ataque de" + p.getName() + "con un daño de" + rest);
    }

}

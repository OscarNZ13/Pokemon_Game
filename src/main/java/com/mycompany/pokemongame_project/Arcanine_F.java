package com.mycompany.pokemongame_project;

public class Arcanine_F extends Pokemon {

    public Arcanine_F(AllPokemons Name, int HP, int Attack, int Defense, int SpecialAttack, int SpecialDefense, PokemonType Type, PokemonType Strong, PokemonType Weak) {
        super(Name, HP, Attack, Defense, SpecialAttack, SpecialDefense, Type, Strong, Weak);
    }

    @Override
    public void Attack(Pokemon p) {
        int damage;
        if (p.getWeak() == getType()) {
            damage = (int) (getAttack() * 1.5) - p.getDefense();
        } else if (p.getStrong() == getType()) {
            damage = (int) (getAttack() * 0.5) - p.getDefense();
        } else {
            damage = getAttack() - p.getDefense();
        }

        if (damage > 0) {
            int remainingHP = p.getHP() - damage;
            p.setHP(remainingHP);
            System.out.println("Tu oponente " + getName() + " ha atacado a tu Pokémon " + p.getName() + " con un daño de " + damage + ".");
        } else {
            System.out.println("El ataque de " + getName() + " no ha causado ningún daño a " + p.getName() + ".");
        }
    }

    @Override
    public void Defense(Pokemon p) {
        int damage;
        if (p.getWeak() == getType()) {
            damage = p.getAttack() - (int) (getDefense() * 0.5);
        } else if (p.getStrong() == getType()) {
            damage = p.getAttack() - (int) (getDefense() * 1.5);
        } else {
            damage = p.getAttack() - getDefense();
        }

        if (damage > 0) {
            int remainingHP = getHP() - damage;
            setHP(remainingHP);
            System.out.println("Tu Pokémon " + getName() + " ha sido atacado por " + p.getName() + " con un daño de " + damage + ".");
        } else {
            System.out.println("El ataque de " + p.getName() + " no ha causado ningún daño a tu Pokémon " + getName() + ".");
        }
    }

    @Override
    public void SpecialAttack(Pokemon p) {
        int damage = getSpecialAttack() - p.getSpecialDefense();

        // Verificar el tipo de Pokémon atacante y objetivo
        if (getType() == PokemonType.Normal && p.getType() == PokemonType.Water) {
            damage += 5;  // Aumentar el daño en 5 HP contra tipo Agua
        } else if (getType() == PokemonType.Fire && p.getType() == PokemonType.Normal) {
            damage += 5;  // Aumentar el daño en 5 HP contra tipo Normal
        } else if (getType() == PokemonType.Water && p.getType() == PokemonType.Fire) {
            damage += 10;  // Aumentar el daño en 10 HP contra tipo Fuego
        }

        System.out.println("Tu oponente " + getName() + " ha atacado a tu Pokémon con un ataque Especial " + p.getName() + " con un daño de " + damage);

        int rest = p.getHP() - damage;
        p.setHP(rest);
    }

    @Override
    public void SpecialDefense(Pokemon p) {
        int damage = p.getSpecialAttack() - getSpecialDefense();

        // Verificar el tipo de Pokémon atacante y objetivo
        if (p.getType() == PokemonType.Water && getType() == PokemonType.Normal) {
            damage -= 5;  // Reducir el daño en 5 HP contra tipo Agua
        } else if (p.getType() == PokemonType.Normal && getType() == PokemonType.Fire) {
            damage -= 5;  // Reducir el daño en 5 HP contra tipo Normal
        } else if (p.getType() == PokemonType.Fire && getType() == PokemonType.Water) {
            damage -= 10;  // Reducir el daño en 10 HP contra tipo Fuego
        }

        System.out.println("Tu Pokémon " + getName() + " ha utilizado una defensa especial contra el ataque de " + p.getName() + " con un daño de " + damage);

        int rest = getHP() - damage;
        setHP(rest);
    }
}

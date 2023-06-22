package com.mycompany.pokemongame_project;

public class Pokemon implements IPokemon_Attacks {

    private String Name;
    private int HP, Attack, Defense;
    private PokemonType Type, Strong, Weak;

    public Pokemon(String name, int hP, int attack, int defense, PokemonType type, PokemonType strong,
            PokemonType weak) {
        Name = name;
        HP = hP;
        Attack = attack;
        Defense = defense;
        Type = type;
        Strong = strong;
        Weak = weak;
    }

    //Interface Methods:
    @Override
    public void SpecialAttack() {
        //Will be create the Special attack here
    }

    @Override
    public void SpecialDefense() {
        //Will be create the Special defense here
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int hP) {
        HP = hP;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public PokemonType getType() {
        return Type;
    }

    public void setType(PokemonType type) {
        Type = type;
    }

    public PokemonType getStrong() {
        return Strong;
    }

    public void setStrong(PokemonType strong) {
        Strong = strong;
    }

    public PokemonType getWeak() {
        return Weak;
    }

    public void setWeak(PokemonType weak) {
        Weak = weak;
    }

}

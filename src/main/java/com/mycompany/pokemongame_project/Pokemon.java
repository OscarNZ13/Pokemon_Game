package com.mycompany.pokemongame_project;

public abstract class Pokemon{

    private AllPokemons Name;
    private int HP, Attack, Defense;
    private PokemonType Type, Strong, Weak;

    public Pokemon(AllPokemons Name, int HP, int Attack, int Defense, PokemonType Type, PokemonType Strong, PokemonType Weak) {
        this.Name = Name;
        this.HP = HP;
        this.Attack = Attack;
        this.Defense = Defense;
        this.Type = Type;
        this.Strong = Strong;
        this.Weak = Weak;
    }

    public AllPokemons getName() {
        return Name;
    }

    public void setName(AllPokemons Name) {
        this.Name = Name;
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

    @Override
    public String toString() {
        return "|Pokemon: "+ Name + " - HP: " + HP + " - Attack: " + Attack + " - Defense: " + Defense + " - Type: " + Type + " - Strong: " + Strong + " - Weak: " + Weak;
    }
}

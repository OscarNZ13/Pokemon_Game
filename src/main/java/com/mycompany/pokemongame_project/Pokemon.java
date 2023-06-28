package com.mycompany.pokemongame_project;

public abstract class Pokemon{

    private AllPokemons Name;
    private int HP, Attack, Defense, SpecialAttack, SpecialDefense;
    private PokemonType Type, Strong, Weak;

    public Pokemon(AllPokemons Name, int HP, int Attack, int Defense, int SpecialAttack, int SpecialDefense, PokemonType Type, PokemonType Strong, PokemonType Weak) {
        this.Name = Name;
        this.HP = HP;
        this.Attack = Attack;
        this.Defense = Defense;
        this.SpecialAttack = SpecialAttack;
        this.SpecialDefense = SpecialDefense;
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

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    public int getSpecialAttack() {
        return SpecialAttack;
    }

    public void setSpecialAttack(int SpecialAttack) {
        this.SpecialAttack = SpecialAttack;
    }

    public int getSpecialDefense() {
        return SpecialDefense;
    }

    public void setSpecialDefense(int SpecialDefense) {
        this.SpecialDefense = SpecialDefense;
    }

    public PokemonType getType() {
        return Type;
    }

    public void setType(PokemonType Type) {
        this.Type = Type;
    }

    public PokemonType getStrong() {
        return Strong;
    }

    public void setStrong(PokemonType Strong) {
        this.Strong = Strong;
    }

    public PokemonType getWeak() {
        return Weak;
    }

    public void setWeak(PokemonType Weak) {
        this.Weak = Weak;
    }

    @Override
    public String toString() {
        return "|Pokemon: "+ Name + " - HP: " + HP + " - Attack: " + Attack + " - Defense: " + Defense + " - Type: " + Type + " - Strong: " + Strong + " - Weak: " + Weak;
    }
}

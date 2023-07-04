package com.mycompany.pokemongame_project;

public class PokemonGame_Project {

    public static void main(String[] args) {
        
        Menu menu = new Menu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);

        Snorlax_N P1 = new Snorlax_N(AllPokemons.Snorlax, 160, 70, 60, 70, 50, PokemonType.Fire, PokemonType.Normal, PokemonType.Fire);
        Chandelure_F P2 = new Chandelure_F(AllPokemons.Chandelure, 150, 60, 50, 75, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Fire);
        Rattata_N P3 = new Rattata_N(AllPokemons.Rattata, 160, 70, 60, 70, 50, PokemonType.Fire, PokemonType.Normal, PokemonType.Fire);
       
        System.out.println(P1);
        System.out.println(P2);        
        System.out.println(P3);

        //Prueba de branch
        //Prueba de branch_Valeria

    }
}

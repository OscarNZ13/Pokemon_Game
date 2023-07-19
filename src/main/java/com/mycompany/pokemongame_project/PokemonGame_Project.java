package com.mycompany.pokemongame_project;

public class PokemonGame_Project {

    public static void main(String[] args) {
         Menu menu = new Menu();
         menu.setLocationRelativeTo(null);
         menu.setVisible(true);

        // Todos los objetos de los pokemones:
        Snorlax_N snorlax = new Snorlax_N(AllPokemons.Snorlax,
                150, 50, 35, 70, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);
        Pidgeotto_N pidgeotto = new Pidgeotto_N(AllPokemons.Pidgeotto,
                150, 50, 35, 70, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);
        Rattata_N rattata = new Rattata_N(AllPokemons.Rattata,
                150, 50, 35, 70, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);
        Jigglypuff_N jigglypuff = new Jigglypuff_N(AllPokemons.Jigglypuff,
                150, 50, 35, 70, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);

        Charizard_F charizard = new Charizard_F(AllPokemons.Charizard,
                115, 70, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);
        Magmortar_F magmortar = new Magmortar_F(AllPokemons.Magmortar,
                115, 70, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);
        Chandelure_F chandelure = new Chandelure_F(AllPokemons.Chandelure,
                115, 70, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);
        Darmanitan_F darmanitan = new Darmanitan_F(AllPokemons.Darmanitan,
                115, 70, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);

        Gyarados_A gyarados = new Gyarados_A(AllPokemons.Gyarados,
                190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Vaporeon_A vaporeon = new Vaporeon_A(AllPokemons.Vaporeon,
                190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Gastrodon_A gastrodon = new Gastrodon_A(AllPokemons.Gastrodon,
                190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Milotic_A milotic = new Milotic_A(AllPokemons.Milotic,
                190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);

        // Jugadores:
        Player Player1 = new Player();
        Player1.setName("Oscar13");
        Player1.insert_Pokemon(snorlax);
        Player1.insert_Pokemon(chandelure);
        Player1.insert_Pokemon(gyarados);
        Player1.insert_Pokemon(vaporeon);
        System.out.println(Player1);

        CPU_Player CPUP = new CPU_Player();
        CPUP.insertRandomPokemons();
        System.out.println(CPUP);

        vaporeon.SpecialAttack(CPUP.selectActivePokemon());
        System.out.println(CPUP);
    }
}

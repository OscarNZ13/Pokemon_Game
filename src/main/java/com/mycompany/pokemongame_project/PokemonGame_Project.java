package com.mycompany.pokemongame_project;

public class PokemonGame_Project {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        

        // Todos los objetos de los pokemones:
        Snorlax_N snorlax = new Snorlax_N(AllPokemons.Snorlax,
                100, 18, 35, 45, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);
        Pidgeotto_N pidgeotto = new Pidgeotto_N(AllPokemons.Pidgeotto,
                100, 15, 35, 70, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);
        Rattata_N rattata = new Rattata_N(AllPokemons.Rattata,
                100, 14, 35, 70, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);
        Jigglypuff_N jigglypuff = new Jigglypuff_N(AllPokemons.Jigglypuff,
                100, 10, 35, 70, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);

        Charizard_F charizard = new Charizard_F(AllPokemons.Charizard,
                100, 28, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);
        Arcanine_F arcanine = new Arcanine_F(AllPokemons.Arcanine,
                100, 28, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);
        Blaziken_F blaziken = new Blaziken_F(AllPokemons.Blaziken,
                100, 30, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);
        Infernape_F infernape = new Infernape_F(AllPokemons.Infernape,
                100, 24, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);

        Gyarados_A gyarados = new Gyarados_A(AllPokemons.Gyarados,
                100, 35, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Vaporeon_A vaporeon = new Vaporeon_A(AllPokemons.Vaporeon,
                100, 20, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Blastoise_A blastoise = new Blastoise_A(AllPokemons.Blastoise,
                100, 50, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Milotic_A milotic = new Milotic_A(AllPokemons.Milotic,
                100, 12, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
    }
}

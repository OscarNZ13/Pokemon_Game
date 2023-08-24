package com.mycompany.pokemongame_project;

import java.util.Random;
import javax.swing.JOptionPane;

public class CPU_Player {

    private String name = "CPU";
    private Nodo cabeza;

    Player player;
    Batalla batalla;

    public CPU_Player(String name) {
        this.name = name;
    }

    public CPU_Player() {
    }

    public void insertRandomPokemons() {
        // Se declaran todos los Pokemones para luego poder ser asignados de manera aleatoria:
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
        Arcanine_F arcanine = new Arcanine_F(AllPokemons.Arcanine,
                115, 70, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);
        Blaziken_F blaziken = new Blaziken_F(AllPokemons.Blaziken,
                115, 70, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);
        Infernape_F infernape = new Infernape_F(AllPokemons.Infernape,
                115, 70, 45, 80, 60, PokemonType.Fire, PokemonType.Normal, PokemonType.Water);

        Gyarados_A gyarados = new Gyarados_A(AllPokemons.Gyarados,
                190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Vaporeon_A vaporeon = new Vaporeon_A(AllPokemons.Vaporeon,
                190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Blastoise_A blastoise = new Blastoise_A(AllPokemons.Blastoise,
                190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
        Milotic_A milotic = new Milotic_A(AllPokemons.Milotic,
                190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);

        Nodo cabeza = null;
        Random random = new Random();
        int count = 0;

        while (count < 4) {
            int randomNumber = random.nextInt(12);  // Genera un número aleatorio del 0 al 11

            //Esta varaible va a estar cambiando, ya que va a tomar el valor del pokemon al que este asignado el numero, y asi mismo
            //se insertara en la lista
            Pokemon selectedPokemon;

            // Selecciona el Pokémon según el número aleatorio generado
            switch (randomNumber) {
                case 0:
                    selectedPokemon = snorlax;
                    break;
                case 1:
                    selectedPokemon = pidgeotto;
                    break;
                case 2:
                    selectedPokemon = rattata;
                    break;
                case 3:
                    selectedPokemon = jigglypuff;
                    break;
                case 4:
                    selectedPokemon = charizard;
                    break;
                case 5:
                    selectedPokemon = arcanine;
                    break;
                case 6:
                    selectedPokemon = blaziken;
                    break;
                case 7:
                    selectedPokemon = infernape;
                    break;
                case 8:
                    selectedPokemon = gyarados;
                    break;
                case 9:
                    selectedPokemon = vaporeon;
                    break;
                case 10:
                    selectedPokemon = blastoise;
                    break;
                case 11:
                    selectedPokemon = milotic;
                    break;
                default:
                    selectedPokemon = null;
                    break;
            }

            if (selectedPokemon != null && !containsPokemon(selectedPokemon, cabeza)) {
                cabeza = insertPokemon(selectedPokemon, cabeza);
                count++;
            }
        }

        // Asigna la cabeza actualizada a la lista enlazada del CPU
        this.cabeza = cabeza;
    }

    //Este metodo verifica que en pokemon que se ingrese no sea repetido
    private boolean containsPokemon(Pokemon pokemon, Nodo cabeza) {
        Nodo aux = cabeza;
        while (aux != null) {
            if (aux.getPokemon().equals(pokemon)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    private Nodo insertPokemon(Pokemon pokemon, Nodo cabeza) {
        Nodo newNode = new Nodo(pokemon);

        if (cabeza == null) {
            cabeza = newNode;
        } else {
            Nodo aux = cabeza;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }

        return cabeza;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void removeFirstPokemon() {
        if (cabeza == null) {
  
            JOptionPane.showMessageDialog(null,  " Eres el Ganador");
            
        
        }

        cabeza = cabeza.getNext();
    }

    public Pokemon selectActivePokemon() {

        if (cabeza.getNext() == null) {
 
            JOptionPane.showMessageDialog(null,  "A CPU solo le resta un Pokemon");
       
        }
        // Seleccionar un Pokémon activo al azar de la lista
        Random random = new Random();
        // Generamos un numero randon apartir del get_size que nos trae la cantidad de
        // elementos que haya en la lista
        int index = random.nextInt(getSize());
        // Creamos un nodo auxiliar igualado a cabeza
        Nodo aux = cabeza;
        // Recorremos la lista con el index random
        for (int i = 0; i < index; i++) {
            // Alcanzamos al nodo que conincide con el index random generado
            aux = aux.getNext();
        }
        // Devolvemos el pokemon que se selecciono de manera aleatoria
        return aux.getPokemon();
    }

    public int getSize() {
        int count = 0;
        Nodo aux = cabeza;
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        Nodo aux = cabeza;
        String s = "--> Jugador: " + name + "\n";

        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }

        return s;
    }
}

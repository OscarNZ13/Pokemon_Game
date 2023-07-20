package com.mycompany.pokemongame_project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author EstivenQ
 */
public class PokedexJF extends JFrame {

    private PokedexJFinfo pokedex;
    private JPanel panel;

    public PokedexJF() {
        pokedex = new PokedexJFinfo();
        IniciarPanel();
    }

    private void IniciarPanel() {
        setTitle("Pokédex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnMostrar = new JButton("Mostrar Pokédex");
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPokemons();
            }
        });
        add(btnMostrar, BorderLayout.PAGE_START);

        JButton btnAtras = new JButton("Atras");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir();

            }
        });
        add(btnAtras, BorderLayout.PAGE_END);

    }

    public void sonido() {
        try {
            String ruta = "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Audios\\PokemonTheme.wav";
            try {
                AudioInputStream aui = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());

                try {
                    Clip clip = AudioSystem.getClip();
                    clip.open(aui);
                    clip.start();

                } catch (Exception e) {
                }

            } catch (Exception e) {
            }

        } catch (Exception e) {
        }
    }

    public void mostrarPokemons() {
        pokedex.mostrarPokedex(panel);

    }

    public void agregarPokemon(PokemonJF pokemon) {
        pokedex.agregarPokemon(pokemon);
    }

    public void salir() {
        this.dispose();
        dispose();

    }

    public void Iniciar() {

        PokedexJF Pokemons = new PokedexJF();

        //para ver las imagenes tienen que poner la ruta de la imagen de donde se guarda el poryecto
        Pokemons.agregarPokemon(new PokemonJF("Pikachu", "Rayo", "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\images\\Pokedex\\Pikachu.gif"));
        Pokemons.agregarPokemon(new PokemonJF("Bulbasaur", "Planta", "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\images\\Pokedex\\Bulbasaur.gif"));
        Pokemons.agregarPokemon(new PokemonJF("Charizard", "Fuego", "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\images\\Pokedex\\Charizard.gif"));
        Pokemons.agregarPokemon(new PokemonJF("Vaporeon", "Agua", "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\images\\Pokedex\\Vaporeon.gif"));
        Pokemons.agregarPokemon(new PokemonJF("Gyarados", "Agua", "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\images\\Pokedex\\Gyarados (2).gif"));
        Pokemons.agregarPokemon(new PokemonJF("Rattata", "Normal", "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\images\\Pokedex\\Rattata.gif"));

        Pokemons.setVisible(true);

    }

}

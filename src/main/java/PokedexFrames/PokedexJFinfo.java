/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemongame_project;

import java.awt.BorderLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author EstivenQ
 */
public class PokedexJFinfo {
    
    private Nodo2 primero;
    private Nodo2 ultimo;

    public PokedexJFinfo() {
        primero = null;
        ultimo = null;
    }

    public void agregarPokemon(PokemonJF pokemon) {
        Nodo2 nuevoNodo = new Nodo2(pokemon);
        if (primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
    }

    public void mostrarPokedex(JPanel panel) {
        panel.removeAll();

        if (primero == null) {
            JLabel PokedexVacia = new JLabel("La Pokédex está vacía.");
            panel.add(PokedexVacia);
        } else {
            Nodo2 actual = primero;
            while (actual != null) {
                JTextField Pokemon = new JTextField();
                Pokemon.setEditable(false);
                Pokemon.setText("Nombre: " + actual.pokemon.nombre + " \n-Tipo: " + actual.pokemon.Tipo);

                JLabel ImagenPokemon = new JLabel();
             
                ImagenPokemon.setIcon((Icon) actual.pokemon.imagen);
               

                JPanel pokemonPanel = new JPanel(new BorderLayout());
                pokemonPanel.add(Pokemon, BorderLayout.NORTH);
                pokemonPanel.add(ImagenPokemon, BorderLayout.WEST);

                panel.add(pokemonPanel);

                actual = actual.siguiente;
            }
        }

        panel.revalidate();
        panel.repaint();
    }
    
}

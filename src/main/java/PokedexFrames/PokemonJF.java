/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemongame_project;

import javax.swing.ImageIcon;

/**
 *
 * @author EstivenQ
 */
public class PokemonJF {

public String nombre;
    public String Tipo;
    public ImageIcon imagen;

    public PokemonJF(String nombre, String Tipo, String imagePath) {
        this.nombre = nombre;
        this.Tipo = Tipo;
        this.imagen = new ImageIcon(imagePath);
    }

}

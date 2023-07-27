/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaMovimiento;

import javax.swing.JFrame;

/**
 *
 * @author valer
 */
public class Teclado {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Teclado");
        ventana.add(new Lienzo());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 300);
        ventana.setVisible(true);
    }
}

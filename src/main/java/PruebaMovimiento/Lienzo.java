/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PruebaMovimiento;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Lienzo extends JPanel implements KeyListener {

    private JLabel imagenLabel;
    private int x, y;
    private double escala = 0.55;

    public Lienzo() {
                setBackground(Color.BLACK); 

        setLayout(null); 
        addKeyListener(this);
        setFocusable(true);
        x = 100; 
        y = 100;

        try {
             BufferedImage imagen = ImageIO.read(getClass().getResource("/Imagenes/entrenador.png"));

            int anchoReducido = (int) (imagen.getWidth() * escala);
            int altoReducido = (int) (imagen.getHeight() * escala);

            ImageIcon imagenIcono = new ImageIcon(imagen.getScaledInstance(anchoReducido, altoReducido, BufferedImage.SCALE_SMOOTH));
            imagenLabel = new JLabel(imagenIcono);
            imagenLabel.setPreferredSize(new Dimension(anchoReducido, altoReducido));
            imagenLabel.setBounds(x, y, anchoReducido, altoReducido);
            add(imagenLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int moveAmount = 5;

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= moveAmount;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y += moveAmount;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= moveAmount;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += moveAmount;
        }

        imagenLabel.setLocation(x, y);
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
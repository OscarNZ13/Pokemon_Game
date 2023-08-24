/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pokemongame_project;

import com.mycompany.pokemongame_project.AllPokemons;
import com.mycompany.pokemongame_project.Pokemon;
import com.mycompany.pokemongame_project.PokemonType;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author EstivenQ
 */
public class Batalla extends javax.swing.JFrame {

    Nodo Pokemon2;
    Nodo Pokemon3;
    Nodo Pokemon4;

    Player player = new Player();
   
    CPU_Player Cpu = new CPU_Player();
    Seleccion selec = new Seleccion();
    JProgressBar BarraHp_CPU;
    JProgressBar BarraHp_PL;
    String Jugador;
    JLabel imagen = new JLabel();
    JLabel imagen2 = new JLabel();
    JLabel imagen3 = new JLabel();
    JLabel imagen4 = new JLabel();
    JLabel imagen5 = new JLabel();
    JLabel imagen6 = new JLabel();
    JLabel imagen7 = new JLabel();

    int contador = 0;
    int contador2 = 0;

    Snorlax_N snorlax = new Snorlax_N(AllPokemons.Snorlax,
            150, 9999, 35, 70, 60, PokemonType.Normal, PokemonType.Water, PokemonType.Fire);
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
            1190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);
    Milotic_A milotic = new Milotic_A(AllPokemons.Milotic,
            190, 55, 45, 75, 65, PokemonType.Water, PokemonType.Fire, PokemonType.Normal);

    public Batalla() {
        initComponents();

    }

    public void victoria() {

        if (player.primero.getPokemon().getHP() == 0 && player.primero.getNext().getPokemon().getHP() == 0 && player.ultimo.getBack().getPokemon().getHP() == 0 && player.ultimo.getPokemon().getHP() == 0) {

            JOptionPane.showMessageDialog(null, "Tus Pokemons han sido derrotados\n" + "CPU  Es el ganador");
            this.dispose();

        } else if (BarraHp_CPU.getValue() == 0 && BarraHp_PL.getValue() != 0) {

            JOptionPane.showMessageDialog(null, "Los Pokemons de tu oponente han sido derrotados\n" + Jugador + " Es el ganador");
            this.dispose();

        }
    }

    public void prueba() {
        if (player.primero.getPokemon().getHP() == 0 && player.primero.getNext().getPokemon().getHP() == 0 && player.ultimo.getBack().getPokemon().getHP() == 0 && player.ultimo.getPokemon().getHP() == 0) {
            JOptionPane.showMessageDialog(null, "Tus Pokemons han sido derrotados\n" + Cpu.getName() + " Es el ganador");
        }
        if (PK1.isSelected()) {

            if (player.primero.getPokemon().getHP() == 0) {
                PKN1.setText("Derrotado");
                PpkName.setText("Derrotado");
            }
            player.intercambiarCabezaConSiguiente();
            imagen2.setSize(0, 0);
            imgplayerPK();
            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName().toString() + " Entra a la batalla");
            imagen4.setSize(0, 0);
            imgppixel1();
            imagen6.setSize(0, 0);
            imgppixel2();

            BarraHp_PL.setBounds(0, 0, 0, 0);
            BarraHp_PL();
            PpkName.setText(player.primero.getPokemon().getName().toString());
            HPPlayer.setText(String.valueOf(BarraHp_PL.getValue()));
            PKN1.setText(player.primero.getPokemon().getName().toString());
            PKN2.setText(player.primero.getNext().getPokemon().getName().toString());

        } else if (PK3.isSelected()) {
            if (player.ultimo.getBack().getPokemon().getHP() == 0) {
                PK3N.setText("Derrotado");
                PpkName.setText("Derrotado");
            }
            player.intercambiarNodos(player.primero.getNext().getNext(), player.primero);

            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName().toString() + " Entra a la batalla");
            PpkName.setText(player.primero.getPokemon().getName().toString());
            BarraHp_PL.setBounds(0, 0, 0, 0);
            BarraHp_PL();
            imagen2.setSize(0, 0);
            imgplayerPK();
            HPPlayer.setText(String.valueOf(BarraHp_PL.getValue()));
            PKN1.setText(player.primero.getPokemon().getName().toString());
            PK3N.setText(player.ultimo.getBack().getPokemon().getName().toString());

            imagen4.setSize(0, 0);
            imgppixel1();
            imagen3.setSize(0, 0);
            imgppixel3();

        } else if (PK4.isSelected()) {

            if (player.ultimo.getPokemon().getHP() == 0) {
                PKN4.setText("Derrotado");
                PpkName.setText("Derrotado");
            }

            player.intercambiarNodos(player.ultimo, player.primero);

            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName().toString() + " Entra a la batalla");
            PpkName.setText(player.primero.getPokemon().getName().toString());
            BarraHp_PL.setBounds(0, 0, 0, 0);
            BarraHp_PL();
            HPPlayer.setText(String.valueOf(BarraHp_PL.getValue()));
            PKN4.setText(player.ultimo.getPokemon().getName().toString());
            PKN1.setText(player.primero.getPokemon().getName().toString());

            imagen4.setSize(0, 0);
            imgppixel1();

            imagen5.setSize(0, 0);
            imgppixel4();

            imagen2.setSize(0, 0);
            imgplayerPK();

        }

    }

    public void PokemonCambio() {

        player.intercambiarNodos(player.primero, player.primero.getNext());
        imagen2.setBounds(0, 0, 0, 0);
        imgplayerPK();

        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName().toString() + " Entra a la batalla");
        PpkName.setText(player.primero.getPokemon().getName().toString());
        BarraHp_PL.setBounds(0, 0, 0, 0);
        BarraHp_PL();
        HPPlayer.setText(String.valueOf(BarraHp_PL.getValue()));

        /* player.primero.setPokemon(selec.rattata);
        BarraHp_PL.setValue(selec.rattata.getHP());
        Pokemons.addItem("Pokemons");
        Pokemons.addItem(player.primero.getPokemon().getName().toString());
        Pokemons.addItem(player.primero.getNext().getPokemon().getName().toString());
        Pokemons.addItem(player.primero.getNext().getNext().getPokemon().getName().toString());
        Pokemons.addItem(player.primero.getNext().getNext().getNext().getPokemon().getName().toString());*/
    }

    public void Derrota() {

        if (BarraHp_CPU.getValue() == 0 && BarraHp_PL.getValue() != 0) {
            JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha sido derrotado\n"
                    + player.primero.getPokemon().getName() + " Es el ganador");

            Cpu.removeFirstPokemon();
            Cpu.selectActivePokemon();

            imagen.setSize(0, 0);
            imgCpuPK();
            JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName().toString() + " Entra a la batalla");
            CpupkName.setText(Cpu.getCabeza().getPokemon().getName().toString());
            BarraHp_CPU.setBounds(0, 0, 0, 0);
            BarraHp_CPU();
            PKHPCPU.setText(String.valueOf(BarraHp_CPU.getValue()));

        } else if (BarraHp_PL.getValue() == 0) {
            JOptionPane.showMessageDialog(null, "¡Oh no!, parece que " + player.primero.getPokemon().getName().toString() + " no puede continuar");
            JOptionPane.showMessageDialog(null, "Escoge un pokemon de tu pokedex");
            prueba();

            /* imagen2.setBounds(0, 0, 0, 0);
            imgplayerPK();
            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName().toString() + " Entra a la batalla");
            PpkName.setText(player.primero.getPokemon().getName().toString());
            BarraHp_PL.setBounds(0, 0, 0, 0);
            BarraHp_PL();
            HPPlayer.setText(String.valueOf(BarraHp_PL.getValue()));*/
        }

    }

    public void BarraHp_PL() {
        int vidaActual = player.primero.getPokemon().getHP();

        BarraHp_PL = new JProgressBar(0, player.primero.getPokemon().getHP());
        BarraHp_PL.setLayout(null);
        jPanel1.add(BarraHp_PL);
        BarraHp_PL.setBounds(330, 278, 150, 20);
        BarraHp_PL.setValue(vidaActual);

        BarraHp_PL.setStringPainted(true);
    }

    public void BarraHp_CPU() {
        int vidaActual = Cpu.getCabeza().getPokemon().getHP();

        BarraHp_CPU = new JProgressBar(0, Cpu.getCabeza().getPokemon().getHP());
        BarraHp_CPU.setLayout(null);
        jPanel1.add(BarraHp_CPU);
        BarraHp_CPU.setBounds(70, 151, 150, 20);
        BarraHp_CPU.setValue(vidaActual);

        BarraHp_CPU.setStringPainted(true);
    }

    public void NormAtakPlayer(java.awt.event.ActionEvent evt) {
        if (BarraHp_PL.getValue() == 0 || BarraHp_CPU.getValue() == 0) {
            Derrota();

        } else {

            Random random = new Random();
            int count = 0;

            while (count != 6) {
                int randomNumber = random.nextInt(6);

                switch (randomNumber) {
                    case 0:
                        AtakNorm_PL(evt);
                        Derrota();
                        break;
                    case 1:
                        AtakNorm_PL(evt);
                        Derrota();
                        break;
                    case 2:
                        AtakNorm_PL(evt);
                        Derrota();
                        break;
                    case 3:
                        AtakNorm_PL(evt);
                        Derrota();
                        break;
                    case 4:
                        AtakNorm_PL(evt);
                        Derrota();
                        break;
                    case 5:
                        AtakNorm_PL(evt);
                        Derrota();
                        break;
                }
                break;
            }

        }
    }

    //listo
    public void atakSpecialPlayer(java.awt.event.ActionEvent evt) {

        if (BarraHp_PL.getValue() == 0 || BarraHp_CPU.getValue() == 0) {
            Derrota();

        } else {

            Random random = new Random();
            int count = 0;

            while (count <= 8) {
                int randomNumber = random.nextInt(8);

                switch (randomNumber) {
                    case 0:
                        atakSpecial_PL(evt);
                        Derrota();
                        break;
                    case 1:
                        atakSpecial_PL(evt);
                        Derrota();
                        break;
                    case 2:
                        atakSpecial_PL(evt);
                        Derrota();
                        break;
                    case 3:
                        DefSpec_CPU();
                        Derrota();
                        break;
                    case 4:
                        atakSpecial_PL(evt);
                        Derrota();
                        break;
                    case 5:
                        atakSpecial_PL(evt);
                        Derrota();
                        break;
                    case 6:
                        atakSpecial_PL(evt);
                        Derrota();
                        break;
                    case 7:
                        atakSpecial_PL(evt);
                        Derrota();
                        break;
                }
                break;
            }

        }

        /* if (BarraHp_CPU.getValue() == 0) {
            Derrota();

        } else {

            if (BarraHp_CPU.getValue() > 0 && BarraHp_PL.getValue() > 0) {

                if (Cpu.getCabeza() != null && player.primero != null) {//blast
                    if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Normal") {
                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack() + 5;
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);

                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Fire") {
                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack() + 5;
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);

                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Water") {

                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack() + 10;
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack();
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }
                    }
                    
                }

            }
        }*/
    }
    //listo

    public void AtakSpecialCpu(java.awt.event.ActionEvent evt) {

        if (BarraHp_PL.getValue() == 0) {
            Derrota();

        } else {
            JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
            if (BarraHp_CPU.getValue() == 0) {
                Derrota();

            } else {

                if (BarraHp_CPU.getValue() > 0 && BarraHp_PL.getValue() > 0) {

                    if (Cpu.getCabeza() != null && player.primero != null) {//blast
                        if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Water") {
                            JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                            int actualvida = BarraHp_PL.getValue();
                            int ataque = Cpu.getCabeza().getPokemon().getSpecialAttack() + 5;
                            int reduce = Math.max(actualvida - ataque, 0);
                            BarraHp_PL.setValue(reduce);
                            PKHPCPU.setText(String.valueOf(reduce));
                            player.primero.getPokemon().setHP(reduce);

                        } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Normal") {
                            JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                            int actualvida = BarraHp_CPU.getValue();
                            int ataque = Cpu.getCabeza().getPokemon().getSpecialAttack() + 5;
                            int reduce = Math.max(actualvida - ataque, 0);
                            BarraHp_CPU.setValue(reduce);

                            PKHPCPU.setText(String.valueOf(reduce));
                            player.primero.getPokemon().setHP(reduce);

                        } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Fire") {

                            JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                            int actualvida = BarraHp_PL.getValue();
                            int ataque = Cpu.getCabeza().getPokemon().getSpecialAttack() + 10;
                            int reduce = Math.max(actualvida - ataque, 0);
                            BarraHp_PL.setValue(reduce);
                            PKHPCPU.setText(String.valueOf(reduce));
                            player.primero.getPokemon().setHP(reduce);
                        } else {

                            JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                            int actualvida = BarraHp_PL.getValue();
                            int ataque = Cpu.getCabeza().getPokemon().getSpecialAttack();
                            int reduce = Math.max(actualvida - ataque, 0);
                            BarraHp_PL.setValue(reduce);
                            PKHPCPU.setText(String.valueOf(reduce));
                            player.primero.getPokemon().setHP(reduce);

                        }
                    }
                }
            }
        }

    }

    //listo
    public void AtakNormCpu(java.awt.event.ActionEvent evt) {

        if (BarraHp_PL.getValue() == 0 || BarraHp_CPU.getValue() == 0) {
            Derrota();

        } else {

            Random random = new Random();
            int count = 0;

            while (count < 1) {
                int randomNumber = random.nextInt(1);

                switch (randomNumber) {
                    case 0:
                        AtakNorm_CPU(evt);
                        break;
                }
                break;
            }

        }

    }

    //listo
    public void DefNormPlayer(java.awt.event.ActionEvent evt) {

        if (BarraHp_CPU.getValue() > 0 && BarraHp_PL.getValue() > 0) {

            if (Cpu.getCabeza() != null && player.primero != null) {

                Random random = new Random();
                int count = 0;

                while (count < 1) {
                    int ramNumber = random.nextInt(1);
                    switch (ramNumber) {
                        case 0:
                            DefNormal_PL();
                            Derrota();
                            break;
                    }

                    break;
                }
            }
        }

    }

    public void DefSpPlayer(java.awt.event.ActionEvent evt) {

        if (BarraHp_CPU.getValue() > 0 && BarraHp_PL.getValue() > 0) {

            if (Cpu.getCabeza() != null && player.primero != null) {//blast

                Random random = new Random();
                int count = 0;

                while (count < 1) {
                    int ramNumber = random.nextInt(1);
                    switch (ramNumber) {
                        case 0:
                            DefSpec_PL();
                            Derrota();
                            break;
                    }

                    break;
                }
            }
        }

    }

    public void AtakNorm_PL(java.awt.event.ActionEvent evt) {

        if (BarraHp_CPU.getValue() == 0 || BarraHp_PL.getValue() == 0 || player.primero.getPokemon().getHP() == 0 || Cpu.getCabeza().getPokemon().getHP() == 0) {
            Derrota();

        } else {

            if (Cpu.getCabeza() != null && player.primero != null) {//blast

                Random random = new Random();

                int ramNumber = random.nextInt(6);

                while (ramNumber < 6) {

                    switch (ramNumber) {

                        case 0:

                            if (Cpu.getCabeza().getPokemon().getDefense() < player.primero.getPokemon().getAttack()) {

                                JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque!");
                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_CPU.getValue();
                                int ataque = player.primero.getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_CPU.setValue(reduce);
                                PKHPCPU.setText(String.valueOf(reduce));

                                Random rand = new Random();
                                int randm = rand.nextInt(3);

                                while (randm < 3) {

                                    switch (randm) {

                                        case 0:
                                            AtakNorm_CPU(evt);
                                            break;
                                        case 1:
                                            AtakSpecial_CPU(evt);
                                            break;
                                    }
                                    break;
                                }

                            }

                            break;
                        case 1:
                            if (player.primero.getPokemon().getType().toString() == "Fire" && Cpu.getCabeza().getPokemon().getType().toString() == "Normal") {
                                JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque!");

                                JOptionPane.showMessageDialog(null, " Ha usado su defensa especial");
                                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getType().toString() + " ha sufrido un poco de daño!");

                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_CPU.getValue();
                                int ataque = player.primero.getPokemon().getAttack() - 50;
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_CPU.setValue(reduce);
                                PKHPCPU.setText(String.valueOf(reduce));

                                Random rand = new Random();
                                int opc = rand.nextInt(2);

                                while (opc < 2) {

                                    switch (opc) {

                                        case 0:
                                            AtakNorm_CPU(evt);
                                            break;
                                        case 1:
                                            AtakSpecial_CPU(evt);
                                            break;
                                    }
                                    break;
                                }
                            } else {

                                JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque!");
                                JOptionPane.showMessageDialog(null, "¡Oh no! " + player.primero.getPokemon().getName() + " Ha fallado su ataque");

                                Random rand2 = new Random();
                                int randm = rand2.nextInt(2);

                                while (randm < 2) {

                                    switch (randm) {

                                        case 0:
                                            AtakNorm_CPU(evt);
                                            break;
                                        case 1:
                                            AtakSpecial_CPU(evt);
                                            break;
                                    }
                                    break;
                                }

                                break;
                            }

                            break;
                        case 2:

                            JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque!");
                            JOptionPane.showMessageDialog(null, "¡Oh no! " + player.primero.getPokemon().getName() + " Ha fallado su ataque");

                            Random rand2 = new Random();
                            int randm = rand2.nextInt(2);

                            while (randm < 2) {

                                switch (randm) {

                                    case 0:
                                        AtakNorm_CPU(evt);
                                        break;
                                    case 1:
                                        AtakSpecial_CPU(evt);
                                        break;
                                }
                                break;
                            }

                            break;
                        case 3:
                            if (Cpu.getCabeza().getPokemon().getDefense() < player.primero.getPokemon().getAttack()) {
                                JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque!");
                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_CPU.getValue();
                                int ataque = player.primero.getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_CPU.setValue(reduce);
                                PKHPCPU.setText(String.valueOf(reduce));

                                Random rand3 = new Random();
                                int opc2 = rand3.nextInt(2);

                                while (opc2 < 2) {

                                    switch (opc2) {

                                        case 0:
                                            AtakNorm_CPU(evt);
                                            break;
                                        case 1:
                                            AtakSpecial_CPU(evt);
                                            break;
                                    }
                                    break;
                                }
                            }

                            break;
                        case 4:
                            if (Cpu.getCabeza().getPokemon().getDefense() < player.primero.getPokemon().getAttack()) {
                                JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque!");
                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_CPU.getValue();
                                int ataque = player.primero.getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_CPU.setValue(reduce);
                                PKHPCPU.setText(String.valueOf(reduce));

                                Random rand4 = new Random();
                                int op3 = rand4.nextInt(2);

                                while (op3 < 2) {

                                    switch (op3) {

                                        case 0:

                                            AtakNorm_CPU(evt);
                                            break;
                                        case 1:
                                            AtakSpecial_CPU(evt);
                                            break;
                                    }
                                    break;
                                }

                            }

                            break;
                        case 5:
                            if (Cpu.getCabeza().getPokemon().getDefense() < player.primero.getPokemon().getAttack()) {
                                JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque!");
                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_CPU.getValue();
                                int ataque = player.primero.getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_CPU.setValue(reduce);
                                PKHPCPU.setText(String.valueOf(reduce));

                                Random rand5 = new Random();
                                int op4 = rand5.nextInt(2);

                                while (op4 < 2) {

                                    switch (op4) {

                                        case 0:
                                            AtakNorm_CPU(evt);
                                            break;
                                        case 1:
                                            AtakSpecial_CPU(evt);
                                            break;
                                    }
                                    break;
                                }

                            }

                            break;
                    }
                    break;
                }

            }

        }

    }

    //listo
    public void AtakNorm_CPU(java.awt.event.ActionEvent evt) {
        if (BarraHp_CPU.getValue() == 0 || BarraHp_PL.getValue() == 0) {
            Derrota();

        } else {

            if (Cpu.getCabeza() != null && player.primero != null) {//blast

                Random random = new Random();
                int ramNumber = random.nextInt(6);

                while (ramNumber < 6) {

                    switch (ramNumber) {
                        case 0:

                            if (Cpu.getCabeza().getPokemon().getAttack() > player.primero.getPokemon().getDefense()) {
                                JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_PL.getValue();
                                int ataque = Cpu.getCabeza().getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_PL.setValue(reduce);
                                HPPlayer.setText(String.valueOf(reduce));
                                player.primero.getPokemon().setHP(reduce);

                            }

                            break;

                        case 1:
                            if (Cpu.getCabeza().getPokemon().getAttack() > player.primero.getPokemon().getDefense()) {
                                JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_PL.getValue();
                                int ataque = Cpu.getCabeza().getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_PL.setValue(reduce);
                                HPPlayer.setText(String.valueOf(reduce));
                                player.primero.getPokemon().setHP(reduce);

                            }
                            break;

                        case 2:
                            JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                            JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                            JOptionPane.showMessageDialog(null, "Oh no " + Cpu.getCabeza().getPokemon().getName() + " ha fallado su ataque  ");
                            break;

                        case 3:
                            if (Cpu.getCabeza().getPokemon().getAttack() > player.primero.getPokemon().getDefense()) {
                                JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_PL.getValue();
                                int ataque = Cpu.getCabeza().getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_PL.setValue(reduce);
                                HPPlayer.setText(String.valueOf(reduce));
                                player.primero.getPokemon().setHP(reduce);

                            }
                            break;

                        case 4:
                            JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                            if (Cpu.getCabeza().getPokemon().getAttack() > player.primero.getPokemon().getDefense()) {
                                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                {
                                    try {
                                        sonidoGolpe();
                                    } catch (UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (LineUnavailableException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                int actualvida = BarraHp_PL.getValue();
                                int ataque = Cpu.getCabeza().getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_PL.setValue(reduce);
                                HPPlayer.setText(String.valueOf(reduce));
                                player.primero.getPokemon().setHP(reduce);

                            }
                            break;

                        case 5:
                            JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                            if (Cpu.getCabeza().getPokemon().getAttack() > player.primero.getPokemon().getDefense()) {
                                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                int actualvida = BarraHp_PL.getValue();
                                int ataque = player.primero.getPokemon().getAttack();
                                int reduce = Math.max(actualvida - ataque, 0);
                                BarraHp_PL.setValue(reduce);
                                HPPlayer.setText(String.valueOf(reduce));
                                player.primero.getPokemon().setHP(reduce);

                                break;
                            }
                            break;
                    }

                    break;
                }

            }

        }
    }

    //listo
    public void AtakSpecial_CPU(java.awt.event.ActionEvent evt) {
        if (BarraHp_PL.getValue() == 0) {
            Derrota();

        } else {
            JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
            if (BarraHp_CPU.getValue() == 0) {
                Derrota();

            } else {

                if (BarraHp_CPU.getValue() > 0 && BarraHp_PL.getValue() > 0) {

                    if (Cpu.getCabeza() != null && player.primero != null) {//blast
                        if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Water") {
                            JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                            {
                                try {
                                    sonidoGolpe();
                                } catch (UnsupportedAudioFileException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (LineUnavailableException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            int actualvida = BarraHp_PL.getValue();
                            int ataque = Cpu.getCabeza().getPokemon().getSpecialAttack() + 5;
                            int reduce = Math.max(actualvida - ataque, 0);
                            BarraHp_PL.setValue(reduce);
                            HPPlayer.setText(String.valueOf(reduce));
                            player.primero.getPokemon().setHP(reduce);

                        } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Normal") {
                            JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                            {
                                try {
                                    sonidoGolpe();
                                } catch (UnsupportedAudioFileException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (LineUnavailableException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            int actualvida = BarraHp_PL.getValue();
                            int ataque = Cpu.getCabeza().getPokemon().getSpecialAttack() + 5;
                            int reduce = Math.max(actualvida - ataque, 0);
                            BarraHp_PL.setValue(reduce);
                            HPPlayer.setText(String.valueOf(reduce));
                            player.primero.getPokemon().setHP(reduce);

                        } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Fire") {

                            JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                            {
                                try {
                                    sonidoGolpe();
                                } catch (UnsupportedAudioFileException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (LineUnavailableException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            int actualvida = BarraHp_PL.getValue();
                            int ataque = Cpu.getCabeza().getPokemon().getSpecialAttack() + 10;
                            int reduce = Math.max(actualvida - ataque, 0);
                            BarraHp_PL.setValue(reduce);
                            HPPlayer.setText(String.valueOf(reduce));
                            player.primero.getPokemon().setHP(reduce);

                        } else {
                            JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                            {
                                try {
                                    sonidoGolpe();
                                } catch (UnsupportedAudioFileException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (LineUnavailableException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            int actualvida = BarraHp_PL.getValue();
                            int ataque = Cpu.getCabeza().getPokemon().getSpecialAttack();
                            int reduce = Math.max(actualvida - ataque, 0);
                            BarraHp_PL.setValue(reduce);
                            HPPlayer.setText(String.valueOf(reduce));
                            player.primero.getPokemon().setHP(reduce);
                        }
                    }
                }
            }
        }
    }

    public void atakSpecial_PL(java.awt.event.ActionEvent evt) {
        if (BarraHp_CPU.getValue() == 0) {
            Derrota();

        } else {

            if (BarraHp_CPU.getValue() > 0 && BarraHp_PL.getValue() > 0) {

                if (Cpu.getCabeza() != null && player.primero != null) {

                    if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Normal") {
                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack() + 5;
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);

                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Fire") {
                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack() + 5;
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);

                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Water") {

                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack() + 10;
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Water") {

                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack();
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Normal") {

                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack();
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Fire") {

                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack();
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Normal") {

                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack();
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Fire") {

                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack();
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Water") {

                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque especial!");
                        {
                            try {
                                sonidoGolpe();
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        int actualvida = BarraHp_CPU.getValue();
                        int ataque = player.primero.getPokemon().getSpecialAttack();
                        int reduce = Math.max(actualvida - ataque, 0);
                        BarraHp_CPU.setValue(reduce);
                        PKHPCPU.setText(String.valueOf(reduce));

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {

                                case 0:
                                    AtakNorm_CPU(evt);
                                    Derrota();
                                    break;
                                case 1:
                                    AtakSpecial_CPU(evt);
                                    Derrota();
                                    break;

                            }
                            break;
                        }

                    }

                }

            }
        }
    }

    //listo
    public void DefNormal_PL() {

        if (Cpu.getCabeza().getPokemon().getHP() == 0 || player.primero.getPokemon().getHP() == 0) {
            Derrota();
        } else {

            if (Cpu.getCabeza().getPokemon().getAttack() > player.primero.getPokemon().getDefense()) {

                JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " se ha defendido");
                JOptionPane.showMessageDialog(null, "¡El ataque de " + Cpu.getCabeza().getPokemon().getName() + " fue muy fuerte\n se ha sufrido un leve  daño");
                int actualvida = BarraHp_PL.getValue();
                int ataque = Cpu.getCabeza().getPokemon().getAttack() - 30;
                int reduce = Math.max(actualvida - ataque, 0);
                BarraHp_PL.setValue(reduce);
                HPPlayer.setText(String.valueOf(reduce));
                player.primero.getPokemon().setHP(reduce);

            } else if (Cpu.getCabeza().getPokemon().getAttack() < player.primero.getPokemon().getDefense()) {
                JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " se ha defendido");

            } else if (Cpu.getCabeza().getPokemon().getStrong() == player.primero.getPokemon().getWeak()) {
                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                JOptionPane.showMessageDialog(null, "¡El ataque de " + Cpu.getCabeza().getPokemon().getName() + " fue muy fuerte\n se ha sufrido daño considerado");
                int actualvida = BarraHp_PL.getValue();
                int ataque = Cpu.getCabeza().getPokemon().getAttack() - 15;
                int reduce = Math.max(actualvida - ataque, 0);
                BarraHp_PL.setValue(reduce);
                HPPlayer.setText(String.valueOf(reduce));
                player.primero.getPokemon().setHP(reduce);

            } else if (Cpu.getCabeza().getPokemon().getType() == player.primero.getPokemon().getType()) {
                JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " se ha defendido");

            }
        }

    }

    //listo
    public void DefNormCpu(java.awt.event.ActionEvent evt) {
        if (BarraHp_CPU.getValue() == 0 || BarraHp_PL.getValue() == 0) {
            Derrota();
        } else {
            if (BarraHp_PL.getValue() > 0 && BarraHp_PL.getValue() > 0) {
                if (Cpu.getCabeza() != null && player.primero != null) {//blast

                    Random random = new Random();
                    int count = 0;

                    while (count < 3) {
                        int ramNumber = random.nextInt(3);
                        switch (ramNumber) {

                            case 0:
                                if (Cpu.getCabeza().getPokemon().getSpecialAttack() < player.primero.getPokemon().getDefense()) {
                                    JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                                    JOptionPane.showMessageDialog(null, "¡El ataque de " + Cpu.getCabeza().getPokemon().getName() + " se ha defendido");
                                    JOptionPane.showMessageDialog(null, "¡El ataque de " + player.primero.getPokemon().getName() + " fue muy fuerte\n se ha sufrido daño");
                                    int actualvida = BarraHp_CPU.getValue();
                                    int ataque = player.primero.getPokemon().getAttack() - 5;
                                    int reduce = Math.max(actualvida - ataque, 0);
                                    BarraHp_CPU.setValue(reduce);
                                    PKHPCPU.setText(String.valueOf(reduce));

                                }
                                break;

                            case 1:
                                if (Cpu.getCabeza().getPokemon().getDefense() > player.primero.getPokemon().getAttack()) {
                                    JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " No sufrio daño");
                                }
                                break;

                            case 2:
                                if (Cpu.getCabeza().getPokemon().getDefense() < player.primero.getPokemon().getAttack()) {
                                    JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " se ha defendido");
                                    JOptionPane.showMessageDialog(null, "pero " + Cpu.getCabeza().getPokemon().getName() + " ha sufrido daño leve");
                                    int actualvida = BarraHp_CPU.getValue();
                                    int ataque = player.primero.getPokemon().getAttack() - 10;
                                    int reduce = Math.max(actualvida - ataque, 0);
                                    BarraHp_CPU.setValue(reduce);
                                    PKHPCPU.setText(String.valueOf(reduce));
                                }
                                break;
                        }

                        break;
                    }
                }
            } else {
                Derrota();
            }
        }
    }

    public void DefSpec_PL() {

        if (BarraHp_CPU.getValue() == 0) {
            Derrota();

        } else {

            if (BarraHp_CPU.getValue() > 0 && BarraHp_PL.getValue() > 0) {

                if (Cpu.getCabeza() != null && player.primero != null) {//blast

                    if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Normal") {
                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());

                        int aumento = player.primero.getPokemon().getSpecialDefense() + 5;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);

                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);

                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Fire") {
                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                        int aumento2 = Cpu.getCabeza().getPokemon().getSpecialAttack() + 5;
                        int aumento = player.primero.getPokemon().getSpecialDefense() + 10;
                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;
                                case 1:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    }
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Water") {
                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                        int aumento = player.primero.getPokemon().getSpecialDefense() + 10;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Normal") {
                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Water") {
                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Fire") {
                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Normal") {
                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Water") {
                        JOptionPane.showMessageDialog(null, "Es el turno de " + Cpu.getCabeza().getPokemon().getName());
                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;
                        int aumento2 = Cpu.getCabeza().getPokemon().getSpecialAttack() + 5;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }

                                    break;
                                case 1:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " Se ha defendido");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + player.primero.getPokemon().getName());
                                        int actualvida = BarraHp_PL.getValue();
                                        int ataque = Cpu.getCabeza().getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_PL.setValue(reduce);
                                        player.primero.getPokemon().setHP(reduce);
                                        HPPlayer.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, "¡" + Cpu.getCabeza().getPokemon().getName() + " ha realizado un ataque especial!");
                                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha esquivado el ataque");

                                    }
                                    break;

                            }
                            break;
                        }

                    }
                }
            }
        }
    }

    public void DefSpec_CPU() {

        if (BarraHp_CPU.getValue() == 0) {
            Derrota();

        } else {

            if (BarraHp_CPU.getValue() > 0 && BarraHp_PL.getValue() > 0) {

                if (Cpu.getCabeza() != null && player.primero != null) {//blast

                    if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Water") {

                        int aumento = Cpu.getCabeza().getPokemon().getSpecialDefense() + 5;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() < aumento) {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());
                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Fire") {

                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");

                        int aumento2 = player.primero.getPokemon().getSpecialAttack() + 5;
                        int aumento = Cpu.getCabeza().getPokemon().getSpecialDefense();
                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:

                                    JOptionPane.showMessageDialog(null, "¡Oh no!" + player.primero.getPokemon().getName().toString() + " ha fallado su ataque especial");

                                    break;
                                case 1:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());
                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getSpecialAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    }
                                    break;

                            }
                            break;
                        }

                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Water") {

                        int aumento = player.primero.getPokemon().getSpecialDefense() + 10;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() < aumento) {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Normal") {

                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() < aumento) {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Fire") {

                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() < aumento) {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Water") {

                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() < aumento) {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    } else {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));
                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Fire") {

                        int aumento = player.primero.getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (Cpu.getCabeza().getPokemon().getSpecialAttack() < aumento) {

                                    } else {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));
                                    }

                                    break;
                                case 1:
                                    if (Cpu.getCabeza().getPokemon().getAttack() > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Normal" && player.primero.getPokemon().getType().toString() == "Fire") {
                        int aumento2 = player.primero.getPokemon().getSpecialAttack() + 5;
                        int aumento = Cpu.getCabeza().getPokemon().getSpecialDefense();

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getSpecialAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));
                                    } else {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");
                                    }

                                    break;
                                case 1:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getSpecialAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Water" && player.primero.getPokemon().getType().toString() == "Normal") {
                        int aumento2 = player.primero.getPokemon().getSpecialAttack() + 5;
                        int aumento = Cpu.getCabeza().getPokemon().getSpecialDefense() + 0;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getSpecialAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));
                                    } else {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");
                                    }

                                    break;
                                case 1:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    } else if (Cpu.getCabeza().getPokemon().getType().toString() == "Fire" && player.primero.getPokemon().getType().toString() == "Normal") {
                        int aumento2 = player.primero.getPokemon().getSpecialAttack();
                        int aumento = Cpu.getCabeza().getPokemon().getSpecialDefense() + 5;

                        Random rand = new Random();
                        int randm = rand.nextInt(2);

                        while (randm < 2) {

                            switch (randm) {
                                case 0:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getSpecialAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));
                                    } else {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");
                                    }

                                    break;
                                case 1:
                                    if (aumento2 > aumento) {
                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha usado su defensa especial");
                                        JOptionPane.showMessageDialog(null, " El ataque ha dañado un poco a " + Cpu.getCabeza().getPokemon().getName());

                                        int actualvida = BarraHp_CPU.getValue();
                                        int ataque = player.primero.getPokemon().getAttack() - 40;
                                        int reduce = Math.max(actualvida - ataque, 0);
                                        BarraHp_CPU.setValue(reduce);

                                        PKHPCPU.setText(String.valueOf(reduce));

                                    } else {

                                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha esquivado el ataque con su defensa especial");

                                    }
                                    break;

                            }
                            break;
                        }
                    }
                }
            }
        }

    }

    public void sonidoGolpe() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String ruta = "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Audios\\golpe.wav";
        AudioInputStream aui = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();

        clip.open(aui);
        clip.start();

    }

    public void sonido() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String ruta = "F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Audios\\PokemonBatalla.wav";
        AudioInputStream aui = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();

        clip.open(aui);
        clip.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnAtaqEsp = new javax.swing.JButton();
        BtnAtaque = new javax.swing.JButton();
        BtnDefensa = new javax.swing.JButton();
        CambiarPK = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TxtJugador = new javax.swing.JTextField();
        BtnDefEspec = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        PK1 = new javax.swing.JCheckBox();
        PK3 = new javax.swing.JCheckBox();
        PK4 = new javax.swing.JCheckBox();
        PKN1 = new javax.swing.JLabel();
        PKN2 = new javax.swing.JLabel();
        PK3N = new javax.swing.JLabel();
        PKN4 = new javax.swing.JLabel();
        pkpixel3 = new javax.swing.JLabel();
        pkpixel4 = new javax.swing.JLabel();
        pixelpk2 = new javax.swing.JLabel();
        pk1 = new javax.swing.JLabel();
        imgPk = new javax.swing.JLabel();
        HPPlayer = new javax.swing.JLabel();
        PpkName = new javax.swing.JLabel();
        CpupkName = new javax.swing.JLabel();
        imgpkCPU = new javax.swing.JLabel();
        PKHPCPU = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jLabel1.setText("CPU");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BtnAtaqEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SpAtack.png"))); // NOI18N
        BtnAtaqEsp.setText("Ataque Especial");
        BtnAtaqEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtaqEspActionPerformed(evt);
            }
        });

        BtnAtaque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/NormAta.png"))); // NOI18N
        BtnAtaque.setText("Ataque");
        BtnAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtaqueActionPerformed(evt);
            }
        });

        BtnDefensa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defnorm.png"))); // NOI18N
        BtnDefensa.setText("Defensa");
        BtnDefensa.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                BtnDefensaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        BtnDefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDefensaActionPerformed(evt);
            }
        });

        CambiarPK.setText("Cambiar Pokemon");
        CambiarPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarPKActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Batalla/Rendirse (1).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TxtJugador.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TxtJugadorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TxtJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtJugadorActionPerformed(evt);
            }
        });

        BtnDefEspec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SpDef.png"))); // NOI18N
        BtnDefEspec.setText("Defenza Especial");
        BtnDefEspec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDefEspecActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "POKEDEX", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
        jPanel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });

        PK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PK1ActionPerformed(evt);
            }
        });

        PK3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PK3ActionPerformed(evt);
            }
        });

        PK4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PK4ActionPerformed(evt);
            }
        });

        PKN1.setText("pk1");
        PKN1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PKN1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        PKN2.setText("sad");
        PKN2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PKN2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        PK3N.setText("pk3");
        PK3N.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PK3NAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        PKN4.setText("pk4");
        PKN4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PKN4AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        pkpixel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pkpixel3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        pkpixel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pkpixel4AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        pixelpk2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pixelpk2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        pk1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pk1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(PKN1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pk1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(PKN2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pixelpk2)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(PK3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(PK1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PK4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pkpixel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PKN4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pkpixel3)
                        .addGap(45, 45, 45)
                        .addComponent(PK3N)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PKN1)
                            .addComponent(pk1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PK3)
                        .addComponent(PK3N)
                        .addComponent(pkpixel3)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PKN4)
                            .addComponent(pkpixel4)
                            .addComponent(PK4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PK1)
                            .addComponent(pixelpk2)
                            .addComponent(PKN2))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAtaqEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(TxtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnDefEspec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnDefensa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(CambiarPK, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnAtaqEsp, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(BtnDefEspec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CambiarPK, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        TxtJugador.getAccessibleContext().setAccessibleName("TxtJugador");

        imgPk.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                imgPkAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        HPPlayer.setText("asd");
        HPPlayer.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                HPPlayerAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        PpkName.setText("ds");
        PpkName.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PpkNameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        CpupkName.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CpupkNameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        imgpkCPU.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                imgpkCPUAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        PKHPCPU.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PKHPCPUAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgpkCPU)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(PKHPCPU))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(CpupkName)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addComponent(HPPlayer)
                .addGap(316, 316, 316))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(imgPk))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(PpkName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(imgpkCPU)
                .addGap(60, 60, 60)
                .addComponent(CpupkName)
                .addGap(18, 18, 18)
                .addComponent(PKHPCPU)
                .addGap(84, 84, 84)
                .addComponent(PpkName)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(HPPlayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPk)))
                .addGap(76, 76, 76)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtJugadorActionPerformed

    }//GEN-LAST:event_TxtJugadorActionPerformed

    private void TxtJugadorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TxtJugadorAncestorAdded
        TxtJugador.setText(Jugador);


    }//GEN-LAST:event_TxtJugadorAncestorAdded

    private void BtnAtaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtaqueActionPerformed

        NormAtakPlayer(evt);

        contador++;
        contador2++;
        if (contador == 3) {
            BtnAtaqEsp.setVisible(true);
        }

        if (contador2 >= 3) {
            BtnDefEspec.setVisible(true);

        }
        /*/ if (VidaCPU.getValue() > 0 && HPPlayerbar.getValue() > 0) {

            if (Cpu.getCabeza() != null && player.primero != null) {
                if (Cpu.getCabeza().getPokemon().getType() == player.primero.getPokemon().getStrong()) {
                    JOptionPane.showMessageDialog(null, "¡" + player.primero.getPokemon().getName() + " ha realizado un ataque!");
                    int actualvida = VidaCPU.getValue();
                    int ataque = player.primero.getPokemon().getAttack() * 2;
                    int reduce = Math.max(actualvida - ataque, 0);
                    VidaCPU.setValue(reduce);

                    PKHPCPU.setText(String.valueOf(reduce));

                } else {
                    if (VidaCPU.getValue() == 0) {
                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha sido derrotado\n"
                                + player.primero.getPokemon().getName() + " Es el ganador");

                        Cpu.removeFirstPokemon();
                        Cpu.selectActivePokemon();
                        imagen.setSize(0, 0);
                        imgCpuPK();
                        JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName().toString() + " Entra a la batalla");
                        CpupkName.setText(Cpu.getCabeza().getPokemon().getName().toString());
                        VidaCPU.setValue(100);
                        PKHPCPU.setText(String.valueOf(VidaCPU.getValue()));

                    } else if (HPPlayerbar.getValue() == 0) {

                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha sido derrotado\n" + Cpu.getCabeza().getPokemon().getName() + " Es el ganador");
                        player.Remove_Pokemon(snorlax);

                        imagen2.setSize(0, 0);
                        imgplayerPK();
                        JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName().toString() + " Entra a la batalla");
                        PpkName.setText(player.primero.getPokemon().getName().toString());
                        HPPlayerbar.setValue(100);
                        HPPlayer.setText(String.valueOf(HPPlayerbar.getValue()));
                    }
                }
            }
        }
       if (VidaCPU.getValue() > 0) {

            if (Cpu.getCabeza() != null && player.primero != null) {
                if (Cpu.getCabeza().getPokemon().getType() == player.primero.getPokemon().getStrong()) {
                    JOptionPane.showMessageDialog(null, "¡Snorlax ha realizado un ataque!");
                    int actualvida = VidaCPU.getValue();
                    int ataque = player.primero.getPokemon().getAttack() * 2;
                    int reduce = Math.max(actualvida - ataque, 0);
                    VidaCPU.setValue(reduce);
                    PKHPCPU.setText(String.valueOf(reduce));
                    System.out.println("la vida de blas es: " + reduce);

                } else {
                    JOptionPane.showMessageDialog(null, "¡Snorlax ha realizado un ataque!");
                    int actualvida = VidaCPU.getValue();
                    int reduce = Math.max(actualvida - player.primero.getPokemon().getAttack(), 0);
                    VidaCPU.setValue(reduce);
                    PKHPCPU.setText(String.valueOf(reduce));
                    System.out.println("la vida de blas es: " + reduce);
                }

            }
        } else {
            if (VidaCPU.getValue() == 0) {
                JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha sido derrotado\n"
                        + player.primero.getPokemon().getName() + " Es el ganador");

                Cpu.removeFirstPokemon();
                Cpu.selectActivePokemon();
                imagen.setSize(0, 0);
                imgCpuPK();
                JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName().toString() + " Entra a la batalla");
                CpupkName.setText(Cpu.getCabeza().getPokemon().getName().toString());
                VidaCPU.setValue(100);
                PKHPCPU.setText(String.valueOf(VidaCPU.getValue()));
            } else if (HPPlayerbar.getValue() == 0) {
                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha sido derrotado\n" + Cpu.getCabeza().getPokemon().getName() + " Es el ganador");
            }
        }
        /*/

    }//GEN-LAST:event_BtnAtaqueActionPerformed


    private void CambiarPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarPKActionPerformed

        prueba();


        /* if (Pokemons.getSelectedItem().equals("Rattata")) {
            PokemonCambio();
            player.primero.setPokemon(selec.rattata);

            imagen2.setSize(0, 0);
            imgplayerPK();
            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName().toString() + " Entra a la batalla");
            PpkName.setText(player.primero.getPokemon().getName().toString());
            BarraHp_PL.setBounds(0, 0, 0, 0);
            BarraHp_PL();
            player.primero.setPokemon(selec.rattata);
            HPPlayer.setText(String.valueOf(BarraHp_PL.getValue()));

            System.out.println(selec.rattata);
        }*/
        contador++;
        contador2++;
        if (contador == 3) {
            BtnAtaqEsp.setVisible(true);
        }

        if (contador2 >= 3) {
            BtnDefEspec.setVisible(true);

        }
    }//GEN-LAST:event_CambiarPKActionPerformed

    private void imgPkAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_imgPkAncestorAdded
        imgplayerPK();

    }//GEN-LAST:event_imgPkAncestorAdded

    private void HPPlayerAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_HPPlayerAncestorAdded
        HPPlayer.setText(String.valueOf(player.primero.getPokemon().getHP()));

    }//GEN-LAST:event_HPPlayerAncestorAdded

    private void BtnAtaqEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtaqEspActionPerformed
        atakSpecialPlayer(evt);
        contador2++;

         contador = 1;
        if (contador == 1) {
            BtnAtaqEsp.setVisible(false);
        }

        if (contador2 >= 3) {
            BtnDefEspec.setVisible(true);

        }

    }//GEN-LAST:event_BtnAtaqEspActionPerformed

    private void PpkNameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PpkNameAncestorAdded
        PpkName.setText(player.primero.getPokemon().getName().toString());
    }//GEN-LAST:event_PpkNameAncestorAdded

    private void CpupkNameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CpupkNameAncestorAdded
        CpupkName.setText(Cpu.getCabeza().getPokemon().getName().toString());
    }//GEN-LAST:event_CpupkNameAncestorAdded

    private void imgpkCPUAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_imgpkCPUAncestorAdded
        imgCpuPK();
    }//GEN-LAST:event_imgpkCPUAncestorAdded

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
        try {
            sonido();

        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Batalla.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (LineUnavailableException ex) {
            Logger.getLogger(Batalla.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Batalla.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1AncestorAdded

    private void PKHPCPUAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PKHPCPUAncestorAdded

        PKHPCPU.setText(String.valueOf(Cpu.getCabeza().getPokemon().getHP()));

    }//GEN-LAST:event_PKHPCPUAncestorAdded

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded

        BarraHp_CPU();
        BarraHp_PL();


    }//GEN-LAST:event_jPanel1AncestorAdded

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        victoria();

        /* if (VidaCPU.getValue() == 0) {
            JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha sido derrotado\n"
                    + player.primero.getPokemon().getName() + " Es el ganador");

            Cpu.removeFirstPokemon();
            Cpu.selectActivePokemon();
            imagen.setSize(0, 0);
            imgCpuPK();
            JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName().toString() + " Entra a la batalla");
            CpupkName.setText(Cpu.getCabeza().getPokemon().getName().toString());
            VidaCPU.setValue(100);
            PKHPCPU.setText(String.valueOf(VidaCPU.getValue()));

        } else if (HPPlayerbar.getValue() == 0) {

            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " ha sido derrotado\n" + Cpu.getCabeza().getPokemon().getName() + " Es el ganador");
            player.Remove_Pokemon(snorlax);

            imagen2.setSize(0, 0);
            imgplayerPK();
            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName().toString() + " Entra a la batalla");
            PpkName.setText(player.primero.getPokemon().getName().toString());
            HPPlayerbar.setValue(100);
            HPPlayer.setText(String.valueOf(HPPlayerbar.getValue()));
        }*/
    }//GEN-LAST:event_jPanel1MouseMoved

    private void BtnDefEspecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDefEspecActionPerformed
        DefSpPlayer(evt);
        
        contador++;

        contador2 = 1;
        if (contador2 == 1) {
            BtnDefEspec.setVisible(false);
        }

        if (contador == 3) {
            BtnAtaqEsp.setVisible(true);

        }

 /*  if (VidaCPU.getValue() > 0 && HPPlayerbar.getValue() > 0) {

            if (Cpu.getCabeza() != null && player.primero.getPokemon() != null) {//blast
                int actualHpP = HPPlayerbar.getValue();
                int ataque2 = 8;
                int reduce2 = Math.max(actualHpP - ataque2, 0);
                Nodo primero = null;
                Random random = new Random();
                int count = 0;

                while (count < 10) {
                    int randomNumber = random.nextInt(3);  // Genera un número aleatorio del 0 al 11

                    //Esta varaible va a estar cambiando, ya que va a tomar el valor del pokemon al que este asignado el numero, y asi mismo
                    //se insertara en la lista
                    // Selecciona el Pokémon según el número aleatorio generado
                    switch (randomNumber) {
                        case 0:
                            Cpu.getCabeza().getPokemon().getAttack();
                            JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha atacado pero" + snorlax.getName() + " se ha defendido");
                            break;
                        case 1:
                            blastoise.getSpecialAttack();
                            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido tambien");
                            break;
                        case 2:
                            Cpu.getCabeza().getPokemon().getSpecialDefense();
                            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido pero sufre un poco de daño");
                            actualHpP = HPPlayerbar.getValue();
                            ataque2 = 8;
                            reduce2 = Math.max(actualHpP - ataque2, 0);
                            HPPlayerbar.setValue(reduce2);
                            HPPlayer.setText(String.valueOf(reduce2));
                            break;

                        case 3:
                            Cpu.getCabeza().getPokemon().getAttack();
                            JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha atacado pero" + snorlax.getName() + " se ha defendido");
                            break;
                        case 4:
                            blastoise.getSpecialAttack();
                            JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " Se ha defendido tambien");
                            break;

                        case 5:
                            Cpu.getCabeza().getPokemon().getSpecialDefense();
                            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " se ha defendido pero sufre un poco de daño");
                            actualHpP = HPPlayerbar.getValue();
                            ataque2 = 8;
                            reduce2 = Math.max(actualHpP - ataque2, 0);
                            HPPlayerbar.setValue(reduce2);
                            HPPlayer.setText(String.valueOf(reduce2));

                            break;
                        case 6:
                            blastoise.getSpecialAttack();
                            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido tambien");
                            break;
                        case 7:
                            Cpu.getCabeza().getPokemon().getSpecialDefense();
                            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido pero sufre un poco de daño");
                            actualHpP = HPPlayerbar.getValue();
                            ataque2 = 8;
                            reduce2 = Math.max(actualHpP - ataque2, 0);
                            HPPlayerbar.setValue(reduce2);
                            HPPlayer.setText(String.valueOf(reduce2));
                            break;

                        case 8:
                            Cpu.getCabeza().getPokemon().getAttack();
                            JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha atacado pero" + snorlax.getName() + " se ha defendido");
                            break;
                        case 9:
                            blastoise.getSpecialAttack();
                            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido tambien");
                            break;

                        case 10:
                            Cpu.getCabeza().getPokemon().getSpecialDefense();
                            JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido pero sufre  daño");
                            actualHpP = HPPlayerbar.getValue();
                            ataque2 = 8;
                            reduce2 = Math.max(actualHpP - ataque2, 0);
                            HPPlayerbar.setValue(reduce2);
                            HPPlayer.setText(String.valueOf(reduce2));

                            break;
                    }
                    break;
                }

            }
        }

         */
    }//GEN-LAST:event_BtnDefEspecActionPerformed

    private void BtnDefensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDefensaActionPerformed

        DefNormPlayer(evt);
        contador2++;
        contador++;
        if (contador == 3) {
            BtnAtaqEsp.setVisible(true);

            if (contador2 >= 3) {
                BtnDefEspec.setVisible(true);

            }
        }
        /* if (VidaCPU.getValue() > 0 && HPPlayerbar.getValue() > 0) {

            if (Cpu.getCabeza().getPokemon().getName() == blastoise.getName() && player.primero.getPokemon().getName() == snorlax.getName()) {//blast
                if (blastoise.getType() == snorlax.getStrong()) {

                    int actualHpP = HPPlayerbar.getValue();
                    int ataque2 = 8;
                    int reduce2 = Math.max(actualHpP - ataque2, 0);

                    Nodo primero = null;
                    Random random = new Random();
                    int count = 0;

                    while (count < 3) {
                        int randomNumber = random.nextInt(3);  // Genera un número aleatorio del 0 al 11

                        //Esta varaible va a estar cambiando, ya que va a tomar el valor del pokemon al que este asignado el numero, y asi mismo
                        //se insertara en la lista
                        // Selecciona el Pokémon según el número aleatorio generado
                        switch (randomNumber) {
                            case 0:
                                Cpu.getCabeza().getPokemon().getAttack();
                                JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha atacado pero" + snorlax.getName() + " se ha defendido");
                                break;
                            case 1:
                                blastoise.getSpecialAttack();
                                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido tambien");
                                break;
                            case 2:
                                Cpu.getCabeza().getPokemon().getSpecialDefense();
                                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido pero sufre un poco de daño");
                                actualHpP = HPPlayerbar.getValue();
                                ataque2 = 16;
                                reduce2 = Math.max(actualHpP - ataque2, 0);
                                HPPlayerbar.setValue(reduce2);
                                HPPlayer.setText(String.valueOf(reduce2));
                                break;

                            case 3:
                                Cpu.getCabeza().getPokemon().getAttack();
                                JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha atacado pero" + snorlax.getName() + " se ha defendido");
                                break;
                            case 4:
                                blastoise.getSpecialAttack();
                                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido tambien");
                                break;

                            case 5:
                                Cpu.getCabeza().getPokemon().getSpecialDefense();
                                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido pero sufre un poco de daño");
                                actualHpP = HPPlayerbar.getValue();
                                ataque2 = 16;
                                reduce2 = Math.max(actualHpP - ataque2, 0);
                                HPPlayerbar.setValue(reduce2);
                                HPPlayer.setText(String.valueOf(reduce2));

                                break;
                            case 6:
                                blastoise.getSpecialAttack();
                                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido tambien");
                                break;
                            case 7:
                                Cpu.getCabeza().getPokemon().getSpecialDefense();
                                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + " Se ha defendido pero sufre un poco de daño");
                                actualHpP = HPPlayerbar.getValue();
                                ataque2 = 16;
                                reduce2 = Math.max(actualHpP - ataque2, 0);
                                HPPlayerbar.setValue(reduce2);
                                HPPlayer.setText(String.valueOf(reduce2));
                                break;

                            case 8:
                                Cpu.getCabeza().getPokemon().getAttack();
                                JOptionPane.showMessageDialog(null, Cpu.getCabeza().getPokemon().getName() + " ha atacado pero" + snorlax.getName() + " se ha defendido");
                                break;
                            case 9:
                                blastoise.getSpecialAttack();
                                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + "Se ha defendido tambien");
                                break;

                            case 10:
                                Cpu.getCabeza().getPokemon().getSpecialDefense();
                                JOptionPane.showMessageDialog(null, player.primero.getPokemon().getName() + "Se ha defendido pero sufre  daño");
                                actualHpP = HPPlayerbar.getValue();
                                ataque2 = 16;
                                reduce2 = Math.max(actualHpP - ataque2, 0);
                                HPPlayerbar.setValue(reduce2);
                                HPPlayer.setText(String.valueOf(reduce2));

                                break;
                        }
                        break;
                    }
                }

            }

        }*/
    }//GEN-LAST:event_BtnDefensaActionPerformed

    private void BtnDefensaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_BtnDefensaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDefensaAncestorAdded

    private void PK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PK1ActionPerformed

    }//GEN-LAST:event_PK1ActionPerformed

    private void PKN1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PKN1AncestorAdded
        PKN1.setText(player.primero.getPokemon().getName().toString());

    }//GEN-LAST:event_PKN1AncestorAdded

    private void PKN2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PKN2AncestorAdded
        PKN2.setText(player.primero.getNext().getPokemon().getName().toString());
    }//GEN-LAST:event_PKN2AncestorAdded

    private void PKN4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PKN4AncestorAdded
        PKN4.setText(player.ultimo.getPokemon().getName().toString());
    }//GEN-LAST:event_PKN4AncestorAdded

    private void PK3NAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PK3NAncestorAdded
        PK3N.setText(player.ultimo.getBack().getPokemon().getName().toString());
    }//GEN-LAST:event_PK3NAncestorAdded

    private void PK3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PK3ActionPerformed

    }//GEN-LAST:event_PK3ActionPerformed

    private void PK4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PK4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PK4ActionPerformed

    private void pixelpk2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pixelpk2AncestorAdded
        imgppixel2();
    }//GEN-LAST:event_pixelpk2AncestorAdded

    private void pk1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pk1AncestorAdded
        imgppixel1();
    }//GEN-LAST:event_pk1AncestorAdded

    private void pkpixel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pkpixel3AncestorAdded
        imgppixel3();
    }//GEN-LAST:event_pkpixel3AncestorAdded

    private void pkpixel4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pkpixel4AncestorAdded
        imgppixel4();
    }//GEN-LAST:event_pkpixel4AncestorAdded

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null,Jugador+ " Ha escapado de la batalla");
        JOptionPane.showMessageDialog(null,Cpu.getName()+ " Es el ganador");
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel3AncestorAdded

    }//GEN-LAST:event_jPanel3AncestorAdded

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved
        if (player.primero.getPokemon().getHP() == 0) {
            PKN1.setText("Derrotado");

        } else if (player.primero.getNext().getPokemon().getHP() == 0) {
            PKN2.setText("Derrotado");
        } else if (player.primero.getNext().getNext().getPokemon().getHP() == 0) {
            PK3N.setText("Derrotado");
        } else if (player.ultimo.getPokemon().getHP() == 0) {
            PKN4.setText("Derrotado");

        }
    }//GEN-LAST:event_jPanel3MouseMoved

    public void imgCpuPK() {
        if (Cpu.getCabeza().getPokemon().getName() == snorlax.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\snorlax3.png"));
            imagen.setBounds(50, 20, 120, 120);
            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == pidgeotto.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\Pidgeotto.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == gyarados.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\gyarados.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == arcanine.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\arcanine.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == charizard.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\charizard.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == jigglypuff.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\jygglypuff.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == rattata.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\ratatta.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == blastoise.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blastoise.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == blaziken.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blaziken.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == milotic.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\milotic.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == vaporeon.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\vaporeon.png"));

            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        } else if (Cpu.getCabeza().getPokemon().getName() == infernape.getName()) {
            imagen.doLayout();
            imagen = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\infernape.png"));
            imagen.setBounds(50, 20, 120, 120);

            jPanel1.add(imagen);
        }
    }

    public void imgplayerPK() {
        if (player.primero.getPokemon().getName() == snorlax.getName()) {
            imagen2.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\snorlax3.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);

        } else if (player.primero.getPokemon().getName() == pidgeotto.getName()) {
            imagen2.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\Pidgeotto.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);

        } else if ((player.primero).getPokemon().getName() == gyarados.getName()) {
            imagen2.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\gyarados.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);

        } else if (player.primero.getPokemon().getName() == arcanine.getName()) {
            imagen.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\arcanine.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        } else if (player.primero.getPokemon().getName() == charizard.getName()) {
            imagen.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\charizard.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        } else if (player.primero.getPokemon().getName() == jigglypuff.getName()) {
            imagen.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\jygglypuff.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        } else if (player.primero.getPokemon().getName() == rattata.getName()) {
            imagen.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\ratatta.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        } else if (player.primero.getPokemon().getName() == blastoise.getName()) {
            imagen.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blastoise.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        } else if (player.primero.getPokemon().getName() == blaziken.getName()) {
            imagen.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blaziken.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        } else if (player.primero.getPokemon().getName() == milotic.getName()) {
            imagen.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\milotic.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        } else if (player.primero.getPokemon().getName() == vaporeon.getName()) {
            imagen2.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\vaporeon.png"));

            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        } else if (player.primero.getPokemon().getName() == infernape.getName()) {
            imagen2.doLayout();
            imagen2 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\infernape.png"));
            imagen2.setBounds(400, 150, 120, 120);
            jPanel1.add(imagen2);
        }
    }

    public void imgppixel2() {
        if (player.primero.getNext().getPokemon().getName() == pidgeotto.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\pidgeotto_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);

        } else if (player.primero.getNext().getPokemon().getName() == snorlax.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\Snorlax_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);

        } else if (player.primero.getNext().getPokemon().getName() == milotic.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\milotic_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);

        } else if (player.primero.getNext().getPokemon().getName() == blastoise.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blastoise_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        } else if (player.primero.getNext().getPokemon().getName() == infernape.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\infernape_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        } else if (player.primero.getNext().getPokemon().getName() == gyarados.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\gyarados_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        } else if (player.primero.getNext().getPokemon().getName() == charizard.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\charizard_Pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        } else if (player.primero.getNext().getPokemon().getName() == jigglypuff.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\jygglypuff_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        } else if (player.primero.getNext().getPokemon().getName() == arcanine.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\arcanine_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        } else if (player.primero.getNext().getPokemon().getName() == rattata.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\rattata_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        } else if (player.primero.getNext().getPokemon().getName() == vaporeon.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\vaporeon_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        } else if (player.primero.getNext().getPokemon().getName() == blaziken.getName()) {
            imagen.doLayout();
            imagen6 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blaziken_pixel.png"));
            imagen6.setBounds(70, 90, 32, 32);
            jPanel3.add(imagen6);
        }

    }

    public void imgppixel1() {

        if (player.primero.getPokemon().getName() == pidgeotto.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\pidgeotto_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);

        } else if (player.primero.getPokemon().getName() == snorlax.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\Snorlax_Pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);

        } else if (player.primero.getPokemon().getName() == milotic.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\milotic_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);

        } else if (player.primero.getPokemon().getName() == blastoise.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blastoise_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);
        } else if (player.primero.getPokemon().getName() == infernape.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\infernape_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);
        } else if (player.primero.getPokemon().getName() == gyarados.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\gyarados_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);
        } else if (player.primero.getPokemon().getName() == charizard.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\charizard_Pixel.png"));
            imagen4.setBounds(60, 40, 32, 32);
            jPanel3.add(imagen4);
        } else if (player.primero.getPokemon().getName() == jigglypuff.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\jygglypuff_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);
        } else if (player.primero.getPokemon().getName() == arcanine.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\arcanine_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);
        } else if (player.primero.getPokemon().getName() == rattata.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\rattata_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);
        } else if (player.primero.getPokemon().getName() == vaporeon.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\vaporeon_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);
        } else if (player.primero.getPokemon().getName() == blaziken.getName()) {
            imagen.doLayout();
            imagen4 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blaziken_pixel.png"));
            imagen4.setBounds(70, 40, 32, 32);
            jPanel3.add(imagen4);
        }

    }

    public void imgppixel3() {

        if (player.ultimo.getBack().getPokemon().getName() == pidgeotto.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\pidgeotto_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);

        } else if (player.ultimo.getBack().getPokemon().getName() == snorlax.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\Snorlax_Pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);

        } else if (player.ultimo.getBack().getPokemon().getName() == milotic.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\milotic_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);

        } else if (player.ultimo.getBack().getPokemon().getName() == blastoise.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blastoise_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        } else if (player.ultimo.getBack().getPokemon().getName() == infernape.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\infernape_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        } else if (player.ultimo.getBack().getPokemon().getName() == gyarados.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\gyarados_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        } else if (player.ultimo.getBack().getPokemon().getName() == charizard.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\charizard_Pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        } else if (player.ultimo.getBack().getPokemon().getName() == jigglypuff.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\jygglypuff_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        } else if (player.ultimo.getBack().getPokemon().getName() == arcanine.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\arcanine_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        } else if (player.ultimo.getBack().getPokemon().getName() == rattata.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\rattata_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        } else if (player.ultimo.getBack().getPokemon().getName() == vaporeon.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\vaporeon_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        } else if (player.ultimo.getBack().getPokemon().getName() == blaziken.getName()) {
            imagen.doLayout();
            imagen3 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blaziken_pixel.png"));
            imagen3.setBounds(280, 40, 32, 32);
            jPanel3.add(imagen3);
        }

    }

    public void imgppixel4() {

        if (player.ultimo.getPokemon().getName() == pidgeotto.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\pidgeotto_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);

        } else if (player.ultimo.getPokemon().getName() == snorlax.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\Snorlax_Pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);

        } else if (player.ultimo.getPokemon().getName() == milotic.getName()) {
            imagen3.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\milotic_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);

        } else if (player.ultimo.getPokemon().getName() == blastoise.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blastoise_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        } else if (player.ultimo.getPokemon().getName() == infernape.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\infernape_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        } else if (player.ultimo.getPokemon().getName() == gyarados.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\gyarados_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        } else if (player.ultimo.getPokemon().getName() == charizard.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\charizard_Pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        } else if (player.ultimo.getPokemon().getName() == jigglypuff.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\jygglypuff_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        } else if (player.ultimo.getPokemon().getName() == arcanine.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\arcanine_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        } else if (player.ultimo.getPokemon().getName() == rattata.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\rattata_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        } else if (player.ultimo.getPokemon().getName() == vaporeon.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\vaporeon_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        } else if (player.ultimo.getPokemon().getName() == blaziken.getName()) {
            imagen.doLayout();
            imagen5 = new JLabel(new ImageIcon("F:\\NetBeansProjects\\Cuatri 2 2023\\Pokemon_Game\\src\\main\\resources\\Images\\blaziken_pixel.png"));
            imagen5.setBounds(280, 97, 32, 32);
            jPanel3.add(imagen5);
        }
    }

    public void QuitarImg() {
        imagen.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Batalla.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Batalla.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Batalla.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Batalla.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Batalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtaqEsp;
    private javax.swing.JButton BtnAtaque;
    private javax.swing.JButton BtnDefEspec;
    private javax.swing.JButton BtnDefensa;
    private javax.swing.JButton CambiarPK;
    private javax.swing.JLabel CpupkName;
    private javax.swing.JLabel HPPlayer;
    private javax.swing.JCheckBox PK1;
    private javax.swing.JCheckBox PK3;
    private javax.swing.JLabel PK3N;
    private javax.swing.JCheckBox PK4;
    private javax.swing.JLabel PKHPCPU;
    private javax.swing.JLabel PKN1;
    private javax.swing.JLabel PKN2;
    private javax.swing.JLabel PKN4;
    private javax.swing.JLabel PpkName;
    private javax.swing.JTextField TxtJugador;
    private javax.swing.JLabel imgPk;
    private javax.swing.JLabel imgpkCPU;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel pixelpk2;
    private javax.swing.JLabel pk1;
    private javax.swing.JLabel pkpixel3;
    private javax.swing.JLabel pkpixel4;
    // End of variables declaration//GEN-END:variables
}

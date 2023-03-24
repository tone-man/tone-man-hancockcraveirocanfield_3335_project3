/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.Random_Agent;
import java.util.Random;
import snookie.Snookie;

/**
 *
 * @author Antonio Craveiro
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        rand.setSeed(rand.nextInt());
        GipfGame g = new GipfGame(rand.nextInt());
        
        int result = g.playGame(new Snookie(g), new Random_Agent(g));
        
        System.out.println("Player " + result + " Wins!");
    }
    
}

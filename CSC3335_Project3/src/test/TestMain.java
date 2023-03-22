/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.Random_Agent;
import csc3335_project3.Snookie;

/**
 *
 * @author Antonio Craveiro
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GipfGame g = new GipfGame(1000);
        
        int result = g.playGame(new Random_Agent(g), new Snookie(g));
        
        System.out.println("Player " + result + "Wins!");
    }
    
}

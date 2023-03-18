package csc3335_project3;

import csc3335.gipf_game.GipfGame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 * Interface for searching over a state space.
 * @author ncrav
 */
public interface Searchable {
    
    /**
     * Searches a state space given a game
     * @param g
     * @param s
     * @return String - Best next move for the agent
     */
    public String search(GipfGame g, State s);
}

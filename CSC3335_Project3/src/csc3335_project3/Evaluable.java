/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package csc3335_project3;

import csc3335.gipf_game.GipfGame;

/**
 *
 * @author ncrav
 */
public interface Evaluable {
    
    /**
     * Evaluates a state given a game.
     * @param g
     * @param s
     * @return
     */
    public int eval(GipfGame g, State s);
}

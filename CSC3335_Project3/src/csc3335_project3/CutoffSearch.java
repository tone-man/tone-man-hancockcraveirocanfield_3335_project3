/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

import csc3335.gipf_game.GipfGame;

/**
 *
 * @author ncrav
 */
public class CutoffSearch implements Searchable {

    private Evaluable evaluator;
    private Thread searchThread;
    private int searchCutoff;
    private int evalCutoff; //Unsure if neccessary
    
    @Override
    public String search(GipfGame g, State s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

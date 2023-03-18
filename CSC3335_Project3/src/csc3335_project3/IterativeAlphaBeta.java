/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

import csc3335.gipf_game.GipfGame;
import java.util.Map;

/**
 *
 * @author ncrav
 */
public class IterativeAlphaBeta implements Runnable, Searchable{

    private Map<State, Integer> transpositions;
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String search(GipfGame g, State s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private Tuple<State, Integer> maxValue(GipfGame g, State s, Tuple<Integer, Integer> alphaBeta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Tuple<State, Integer> minValue(GipfGame g, State s, Tuple<Integer, Integer> alphaBeta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

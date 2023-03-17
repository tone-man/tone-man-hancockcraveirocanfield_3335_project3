package csc3335_project3;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Class containing universal giph game
 * @author ncrav
 */
public class Game {
    
    public static State initialState;
    public static char[] letterValues;
    public static String[] columns;
    public static String[] edgeSpots;
    public static int[][][] moves;
    public static final int WHITE_GIPH = 0;
    public static final int BLACK_GIPH = 1;
    public static final int BLACK = 2;
    public static final int WHITE = 3;
    public static final int EMPTY = 14;
    
    /**
     * 
     * @param s
     * @return 
     */
    public static State toMove(State s){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Gives all the possible actions the agent can take from a given state.
     * @param s
     * @return 
     */
    public static ArrayList<String> getActions(State s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Gives the resulting board state of an action
     * @param s
     * @param action
     * @return 
     */
    public static State result(State s, String action){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Determines if a given state is terminal.
     * @param s
     * @return 
     */
    public static boolean isTerminal(State s){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Generates the utility value of a given state.
     * @param s
     * @param p
     * @return 
     */
    public static int utility(State s, int p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
    

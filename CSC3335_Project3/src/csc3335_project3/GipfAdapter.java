package csc3335_project3;

import csc3335.gipf_game.GipfGame;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Class containing universal gipf game rules. Just needed to access more things
 * than the original class allowed.
 * @author ncrav
 */
public class GipfAdapter implements Playable {
    
    public static State initialState;
    public static char[] letterValues = "abcdefghi".toCharArray();
    public static String[] columns = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
    public static String[] edgeSpots = {"a 1", "a 2", "a 3", "a 4", "a 5", "b 1", "b 6",
        "c 1", "c 7", "d 1", "d 8", "e 1", "e 9", "f 1", "f 8", "g 1", "g 7", "h 1", "h 6",
        "i 1", "i 2", "i 3", "i 4", "i 5"};
    public static int[][][] moves
            = {{{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}}, // a
            {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}}, // b
            {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}}, // c
            {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}}, // d
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}}, // e
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}}, // f
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}}, // g
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}}, // h
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}} // i
        };
    
    public GipfAdapter(GipfGame g) {
        
    }
    
    /**
     * Returns whose turn it is to move in a given state.
     * @param s State that is being examined
     * @return 
     */
    @Override
    public State toMove(State s){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Gives all the possible actions the agent can take from a given state.
     * @param s State that is being examined
     * @return ArrayList of all possible actions that can be taken from that state.
     */
    @Override
    public ArrayList<String> getActions(State s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Gives the resulting board state of an action
     * @param s State the board is currently in
     * @param action String representing the next move
     * @return Resulting board state of the action
     */
    @Override
    public State result(State s, String action){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Determines if a given state is terminal.
     * @param s State that is being examined
     * @return 
     */
    @Override
    public boolean isTerminal(State s){
        if (s.piecesLeft[0] == 0) {
            return true;
        }
        if (s.piecesLeft[1] == 0) {
            return true;
        }
        if (s.gipfsRemaining[0] == 0) {
            return true;
        }
        if (s.gipfsRemaining[1] == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Generates the utility value of a given state for a player.
     * @param t Terminal state that is being examined
     * @param p Player that is being examined
     * @return 
     */
    @Override
    public int utility(State t, int p) {
        if (t.piecesLeft[0] == 0) {
            if (p == 0)
                return 0;
            
            return 1;
        }
        if (t.piecesLeft[1] == 0) {
            if (p == 1) {
                return 0;
            }

            return 1;
        }
        if (t.gipfsRemaining[0] == 0) {
            if (p == 0) {
                return 0;
            }

            return 1;
        }
        if (t.gipfsRemaining[1] == 0) {
            if (p == 1) {
                return 0;
            }

            return 1;
        }
        return 0;
    }
}
    

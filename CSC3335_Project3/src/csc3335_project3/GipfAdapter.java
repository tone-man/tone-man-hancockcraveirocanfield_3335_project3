package csc3335_project3;

import csc3335.gipf_game.GipfGame;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Adapter that takes a GipfGame object and adapts it to the playable interface.
 * This makes it much easier to use with the codebase.
 * @author ncrav
 */
public class GipfAdapter implements Playable {
    
    public GipfGame gipfGame;
    public State initialState;
    public char[] letterValues = "abcdefghi".toCharArray();
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
        gipfGame = g;
    }
    
    @Override
    public int toMove(State state){
        return state.turn;
    }
    

    @Override
    public ArrayList<String> getActions(State state) {
        throw new UnsupportedOperationException("Not supported yet.");
        
        //for each edgespot check direction
        
        //for each possible direction of this edgespot, see if move can be made
        
        //since move can be made append the action string to array
        
        //do nothing if it cant be made
    }
    

    @Override
    public State result(State state, String action){
        throw new UnsupportedOperationException("Not supported yet.");
        
        //create a new state using the action that was provided
        
        //return that state
    }
    

    @Override
    public boolean isTerminal(State state){
        if (state.piecesLeft[0] == 0) {
            return true;
        }
        if (state.piecesLeft[1] == 0) {
            return true;
        }
        if (state.gipfsRemaining[0] == 0) {
            return true;
        }
        if (state.gipfsRemaining[1] == 0) {
            return true;
        }
        return false;
    }
    

    @Override
    public int utility(State tState, int plr) {
        if (tState.piecesLeft[0] == 0) {
            if (plr == 0)
                return 0;
            
            return 1;
        }
        if (tState.piecesLeft[1] == 0) {
            if (plr == 1) {
                return 0;
            }

            return 1;
        }
        if (tState.gipfsRemaining[0] == 0) {
            if (plr == 0) {
                return 0;
            }

            return 1;
        }
        if (tState.gipfsRemaining[1] == 0) {
            if (plr == 1) {
                return 0;
            }

            return 1;
        }
        return 0;
    }
}
    

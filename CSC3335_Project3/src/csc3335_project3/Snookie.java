
package csc3335_project3;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.GipfPlayable;

/**
 * Our Agent to compete in the tournament
 * @author William Hancock, Antonio Craveiro, Ryan Canfield
 */
public class Snookie implements GipfPlayable {

    private Searchable algorithm;
    private GipfGame game;
    private State curState;
    private boolean debug = false;
    
    public Snookie(GipfGame g) {
        
    }
    
    /**
     * Toggles the debugger
     */
    public void toggleDebug() {
        debug = !debug;
    }
    
    @Override
    public String makeGipfMove(int curPlayer) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    /**
     * Searches the state space and returns the next best move.
     * @return String - the best action to be taken
     */
    private String search(){
      throw new UnsupportedOperationException("Not supported yet.");  
    }



}

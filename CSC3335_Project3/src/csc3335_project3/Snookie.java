
package csc3335_project3;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.GipfPlayable;

/**
 * Our Agent to compete in the tournament
 * @author William Hancock, Antonio Craveiro, Ryan Canfield
 */
public class Snookie implements GipfPlayable {

    private Searchable algorithm;
    private GipfGame agame; //Stuetzle's complete game 
    private Playable game; //Static rules of the game
    private State curState; //Dynamic state of the game
    private boolean debug = false; //Debugger for search time, and other things
    
    public Snookie(GipfGame g) {
        //save reference of giph game
        agame = g;
        
        //init all other internal parameters
        
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
        
        //Create state object using gipfGame
        
        //Pass it to search
        search();
    }
    
    /**
     * Searches the state space and returns the next best move.
     * @return String - the best action to be taken
     */
    private String search(){
        
      String move = algorithm.search(game, curState)
    }



}

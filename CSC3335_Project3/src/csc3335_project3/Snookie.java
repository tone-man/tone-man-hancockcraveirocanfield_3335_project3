
package csc3335_project3;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.GipfPlayable;

/**
 * Our Agent to compete in the tournament
 * @author William Hancock, Antonio Craveiro, Ryan Canfield
 */
public class Snookie implements GipfPlayable {

    private Searchable algorithm;
    private GipfAdapter game; //Static rules of the game
    private State curState; //Dynamic state of the game
    private boolean debug = false; //Debugger for search time, and other things
    
    public Snookie(GipfGame g) {
        
        game = new GipfAdapter(g);
        curState = new State(g);
        
        //select our desired alorithm here
        algorithm = new CutoffSearch(game, curState, new IterativeMinMax(curState, new MaterialEval()), new MaterialEval());
    }
    
    /**
     * Toggles the debugger
     */
    public void toggleDebug() {
        debug = !debug;
    }
    
    @Override
    public String makeGipfMove(int curPlayer) {
        //Create state object using gipfGame
        curState = new State(game.gipfGame);
        
        //Set the turn to that of curPlayer
        curState.turn = curPlayer;
        
        //Pass it to search, and return result
        return search();
    }
    
    /**
     * Searches the state space and returns the next best move.
     * @return String - the best action to be taken
     */
    private String search(){
        
      //call the search algorithm and return it
      return algorithm.search(game, curState);
      
    }



}

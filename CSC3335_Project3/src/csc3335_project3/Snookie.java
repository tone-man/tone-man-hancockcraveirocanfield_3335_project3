
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
    private int turn;
    
    public Snookie(GipfGame g) {
        
        turn = 0;
        game = new GipfAdapter(g);
        curState = null;
        //Select and evaluator for our game search
        Evaluable evaluator = new MaterialEval();
        
        //Select algorithm for our search
        final int MAX_ITERATIONS = 10; //maximum interation depth
        Searchable search = new IterativeAlphaBeta(game, evaluator, MAX_ITERATIONS);
        
        //Since this Algorithm possibly takes longer then five seconds wrap 
        //it in a CutoffSearch object, so it will terminate after a set time.
        algorithm = new CutoffSearch(game, curState, search);
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
        if(turn == 0){
            turn++;
            return "a 3 2";
        }    
        else 
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

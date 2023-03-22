/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Antonio Craveiro
 */
public class DepthLimitedAlphaBeta implements Searchable {
    protected Playable game;
    protected Evaluable evaluator;
    protected int plr; //Player for ai
    protected String bestAction;
    protected Map<State, String> transpositions; //May be moved it iterative!
    protected int depth;

    public DepthLimitedAlphaBeta(Playable game, Evaluable evaluator, int depth) {
        this.game = game;
        this.evaluator = evaluator;
        this.depth = depth;
        this.bestAction = null;
        this.transpositions = new HashMap<>();
    }

    @Override
    public String search(Playable game, State state) {
        plr = this.game.toMove(state);
        Tuple<Float, String> result = maxValue(state, this.depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
        bestAction = result.getSecond();
        return bestAction;
    }

    @Override
    public String getAction() {
        return bestAction;
    }
    
    /**
     * Gets the maximum utility from a State.
     * @param state State - State being observed
     * @param depth Integer - recursive calls before reaching desired level of state tree.
     * @param alpha int - best Max move
     * @param beta int - best Min move
     * @return Tuple - an int, String pair representing utility, action.
     */
    protected Tuple<Float, String> maxValue(State state, Integer depth, int alpha, int beta) {
        
        //Instance a tuple
        Tuple<Float, String> max = new Tuple<>(null, null);
        
        //Check if at terminal state
        if (game.isTerminal(state)) {
            
            //Return the utility of state
            max.setFirst(game.utility(state, this.plr));
            max.setSecond(null);
            return max;
        }
        
        //Check if at cutoff
        else if(depth == 0) {
            
            //Return the evaluation of state
            max.setFirst(evaluator.eval(game, state));
            max.setSecond(null);
            return max;
        }
        
        //Loop over all child action states
        int value = Integer.MIN_VALUE;
        for (String a : game.getActions(state)) {
            //Generate the min state
            Tuple<Float, String> min = minValue(game.result(state, a), depth - 1, alpha, beta);
            if (min.getFirst() > value) {
                max.setFirst(min.getFirst());
                max.setSecond(a);
                alpha = Math.max(alpha, value);
            }
            //Kill search if value > beta
            if (value >= beta) {
                return max;
            }
        }
        
        //Return Max tuple now that search is complete
        return max;
    }
    
    /**
     * Gets the minimum utility from a State.
     * @param state State - State being observed
     * @param depth Integer - recursive calls before reaching desired level of state tree.
     * @param alpha int - best Max move
     * @param beta int - best Min move
     * @return Tuple - an int, String pair representing utility, action.
     */
    protected Tuple<Float, String> minValue(State state, Integer depth, int alpha, int beta ) {
        
        //Instance a tuple
        Tuple<Float, String> min = new Tuple<>(null, null);

        //Check if at terminal state
        if (game.isTerminal(state)) {

            //Return the utility of state
            min.setFirst(game.utility(state, this.plr));
            min.setSecond(null);
            return min;
        } 
        
        //Check if at cutoff
        else if (depth == 0) {

            //Return the evaluation of state
            min.setFirst(evaluator.eval(game, state));
            min.setSecond(null);
            return min;
        }

        //Loop over all child action states
        int value = Integer.MAX_VALUE;
        for (String a : game.getActions(state)) {
            //Generate the min state
            Tuple<Float, String> max = minValue(game.result(state, a), depth - 1, alpha, beta);
            if (max.getFirst() < value) {
                min.setFirst(min.getFirst());
                min.setSecond(a);
                beta = Math.min(beta, value);
            }
            //Kill search if v < alpha
            if (value <= alpha) {
                return min;
            }
        }
        //Return Max tuple now that search is complete
        return min;
    }
    
    
}

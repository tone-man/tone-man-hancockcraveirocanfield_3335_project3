/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snookie.util;

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
    protected Map<GipfState, String> transpositions;
    protected int depth;

    public DepthLimitedAlphaBeta(Playable game, Evaluable evaluator, int depth) {
        this.game = game;
        this.evaluator = evaluator;
        this.depth = depth;
        this.bestAction = null;
        this.transpositions = new HashMap<>();
    }

    @Override
    public String search(Playable game, GipfState state) {
        plr = this.game.toMove(state);
        Tuple<Float, String> result = maxValue(state, this.depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
        bestAction = result.getSecond();
        transpositions.clear(); //This is a problem because we nuke the thread, but I do not have time to fix it
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
    protected Tuple<Float, String> maxValue(GipfState state, Integer depth, int alpha, int beta) {
        
        //Instance a tuple
        Tuple<Float, String> max = new Tuple<>(null, null);
        
        //Check if we have seen this state before
        String lookup = transpositions.get(state);

        if (lookup != null) {
            max.setFirst(Float.valueOf(lookup));
            max.setSecond(null);
            transpositions.put(state, (String) Float.toString(max.getFirst()));
            return max;
        }
        
        //Check if at terminal state
        if (game.isTerminal(state)) {
            
            //Return the utility of state
            max.setFirst(game.utility(state, this.plr));
            max.setSecond(null);
            transpositions.put(state, (String) Float.toString(max.getFirst()));
            return max;
        }
        
        //Check if at cutoff
        else if(depth == 0) {
            
            //Return the evaluation of state
            max.setFirst(evaluator.eval(game, state));
            max.setSecond(null);
            transpositions.put(state, (String) Float.toString(max.getFirst()));
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
                transpositions.put(state, (String) Float.toString(max.getFirst()));
                return max;
            }
        }
        
        //Return Max tuple now that search is complete
        transpositions.put(state, (String) Float.toString(max.getFirst()));
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
    protected Tuple<Float, String> minValue(GipfState state, Integer depth, int alpha, int beta ) {
        
        //Instance a tuple
        Tuple<Float, String> min = new Tuple<>(null, null);

        //Check if we have seen this state before
        String lookup = transpositions.get(state);
        
        if(lookup != null)
        {
            min.setFirst(Float.valueOf(lookup));
            min.setSecond(null);
            return min;
        }
        
        //Check if at terminal state
        if (game.isTerminal(state)) {

            //Return the utility of state
            min.setFirst(game.utility(state, this.plr));
            min.setSecond(null);
            transpositions.put(state, (String) Float.toString(min.getFirst()));
            return min;
        } 
        
        //Check if at cutoff
        else if (depth == 0) {

            //Return the evaluation of state
            min.setFirst(evaluator.eval(game, state));
            min.setSecond(null);
            transpositions.put(state, (String) Float.toString(min.getFirst()));
            return min;
        }

        //Loop over all child action states
        int value = Integer.MAX_VALUE;
        for (String a : game.getActions(state)) {
            //Generate the min state
            Tuple<Float, String> max = maxValue(game.result(state, a), depth - 1, alpha, beta);
            if (max.getFirst() < value) {
                min.setFirst(max.getFirst());
                min.setSecond(a);
                beta = Math.min(beta, value);
            }
            //Kill search if v < alpha
            if (value <= alpha) {
                transpositions.put(state, (String) Float.toString(min.getFirst()));
                return min;
            }
        }
        //Return Max tuple now that search is complete
        transpositions.put(state, (String) Float.toString(min.getFirst()));
        return min;
    }
    
}

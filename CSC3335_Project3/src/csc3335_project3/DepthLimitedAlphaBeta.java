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
    private Playable game;
    private Evaluable evaluator;
    private int plr; //Player for ai
    private String bestAction;
    private Map<State, String> transpositions;
    private int depth;

    public DepthLimitedAlphaBeta(Playable game, Evaluable evaluator, int depth) {
        this.game = game;
        this.evaluator = evaluator;
        this.bestAction = null;
        this.transpositions = new HashMap<>();
    }

    @Override
    public String search(Playable game, State state) {
        plr = this.game.toMove(state);
        Tuple<Integer, String> result = maxValue(state, this.depth, new Tuple<Integer, Integer>(Integer.MIN_VALUE,Integer.MAX_VALUE));
        return result.getSecond();
    }

    @Override
    public String getAction() {
        return bestAction;
    }
    
    private Tuple<Integer, String> maxValue(State state, Integer depth, Tuple<Integer, Integer> alphaBeta ) {
        
    }
    
    private Tuple<Integer, String> minValue(State state, Integer depth, Tuple<Integer, Integer> alphaBeta ) {
        
    }
}

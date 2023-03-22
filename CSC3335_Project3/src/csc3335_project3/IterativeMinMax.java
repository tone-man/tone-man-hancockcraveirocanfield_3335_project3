/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ncrav
 */
public class IterativeMinMax implements Searchable {

    private Map<State, Integer> transpositions;
    private State startState;
    private Evaluable evaluator;
    private String bestAction;
    private int player;
    private int depth;
    
    public IterativeMinMax(State state, Evaluable evaluator) {
        this.transpositions = new HashMap<State, Integer>();
        this.startState = state;
        this.evaluator = evaluator;
    }
    
    @Override
    public String search(Playable game, State state) {
        player = game.toMove(state);
        Tuple<Float, String> max = maxValue(game, state);
        return max.getSecond();
    }

    private Tuple<Float, String> maxValue(Playable game, State state) {
        Tuple<Float, String> ret = new Tuple<>(null, null);
        if (game.isTerminal(state)) {
            ret.setFirst(game.utility(state, player));
            ret.setSecond(null);
            return ret;
        }
        int v = Integer.MIN_VALUE;
        for (String a : game.getActions(state)) {
            Tuple<Float, String> v2a2 = minValue(game, game.result(state, a));
            if (v2a2.getFirst() > v) {
                ret.setFirst(v2a2.getFirst());
                ret.setSecond(a);
            }
        }
        return ret;
    }

    private Tuple<Float, String> minValue(Playable game, State state) {
        Tuple<Float, String> ret = new Tuple<>(null, null);
        if (game.isTerminal(state)) {
            ret.setFirst(game.utility(state, player));
            ret.setSecond(null);
            return ret;
        }
        int v = Integer.MAX_VALUE;
        for (String a : game.getActions(state)) {
            Tuple<Float, String> v2a2 = maxValue(game, game.result(state, a));
            if (v2a2.getFirst() < v) {
                ret.setFirst(v2a2.getFirst());
                ret.setSecond(a);
            }
        }
        return ret;
    }

    @Override
    public String getAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

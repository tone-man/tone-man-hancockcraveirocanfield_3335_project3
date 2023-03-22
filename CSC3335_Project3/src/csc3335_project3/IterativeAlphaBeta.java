/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

import java.util.Map;

/**
 *
 * @author ncrav
 */
public class IterativeAlphaBeta implements Searchable {

    private Map<State, Integer> transpositions;
    private int player;

    @Override
    public String search(Playable game, State state) {
        player = game.toMove(state);
        Tuple<Integer, String> max = maxValue(game, state, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return max.getSecond();
    }

    private Tuple<Integer, String> maxValue(Playable game, State state, int alpha, int beta) {
        Tuple<Integer, String> ret = new Tuple<>(null, null);
        if (game.isTerminal(state)) {
            ret.setFirst(game.utility(state, player));
            ret.setSecond(null);
            return ret;
        }
        int v = Integer.MIN_VALUE;
        for (String a : game.getActions(state)) {
            Tuple<Integer, String> v2a2 = minValue(game, game.result(state, a), alpha, beta);
            if (v2a2.getFirst() > v) {
                ret.setFirst(v2a2.getFirst());
                ret.setSecond(a);
                alpha = Math.max(alpha, v);
            }
            if (v >= beta) {
                return ret;
            }
        }
        return ret;
    }

    private Tuple<Integer, String> minValue(Playable game, State state, int alpha, int beta) {
        Tuple<Integer, String> ret = new Tuple<>(null, null);
        if (game.isTerminal(state)) {
            ret.setFirst(game.utility(state, player));
            ret.setSecond(null);
            return ret;
        }
        int v = Integer.MAX_VALUE;
        for (String a : game.getActions(state)) {
            Tuple<Integer, String> v2a2 = maxValue(game, game.result(state, a), alpha, beta);
            if (v2a2.getFirst() < v) {
                ret.setFirst(v2a2.getFirst());
                ret.setSecond(a);
                beta = Math.min(beta, v);
            }
            if (v <= alpha) {
                return ret;
            }
        }
        return ret;
    }

    @Override
    public String getAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

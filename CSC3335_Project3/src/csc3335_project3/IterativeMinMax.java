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
public class IterativeMinMax implements Runnable, Searchable{

    private Map<State, Integer> transpositions;
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String search(Playable game, State state) {
        return String.valueOf(IterMinMax(game, state, 5, 0));
    }
    
    private int IterMinMax(Playable game, State state, int depth, int player){
        //minimax implementation
        //https://www.javatpoint.com/mini-max-algorithm-in-ai
        if (depth == 0 || game.isTerminal(state)) {
            return game.utility(state, player);
        }
        if (player == 0) {
            int maxEva = Integer.MIN_VALUE;
            for (String move : game.getActions(state)) {
                State child = game.result(state, move);
                int eva = IterMinMax(game, child, depth - 1, 1);
                maxEva = Math.max(maxEva, eva);
            }
            return maxEva;
        }
        else {
            int minEva = Integer.MAX_VALUE;
            for (String move : game.getActions(state)) {
                State child = game.result(state, move);
                int eva = IterMinMax(game, child, depth - 1, 0);
                minEva = Math.min(minEva, eva);
            }
            return minEva;
        }
    }
    
    private Tuple<State, Integer> maxValue(Playable game, State state){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Tuple<State, Integer> minValue(Playable game, State state){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

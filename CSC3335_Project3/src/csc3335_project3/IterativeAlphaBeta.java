/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

/**
 *
 * @author ncrav
 */
public class IterativeAlphaBeta extends DepthLimitedAlphaBeta {

    public IterativeAlphaBeta(Playable game, Evaluable evaluator, int depth) {
        super(game, evaluator, depth);
    }
    
    @Override
    public String search(Playable game, State state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

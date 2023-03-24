/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snookie.util;

/**
 * Iterative AlphaBeta is the AlphaBeta algorithm over many iterations. Iterative
 * AlphaBeta will search starting at depth 1 until MAX_DEPTH is reached, or terminated early. 
 * Default MAX_DEPTH is 10. 
 * @author ncrav
 */
public class IterativeAlphaBeta extends DepthLimitedAlphaBeta {

    protected int MAX_DEPTH;
    
    public IterativeAlphaBeta(Playable game, Evaluable evaluator, int maxDepth) {
        super(game, evaluator, 1);
        this.MAX_DEPTH = maxDepth;
    }
    
    @Override
    public String search(Playable game, GipfState state) {
        int depth = 1;
        
        //While not deeper than MAX_DEPTH
        while (depth <= this.MAX_DEPTH)
        {
            //Set depth of this search
            super.depth = depth;
            
            //Search the state space
            super.search(game, state);
            depth++;
        }
        
        return super.bestAction;
    }

    public int getMaxDepth() {
        return MAX_DEPTH;
    }

    public void setMaxDepth(int maxDepth) {
        this.MAX_DEPTH = maxDepth;
    }
    
}

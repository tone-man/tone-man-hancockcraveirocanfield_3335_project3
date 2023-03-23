/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3.objects;

import csc3335_project3.objects.State;

/**
 * A basic implementation of eval that considers keeping material only.
 * @author Antonio Craveiro
 */
public class MaterialEval implements Evaluable{

    private int plr;
    private int opponent;
    
    @Override
    public float eval(Playable g, State s) {
        
        // Check if state is terminal
        if(g.isTerminal(s))
            return g.utility(s, plr);
        
        // Evauluate state of game
        // %giphs on board that agent has
        float value1 = (float) s.gipfsRemaining[this.plr] / 
                (s.gipfsRemaining[this.plr] + s.gipfsRemaining[this.opponent]);
        // %normal peices on board that agent has
        float value2 = (float) s.piecesLeft[this.plr] / 
                (s.piecesLeft[this.plr] + s.piecesLeft[this.opponent]);
        // %pieces in hand that agent has
        
        float value3 = 1;
        if (s.boardMaterial[this.plr] + s.boardMaterial[this.opponent] != 0)
            value3 = (float) s.boardMaterial[this.plr] / 
                (s.boardMaterial[this.plr] + s.boardMaterial[this.opponent]);

        return (float) ((float) 0.4*(value1) + 0.4*(value2) + 0.2*(value3));
        
        // 1. gipf pieces
        // 2. normal pieces
        // 3. anything else
        // gipfsRemaining;
        // piecesLeft;
        // public Integer[] boardMaterial;
        // if its your turn your 
        //  your things / your things + their things 

    }

    @Override
    public void setPlr(int plr) {
        this.plr = plr;
        this.opponent = (plr + 1) % 2;
    }    
}

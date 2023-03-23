/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package snookie.util;

import snookie.util.State;

/**
 *
 * @author ncrav
 */
public interface Evaluable {

    /**
     * Evaluates a state given a game.
     * @param g
     * @param s
     * @return
     */
    public float eval(Playable g, State s);
    
    /**
     * Informs the evaluator which player the agent is.
     * @param plr 
     */
    public void setPlr(int plr);
    
}

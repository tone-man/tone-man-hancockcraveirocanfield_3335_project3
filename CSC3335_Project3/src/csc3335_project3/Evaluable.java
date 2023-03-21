/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package csc3335_project3;

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
    // eval(Game: game, s : State): int
    public int eval(Playable g, State s);
    /**
        //run untility here or previously 
        State bestState = 0;
        for(int i = 0; state[i]; i++){//go through all the state's utiliy values
            
            if(i > bestState){
                bestState = i
            }// evaluating all the states
     //retruns the best state/move to make
    */      
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package csc3335_project3;

import java.util.ArrayList;

/**
 * Interface that allows a game to be played by an Agent.
 * @author Antonio Craveiro
 */
public interface Playable {
    
    /**
     * Returns whose turn it is to move in a given state.
     *
     * @param state State that is being examined
     * @return Integer indicating player turn
     */
    public int toMove(State state);
    
    /**
     * Gives all the possible actions the agent can take from a given state.
     *
     * @param state State that is being examined
     * @return ArrayList of all possible actions that can be taken from that
     * state.
     */
    public ArrayList<String> getActions(State state);
    
    /**
     * Gives the resulting board state of an action
     *
     * @param s State the board is currently in
     * @param action String representing the next move
     * @return Resulting board state of the action
     */
    public State result(State s, String action);
    
    /**
     * Determines if a given state is terminal.
     *
     * @param state State that is being examined
     * @return true if terminal State, false otherwise
     */
    public boolean isTerminal(State state);
    
    /**
     * Generates the utility value of a given state for a player.
     *
     * @param tState Terminal state that is being examined
     * @param plr Player that is being examined
     * @return Integer of 1 if win, 0 otherwise
     */
    public int utility(State tState, int plr);
    /**
        // simple utility that compares pieces in reserve and gipf pieces on the field

        //If it runs every turn our player will always be at a disatvatage 
        if (plr == OUR PLAYERS TURN) {
            for (int i = 0; i < tStatelist[i]; i++) { // checks the list of possible moves 
                if(pieces do not get removed OR plr gipf pieces == opponents gipf pieces ){
                    give the state +.1 //because relative to the reserves not much has changed
                } else if (plr gipf pieces > opponents gipf pieces) {
                    give that state +.3
                } else if (plr gipf pieces < opponents gipf pieces) {
                    give that state -.3
                }else //that means theres been a 4 in row 
                  give that state +.5     
            
               if(opponent has no more reserves Or No Gipf pieces){
                   give state +1       
               } else if (player has no more reserves OR no Gipf pieces){
                give state -1
               }      
            }
        } 
    */ 
     
    // unsure about places on the board because on one hand you want more pieces
    // on the board to controll and make moves but on the other you wanna make
    // 4 in a row to get your pieces back and maybe take off opponents pieces
}

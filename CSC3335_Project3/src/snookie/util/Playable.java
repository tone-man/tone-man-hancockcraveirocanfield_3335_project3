/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package snookie.util;

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
    public int toMove(GipfState state);
    
    /**
     * Gives all the possible actions the agent can take from a given state.
     *
     * @param state State that is being examined
     * @return ArrayList of all possible actions that can be taken from that
     * state.
     */
    public ArrayList<String> getActions(GipfState state);
    
    /**
     * Gives the resulting board state of an action
     *
     * @param s State the board is currently in
     * @param action String representing the next move
     * @return Resulting board state of the action
     */
    public GipfState result(GipfState s, String action);
    
    /**
     * Determines if a given state is terminal.
     *
     * @param state State that is being examined
     * @return true if terminal State, false otherwise
     */
    public boolean isTerminal(GipfState state);
    
    /**
     * Generates the utility value of a given state for a player.
     *
     * @param tState Terminal state that is being examined
     * @param plr Player that is being examined
     * @return Integer of 1 if win, 0 otherwise
     */
    public float utility(GipfState tState, int plr);
}

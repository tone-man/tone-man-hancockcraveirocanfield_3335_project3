package snookie.util;

import snookie.util.State;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 * Interface for searching over a state space.
 * @author ncrav
 */
public interface Searchable {
    
    /**
     * Searches a state space given a game
     * @param game The game that is being played
     * @param state The State the game is currently in
     * @return String - Best next move for the agent
     */
    public String search(Playable game, State state);
    
    /**
     * Returns the best action given the most recent state provided. This is
     * used in objects where the search is not complete or cancelled early.
     * @return String - next best move for the agent
     */
    public String getAction();
}

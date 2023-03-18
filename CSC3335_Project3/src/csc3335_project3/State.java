/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

/**
 * Our state object, or node, for the game
 * @author ncrav
 */
public class State {
    
    public int[] piecesLeft;
    public int[] gipfsRemaining;
    public int[][] board;
    public int plr;
    public String prevAction;
    
    public State(int[] piecesLeft, int[] gipfsRemaining, int[][] board, 
            int plr, String prevAction) 
    {
        
    }
    @Override
    public boolean equals(Object otherObject) {
              throw new UnsupportedOperationException("Not supported yet.");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snookie.util;

import csc3335.gipf_game.GipfGame;
import java.util.Arrays;
/**
 * Our state object, or node, for the game
 *
 * @author ncrav
 */
public class GipfState {

    public Integer[] piecesLeft;
    public Integer[] gipfsRemaining;
    public Integer[] boardMaterial;
    public Integer[][] board;
    public int turn;

    public GipfState(GipfState ostate){
        this.piecesLeft = Arrays.copyOf(ostate.piecesLeft, 2);
        this.gipfsRemaining = Arrays.copyOf(ostate.piecesLeft, 2);
        this.boardMaterial = Arrays.copyOf(ostate.boardMaterial, 2);
        this.turn = ostate.turn;
        
        //copy board across
        Integer[][] oboard = ostate.board;
        this.board = new Integer[oboard.length][];
        
        for (int col = 0; col < board.length; col++) {
            this.board[col] = new Integer[oboard[col].length];
            for (int pos = 0; pos < oboard[col].length; pos++) {
                this.board[col][pos] = oboard[col][pos];
            }
        }
    }
    
    /**
     * Generates a state using a GipfGame object.
     * A common issue is making sure to set the player's turn is set, since
     * gipfGame does not indicate that for you. Make sure you set it before 
     * working with the GipfAdapter getActions() or result().
     * @param g GipfGame that you want to turn into a state.
     */
    public GipfState(GipfGame g) {
        this.piecesLeft = new Integer[2];
        this.gipfsRemaining = new Integer[2];
        this.boardMaterial = new Integer[2];
        this.turn = -1;
        
        this.piecesLeft[0] = g.getPiecesLeft(0);
        this.piecesLeft[1] = g.getPiecesLeft(1);
        
        this.gipfsRemaining[0] = 0;
        this.gipfsRemaining[1] = 0;
        this.boardMaterial[0] = 0;
        this.boardMaterial[1] = 0;
        
        //get a copy of the board
        this.board = g.getBoardCopy();
        
        //read the board for material
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++){
                int piece = board[row][col];
                
                if (piece == GipfGame.WHITE_GIPF)
                    this.gipfsRemaining[0]++;
                else if (piece == GipfGame.BLACK_GIPF)
                    this.gipfsRemaining[1]++;
                else if (piece == GipfGame.WHITE)   
                    this.boardMaterial[0]++;
                else if (piece == GipfGame.BLACK)
                    this.boardMaterial[1]++;
                //otherwise the value is empty
                
            }//end of col
        }//end of row
        
    }//end constructor
    
    public GipfState clone() {
        return new GipfState(this);
    }
}

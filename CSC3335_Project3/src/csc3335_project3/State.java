/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

import csc3335.gipf_game.GipfGame;

/**
 * Our state object, or node, for the game
 * @author ncrav
 */
public class State {
    
    public int[] piecesLeft;
    public int[] gipfsRemaining;
    public int[] boardMaterial;
    public int[][] board;
    public int turn;
    public String prevAction;
    
    public State(int[][] board, int[] piecesLeft, int turn) 
    {
        this.piecesLeft = piecesLeft;
        this.boardMaterial = new int[2]; //tracks pieces on board?
        this.gipfsRemaining = new int[2];
        this.board = new int[9][];
        this.turn = turn;
        this.prevAction = null; //does this work for parenting? Prolly not...
        
        //read the board, and build a deep copy while incrementing piece counts
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
                
                //insert value into table
                this.board[row][col] = piece;
            }//end of col
        }//end of row
        
    }//end of constructor
    
    @Override
    public boolean equals(Object otherObject) {
              throw new UnsupportedOperationException("Not supported yet.");
    }
}

package csc3335_project3;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.Run;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Adapter that takes a GipfGame object and adapts it to the playable interface.
 * This makes it much easier to use with the codebase.
 * @author ncrav
 */
public class GipfAdapter implements Playable {
    
    public GipfGame gipfGame;
    public State initialState;
    public char[] letterValues = "abcdefghi".toCharArray();
    public static String[] edgeSpots = {"a 1", "a 2", "a 3", "a 4", "a 5", "b 1", "b 6",
        "c 1", "c 7", "d 1", "d 8", "e 1", "e 9", "f 1", "f 8", "g 1", "g 7", "h 1", "h 6",
        "i 1", "i 2", "i 3", "i 4", "i 5"};
    private static final Integer[][][] moves
            = {{{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}}, // a
            {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}}, // b
            {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}}, // c
            {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}}, // d
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}}, // e
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}}, // f
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}}, // g
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}}, // h
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}} // i
    };
    
    public GipfAdapter(GipfGame g) {
        this.gipfGame = g;
        edgeSpots = g.getEdgeSpots();
    }
    
    @Override
    public int toMove(State state){
        return state.turn;
    }
    
    @Override
    public ArrayList<String> getActions(State state) {
        
        ArrayList<String> actions = new ArrayList<>();
        
        //Copy gipf board data if state is null
        if (state == null)
            state = new State(this.gipfGame);
        
        //for each edgespot check direction
        for (String spot : edgeSpots){
            
            //for each possible direction of this edgespot, see if move can be made
            //TODO: Optimimize dir to only look at the moves possible
            for(int dir = 0; dir < 6; dir++) {
                
                String move = spot + " " + dir;
                if(isValidMove(spot, state.turn)){
                    //since move can be made append the action string to array
                    actions.add(move);
                }
                //do nothing if it cant be made
            }
        }
        return actions;
    } //end of getActions
    
    @Override
    public State result(State state, String action){
        
        //create a new state using the action that was provided
        System.out.println(action);
        // Then, make the move
        String[] pAction = action.split(" ");
        Integer col = this.convertLetterToIndex(pAction[0]);
        Integer pos = Integer.parseInt(pAction[1]) - 1;
        Integer dir = Integer.parseInt(pAction[2]);

        // First, check to see if the move is legal
        if (Arrays.binarySearch(edgeSpots, pAction[0] + " " + pAction[1]) < 0) {
            return null; //Probably raise an exception, as this should not happen
        }
        
        // Then, make the move
        boolean result = push(state.turn, col + moves[col][dir][0], pos + moves[col][dir][1], dir);
        if (result) 
            return state;
        //return that state
        
        return null;
    }
    

    @Override
    public boolean isTerminal(State state){
        if (state.piecesLeft[0] == 0) {
            return true;
        }
        if (state.piecesLeft[1] == 0) {
            return true;
        }
        if (state.gipfsRemaining[0] == 0) {
            return true;
        }
        if (state.gipfsRemaining[1] == 0) {
            return true;
        }
        return false;
    }
    

    @Override
    public int utility(State tState, int plr) {
        if (tState.piecesLeft[0] == 0) {
            if (plr == 0)
                return 0;
            
            return 1;
        }
        if (tState.piecesLeft[1] == 0) {
            if (plr == 1) {
                return 0;
            }

            return 1;
        }
        if (tState.gipfsRemaining[0] == 0) {
            if (plr == 0) {
                return 0;
            }

            return 1;
        }
        if (tState.gipfsRemaining[1] == 0) {
            if (plr == 1) {
                return 0;
            }

            return 1;
        }
        return 0;
    }
    
    
    private boolean isValidMove(State state, String move) {
        System.out.println(move);
        // Then, make the move
        String[] pMove = move.split(" ");
        Integer col = this.convertLetterToIndex(pMove[0]);
        Integer pos = Integer.parseInt(pMove[1]) - 1;
        Integer dir = Integer.parseInt(pMove[2]);

        // First, check to see if the move is legal
        if (Arrays.binarySearch(edgeSpots, pMove[0] + " " + pMove[1]) < 0) {
            return false;
        }
        
        // Then, see if the move puse
        return push(state.turn, col + moves[col][dir][0], pos + moves[col][dir][1], dir);
        
    }
    
    /**
     * This recursive method continues to push pieces forward until either a
     * blank is reached, or the algorithm realizes that a push is impossible.
     * The method relies on the ArrayIndexOutOfBoundsException to find
     * impossible pushes.
     *
     * @param piece The piece being pushed
     * @param col The column of the current intersection being pushed from
     * @param pos The position in the column of the current intersection being
     * pushed from
     * @param dir The direction being pushed
     * @return True if the push was successful, false if it failed
     * @throws ArrayIndexOutOfBoundsException
     */
    private boolean push(State state, Integer piece, Integer col, Integer pos, Integer dir)
            throws ArrayIndexOutOfBoundsException {
        // push to the next location
        Integer pieceToMove;
        boolean result;
        // If at the end of the row (and found an edge spot), the move's illegal
        if (!isLegalSpot(col, pos)) {
            return false;
        }
        try {
            // First, is the place we're in null? If so, then make the move and 
            //  return true
            Integer[][] board = state.board;
            if (board[col][pos].equals(GipfGame.EMPTY)) {
                board[col][pos] = piece;
                return true;
            }
            pieceToMove = board[col][pos];
            result = push(pieceToMove,
                    col + moves[col][dir][0], pos + moves[col][dir][1], dir);
        } catch (ArrayIndexOutOfBoundsException e) {
            result = false;
        }
        if (result) {
            board[col][pos] = piece;
        }
        return result;
    }

    /**
     * This method checks for runs of four or more of the same color and removes
     * the pieces accordingly.
     */
    public void checkForFourInARow() {
        ArrayList< Run> runs = new ArrayList();
        Integer curRun;
        Integer numInRun;
        int tempCol;
        int tempPos;
        // For each edge spot
        for (int col = 0; col < board.length; col++) {
            for (int pos = 0; pos < board[col].length; pos++) {
                // Is this the start of a four-in-a-row?
                for (int dir = 0; dir < 6; dir++) {
                    if (!board[col][pos].equals(GipfGame.EMPTY)) {
                        curRun = board[col][pos] % 2;
                        numInRun = 0;
                        tempCol = col;
                        tempPos = pos;
                        // Count the run
                        while (isInRange(tempCol, tempPos)
                                && isSamePlayer(board[tempCol][tempPos], curRun)) {
                            tempPos += moves[tempCol][dir][1];
                            tempCol += moves[tempCol][dir][0];
                            numInRun++;
                        }
                        if (numInRun >= 4) {
                            // Add the run to our list of runs
                            runs.add(new Run(numInRun, curRun, col, pos, dir));
                        }
                    }
                }
            }
        }

        System.out.println("Processing " + runs.size() + " runs.");
        // Now, we must handle all the runs we found
        for (Run r : runs) {
            Integer col = r.startingCol;
            Integer pos = r.startingPos;
            Integer dir = r.direction;
            // First, remove all the like pieces that aren't gipf pieces
            Integer pieceType = (r.playerValue % 2) + 2;
            Integer numPieces = 0;
            while (numPieces < r.runLength) {
                if (board[col][pos].equals(pieceType)) {
                    board[col][pos] = GipfGame.EMPTY;
                    piecesLeft[pieceType % 2]++;
                }
                col += moves[col][dir][0];
                pos += moves[col][dir][1];
                numPieces++;
            }
            // Then remove the non-player colors from the ends
            while (this.isInRange(col, pos)
                    && !board[col][pos].equals(GipfGame.EMPTY)
                    && !board[col][pos].equals(pieceType)
                    && !board[col][pos].equals(pieceType - 2)) {
                // If the piece removed is a GIPF, updated Gipfs remaining
                if( board[col][pos] < 2 ) {
                    this.gipfsRemaining[(pieceType+1)%2]--;
                }
                board[col][pos] = GipfGame.EMPTY;
                col += moves[col][dir][0];
                pos += moves[col][dir][1];
            }
        }
    }

    private boolean isInRange(int col, int pos) {
        return col >= 0 && col < board.length
                && pos >= 0 & pos < board[col].length;
    }

    private Integer convertLetterToIndex(String letter) {
        return Arrays.binarySearch(this.letterValues, letter.charAt(0));
    }

    private String convertColToLetter(Integer col) {
        if (col < this.columns.length && col >= 0) {
            return this.columns[col];
        }
        return null;
    }

    private boolean isSamePlayer(Integer piece, Integer curRun) {
        return (piece % 2 == curRun % 2) && !piece.equals(GipfGame.EMPTY);
    }

    private boolean isLegalSpot(Integer col, Integer pos) {
        return Arrays.binarySearch(edgeSpots, convertColToLetter(col) + " " + (pos + 1)) < 0;
    }
}
    

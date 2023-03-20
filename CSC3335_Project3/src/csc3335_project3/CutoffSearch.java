/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

/**
 *
 * @author ncrav
 */
public class CutoffSearch implements Searchable {

    private Evaluable evaluator;
    private Thread searchThread;
    private int searchCutoff;
    private int evalCutoff; //Unsure if neccessary
    
    public CutoffSearch(Runnable search, Evaluable evaluator) {
        this.evaluator = evaluator;
        this.searchThread = new Thread(search);
    }
    
    @Override
    public String search(Playable g, State s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

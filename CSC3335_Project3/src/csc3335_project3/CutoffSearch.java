/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ncrav
 */
public class CutoffSearch implements Searchable, Runnable {

    private Playable game;
    private Evaluable evaluator;
    private Searchable algorithm;
    private Thread searchThread;
    private String result;
    private State curState;
    private int searchCutoff = 5000;
    private int evalCutoff; //Unsure if neccessary
    
    public CutoffSearch(Playable g, State s, Searchable search, Evaluable evaluator) {
        this.game = g;
        this.algorithm = search;
        this.evaluator = evaluator;
        this.curState = s;
        this.result = null;
        this.searchThread = new Thread(this);
    }
    
    @Override
    public String search(Playable g, State s) {
        
        //Reset result
        result = null;
        
        //Update state
        this.curState = s;
        
        try {
            //Run the search
            searchThread.start();
            
            Thread.sleep(searchCutoff);
            
            //Cut search off after searchCutoff
            searchThread.interrupt();
            
            //Wait for thread to join
            searchThread.join();
                
        } catch (InterruptedException ex) {
            result = algorithm.getAction();
            return result;
        }
        
        //return the resulting action
        result = algorithm.getAction();
        return result;
    }

    @Override
    public String getAction() {
        return result;
    }

    @Override
    public void run() {
        this.algorithm.search(this.game, this.curState);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snookie.util;

import snookie.util.Searchable;
import snookie.util.State;

/**
 *
 * @author ncrav
 */
public class CutoffSearch implements Searchable, Runnable {

    private Playable game;
    private Searchable algorithm;
    private String result;
    private State curState;
    private int searchCutoff = 4900;
    private int evalCutoff; //Unsure if neccessary
    
    public CutoffSearch(Playable g, State s, Searchable search) {
        this.game = g;
        this.algorithm = search;
        this.curState = s;
        this.result = null;
    }
    
    @Override
    public String search(Playable g, State s) {
        
        //Reset result
        result = null;
        
        //Update state
        this.curState = s;
        
        //Create thread
        Thread searchThread = new Thread(this);
        
        try {
            //Run the search
            searchThread.start();
            
            Thread.sleep(searchCutoff);
            
            //Cut search off after searchCutoff
            searchThread.stop();
            
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

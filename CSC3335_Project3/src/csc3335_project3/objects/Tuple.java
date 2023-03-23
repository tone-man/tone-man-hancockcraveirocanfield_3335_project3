/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc3335_project3.objects;

import java.util.Objects;

/**
 * Tuple is a set of two Objects.
 * @author Antonio Craveiro
 * @param <T1>
 * @param <T2>
 */
public class Tuple<T1, T2> {
    private T1 first;
    private T2 second;
    
    public Tuple(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the first entry.
     * @return T1
     */
    public T1 getFirst() {
        return first;
    }

    /**
     * Sets the first entry.
     * @param first
     */
    public void setFirst(T1 first) {
        this.first = first;
    }

    /**
     * Gets the second entry.
     * @return T2
     */
    public T2 getSecond() {
        return second;
    }

    /**
     * Sets the second entry.
     * @param second
     */
    public void setSecond(T2 second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Tuple{" + "first=" + first + ", second=" + second + '}';
    }
    

}

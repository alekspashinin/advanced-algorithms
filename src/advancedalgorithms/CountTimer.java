/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedalgorithms;


public class CountTimer {
long start;
long finish;
long timeElapsed;

public long start(){
    start = System.nanoTime();
    return start;
}

public long stop(){
    long finish = System.nanoTime();
    timeElapsed = finish - start;
    return timeElapsed;
}

public CountTimer(){
}

}
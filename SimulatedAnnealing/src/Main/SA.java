/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Random;

/**
 *
 * @author Someone
 */
public class SA {
    private final double coolingRate = 0.00025;
    private Fungsi fn = new Fungsi();
    private double solution, x, y;
        
    public void getSoulution(double minx, double maxx, double miny, double maxy){
        this.solution = Double.MAX_VALUE;
        double current, E;
        int i = 0;
        System.out.println("i\tTemp\tx1\tx2\tf(x)");
        
        for(double T = 100000.0; T>0.0001; T*=1-coolingRate){
            double randomValue1 = minx + (maxx - minx) * new Random().nextDouble();
            double randomValue2 = miny + (maxy - miny) * new Random().nextDouble();            
            
            current = fn.calc(randomValue1, randomValue2);
            
            if(current<this.solution){
                this.solution = current;
                this.x = randomValue1;
                this.y = randomValue2;
            }else{
                E = current - this.solution;
                if(Math.exp(-E/T)>new Random().nextDouble()){
                    this.solution = current;
                    this.x = randomValue1;
                    this.y = randomValue2;
                }
            }            
            
            i++;
            System.out.println(i+"\t"+T+"\t"+this.x+"\t"+this.y+"\t"+this.solution);
        }
    }
    
    public void showAccuracy(double fr){
        System.out.println("accuracy : " + fn.accuracy(this.solution, fr) + "%");
    }
}

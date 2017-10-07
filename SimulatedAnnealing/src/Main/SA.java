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
        double current, E, P, BestSoFar;
        int i = 0;
        System.out.println("i\tTemp\tx1\tx2\tf(x1,x2)");
        
        double randomValue1 = minx + (maxx - minx) * new Random().nextDouble();
        double randomValue2 = miny + (maxy - miny) * new Random().nextDouble();            

        BestSoFar = fn.calc(randomValue1, randomValue2);
        
        for(double T = 100000.0; T>0.0001; T*=1-coolingRate){
            
            double minx1 = minx - randomValue1;
            double miny1 = miny - randomValue2;
            double maxx1 = maxx - randomValue1;
            double maxy1 = maxy - randomValue2;
            
            randomValue1 += minx1 + (maxx1 - minx1) * new Random().nextDouble();
            randomValue2 += miny1 + (maxy1 - miny1) * new Random().nextDouble();          
                        
            current = fn.calc(randomValue1, randomValue2);
            
            if(current<BestSoFar){
                BestSoFar = current;
                this.x = randomValue1;
                this.y = randomValue2;
            }else{
                E = current - BestSoFar;
                P = Math.exp(-E/T);
                if(P>new Random().nextDouble()){
                    BestSoFar = current;
                    this.x = randomValue1;
                    this.y = randomValue2;
                }
            }          
            
            i++;
            System.out.println(i+"\t"+T+"\t"+this.x+"\t"+this.y+"\t"+BestSoFar);
        }
        
        this.solution = BestSoFar;
    }
    
    public void showSolution(){
        System.out.println("Solution:");
        System.out.println("x1: "+this.x);
        System.out.println("x2: "+this.y);
        System.out.println("f(x1,x2): "+this.solution);
    }
    
    public void showAccuracy(double fr){
        System.out.println("accuracy : " + fn.accuracy(this.solution, fr) + "%");
    }
}

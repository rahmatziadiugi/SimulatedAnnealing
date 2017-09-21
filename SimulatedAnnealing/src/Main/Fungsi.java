/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Someone
 */
public class Fungsi {    
    public double calc(double x1, double x2){
        double a = 4 - (2.1 * (Math.pow(x1, 2))) + ((Math.pow(x1, 4))/3);
        a += (x1*x2);
        a += (((-4)+(4*Math.pow(x2, 2)))*Math.pow(x2, 2));
        
        return a;
    }
    
    public double accuracy(double fa, double fr){
        double acc = (1.0-((fa-fr)/fr))*100.0;
        return acc;
    }
}

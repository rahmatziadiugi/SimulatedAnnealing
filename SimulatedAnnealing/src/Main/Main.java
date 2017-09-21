/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.SA;
import java.util.Scanner;

/**
 *
 * @author Someone
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SA simulateAnnealing = new SA();
        
        simulateAnnealing.getSoulution(-10.0, 10.0, -10.0, 10.0);
        
        System.out.println("input fr : ");
        simulateAnnealing.showAccuracy(new Scanner(System.in).nextDouble());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.concurrent.Semaphore;
import controller.Corredor;
/**
 *
 * @author bruno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int permissoes=1;
        Semaphore semaforo=new Semaphore(permissoes);
        for(int pessoa=0;pessoa<4;pessoa++){
            Thread tCorredor=new Corredor(pessoa,semaforo);
            tCorredor.start();
        }
    }
    
}

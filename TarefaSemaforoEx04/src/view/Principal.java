/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Banco;
import java.util.concurrent.Semaphore;

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
        for(int codigoConta=10;codigoConta<20;codigoConta++){
            Thread tSaque=new Banco(codigoConta,semaforo);
            tSaque.start();
        }
        for(int codigoConta=0;codigoConta<10;codigoConta++){
            Thread tDeposito=new Banco(codigoConta,semaforo);
            tDeposito.start();
        }
        
    }
    
}

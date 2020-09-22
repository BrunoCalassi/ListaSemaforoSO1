/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Carro;
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
        for(int idCarro=0;idCarro<4;idCarro++){
            Thread tCarro=new Carro(idCarro,semaforo);
            tCarro.start();
        }
    }
    
}

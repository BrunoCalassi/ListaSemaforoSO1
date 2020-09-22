/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author bruno
 */
public class Carro extends Thread {
    private int idCarro;
    private Semaphore semaforo;
    private static int posSaida;
    private static String sentido;
    
    public Carro(int idCarro,Semaphore semaforo){
        this.idCarro=idCarro;
        this.semaforo=semaforo;
    }

    @Override
    public void run() {
        carroAndando();
        try {
            semaforo.acquire();
            Cruzamento();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally{
            semaforo.release();
            carroSaindo();
        }
    }

    private void carroAndando() {
            int tempo=(int)((Math.random()*1001)+9000);//1 a 10
            try {
                sleep(tempo);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    private void Cruzamento() {
        Random random = new Random();
	int rd = random.nextInt(4);
	switch(rd){
		case 1:
			sentido = "norte";
                        System.out.println("carro " + idCarro + " está no sentido " + sentido);
			break;
		case 2:
			sentido = "sul";
                         System.out.println("carro " + idCarro + " está no sentido " + sentido);
			break;
		case 3:
			sentido = "leste";
                         System.out.println("carro " + idCarro + " está no sentido " + sentido);
			break;
		default:
			sentido = "oeste";
                         System.out.println("carro " + idCarro + " está no sentido " + sentido);
			break;
	}
	try {
		sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    }
    private void carroSaindo() {
        posSaida++;
        System.out.println("#" + idCarro+" foi o  " + posSaida+"° a sair");
        
    }
}

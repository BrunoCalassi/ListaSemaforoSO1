/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.Thread.sleep;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author bruno
 */
public class Formula1 extends Thread {
    private int idCarro;
    private static String escuderia;
    private Semaphore semaforo;
    private static double tempomenor;
    private static int volta;
    private static int i;
    private double vetor[]=new double[14];
    
    public Formula1(int idCarro,Semaphore semaforo){
        this.idCarro=idCarro;
        this.semaforo=semaforo;
    }

    @Override
    public void run() {
        selecao();
        //inicio seção critica
        try {
            semaforo.acquire();
            carroCorrendo();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally{
            semaforo.release();
            //fim seção critica
            Podium();
        }
    }

    private void selecao() {
        Random random = new Random();
	int rd = random.nextInt(7);
        try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
       
            switch(rd){
                
                case 1:
                        escuderia = "Ferrari";
                        System.out.println("carro " + idCarro + " da " + escuderia);
                        break;
		case 2:
			escuderia = "Mercedes";
                         System.out.println("carro " + idCarro + " da " + escuderia);
			break;
		case 3:
			escuderia = "Alfa Romeo";
                         System.out.println("carro " + idCarro + " da " + escuderia);
			break;
                 case 4:
			escuderia = "McLaren";
                         System.out.println("carro " + idCarro + " da " + escuderia);
			break;
                 case 5:
			escuderia = "Williams";
                         System.out.println("carro " + idCarro + " da " + escuderia);
			break;
                 case 6:
			escuderia = "Reanault";
                         System.out.println("carro " + idCarro + " da " + escuderia);
			break;
		default:
			escuderia = "Red Bull";
                         System.out.println("carro " + idCarro + " da " + escuderia);
			break;
	}
        
        try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    private void carroCorrendo() {
        System.out.println("# " + idCarro+ " da " + escuderia+ " começou a correr ");
        while(volta<3){
            double tempo=((Math.random()*2001)+3000);
            volta++;
            System.out.println("O tempo da " + volta + "° volta foi de " + tempo/1000+ " minutos");
            if(volta==0){
            tempomenor=tempo;
            }if(tempo<tempomenor){
            tempomenor=tempo;
            }
        }volta=0;
        try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        for(int k=0;k<14;k++){
            vetor[k]=tempomenor;
        }
    }

    private void  Podium() {
        try {
                sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        Arrays.sort(vetor);
        i++;
        System.out.println( idCarro+" da  " + escuderia+" esta saindo na "+ i+"° posição com o a melhor volta de " + vetor[i-1] +" minutos.");
        
    }
}

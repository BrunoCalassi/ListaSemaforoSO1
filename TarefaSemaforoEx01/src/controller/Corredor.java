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
public class Corredor extends Thread {
    private int pessoa;
    private static int posChegada;
    private static int posSaida;
    private Semaphore semaforo;

    public Corredor(int pessoa, Semaphore semaforo) {
        this.pessoa = pessoa;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            pessoaAndando();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally{
            semaforo.release();
            cruzarPorta();

        }
    }

    private void pessoaAndando() {
        Random rd=new Random();
        int distanciaPercorrida=0;
        int deslocamento=rd.nextInt((6-4)+1)+4;
        int tempo=1000;
        while(distanciaPercorrida<200){
            distanciaPercorrida+=deslocamento;
            try {
                sleep(tempo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("A pessoa " + pessoa+" ja andou " + distanciaPercorrida+"m.");
    }
            posChegada++;
            System.out.println("A pessoa " + pessoa+" foi o "+posChegada+"° a chegar ");
    }

    private void cruzarPorta() {
        System.out.println("A pessoa" + pessoa+" abriu a porta e cruzou ");
        int tempo=(int)((Math.random()*1001)+1000);
        try {
                sleep(tempo);
                System.out.println("A pessoa " + pessoa+" demorou " + tempo/1000+" para passar pela porta");

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

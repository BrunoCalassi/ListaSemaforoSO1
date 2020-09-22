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
public class Banco extends Thread{
    private int codigoConta;
    private static int saldo;
    private static int valor;
    private int saque;
    private int deposito;
    private Semaphore semaforo;

    public Banco(int codigoConta, Semaphore semaforo) {
        this.codigoConta = codigoConta;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        
        try {
            semaforo.acquire();
            separacao();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally{
            semaforo.release();
            finalizar();
        }
    }

    private void separacao() {
        try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        if(codigoConta%2==0){
            calculoSaque();
        }else{
            calculoDeposito();
        }
    }
    
    private void calculoSaque() {
        try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        Random random = new Random();
	int rd = random.nextInt(1000);
        saldo=rd;
        valor=rd;
        saldo-=valor;
        System.out.println("O codigo " + codigoConta + " realizou um Saque de:"+valor +"em sua conta cujo saldo é: "+ saldo);
    }
    private void calculoDeposito() {
        try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        Random random = new Random();
	int rd = random.nextInt(1000);
        saldo=rd;
        valor=rd;
        saldo+=valor;
        System.out.println("O codigo " + codigoConta + " realizou um Deposito de:"+valor +"em sua conta cujo saldo é: "+ saldo);
    }

    private void finalizar() {
        System.out.println("O codigo " + codigoConta + " esta finalizando sua transação");
    }
}

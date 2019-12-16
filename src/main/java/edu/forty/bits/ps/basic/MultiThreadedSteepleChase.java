package edu.forty.bits.ps.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedSteepleChase {

    /**
     * Don't simply execute this code for the sake of it. Understand the difference between the
     * responsive and the oblivious thread created below.
     *
     * @param args convertNumbersToName args
     * @throws Exception when trying to interrupt the thread forcefully
     */
    public static void main(String[] args) throws Exception {

        /*
         * A Thread which is responsive to Interruption.
         */
        class ResponsiveToInterruption extends Thread {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("[Interruption Responsive Thread] Alive");
                }
                System.out.println("[Interruption Responsive Thread] bye**");
            }
        }

        /*
         * Thread that is oblivious to Interruption. It does not even check it's
         * interruption status and doesn't even know it was interrupted.
         */
        class ObliviousToInterruption extends Thread {
            @Override
            public void run() {
                while (true) {
                    System.out.println("[Interruption Oblivious Thread] Alive");
                }
                // The statement below will never be reached.
                //                System.out.println("[Interruption Oblivious Thread] bye");
            }
        }

        /*
         * Thread that checks for interruption, but calls a blocking method
         * that doesn't detect Interruptions.
         */
        class InterruptibleShesNot extends Thread {

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        ServerSocket server = new ServerSocket(8080);
                        Socket client = server.accept(); // This method will not
                        // return or 'unblock'
                        // until a client connects
                    } catch (IOException ignored) {
                    }
                }
            }
        }

        Thread theGood = new ResponsiveToInterruption();
        Thread theUgly = new ObliviousToInterruption();

        theGood.start();
        theUgly.start();

        theGood.interrupt(); // The thread will stop itself
        theUgly.interrupt(); // Will do nothing
    }
}
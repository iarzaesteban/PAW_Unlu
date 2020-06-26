package Pto4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket (9003);
			System.out.println( " OK FUNCIONANDO en el puerto 9003");
			
			while(true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Socket cliente = ss.accept();
				ServerHijo sh = new ServerHijo(cliente);
				Thread shThread = new Thread(sh);			
				shThread.start();
	
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}

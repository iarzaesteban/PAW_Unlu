package Pto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
	public static void main( String[] args )
    {
       try {
    	// Primero se crea el servidor.
		ServerSocket ss= new ServerSocket(8000);
		System.out.println("OK conectado en el puerto 8000");
		
		while(true) {
			//acepto clientes
			Socket cliente = ss.accept();
			System.out.println(" CLIENTE RECIBIDO: "+cliente.getInetAddress().getCanonicalHostName() + "Port : " +cliente.getPort());

			
			//establecer canal tcp, 2 canales, de entrada y salida	
			BufferedReader canalEntrada = new BufferedReader(new InputStreamReader ( cliente.getInputStream()));
			PrintWriter canalSalida= new PrintWriter(cliente.getOutputStream(), true); 
			
			//leer del cliente
			String msgEntrada= canalEntrada.readLine();
			
			
			msgEntrada += " El mensaje del cliente fue = " + msgEntrada;
			
			//respuesta al cliente
			canalSalida.println(msgEntrada);
			
			cliente.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("ERROR al conectarse al puerto 8000");
	}
    }

}

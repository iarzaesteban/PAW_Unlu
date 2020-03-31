package Pto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
    		
    		public static void main(String[] args) {
    			try {
    				//conectarse con el servidor
    				Socket s = new Socket("127.0.0.1", 8000);
    				
    				//establecer canal
    				BufferedReader canalEntrada = new BufferedReader(new InputStreamReader ( s.getInputStream()));
    				PrintWriter canalSalida= new PrintWriter(s.getOutputStream(), true); //true es para que cuando haga un canal de salida haga flush solo

    				// Paso 3 - Enviar petición al servidor 
    				canalSalida.println( "Soy un cliente ");
    							
    				// Paso 4 - Recibir la respuesta
    				String msgRespuesta = canalEntrada.readLine();
    				
    				
    				System.out.println(msgRespuesta);
    
    				s.close();
    			} catch (UnknownHostException e) {
    				e.printStackTrace();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
}

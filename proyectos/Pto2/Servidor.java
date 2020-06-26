package Pto2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main( String[] args){
    	
    	try {
			// PASO 1 - Crear servidor (puerto)
    		ServerSocket ss = new ServerSocket (8000);
			System.out.println( " OK FUNCIONANDO en el puerto 8000");
			
			// Paso 2 (repetitivo)
			while (true) {
				// aceptar clientes
				Socket cliente = ss.accept();
				System.out.println(" CLIENTE RECIBIDO: "+cliente.getInetAddress().getCanonicalHostName() + " Port: " +cliente.getPort());
				
				// COMO HACER UN THREAD
				// 1 - Instanciar la clase
				ServerHijo sh = new ServerHijo(cliente);
				// 2 - Crear un thread y decirle que va a ejecutar con la instancia X
				Thread shThread = new Thread(sh);
				// 3 - Ejecutar el hilo (start)
				shThread.start();
				
			}
			
			
			
		} catch (IOException e) {
			System.err.println( " PUERTO EN USO");
		} 
    	
      
    }

}

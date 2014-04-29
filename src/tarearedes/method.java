package tarearedes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;


public class method {
	
	public PrintWriter salida = null;
	private Socket socket = null;
	method(Socket clienteExt)
	  {
	    
	    socket = clienteExt;
	    
	  }
			
		
	
	
	//Petición GET
	  void get(String archivo) throws UnsupportedEncodingException, IOException
	  { 
		  //se instancia el elemento que permite responder al servidor
		  salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "8859_1"), true);
	    
	    if (archivo.startsWith("/")) {
	      archivo = archivo.substring(1); 
	    }
	    
	    
	    
	    //Se verifica el como termina la ruta y se le agrega "index.html"
	    if ((archivo.endsWith("/")) || (archivo.equals(""))) {
	      archivo = archivo + "index.html";
	      
	    
       
        
	    }
	    
	    String basePath = new File("").getAbsolutePath();
	    System.out.println(basePath);
	    try
	    {
	      
	      File arch = new File(archivo);
	      if (arch.exists())
	      {
	        //Se verifica la extensión de cada archivo
	        if (archivo.endsWith("html"))
	        {
	          salida.println("HTTP/1.1 200 ok");
	          salida.println("Content-Type: text/html");
	          salida.println("Content-Length: " + arch.length());
	          salida.println("\n");
	        }
	        
	        else if (archivo.endsWith("js"))
	        {
	          salida.println("HTTP/1.1 200 ok");
	          

	          salida.println("Content-Type: application/javascript");
	          salida.println("Content-Length: " + arch.length());
	          salida.println("\n");
	        }
	        
	        else if (archivo.endsWith("css"))
	        {
	          salida.println("HTTP/1.1 200 ok");
	          salida.println("Content-Type: text/css");
	          salida.println("Content-Length: " + arch.length());
	          salida.println("\n");
	        }
	        
	        //Se crea el archivo para leer el html
	        BufferedReader leer = new BufferedReader(new FileReader(arch));
	        

	        String linea = "";
	      
	        do
	        {
	          linea = leer.readLine();
	          if (linea != null) {
	            salida.println(linea);
	          }
	        } while (linea != null);
	        
	        
	        leer.close();
	        socket.close();
	      }
	      else
	      {
	        
	        socket.close();
	      }
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	     
	    }
	  }
	  
	  
	  public void post() {
		  
		  //Aquí va el ingreso post
	    
	  }

}
	  


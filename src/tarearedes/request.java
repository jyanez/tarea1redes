package tarearedes;


import java.net.*;
import java.io.*; 
import java.util.*;



public class request extends Thread
{
	
	

  
  private Socket socket = null;
  private PrintWriter salida = null;
  
  request(Socket clienteExt)
  {
    
    socket = clienteExt;
   
  }
  
  //Se ejecuta el thread
  public void run()
  {
	  
    try
    {
      // Se instancia el elemento que permite leer la petición
      BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      
      //Se instancia el elemento que responde a la petición
      salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "8859_1"), true);
      
      String cadena = entrada.readLine();
      
     
      int i = 0;
      do
      {
        
       
       
        
        if (i == 0)
        {
          i++;
          
          StringTokenizer st = new StringTokenizer(cadena);
          String metodo=st.nextToken();
          if ((st.countTokens() >= 2) && (metodo.equals("GET"))) {
            
        	
        	method met = new method(socket);
        	met.get(st.nextToken()); //Se llama a get, de la clase method
            
        	//RetornarArchivo(st.nextToken());
          } 
          else if((st.countTokens() >= 2) && (metodo.equals("POST"))){
             
             
        	  //method met = new method(socket);
              
              //met.post();
              
        	  
          }
          
          else {
            salida.println("HTTP/1.1 400 Not Found"); //si no existe el archivo
          }
        }
        
      } while (cadena != null && cadena.length() != 0);
    }
    catch (Exception e)
    {
      
      salida.close();
    }
   
    salida.close();
  }
  
  
 }

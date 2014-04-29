package tarearedes;


import java.net.ServerSocket;
import java.io.*; 



public class server
{
   
  
	ServerSocket client;
	int puerto = 8080; //Puerto que permitirá abrir la web
  
 
  
  public static void main(String[] array)
  {
    
    try{
        String basePath = new File("").getAbsolutePath();
        File archivo = new File(basePath+ "/contactos.txt");
        if(archivo.exists()){
           
        }
        else{
            
            FileWriter contact ;
            PrintWriter contactos ;
            
            //Se crea el archivo que se utilizará como base de datos
            contact = new FileWriter("contactos.txt");
            contactos = new PrintWriter(contact);
            
            contactos.close();
        }
       
        
      
    }
    catch (IOException e) {
            e.printStackTrace();
    }
	  
    //Se instancia el servidor y luego se inicia 
    server servidor = new server();
    servidor.inicio();
  }
  
  public boolean inicio()
  {
	 
    try
    {
        client = new ServerSocket(puerto);
        
      while(true)
      {
    	  
    	          
    	  //Se instancia un cliente
    	  
    	  request req = new request(client.accept());
    	  req.start();
      }
    }
    catch (IOException e)
    {
    	
    }
    return true;
  }
}

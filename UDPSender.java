import java.net.*;
import java.util.Scanner;

public class UDPSender {

	public static void main(String[] args) 
   {
	      // Check the arguments
	      if( args.length != 3 )
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port         = Integer.parseInt( args[1] ) ;
	         socket = new DatagramSocket() ;
     
	         Scanner in;
	         in = new Scanner (System.in);
	         String message = null;
	         int n = args[2]
	         for(int i = 0; i< n;i++)
	         {
	        		 message = "Message " + n;
	        		 byte [] data = message.getBytes() ;
	        		 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        		 socket.send( packet ) ;
	        		 
	        		 print("Waiting to receive packet...")
	    	         for( ;; )
	    	         {
	    		        System.out.println( "Receiving on port " + port ) ;
	    		        DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	    	            socket.receive( packet ) ;
	    	            break;
	    	        }  
	    	         
	         } 
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

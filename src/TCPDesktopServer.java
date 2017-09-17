import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
//Download by http://www.codefans.net
public class TCPDesktopServer implements Runnable{

 
    public static final String SERVERIP = "192.168.1.100";

    public static final int SERVERPORT = 10002;

 
    public void run() {

         try {

             System.out.println("S: Connecting...");

             ServerSocket serverSocket = new ServerSocket(SERVERPORT);

             while (true) {

                  Socket client = serverSocket.accept();

                  System.out.println("S: Receiving...");
 
                  try {

                      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                      int l=in.read();
                      System.out.println("S: Received: '" + l + "'");

                      String str = in.readLine();
                      byte b[]=str.getBytes();

                      System.out.println("S: Received: '" +   "'");
                      for(int i=0;i<l;i++)
                      {
                    	  System.out.print("0x"+Integer.toHexString(b[i])+" ");
                      }
                      System.out.println("end'" +   ".");

                    } catch(Exception e) {

                        System.out.println("S: Error");

                        e.printStackTrace();

                    } finally {

                        client.close();

                        System.out.println("S: Done.");

                    }

             }

          } catch (Exception e) {

             System.out.println("S: Error");

             e.printStackTrace();
         }
    }
 
   public static void main (String a[]) {

        Thread desktopServerThread = new Thread(new TCPDesktopServer());

        desktopServerThread.start();
    }
}

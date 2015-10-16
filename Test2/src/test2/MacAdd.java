/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Fortesys
 */
public class MacAdd {
     public static void main(String[] args) throws InterruptedException{
		
	InetAddress ip;
      
	try {
			
		ip = InetAddress.getLocalHost();
		System.out.println("IP address : " + ip.getHostAddress());
                System.out.println("Host Name : " + ip.getHostName());
                System.out.println("Canonical Host Name : " + ip.getCanonicalHostName());
              
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		System.out.print("Current MAC address : ");
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(sb.toString());
               
                InetAddress[] link6 = InetAddress.getAllByName(ip.getHostName());
                for (InetAddress ipv6 : link6){ 
                    if (ip instanceof InetAddress)
                        System.out.println("ipv6 address is :" + ipv6.getHostAddress());
                    else 
                        System.out.println("ipv4 address is :" + ipv6.getHostAddress());
                
               }
                
               //Sleeping Thread Feature
                int threadNum = 3;
                int count = 2;
                Thread[] th = new Thread[threadNum];
                System.out.println("Threads are creating...");
                System.out.println("Starting Sleeping Threads...");
                for(int seq = 0; seq<th.length; seq++)
                {
                    th[seq] = new Thread(new SleepThread("Runner "+seq, count));
                    th[seq].start();
                    th[seq] = new SleepThread(th[seq].getName(),count);
                }
                System.err.println("Sleeping Thread is Started!");
			
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}	    
   }
}

class SleepThread extends Thread
{
    private String name;
    private int count;
    private int sleepTime;
    
    public SleepThread(String name, int count){
        this.name = name;
        this.count = count;
        
        sleepTime = (int)(Math.random()*2000);
        System.err.println(name+" >> Sleep Time : "+sleepTime );
    }
    
    public void run()
    {
        try 
        {
            for(int i = 0; i<count; i++)
            {
                System.out.println(name +" :: "+ i);
            }
            System.err.println(getName()+" going to sleep...");
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.err.println(getName()+ " done sleeping!");
    }
}

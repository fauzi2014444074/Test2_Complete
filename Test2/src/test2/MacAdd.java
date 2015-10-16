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
/**
 *
 * @author Fortesys
 */
public class MacAdd {
     public static void main(String[] args){
		
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
			
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
	    
   }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javascrap;

import org.jsoup.*;

 import org.jsoup.nodes.*;
 import org.jsoup.select.*;

/**
 *
 * @author Fortesys
 */
public class JavaScrap {
    

    public static void main(String[] args) {
      try{

            Document doc = Jsoup.connect("http://fskm.uitm.edu.my/v1/fakulti/staff-directory/academic/1097.html").timeout(10*1000).get();
            String title = doc.title();

            Element table = doc.getElementById("mytable");
            Elements rows = table.getElementsByTag("tr");
            
            for (Element row : rows) {
                Elements tds = row.getElementsByTag("td");
                for (int i = 0; i < tds.size(); i++) {
                    if (i == 1) System.out.println(tds.get(i).text());
                }
            }                           
        }
        catch (java.io.IOException ex) {
            System.out.println("IO Error: " + ex);
            }
    }
    
}

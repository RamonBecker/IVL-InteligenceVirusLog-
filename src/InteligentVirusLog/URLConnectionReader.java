/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteligentVirusLog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLConnectionReader {

    public String consultaVirusSite(String nomeVirus){
        Document doc; //"http:www.avira.com/pt-br/support-virus-lab?vdl%5Bsq%5D= B a c k d o o r . G e n"                                      
        String urll = String.valueOf("http://www.avira.com/pt-br/support-virus-lab?vdl%5Bsq%5D="+nomeVirus);
        
        //String urll = String.valueOf(nomeVirus);
        String href= "";
        try {
            System.out.println("lala: " + urll);
            doc = Jsoup.connect(urll).get();
            System.out.println("Pagina: " + doc.baseUri());
            //String text = doc.body().text();
            //System.out.print(text);
            
            Elements aElements = doc.getElementsByTag("a");
           
        
            for (Element aElement : aElements) {
                href = aElement.attr("href");
                String text = aElement.text();
                //System.out.println(text);
                //System.out.println("\t" + href);
                if(href.contains("tid")){
                    System.out.println(href);
                    break;
                }if(href.contains("/pt-br/legal-terms")){
                JOptionPane.showMessageDialog(null,"Não foi possível encontrar o vírus em nossa base de dados");
                }                          
            }
            href = "www.avira.com"+href;
            System.out.println("HREF: "+ href);
            
         
        } catch (IOException ex) {
            Logger.getLogger(URLConnectionReader.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return href; 
    }
}
        
    

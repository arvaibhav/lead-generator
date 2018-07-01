import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

 

public class work2 {
starting ts=new starting();
private boolean page;
  
ArrayList<String> name= new ArrayList<String>();
ArrayList<String> address= new ArrayList<String>();
ArrayList<String> phone= new ArrayList<String>();
ArrayList<String> website= new ArrayList<String>();
ArrayList<String> webstate= new ArrayList<String>();
ArrayList<String> email= new ArrayList<String>();
	
void start(String abc)  	
{
	try { 
	
	System.out.println("loading2");
	Document doc=Jsoup.connect("https://www.hotfrog.com/find/"+abc+"/me/2").timeout(7500).get();
	System.out.println("working2");
 	
	 
	Elements s=doc.select("div.tile-content"); 
	 page = true;
	for(Element e:s)
	{
	 if(e.select(".tile-company-phone").hasText())
	{page=false;
		 String g=e.select("a").attr("href");
	 
	 name.add(e.select("a").text());System.err.println("phone");phone.add(e.select(".tile-company-phone").text());
	 try {
	 Document c=Jsoup.connect(g).timeout(4000).get();////////////////////////////////inside
	  
	 
	  Elements sc=c.getElementsByClass("company-contact-info");
  
 address.add(sc.select(".data-address").text());
	
	 String gg=sc.select("a").get(1).attr("href");
	 
	 website.add(gg);
	 
	 { 
	Document ik=Jsoup.connect(gg).timeout(4000).get();
	webstate.add("working");
 
	Pattern p =	Pattern.compile(" [A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
	
	Matcher matcher = p.matcher(ik.text());
	
	Set<String> emails = new HashSet<String>();
    while (matcher.find()) {
    	 
        emails.add(matcher.group());break;
    }
    System.err.println("emailid:");
	email.add(emails.toString());
	 } } 
	catch(Exception l)
	{
		 
		webstate.add("website not working");
		email.add("not provided");
	} 
	
	}
	 
	}
	if(page)
	System.out.println("page ended");////////////what if page ended///////////////
	
	 
	
}
	

catch(Exception e)
{
	System.out.println("loading error:"+e);try {
		Thread.currentThread().sleep(110000000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}

 
 
}

}

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//sorting can be done
public class elocal {
	ArrayList<String> name= new ArrayList<String>();
	ArrayList<String> address= new ArrayList<String>();
	ArrayList<String> phone= new ArrayList<String>();
	ArrayList<String> website= new ArrayList<String>();
	ArrayList<String> webstate= new ArrayList<String>();
	ArrayList<String> email= new ArrayList<String>();
	ArrayList<String> rate= new ArrayList<String>();
	ArrayList<String> extra= new ArrayList<String>();
	void start(String abc,String zip)  	
	{boolean page=true;
		try {
		 
		Document doc=Jsoup.connect("https://www.merchantcircle.com/search?q="+abc+"&qn="+zip).timeout(8500).get();
		 
		System.out.println(doc.title()+"MERCHANTCIRCLE");
		
		
		Elements s=doc.select("li.result");
 
		
			for(Element e:s.select(".hInfo") )
			{

 
			name.add(e.select("a[href]").first().text());
			
			String g=e.select("a[href]").first().attr("href");
	 
			rate.add(e.select(".rateVal").text());
			extra.add(e.select(".reviewsQty").text());
	phone.add(e.select(".phoneWrap").text());
	 
			address.add(e.select(".directWrap").text());
		 
			
			
			//time to 1
			try {
			Document doc2=Jsoup.connect(g).timeout(8500).get();
			 
			
			String gg;
			String o=doc2.getElementById("business-website").text();
			 if(o.endsWith(".com")||o.endsWith(".biz")||o.endsWith(".co")||o.endsWith(".org")||o.endsWith(".info"))
			{if(o.substring(0, 3).equals("www"))
				{gg="https://"+o;System.out.println(gg);}
			else if(o.substring(0, 5).equals("https"))
				{gg="www"+o;System.out.println(gg);}
			else
			{gg="https://www."+o;System.out.println(gg);}
			}
			 else
			 {
				 if(o.substring(0, 3).equals("www"))
					{gg="https://"+o;System.out.println(gg);}
				else if(o.substring(0, 5).equals("https"))
					{gg="www"+o;System.out.println(gg);}
				else
				{gg="https://www."+o;System.out.println(gg);}
				
			 }
			 
			 
			 try{	website.add(gg);
					Document ik=Jsoup.connect(gg).timeout(8500).get();
					
					Pattern p =	Pattern.compile(" [A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
					webstate.add("woarking");
					Matcher matcher = p.matcher(ik.text());
					
					Set<String> emails = new HashSet<String>();
				    while (matcher.find()) {
				    	 
				        emails.add(matcher.group());break;
				    }
				    
				email.add(emails.toString().substring(1));
					}
					catch(Exception sae)
					{ 
						webstate.add("not woarking");
						email.add("not provided");
						 
					}
			 
			 
			 
			}
	 
			
			catch(Exception ee)
			{
				System.out.println("website not working and email not provided");
				email.add("not provided");
				webstate.add("not working");
				website.add("not working");
			}
			
			}
			
			
	 
			
		
			if(page)
				System.out.println("page ended");
		
		
		
		
		
		}
		 catch (Exception e) {
				System.out.println("exception:"+e);try {
					Thread.currentThread().sleep(110000000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} {page=false;
	}
System.err.println("name " +name.size()+" address "+address.size()+" phone "+phone.size()+" website "+website.size()+" webstate "+webstate.size()+" email "+email.size()+" rate "+rate.size()+" extra "+extra.size()+"  ");
			for(int i=0;i<name.size();i++)
			{	System.out.println(  name.get(i));
			System.out.println(  address.get(i));
			System.out.println(  phone.get(i));
			System.out.println( website.get(i));
			System.out.println(  webstate.get(i));
			System.out.println(  email.get(i));
			System.out.println(  rate.get(i));
			System.out.println(  extra.get(i));
				
			}
			
}}

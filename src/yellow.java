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

 

public class yellow {
starting ts=new starting();
private boolean page;
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
	try {page=false;
	System.out.println("loading");
	Document doc=Jsoup.connect("https://www.yellowpages.com/search?search_terms="+abc+"&geo_location_terms="+zip+"&s=average_rating&page=1").timeout(8500).get();
	System.out.println("working");
	System.out.println(doc.title());
	Elements s=doc .select("div.result");
	
	
	 page = true;
	for(Element e:s)
	{
		page=false;
		 
		name.add(e.select(".business-name").text());
		
		 
		rate.add("null");
		 
		extra.add("total reviews:"+e.select(".count").text());
		 
		address.add(e.select(".street-address").text());
		 
		phone.add(e.select(".phones").text());
	 
		 String g=e.select(".business-name").attr("abs:href");
	if(e.select(".links").select("a[href]").attr("href").isEmpty()==false)
		{website.add(e.select(".links").select("a[href]").attr("href"));
		try {
		Document doc2=Jsoup.connect(e.select(".links").select("a[href]").attr("href")).timeout(4500).get();
		webstate.add("working");
		}
		catch(Exception kle)
		{
			webstate.add("not working");
		}
		}
	else
		{website.add("not provided");webstate.add("website not provided");}
		 //try
		 
		 Document c=Jsoup.connect(g).timeout(8500).get();
		 Elements sc=c.getElementsByClass("email-business");
		 if(sc.hasClass("email-business"))
		 { 
		 email.add(sc.attr("href"));
		 }
		 else
		 {	  
		 email.add("not provided");
		 }

	
	
	}
	if(page)
		System.out.println("page ended");
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
	
	
}




}

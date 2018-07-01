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
public class yelp {
	ArrayList<String> name= new ArrayList<String>();
	ArrayList<String> address= new ArrayList<String>();
	ArrayList<String> phone= new ArrayList<String>();
	ArrayList<String> website= new ArrayList<String>();
	ArrayList<String> webstate= new ArrayList<String>();
	ArrayList<String> email= new ArrayList<String>();
	ArrayList<String> rate= new ArrayList<String>();
	ArrayList<String> extra= new ArrayList<String>();
	void start(String abc,String zip )  	
	{boolean page=true;
		try {
		if(zip.isEmpty())
			zip=Integer.toString(10001);
		 
		Document doc=Jsoup.connect("https://www.yelp.com/search?find_desc="+abc+"&find_loc="+zip+"&start=10&sortby=rating").timeout(8500).get();
	 
		System.out.println(doc.title());

		
		Elements s=doc.getElementsByClass("search-result");
	
		
			for(Element e1:s.select(".biz-listing-large"))
			{if(e1.getElementsByAttribute("title").isEmpty()==false)
				rate.add(e1.getElementsByAttribute("title").html().substring(159, 163));
			else
				rate.add("no rating ");
				 
				extra.add(e1.select(".review-count").text()+"  speciality :"+e1.select(".category-str-list").text());
				name.add(e1.select(".biz-name").text());
				page=false;
			
			String g=e1.select("a").attr("abs:href");
			
			phone.add(e1.select(".biz-phone").text());
			
			//time to 1
	 	
			Document doc2=Jsoup.connect(g).timeout(8500).get();
			System.out.println();
			address.add(doc2.select(".map-box-address").text());
			
			 
			if(doc2.select(".biz-website").select("a[href]").text().isEmpty()==false)
			{
				
				String gg="https://www."+doc2.select(".biz-website").select("a[href]").text();
						
							if(gg.isEmpty()==false) {
						try{	
						Document ik=Jsoup.connect(gg).timeout(8500).get();
						website.add(gg);
						Pattern p =	Pattern.compile(" [A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
						webstate.add("working");
						Matcher matcher = p.matcher(ik.text());
						
						Set<String> emails = new HashSet<String>();
					    while (matcher.find()) {
					    	 
					        emails.add(matcher.group());break;
					    }
					    
					    email.add(emails.toString());
						}
						catch(Exception e)
						{ 
							website.add("not provide");email.add("not provided");
							webstate.add("not working");
						}
							}
							else
								{website.add("not provide");email.add("not provided");webstate.add("not working");}
			
			
			}
			
			
			
			
			
			else
				{website.add("not provide");email.add("not provided");webstate.add("not working");}
			
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

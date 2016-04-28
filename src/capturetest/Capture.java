package capturetest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;


public class Capture {
	
	ArrayList<String> getname(String html){
		ArrayList<String> list=new ArrayList<String>();
		Elements name=Jsoup.parse(html).getElementsByClass("product-name");
		int len=name.size();
		for(int i=0;i<len;i++)
			list.add(name.get(i).text());
		return list;
		
	}
	ArrayList<String> getrate(String html){
		ArrayList<String> list=new ArrayList<String>();
		Elements name=Jsoup.parse(html).getElementsByClass("interest-rate");
		int len=name.size();
		for(int i=0;i<len;i++)
			list.add(name.get(i).getElementsByClass("num-style").text());
		
		return list;
		
	}
	ArrayList<String> gettime(String html){
		ArrayList<String> list=new ArrayList<String>();
		Elements name=Jsoup.parse(html).getElementsByClass("invest-period");
		int len=name.size();
		for(int i=0;i<len;i++)
			list.add(name.get(i).child(1).text());
		return list;
		
	}
	ArrayList<String> getmoney(String html){
		ArrayList<String> list=new ArrayList<String>();
		Elements name=Jsoup.parse(html).getElementsByClass("product-amount");
		int len=name.size();
		for(int i=0;i<len;i++)
		list.add(name.get(i).getElementsByClass("num-style").text());
		return list;
		
	}
	
	/*private static ArrayList<Project> list=new ArrayList<Project>();
	public static void main(String args[]) throws IOException{
		
		FileInputStream in=new FileInputStream("html/test.txt");
		InputStreamReader dis=new InputStreamReader(in);
		BufferedReader reader=new BufferedReader(dis);
		String result="";
		String s;
		while((s=reader.readLine())!=null){
			result+=s;
		}
		ArrayList<String> name=getname(result);
		ArrayList<String> rate=getrate(result);
		ArrayList<String> time=gettime(result);
		ArrayList<String> money=getmoney(result);
		int len=name.size();
		for(int i=0;i<len;i++)
		{
			Project p=new Project();
			p.setName(name.get(i));
			p.setRate(rate.get(i));
			p.setTime(time.get(i));
			p.setMoney(money.get(i));
			list.add(p);
		}
		for(int i=0;i<len;i++)
		{
			System.out.println("第"+(i+1)+"个投资项目");
			System.out.println("name:"+list.get(i).getName());
			System.out.println("rate:"+list.get(i).getRate());
			System.out.println("time:"+list.get(i).getTime());
			System.out.println("money:"+list.get(i).getMoney()+"元");
			System.out.println();
			System.out.println();
		}
		
		
	}*/
	

}

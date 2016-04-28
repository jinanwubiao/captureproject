package capturetest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CaptureTest {
	private  String result="";
	private  Capture capture;
	String name[] = { "稳盈-安e 1万元起", "稳盈-变现通 1万元起", "稳盈-变现通 5万元起",
			"稳盈-变现通 1万元起", "稳盈-变现通 1万元起", "稳盈-变现通 16042801688", "稳盈-变现通 1万元起",
			"稳盈-安e 16042510891" };
	
	String rate[] = { "8.40%", "4.70%", "4.70%", "4.60%", "4.50%", "4.40%",
			"4.30%", "6.50%" };
	
	String time[] = { "36个月", "35天", "14天", "14天", "7天", "3天", "3天", "1个月" };
	
	String money[] = { "10,000.00", "10,000.00", "50,000.00", "10,000.00",
			"10,000.00", "50,000.00", "10,000.00", "105,000.00" };

	@Before
	public void setUp() throws Exception {
		FileInputStream in=new FileInputStream("html/test.txt");
		InputStreamReader dis=new InputStreamReader(in);
		BufferedReader reader=new BufferedReader(dis);
		String s;
		while((s=reader.readLine())!=null){
			result+=s;
		}
		capture=new Capture();
	}

	@Test
	public void testGetname() {
		ArrayList<String> getName=capture.getname(result);
		int len=name.length;
		for(int i=0;i<len;i++)
			assertEquals(name[i], getName.get(i));
		
	}

	@Test
	public void testGetrate() {
		ArrayList<String> getRate=capture.getrate(result);
		int len=rate.length;
		for(int i=0;i<len;i++)
			assertEquals(rate[i], getRate.get(i));
	}

	@Test
	public void testGettime() {
		ArrayList<String> getTime=capture.gettime(result);
		int len=name.length;
		for(int i=0;i<len;i++)
			assertEquals(time[i], getTime.get(i));
	}

	@Test
	public void testGetmoney() {
		ArrayList<String> getMoney=capture.getmoney(result);
		int len=name.length;
		for(int i=0;i<len;i++)
			assertEquals(money[i], getMoney.get(i));
	}

}

package naur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Naur
{
	public final static int maxpos = 30;
	
	public static void naurProcess() throws IOException
	{
		String text = "", c;
		
		BufferedReader reader = new BufferedReader(new FileReader("resources/latin.txt"));

		while ((c = reader.readLine()) != null)
		{
			text = text.concat(c);
		}
		
		reader.close();	
		
		textProcess(text);
	}
	
	public static void textProcess(String text) throws IOException
	{		
		int i, count = 0, end = 0, start = 0;
		int length = text.length();
		
		for (i = 0; i < length; ++i, ++count)
		{
			if ((count % maxpos == 0 && i != 0))
			{			
				System.out.println(text.substring(start, end));	
				start = end + 1;
				count = i - end;
			}
			
			if (text.charAt(i) == '\\' && text.charAt(i + 1) == 'n')
			{			
				int newStart = i + 2;
				System.out.println(text.substring(start, newStart));	
				start = newStart;
				count = i - end;	
			}
			
			if (text.charAt(i) == ' ')
			{
				end = i;
			}
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		naurProcess();
	}
}
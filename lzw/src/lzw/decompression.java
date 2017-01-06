package lzw;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class decompression {
	
	ArrayList<String>dictionary = new ArrayList<String>();
	ArrayList<Integer>compresedData = new ArrayList<Integer>();
	
	private String compress;
	private Scanner x;
	
	public void ReadTheFile()
	   {
		  try{//C:\\Users\\paula.pc\\Desktop\\lzw\\lzw\\
	          x =new Scanner(new File("compresed data.txt"));
	         }catch(Exception e)
	         {
	               System.out.println("Couldn't find the file!");
	         }
	  
  			//reading from the file and save is string
			  while(x.hasNext()){
				  String ad =x.nextLine();
				  compress+=ad;
				             }
			  compress=compress.substring(4,compress.length());
				  x.close();
				  String str ="";
				  for (int i=0;i<compress.length();i++)
				  	{
					  char c=compress.charAt(i);
					  if(c!='|'){
						  		   str=str+c;	
					  			}else if(c=='|'){
					  				System.out.println(str+"\n");
					  				int s=Integer.parseInt(str);
					  				compresedData.add(s);
					  				str="";
					  				System.out.println(s +"\n");
					  			}
				
				  	}
	   }
	
	public void makeMyDictionary()
		{
			String c;
			for(int i=0;i<=127;i++)
				{
					c=(char)i+"";
					dictionary.add(c);
				}
		
		}
	public void decompress()
		{
			int i=0;
			int y=0;
			while(i<compresedData.size())
				{
				  if(dictionary.contains(compresedData.get(y)))
				  	{
					  System.out.println(dictionary.indexOf(compresedData.get(y)));
				  	}
				}
			
		}
}

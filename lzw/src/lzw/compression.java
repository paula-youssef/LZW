package lzw;

import java.io.*;
import java.util.*;
import java.lang.*;

public class compression {
	
	ArrayList<String>dictionary = new ArrayList<String>();
	ArrayList<Integer>compresedData = new ArrayList<Integer>();
	
	
	private String data;
	private Scanner x;
	private  Formatter y;
	
	public void ReadTheFile(String fileName)
			{
			  try{
	              x =new Scanner(new File(fileName));
	             }catch(Exception e)
	             {
	                   System.out.println("Couldn't find the file!");
	             }
			  
		  	//reading from the file and save is string
		  while(x.hasNext()){
			  String ad =x.nextLine();
			  data+=ad;
        				    }
		  data=data.substring(4,data.length());
		  x.close();
		  //System.out.println(data);
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
	public void compress()
		{
			String str1="",str2="";
			int i=0;
				
				while(i<data.length())
					{
						str1=data.charAt(i)+"";
						
						if (dictionary.contains(str1))
							{
								for(int j=i+1;j<data.length();j++)
									{
										str2=data.charAt(j)+"";
										str1+=str2;
											
											if(dictionary.contains(str1))
												{
											    	if (j+1>(data.length()-1))
											    	    { 
											    		 compresedData.add(dictionary.indexOf(str1));
											    		 break;
											    		}
											    			continue;
												}else{
													dictionary.add(str1);
													compresedData.add(dictionary.indexOf(str1.substring(0,str1.length()-1)));
													
														if(str1.length()>2)
															{
																i+=str1.length()-2;
																//de 34an m4 yloop tany 3la el7roof elly mskha fe el sub loops
																//-2 34an el length bd2 b 0 w ana hbd2 b a5er 7arf m3aya nw
															}
													break;
													
												}
									}
							  }
					       i++;
					   }
		
		
		}

	public void writeOnFile() throws IOException
		{
		 FileWriter outFile = new FileWriter("compresed data.txt");  
         BufferedWriter outStream = new BufferedWriter(outFile);  
         for (int k = 0; k < compresedData.size(); k++)  
             outStream.write(compresedData.get(k)+"|");     
         outStream.close();  
			}
		
		}


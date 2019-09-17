package homework.kx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import homework.kx.Address;

public class Tools 
{
	private static final String path = "./test.json";
	private static final String dataPath = "./data.txt";
	private static final String separator = System.getProperty("line.separator");
	private static final String slash = "\"";
	
	/* 将传入的list集合保存为.json文件 */
	public static void saveFile(List<Address> list) 
	{
		
		
		File file = new File(path);
		FileWriter fw = null ;
		if(!file.exists())
		{
			try 
			{
				file.createNewFile();
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
		}
		
		try 
		{
			fw = new FileWriter(file);
			for(Address a : list) 
			{
				fw.write("{");
				fw.write(slash + "姓名" + slash + ":");fw.write(slash + a.getName() + slash + ",");
				fw.write(slash + "手机" + slash + ":");fw.write(slash + a.getPhone() + slash + ",");
				fw.write(slash + "地址" + slash + ":");fw.write(slash + a.getAddress().toString() + slash);
				fw.write("}");
				fw.write(separator);
				
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				fw.flush();
				fw.close();
			} catch (IOException e) 
			{
				
				e.printStackTrace();
			}
		}
	}
	
	
	public static List<String> readFile() 
	{
		File file = new File(dataPath);
		FileReader fd = null ;
		BufferedReader br = null ; 
		List<String> dataList = new ArrayList<>();
		if(!file.exists()) 
		{
			return null;  //说明没有存在data文件
		}
		
		try 
		{
			 fd = new FileReader(dataPath);
			 br = new BufferedReader(fd);
			 String line ;
			 while((line = br.readLine()) != null) 
			 {
				 dataList.add(line);
			 }
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				br.close();
				fd.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return dataList ;
	}
	public static List<String> readFile(String filepath) 
	{
		File file = null;
		if(filepath != null) 
		{
			file = new File(filepath);
		}else 
		{
			file = new File(dataPath);
		}
		FileReader fd = null ;
		BufferedReader br = null ; 
		List<String> dataList = new ArrayList<>();
		if(!file.exists()) 
		{
			return null;  //说明没有存在data文件
		}
		
		try {
			 fd = new FileReader(dataPath);
			 br = new BufferedReader(fd);
			 String line ;
			 while((line = br.readLine()) != null) 
			 {
				 dataList.add(line);
			 }
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				br.close();
				fd.close();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dataList ;
	}
}

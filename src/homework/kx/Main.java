package homework.kx;
import java.util.ArrayList;
import java.util.List;
import homework.kx.Tools;

public class Main {
		public static void main(String[] args)
		{
			List<String> dataList = Tools.readFile();
			List<Address> addressList = new ArrayList<>();
			for(String data : dataList) 
			{
				addressList.add(new Address(data));
			}
			
			for(Address add : addressList) 
			{ 
				System.out.println(add); 
			}
			Tools.saveFile(addressList); 
		}//ͨ��Address��Ĺ��췽������ÿһ�������ҵĵ�ַ���±��Ų���װ��Address����
	}

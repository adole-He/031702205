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
		}//通过Address类的构造方法，将每一条被打乱的地址重新编排并封装成Address对象
	}

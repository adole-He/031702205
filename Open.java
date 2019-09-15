package homework.kx;
import java.util.ArrayList;
import java.util.List;

import homework.kx.Tools;

public class Open {

	public Open() {
		
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
	}//通过address函数将打乱的地址信息重新编排
}

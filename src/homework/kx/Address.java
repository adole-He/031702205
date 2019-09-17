package homework.kx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Address 
{
		private static final String slash = "\"";
		private StringBuffer message;
		private String name;
		private String phone;
		private List<String> address = new ArrayList<>();

		public Address(String message) 
		{
			setMessage(new StringBuffer(message));
			setName();
			setPhone();
			setAddress();
		}

	public String getName() 
	{
		return name;
	}

	private void setName() 
	{
		String name = this.message.toString().split(",")[0];
		int index = message.indexOf(",") + 1;
		this.message = new StringBuffer(this.message.substring(index, this.message.length()));
		this.name = name;
	}

	public String getPhone() 
	{
		return this.phone;
	}

	public void setPhone() 
	{
		String newPhone;
		String newMessage = this.message.toString();
		for (int i = 0; i < newMessage.length(); i++) 
		{
			if (Character.isDigit(newMessage.charAt(i))) 
			{
				int end = i + 11;
				if (end > newMessage.length()) 
				{
					end = newMessage.length();
				}
				newPhone = newMessage.substring(i, end);
				if (newPhone.matches("[0-9]{1,}")) 
				{
					this.phone = newPhone;
					this.message = this.message.delete(i, end);

				}
			}
		}
	}

	public List<String> getAddress() 
	{
		return address;
	}
	public void setAddress() 
	{
		String regex="(?<province>[^ʡ]+������|.*?ʡ|.*?������)?(?<city>[^��]+������|.*?����|.*?������λ|.+��|��Ͻ��|.*?��)?(?<dist>[^��]+��|.+?��|.+��|.+��|.+����|.+��)?(?<town>[^��]+��|.+�ֵ�|.+��|.+��)?(?<village>[^��]+·|.+��|.+��|.+��|.+��|.+��|.+Ū|.+��ͬ|.+��|.+ί��|.+������)?(?<number>[^����]+��)?(?<road>.*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(this.message);
		Map messageMap = initMap();
		if(matcher.find()) 
		{
			messageMap.put("province", matcher.group("province"));
			messageMap.put("city", matcher.group("city"));
			messageMap.put("dist", matcher.group("dist"));
			messageMap.put("town", matcher.group("town"));
			messageMap.put("village", matcher.group("village"));
			messageMap.put("number", matcher.group("number"));
			messageMap.put("road", matcher.group("road"));
		}
		add(messageMap);
	}
	public StringBuffer getMessage() 
	{
		return message;
	}

	public void setMessage(StringBuffer message) 
	{
		this.message = message;
	}

	@Override
	public String toString() 
	{
		return "Address [name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	private Map<String,String> initMap() {
		Map map = new HashMap<>();
		
		map.put("province", null);
		map.put("city", null);
		map.put("dist", null);
		map.put("town", null);
		map.put("village", null);
		map.put("number", null);
		map.put("road", null);
		
		return map ;
	}
	
	private void add(Map<String,String> map) 
	{
		address.add(map.get("province") == null ? "" :map.get("province") );
		address.add(map.get("city") == null ? "" :map.get("city") );
		address.add(map.get("dist") == null ? "" :map.get("dist") );
		address.add(map.get("town") == null ? "" :map.get("town") );
		address.add(map.get("village") == null ? "" :map.get("village") );
		address.add(map.get("number") == null ? "" :map.get("number") );
		address.add(map.get("road") == null ? "" :map.get("road") );
		
		//�ų�ֱϽ����δ��ʡ��
		if(this.address.get(0).equals("") && !this.address.get(1).equals("")) 
		{
			String t = this.address.get(1).substring(0,2);
			this.address.set(0, t);
		}
		else if(this.address.get(0).equals("") && this.address.get(1).equals(""))
		{
			String t = this.address.get(2);
			if(t.length() > 4) 
			{
				String province = t.substring(0,2);
				String city = t.substring(2,4) ;
				this.address.set(0, province + "ʡ");
				this.address.set(1, city + "��");
				this.address.set(2, t.substring(4,t.length()));
			}
		}
		//�����ַ���ȫ��ת��Ϊ""
		for(int i = 0 ; i < address.size() ; i++) 
		{
			if(this.address.get(i).equals("") ) 
			{
				this.address.set(i, slash + slash);
			}
		}
	}

}

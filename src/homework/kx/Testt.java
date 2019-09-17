package homework.kx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Testt 
{

	@Test
	public void test() 
	{
		String regex="(?<province>[^ʡ]+������|.*?ʡ|.*?������)?(?<city>[^��]+������|.*?����|.*?������λ|.+��|��Ͻ��|.*?��)?(?<dist>[^��]+��|.+?��|.+��|.+��|.+����|.+��)?(?<town>[^��]+��|.+�ֵ�|.+��|.+��)?(?<village>[^��]+·|.+��|.+��|.+��|.+��|.+��|.+Ū|.+��ͬ|.+��|.+ί��|.+������)?(?<number>[^����]+��)?(?<road>.*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("����ʡ������");
		if(matcher.find()) 
		{
			System.out.println(matcher.group("province"));
		}
	}
}

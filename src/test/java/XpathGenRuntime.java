import org.openqa.selenium.By;

public class XpathGenRuntime {

	public static By email = By.xpath(createXpath("//input[@id='{0}']", "anurag@gmail.com"));
	
	public static String createXpath(String xpathExp, Object... args) {
		for (int i = 0; i < args.length; i++) {
			xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);
		}
		return xpathExp;
	}

	public static void main(String[] args) {
		String x1 = createXpath("//input[@id='{0}']", "test");
		System.out.println(x1);

		String x2 = createXpath("//input[@id='{0}' and @name='{1}']", "email", "username");
		System.out.println(x2);
		
		String x3 = createXpath("//input[@id='{0}' and @name='{1}' and @type='{2}']", "email", "username", "password");
		System.out.println(x3);

		System.out.println(email.toString().substring(email.toString().indexOf("//")));
	}
}

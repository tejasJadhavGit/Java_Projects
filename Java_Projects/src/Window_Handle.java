import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handle {

	public static void main(String[] args) {
		String path = "C:\\Users\\Admin\\Software\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://www.naukri.com/");
		System.out.println("hello");

		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();

		System.out.println(driver.switchTo().window(parent).getTitle());
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();

			}

		}
		// switch to the parent window
		driver.switchTo().window(parent);

		driver.close();
	}

}

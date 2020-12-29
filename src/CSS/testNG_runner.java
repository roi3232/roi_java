package CSS;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class testNG_runner {

	public static void main(String[] args) {
		// TestListenerAdapter tla= new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("C:\\Users\\royko\\git\\roi_java\\src\\CSS\\testng.xml");
		testng.setTestSuites(suites);
		testng.run();

	}

}

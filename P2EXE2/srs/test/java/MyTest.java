import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import exe2.VulnerableClass;

public class MyTest {
	VulnerableClass v = new VulnerableClass();
	@Test
	public void test() {
	  String simulatedUserInput = "R\nW\nbb\na\na";
    InputStream savedStandardInputStream = System.in;
    System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    v.vulnerableMethod("teste.txt");
    System.setIn(savedStandardInputStream);
		v.vulnerableMethod("teste.txt");
		assertTrue(true);
	}
	@Test(expected = IllegalArgumentException.class)
	public void test2() {
	  String simulatedUserInput = "R\nW\nbb\na\na";
    InputStream savedStandardInputStream = System.in;
    System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    v.vulnerableMethod("teste.txt");
    System.setIn(savedStandardInputStream);
		VulnerableClass v = new VulnerableClass();
		v.vulnerableMethod("test/e");
		assertTrue(true);
	}

}

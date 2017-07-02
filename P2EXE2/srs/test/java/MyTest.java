import static org.junit.Assert.*;

import org.junit.Test;

import exe2.VulnerableClass;

public class MyTest {
	VulnerableClass v = new VulnerableClass();
	@Test
	public void test() {
		v.vulnerableMethod("teste.txt");
		assertTrue(true);
	}
	@Test(expected = IllegalArgumentException.class)
	public void test2() {
		VulnerableClass v = new VulnerableClass();
		v.vulnerableMethod("test/e");
		assertTrue(true);
	}

}

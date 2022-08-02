package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloTest {

	private Hello hello;
	private String expectedResponse;
	private String actualResponse;

	@Test
	public void testSayHello() {
		hello = new Hello();

		actualResponse   = hello.sayHello();
		expectedResponse = "Hello World!";
		
		assertEquals ( expectedResponse, actualResponse );
	}

}

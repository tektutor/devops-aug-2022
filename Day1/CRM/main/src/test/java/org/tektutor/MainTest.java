package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

	private Main mainObj;
	private String expectedResponse;
	private String actualResponse;

	@Test
	public void testMainModule() {

		mainObj = new Main();

		actualResponse = mainObj.getModuleName();
		expectedResponse = "Main module";

		assertEquals ( expectedResponse, actualResponse );

	}

}

package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrontendTest {

	private Frontend fe;
	private String expectedResponse;
	private String actualResponse;

	@Test
	public void testFrontendModule() {

		fe = new Frontend();

		actualResponse = fe.getModuleName();
		expectedResponse = "Frontend module";

		assertEquals ( expectedResponse, actualResponse );

	}

}

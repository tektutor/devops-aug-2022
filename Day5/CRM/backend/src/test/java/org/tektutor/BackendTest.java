package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BackendTest {

	private Backend be;
	private String expectedResponse;
	private String actualResponse;

	@Test
	public void testBackendModule() {

		be = new Backend();

		actualResponse = be.getModuleName();
		expectedResponse = "Backend module";

		assertEquals ( expectedResponse, actualResponse );

	}

}

package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BusinessLayerTest {

	private BusinessLayer bl;
	private String expectedResponse;
	private String actualResponse;

	@Test
	public void testBusinessModule() {

		bl = new BusinessLayer();

		actualResponse = bl.getModuleName();
		expectedResponse = "BusinessLayer module";

		assertEquals ( expectedResponse, actualResponse );

	}

}

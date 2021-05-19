package com.example.shipping.transformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.shipping.transformer.InputTransformer;

class InputTransformerTest {

	@Test
	void testIllegalArgumentException() {

		String inputDataSet = "[92004,92002] [92003,92004]";
		InputTransformer transformer = new InputTransformer(inputDataSet);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			transformer.transform();
		});

	}

	@Test
	void testExceptionWhenMoreRanges() {
		String inputDataSet = "[92004,92002,92003] [92003,92004]";
		InputTransformer transformer = new InputTransformer(inputDataSet);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			transformer.transform();
		});
	}

	@Test
	void testExceptionMessageWhenLowerBoundGreater() {
		String inputDataSet = "[92004,92002] [92003,92004]";
		InputTransformer transformer = new InputTransformer(inputDataSet);
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			transformer.transform();
		});
		String expectedMessage = "92004 92002:  ZIP code lower bound should be less" + " than upper bound";
		assertEquals(expectedMessage, exception.getMessage());

	}

	@Test
	void testExceptionMessageWhenMoreRangeGiven() {
		String inputDataSet = "[92004,92002,92003] [92003,92004]";
		InputTransformer transformer = new InputTransformer(inputDataSet);
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			transformer.transform();
		});
		String expectedMessage = "92004ZIP code should have lower " + "and upper bounds";
		assertEquals(expectedMessage, exception.getMessage());

	}
}

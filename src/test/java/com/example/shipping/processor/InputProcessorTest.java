package com.example.shipping.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.shipping.model.Range;
import com.example.shipping.processor.InputProcessor;

class InputProcessorTest {

	@Test
	void testOverlappingRangeToReturnOneRange() {
		Range zipcode1 = new Range(95000, 95005);
		Range zipcode2 = new Range(95002, 95006);
		List<Range> zipcodeList = new LinkedList<Range>();
		zipcodeList.add(zipcode1);
		zipcodeList.add(zipcode2);
		InputProcessor zipcode_merger = new InputProcessor();
		List<Range> mergedZipcodeList = zipcode_merger.getMinimumRanges(zipcodeList);
		assertEquals(1,mergedZipcodeList.size());
		assertEquals(95006,mergedZipcodeList.get(0).getMax());
	}

	@Test
	void testLoadAfterCallingMerge() {
		Range zipcode1 = new Range(95000, 95005);
		Range zipcode2 = new Range(95007, 95008);
		List<Range> zipcodeList = new LinkedList<>();
		zipcodeList.add(zipcode1);
		zipcodeList.add(zipcode2);
		InputProcessor zipcode_merger = new InputProcessor();
		List<Range> mergedZipcodeList = zipcode_merger.getMinimumRanges(zipcodeList);
		assertEquals(mergedZipcodeList, zipcodeList);
	}
}

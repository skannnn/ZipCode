package com.example.shipping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.shipping.service.RangeService;

class RangeServiceTest {

	@Test
	void testfinalResultToMatch() {
		String inputDataSet = "[94133,94133] [94200,94299] [94600,94699]";
		RangeService zipcodeProcessor = new RangeService();
		String output = zipcodeProcessor.getMergedZipcodeRanges(inputDataSet);
		assertEquals(inputDataSet, output);
	}

	@Test
	void testfinalResultToMatchWithOverlap() {
		String inputDataSet = "[94133,94133] [94200,94299] [94226,94399]";
		RangeService zipcodeProcessor = new RangeService();
		String output = zipcodeProcessor.getMergedZipcodeRanges(inputDataSet);
		assertEquals("[94133,94133] [94200,94399]", output);
	}

}

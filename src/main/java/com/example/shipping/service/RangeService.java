package com.example.shipping.service;

import java.util.List;

import com.example.shipping.model.Range;
import com.example.shipping.processor.InputProcessor;
import com.example.shipping.transformer.InputTransformer;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * The RangeService takes the combination of ZIP code ranges and returns filtered
 * ZIP code ranges
 *
 */
@Slf4j
public class RangeService {

	/**
	 * This method takes ZIP code ranges as a string and returns the merged response
	 * if there is any overlap. It uses InputTransformer for transforming the input
	 * and InputProcessor for merging process
	 * 
	 * @param zipcodeRangesString
	 * @return String
	 */
	public String getMergedZipcodeRanges(String zipcodeRangesString) {
		log.info("processing getMergedZipcodeRanges with the input " + zipcodeRangesString);
		InputTransformer zipStringtoListTransformer = new InputTransformer(zipcodeRangesString);
		List<Range> zipcodeRangeList = zipStringtoListTransformer.transform();
		InputProcessor zipcodeRangeProcessor = new InputProcessor();
		List<Range> mergedZipcodeRanges = zipcodeRangeProcessor.getMinimumRanges(zipcodeRangeList);
		StringBuilder mergedZipcodeRangesStringBuilder = new StringBuilder();
		for (Range range : mergedZipcodeRanges) {
			mergedZipcodeRangesStringBuilder.append("[" + range.getMin() + "," + range.getMax() + "] ");
		}
		String resultString = mergedZipcodeRangesStringBuilder.toString().trim();
		log.debug("resultString:" + resultString);
		log.info("processing getMergedZipcodeRanges completed.");
		return resultString;
	}
}

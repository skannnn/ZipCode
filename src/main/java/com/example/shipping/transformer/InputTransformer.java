package com.example.shipping.transformer;

import java.util.LinkedList;
import java.util.List;

import com.example.shipping.model.Range;

import lombok.extern.slf4j.Slf4j;

/**
 * The InputTransformer takes the combination of ZIP code ranges and returns list
 * of Range objects
 *
 */
@Slf4j
public class InputTransformer {
	private String zipcodeRanges;

	public InputTransformer(String zipcodeRanges) {
		this.zipcodeRanges = zipcodeRanges;
	}

	/**
	 * convert the zipcodeRanges strings list of Range objects
	 * 
	 * @return List<Range>
	 */
	public List<Range> transform() {
		log.info("processing transform starts.");
		String[] zipcodeIntervals = zipcodeRanges.split(" ");
		return loadZipcode(zipcodeIntervals);
	}

	/**
	 * covert ZIP code string to integer
	 * 
	 * @param zipcode
	 * @return int
	 */
	public int stringToInt(String zipcode) {
		return Integer.parseInt(zipcode);
	}

	/**
	 * check ZIP code length equals to defined limit 5 or not
	 * 
	 * @param zipcode
	 * @return boolean
	 */
	public boolean checkZipLength(int zipcode) {
		return ((int) (Math.log10(zipcode) + 1) == 5);
	}

	/**
	 * check upper bound is greater than lower bound or not
	 * 
	 * @param lowerBound
	 * @param upperBound
	 * @return boolean
	 */
	public boolean compareZipcodeRange(int lowerBound, int upperBound) {
		return !(lowerBound > upperBound);
	}

	/**
	 * validating each ZIP code for length and upper, lower bounds
	 * 
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public boolean validateZipcodeRange(int lowerBound, int upperBound) {
		if (!checkZipLength(lowerBound) && !checkZipLength(upperBound)) {
			log.error(lowerBound + " " + upperBound + ": " + "ZIP code should have 5 digits");
			throw new IllegalArgumentException(lowerBound + " " + upperBound + ": " + "ZIP code should have 5 digits");
		}
		if (!compareZipcodeRange(lowerBound, upperBound)) {
			log.error(lowerBound + " " + upperBound + ":  " + "ZIP code lower bound should be less than upper bound");
			throw new IllegalArgumentException(
					lowerBound + " " + upperBound + ":  " + "ZIP code lower bound should be less than upper bound");
		}

		return true;
	}

	/**
	 * validate the range
	 * 
	 * @param zipRange
	 * @return Range
	 */
	public Range validateAndAdd(String[] zipRange) {
		if (zipRange.length != 2) {
			log.error(zipRange[0] + "ZIP code should have lower and upper bounds");
			throw new IllegalArgumentException(zipRange[0] + "ZIP code should have lower and upper bounds");
		}

		int lowerBound = stringToInt(zipRange[0]);
		int upperBound = stringToInt(zipRange[1]);
		Range zipcode = null;
		if (validateZipcodeRange(lowerBound, upperBound))
			zipcode = new Range(lowerBound, upperBound);
		return zipcode;
	}

	/**
	 * @param zipcodeRange
	 * @return Range
	 */
	public Range getZipcodeRange(String zipcodeRange) {
		return validateAndAdd(zipcodeRange.replaceAll("\\[|\\]", "").split(","));
	}

	/**
	 * @param zipcodeRange
	 * @return
	 */
	public List<Range> loadZipcode(String[] zipcodeRange) {
		List<Range> zipcodesList = new LinkedList<>();
		for (int i = 0; i < zipcodeRange.length; i++) {
			zipcodesList.add(getZipcodeRange(zipcodeRange[i]));
		}
		return zipcodesList;
	}
}

package com.example.shipping.processor;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.shipping.model.Range;

import lombok.extern.slf4j.Slf4j;

/**
 * The InputProcessor takes the list of ZIP code ranges and returns list of Range
 * objects Checks for overlapping of ranges, and merges if found otherwise keep
 * as it is
 *
 */
@Slf4j
public class InputProcessor {

	/**
	 * this method takes a list of Ranges, merges overlapping intervals
	 * 
	 * @param zipRanges
	 * @return List<Range>
	 */
	public List<Range> getMinimumRanges(List<Range> zipRanges) {
		log.info("processing getMinimumRanges starts.");
		// Test if the given list has at least two Ranges
		if (zipRanges.size() > 1) {
			// Create an empty list for merged Ranges
			LinkedList<Range> mergedList = new LinkedList<>();

			// sort the Ranges in increasing order of min values
			List<Range> sortedList = zipRanges.stream().sorted(Comparator.comparing(Range::getMin))
					.collect(Collectors.toList());

			// add the first Range to final list/mergedList
			mergedList.add(sortedList.get(0));
			// Start from the next Range and merge if necessary
			for (int i = 1; i < sortedList.size(); i++) {
				// get the latest Range from the mergedList
				Range lastRecord = mergedList.getLast();

				// if current Range is not overlapping with latest range,
				// add it to the mergedList
				if (lastRecord.getMax() < sortedList.get(i).getMin()) {
					mergedList.add(sortedList.get(i));
				}

				// Otherwise update the max value of latest range, if max of current
				// range is more
				else if (lastRecord.getMax() < sortedList.get(i).getMax()) {
					lastRecord.setMax(sortedList.get(i).getMax());
					mergedList.removeLast();
					mergedList.add(lastRecord);
				}
			}

			// returning final list
			return mergedList;
		} else {
			return zipRanges;
		}

	}

}
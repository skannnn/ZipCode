package com.example.shipping.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This is a simple POJO class
 *
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Range {

	int min;
	int max;

}

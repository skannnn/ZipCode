# Zip Code Ranges

*Java Challenge*

## Background

Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes.

For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

## Problem

Given a collection of 5 digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the **minimum** number of ranges required to represent **the same restrictions as the input**.

## Test

For the input = [94133,94133] [94200,94299] [94600,94699], the output should be [94133,94133] [94200,94299] [94600,94699].

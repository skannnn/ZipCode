# shippingapp
Sample springboot application to merge the zipcode ranges 

----------------------------------------------------------------------------------------------------------------------
# Problem Statement: 
BACKGROUND
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines:
Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices

---------------------------------------------------------------------------------------------------------------------

# Assumptions made:
1) Assumed input to come as String
For instance input [94133,94133] [94200,94299] [94600,94699] as whole under a string.

# DataStructures used:
- LinkedList - For now, used 2 linkedlist, one for storing the input and the other for storing the output.
- Java8 streams for sorting operation
- Comparator for comparision

# Java File Description:
- RangeService.java --> service class reads the input and drives the zipcode processor
- Range.java --> Data model to store the lower bound and upper bound of zipcode
- InputTransformer.java --> Helps validating the input and load them to linkedlist
- InputProcessor.java --> Main logic that merges the zipcode ranges and returns the final list
- ShippingappApplication.java --> Spring boot main class

# Tests:
1) Wrote Junit tests to validate different scenarios  of input


  
  
  
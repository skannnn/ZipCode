package zipcodesRanges;

// Import the Range class from the range package
// Import java.util package and its ArrayList class, ListIterator and List interface
import java.util.ArrayList;
import java.util.ListIterator;
// import java.util.List;

public class ZipCodeRanges {
  // Static Variable
  // Create a rangeList object initialized only once at the execution start from the ArrayList class to store a list of range objects
  // ArrayList is like a dynamic array with a flexible size in length
  // Add or remove as many range objects as I want
  private static ArrayList<Range> rangeList = new ArrayList<Range>();

  // Static Method
  // Create a generateMinimumRanges method accessed by the ZipCodeRanges class directly to add or remove range objects to or from rangeList
  public static void generateMinimumRanges(Range range) {
    // If the number of range objects in rangeList is 0
    if (rangeList.size() == 0) {
      // Add the object to the List
      rangeList.add(range);
    } else {
      // Create a rangeListIterator interface from the listIterator method of the ArrayList class
      // The rangeListIterator interface allows me to traverse rangeList, modify the List during iteration, and obtain the Iterator's current position in the List
      ListIterator<Range> rangeListIterator = rangeList.listIterator();

      // Declare an addToRangeList variable to decide if the new range object will be added to rangeList
      boolean addToRangeList = true;

      // Iterate through range objects in rangeList
      while (rangeListIterator.hasNext()) {
        // Return the next range object (including the first range object) in the List
        Range nextRange = rangeListIterator.next();

        // If the range of a new range object is inside the range of the next range object
        if (range.getLowerBound() >= nextRange.getLowerBound() && range.getUpperBound() <= nextRange.getUpperBound()) {
          // Don't add the new range object to the List
          addToRangeList = false;
          // If the new range is outside the range of the next range object
        } else if (range.getLowerBound() > nextRange.getUpperBound() || range.getUpperBound() < nextRange.getLowerBound()) {
          // Add the new range object to the List
          addToRangeList = true;
          // If the new range is larger than the range of the next range object
        } else if (range.getLowerBound() < nextRange.getLowerBound() && range.getUpperBound() > nextRange.getUpperBound()) {
          // Remove that range object from the List
          rangeListIterator.remove();

          addToRangeList = true;
          // If the new range overlaps lowerBound of the next range object
        } else if (range.getLowerBound() < nextRange.getLowerBound() && range.getUpperBound() < nextRange.getUpperBound()) {
          // Set upperBound of the new range object to upperBound of the next range object
          range.setUpperBound(nextRange.getUpperBound());

          rangeListIterator.remove();

          addToRangeList = true;
          // If the new range overlaps upperBound of the next range object
        } else if (range.getLowerBound() > nextRange.getLowerBound() && range.getUpperBound() > nextRange.getUpperBound()) {
          // Set lowerBound of the new range object to lowerBound of the next range object
          range.setLowerBound(nextRange.getLowerBound());

          rangeListIterator.remove();

          addToRangeList = true;
        }
      }

      if (addToRangeList) {
        rangeList.add(range);
      }
    }
  }

  // Static Method
  // Create a printMinimumRanges method accessed by the ZipCodeRanges class directly to print every range object in rangeList
  public static void printMinimumRanges() {
    if (rangeList.size() > 0) {
      // Iterate through range objects in rangeList
      for (Range range : rangeList) {
        System.out.println(range.formatString());
      }
    }
  }

  // Static Method
  // Create a getMinimumRangeList method accessed by the ZipCodeRanges class directly to return rangeList
  /* public static List<Range> getMinimumRangeList() {
    return rangeList;
  } */

  public static void main(String[] args) {
    // Create range objects from the Range class
    Range rangeOne = new Range(94133, 94133);
    Range rangeTwo = new Range(94200, 94299);
    Range rangeThree = new Range(94600, 94699);

    // Call the generateMinimumRanges method on the ZipCodeRanges class
    // Pass newly created range objects into the method
    ZipCodeRanges.generateMinimumRanges(rangeOne);
    ZipCodeRanges.generateMinimumRanges(rangeTwo);
    ZipCodeRanges.generateMinimumRanges(rangeThree);

    // Call the printMinimumRanges method on the ZipCodeRanges class
    ZipCodeRanges.printMinimumRanges();

    // Call the getMinimumRangeList method on the ZipCodeRanges class
    // ZipCodeRanges.getMinimumRangeList();
  }
}

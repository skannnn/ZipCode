// Create a range package to export the Range class
package zipcodesRanges;

// Create a Range class for range object creation
public class Range {
  private int upperBound;
  private int lowerBound;

  // Constructor
  // Set lowerBound and upperBound value at the time of range object creation
  public Range(int lowerBound, int upperBound) {
    if (lowerBound <= upperBound) {
      // Use "this" keyword to refer to the current range object
      this.lowerBound = lowerBound;
      this.upperBound = upperBound;
    } else {
      this.lowerBound = upperBound;
      this.upperBound = lowerBound;
    }
  }

  // Getter Method
  // Create a getLowerBound method to get private lowerBound of the current range object from outside class
  public int getLowerBound() {
    return this.lowerBound;
  }

  // Getter Method
  // Create a getUpperBound method to get private upperBound of the current range object from outside class
  public int getUpperBound() {
    return this.upperBound;
  }

  // Setter Method
  // Create a setLowerBound method to set private lowerBound of the current range object from outside class
  public void setLowerBound(int lowerBound) {
    this.lowerBound = lowerBound;
  }

  // Setter Method
  // Create a setUpperBound method to set private upperBound of the current range object from outside class
  public void setUpperBound(int upperBound) {
    this.upperBound = upperBound;
  }

  // Create a formatString method to format decimal integers into a string
  public String formatString() {
    return String.format("[%d,%d]", this.lowerBound, this.upperBound);
  }
}

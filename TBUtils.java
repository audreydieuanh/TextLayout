import java.io.PrintWriter;
import java.util.List;

/**
 * Utilities for TextBlocks.
 *
 * @author Samuel A. Rebelsky (modified by Audrey Trinh)
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)


  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /**
   * Determine if two blocks contain the same lines
   */
  public static boolean equal(TextBlock t1, TextBlock t2) throws Exception {
    if (t1.width() != t2.width() || t1.height() != t2.height()) {
      return false;
    }
    for (int i = 0; i < t1.height(); i++) {
      if (!t1.row(i).equals(t2.row(i))) {
        return false;
      }
    }
    return true;
  }


  /**
   * Determine if two blocks were built in the same way
   */
  public static boolean eqv(TextBlock t1, TextBlock t2) {
    if (t1 instanceof TextLine && t2 instanceof TextLine) {
      return true;
    } else if (t1 instanceof TextLine || t2 instanceof TextLine) {
      return false;
    } else {
      List<TextBlock> t1Child = t1.getChild();
      List<TextBlock> t2Child = t2.getChild();
      if (t1Child.size() != t2Child.size()) {
        return false;
      } else if (t1Child.size() == 1) {
        if (t1Child.get(0).getClass() == t2Child.get(0).getClass()) {
          eqv(t1Child.get(0), t2Child.get(0));
        }
        return false;
      } else {
        if (t1Child.get(0).getClass() == t2Child.get(0).getClass() &&
                t1Child.get(1).getClass() == t2Child.get(1).getClass()) {
          return eqv(t1Child.get(0), t2Child.get(0)) && eqv(t1Child.get(1), t2Child.get(1));
        }
        return false;
      }
    }
  }

  /**
   * Determine if two blocks occupy the same memory location
   */
  public static boolean eq(TextBlock t1, TextBlock t2) {
    return t1 == t2;
  }

} // class TBUtils

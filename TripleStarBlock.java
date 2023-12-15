import java.util.ArrayList;
import java.util.List;

/**
 * A text block surrounded by a 3-layer box of stars
 *
 * @author Audrey Trinh
 */
public class TripleStarBlock implements TextBlock {
  /**
   * The stuff in the box
   */
  TextBlock contents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with contents _contents.
   */
  public TripleStarBlock(TextBlock contents) {
    this.contents = contents;
  } // BoxedBlock(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @throws Exception if the precondition is not met
   * @pre 0 <= i < this.height()
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    // The top and bottom of the box
    if ((i >= 0 && i <= 2) || (i >= h + 3 && i <= h + 5)) {
      return stars(width());
    }
    // Stuff within the box
    else if ((i > 2) && (i <= h + 5)) {
      return stars(3) + this.contents.row(i - 3) + stars(3);
    }
    // Everything else
    else {
      throw new Exception("Invalid row " + i);
    }
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return 6 + this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return 6 + this.contents.width();
  } // width()

  /**
   * Build a sequence of stars of a specified length.
   */
  public String stars(int len) throws Exception {
    String starStr = "";
    if (len < 0) {
      throw new Exception("Invalid length");
    }
    for (int i = 0; i < len; i++) {
      starStr += "*";
    }
    return starStr;
  }

  /**
   * Get a list of the input block
   */
  public List<TextBlock> getChild() {
    List<TextBlock> boxedList = new ArrayList<>();
    boxedList.add(this.contents);
    return boxedList;
  }

}

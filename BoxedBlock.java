import java.util.ArrayList;
import java.util.List;

/**
 * A text block surrounded by a box.
 *
 * @author Samuel A. Rebelsky modified by Audrey Trinh
 */
public class BoxedBlock implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

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
  public BoxedBlock(TextBlock _contents) {
    this.contents = _contents;
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
    if ((i == 0) || (i == h + 1)) {
      return "+" + TBUtils.dashes(this.contents.width()) + "+";
    }
    // Stuff within the box
    else if ((i > 0) && (i <= h)) {
      return "|" + this.contents.row(i - 1) + "|";
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
    return 2 + this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return 2 + this.contents.width();
  } // width()

  /**
   * Get a list of the input block
   */
  public List<TextBlock> getChild() {
    List<TextBlock> boxedList = new ArrayList<>();
    boxedList.add(this.contents);
    return boxedList;
  }


} // class BoxedBlock

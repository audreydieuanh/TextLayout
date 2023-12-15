import java.util.ArrayList;
import java.util.List;

/**
 * Build a block that truncates the input block to the input width
 *
 * @author Audrey Trinh
 */

public class Truncated implements TextBlock {
  TextBlock block;
  int maxWidth;

  /**
   * Build a truncated box with the input width
   */
  public Truncated(TextBlock block, int maxWidth) {
    this.block = block;
    this.maxWidth = maxWidth;
  }

  /**
   * Get one row from the block
   *
   * @throws Exception if the precondition is not met
   * @pre 0 <= i < this.height()
   */
  @Override
  public String row(int i) throws Exception {
    int h = this.block.height();
    // Stuff within the box
    if ((i >= 0) && (i < h)) {
      return truncate(this.block.row(i), this.maxWidth);
    }
    // Everything else
    else {
      throw new Exception("Invalid row " + i);
    }
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  @Override
  public int height() {
    return this.block.height();
  }

  /**
   * Determine how many columns are in the block.
   */
  @Override
  public int width() {
    if (this.maxWidth <= this.block.width()) {
      return this.maxWidth;
    } else {
      return this.block.width();
    }
  }

  /**
   * Delete all letters after the input length to truncate
   */
  public static String truncate(String str, int maxWidth) {
    if (maxWidth <= str.length()) {
      return str.substring(0, maxWidth);
    } else {
      StringBuilder strBuilder = new StringBuilder(str);
      for (int i = strBuilder.length(); i < maxWidth; i++) {
        strBuilder.append(" ");
      }
      str = strBuilder.toString();
      return str;
    }
  }

  /**
   * Get a list of the input block
   */
  public List<TextBlock> getChild() {
    List<TextBlock> truncatedList = new ArrayList<>();
    truncatedList.add(this.block);
    return truncatedList;
  }


}

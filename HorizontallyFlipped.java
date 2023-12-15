import java.util.ArrayList;
import java.util.List;

/**
 * Build a new block that horizontally flip the input block
 *
 * @author Audrey Trinh
 */
public class HorizontallyFlipped implements TextBlock {

  /**
   * The input block
   */
  TextBlock block;

  /**
   * Build a new horizontally flipped block with the input block
   */
  public HorizontallyFlipped(TextBlock block) {
    this.block = block;
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
      return horizontalFlip(this.block.row(i));
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
    return this.block.width();
  }

  /**
   * Horizontally flip the input string
   */
  public String horizontalFlip(String str) {
    char[] strAsChar = new char[str.length()];
    if (str.length() % 2 == 1) {
      strAsChar[str.length() / 2] = str.charAt(str.length() / 2);
    }
    for (int i = 0; i < str.length() / 2; i++) {
      strAsChar[i] = str.charAt(str.length() - i - 1);
      strAsChar[str.length() - i - 1] = str.charAt(i);
    }
    return new String(strAsChar);
  }

  /**
   * Get a list of the input block
   */
  public List<TextBlock> getChild() {
    List<TextBlock> horizontalList = new ArrayList<>();
    horizontalList.add(block);
    return horizontalList;
  }


}

import java.util.ArrayList;
import java.util.List;

/**
 * Build a block that center the input block within the width
 *
 * @author Audrey Trinh
 */

public class Centered implements TextBlock {
  TextBlock block;
  int width;

  /**
   * Build a new centered block with the input block and input width
   */
  public Centered(TextBlock block, int width) {
    this.block = block;
    this.width = width;
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
      if (this.width < this.block.width()) {
        return Truncated.truncate(this.block.row(i), this.width);
      }
      String padStr = padding(this.width, this.block.width());
      return padStr + this.block.row(i) + padStr;
    }
    // Everything else
    else {
      throw new Exception("Invalid row " + i);
    }
  }

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
    return this.width;
  }

  /**
   * Determine padding to right-justify the block
   */
  public String padding(int width, int strLen) {
    int diff = width - strLen;
    String padding = "";
    for (int i = 0; i < diff / 2; i++) {
      padding += " ";
    }
    return padding;
  }

  /**
   * Get a list of the input block
   */
  @Override
  public List<TextBlock> getChild() {
    List<TextBlock> centerList = new ArrayList<>();
    centerList.add(this.block);
    return centerList;
  }

}

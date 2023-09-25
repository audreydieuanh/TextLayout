import java.util.ArrayList;
import java.util.List;

/**
 * Build a block that right-justify the input block within the width
 *
 * @author Audrey Trinh
 */

public class RightJustified implements TextBlock {
    TextBlock block;
    int width;

    /**
     * Build a new right-justified block with the input block and input width
     */
    public RightJustified(TextBlock block, int width) {
        this.block = block;
        this.width = width;
    }

    /**
     * Get one row from the block
     *
     * @pre 0 <= i < this.height()
     * @exception Exception if the precondition is not met
     */
    @Override
    public String row(int i) throws Exception {
        int h = this.block.height();
        if ((i >= 0) && (i < h)) {
            if (this.width < this.block.width()) {
                // truncate if width is smaller than block's width
                return Truncated.truncate(this.block.row(i), this.width);
            }
            // add padding to right-justify
            return padding(this.width, this.block.width()) + this.block.row(i);
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
     * Determine padding to center the block
     */
    public String padding(int width, int strLen) {
        int diff = width - strLen;
        String padding = "";
        for (int i = 0; i < diff; i++) {
            padding += " ";
        }
        return padding;
    }

    /**
     * Get a list of the input block
     */
    public List<TextBlock> getChild() {
        List<TextBlock> rightList = new ArrayList<>();
        rightList.add(this.block);
        return rightList;
    }



}

import java.util.ArrayList;
import java.util.List;

/**
 * Build a new block that vertically flip the input block
 *
 * @author Audrey trinh
 */
public class VerticallyFlipped implements TextBlock {
    TextBlock block;

    public VerticallyFlipped(TextBlock block) {
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
            return this.block.row(this.block.height() - 1 - i);
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
     * Get a list of the input block
     */
    public List<TextBlock> getChild() {
        List<TextBlock> verticalList = new ArrayList<>();
        verticalList.add(this.block);
        return verticalList;
    }

}

import java.util.List;

/**
 * Simple blocks of text for a lab on polymorphism
 *
 * @author Samuel A. Rebelsky
 * @version 1.2 of February 2019
 */
public interface TextBlock {
    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    /**
     * Get one row from the block.
     *
     * @pre i < this.height()
     * @exception Exception if the row number is invalid.
     */
    String row(int i) throws Exception;

    /**
     * Determine how many rows are in the block.
     */
    int height();

    /**
     * Determine how many columns are in the block.
     */
    int width();

    List<TextBlock> getChild();

} // interface TextBlock

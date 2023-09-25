import java.util.ArrayList;
import java.util.List;

/**
 * One line of text.
 *
 * @author Samuel A. Rebelsky (modified by Audrey Trinh)
 * @version 1.3 of February 2019
 */
public class TextLine implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The contents of the line.
     */
    String line;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Build a new line with the specified contents.
     */
    public TextLine(String line) {
        this.line = line;
    } // TextLine(String)

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    /**
     * Get one row from the block.
     *
     * @pre i == 0
     * @exception Exception if i != 0
     */
    public String row(int i) throws Exception {
        if (i != 0) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid
        return this.line;
    } // row(int)


    /**
     * Determine how many rows are in the block.
     */
    public int height() {
        return 1;
    } // height()

    /**
     * Determine how many columns are in the block.
     */
    public int width() {
        return this.line.length();
    } // width()

    /**
     * Get a list of the input block
     */
    public List<TextBlock> getChild() {
        // return empty list because there is no input block
        return new ArrayList<>();
    }


} // class TextLine

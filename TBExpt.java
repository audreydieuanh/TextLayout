import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 *
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    TextBlock[] blockArr = new TextBlock[5];

    // Create a block to use
    blockArr[0] = new TextLine("Hello");
    blockArr[1] = new TextLine("Greeting");
    blockArr[2] = new BoxedBlock(new TextLine("Hello"));
    blockArr[3] = new TripleStarBlock(new TextLine("Hello"));
    blockArr[4] = new VComposition(blockArr[0], blockArr[1]);

    for (TextBlock block : blockArr) {
      pen.println(block.row(0));
    }
//    VComposition vCompose1 = new VComposition(hello, hello2);
//    RightJustified rightJustified = new RightJustified(vCompose, 5);
//    Truncated truncatedStr = new Truncated(boxedBlock, 15);
//    Centered centered = new Centered(hello, 12);
//    HorizontallyFlipped horizontallyFlipped = new HorizontallyFlipped(boxedBlock);
//    VerticallyFlipped verticallyFlipped = new VerticallyFlipped(vCompose);

    HorizontallyFlipped horizontallyFlipped1 = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello")));

    // Print out the block
//        TBUtils.print(pen, vCompose);
//        TBUtils.print(pen, boxedBlock);
//        TBUtils.print(pen, centered);
//        TBUtils.print(pen, truncatedStr);
//        TBUtils.print(pen, horizontallyFlipped1);
//        TBUtils.print(pen, rightJustified);

    // Clean up after ourselves.
    pen.close();

  } // main(String[])

} // class TBExpt

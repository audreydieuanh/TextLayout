import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for TextBlock
 *
 * @author Audrey Trinh
 */

public class TextBlockTests {
  TextBlock hello = new TextLine("hello");
  TextBlock hello2 = hello;
  TextBlock empty = new TextLine("");
  TextBlock greeting = new TextLine("greeting");

  TextBlock helloBoxed = new BoxedBlock(hello);
  TextBlock greetingBoxed = new BoxedBlock(greeting);
  TextBlock emptyBoxed = new BoxedBlock(empty);

  TextBlock helloVGreeting = new VComposition(hello, greeting);
  TextBlock helloVGreetingBoxed = new VComposition(helloBoxed, greetingBoxed);

  @Test
  public void centerTests() throws Exception {
    /* `Centered` works for widths greater than or equal to the width of
    the parameter block. */
    Centered centeredLarger = new Centered(helloBoxed, 9);
    assertEquals(" |hello| ", centeredLarger.row(1));
    Centered centeredSmaller = new Centered(hello, 3);
    assertEquals("hel", centeredSmaller.row(0));
    Centered centeredEqual = new Centered(hello, 5);
    assertEquals("hello", centeredEqual.row(0));
    /* `Centered` works with a width of 0. */
    TextBlock centerZero = new Centered(hello, 0);
    assertEquals("", centerZero.row(0));
  }

  @Test
  public void rightTests() throws Exception {
    /* `RightJustified` works for widths greater than or equal to the width
    of the parameter block. */
    RightJustified rightLarger = new RightJustified(helloBoxed, 10);
    assertEquals("   |hello|", rightLarger.row(1));
    RightJustified rightSmaller = new RightJustified(hello, 3);
    assertEquals("hel", rightSmaller.row(0));
    RightJustified rightEqual = new RightJustified(hello, 5);
    assertEquals("hello", rightEqual.row(0));
  }

  @Test
  public void truncatedTests() throws Exception {
    /* `Truncated` works with a width greater than the width of the
    parameter block. */
    Truncated truncatedLarger = new Truncated(helloBoxed, 10);
    assertEquals("|hello|   ", truncatedLarger.row(1));
    /* `Truncated` works for widths at least 1 and less than or equal to
    the width of the parameter block. */
    Truncated truncatedSmaller = new Truncated(helloBoxed, 3);
    assertEquals("|he", truncatedSmaller.row(1));
    Truncated truncatedEqual = new Truncated(hello, 5);
    assertEquals("hello", truncatedEqual.row(0));
    /* `Truncated` works with a width of 0. */
    TextBlock truncatedZero = new Truncated(hello, 0);
    assertEquals("", truncatedZero.row(0));
  }

  @Test
  public void horizontalTest() throws Exception {
    HorizontallyFlipped helloHFlipped = new HorizontallyFlipped(hello);
    assertEquals("olleh", helloHFlipped.row(0));
    HorizontallyFlipped helloBoxedHFlipped = new HorizontallyFlipped(helloBoxed);
    assertEquals("|olleh|", helloBoxedHFlipped.row(1));
    /* `HorizontallyFlipped` works for nonempty blocks of two or more lines. */
    TextBlock twoLineHFlipped = new HorizontallyFlipped(helloVGreeting);
    assertEquals("   olleh", twoLineHFlipped.row(0));
    assertEquals("gniteerg", twoLineHFlipped.row(1));
    /* `HorizontallyFlipped` works with empty blocks */
    TextBlock emptyHFlipped = new HorizontallyFlipped(empty);
    /* `VerticallyFlipped` works with empty blocks */
    assertEquals("", emptyHFlipped.row(0));
  }

  @Test
  public void verticalTest() throws Exception {
    VerticallyFlipped helloGreetingVFlipped = new VerticallyFlipped(helloVGreeting);
    assertEquals("greeting", helloGreetingVFlipped.row(0));
    assertEquals("hello   ", helloGreetingVFlipped.row(1));
    /* `VerticallyFlipped` works for nonempty blocks of two or more lines. */
    VerticallyFlipped helloGreetingBVFlipped = new VerticallyFlipped(helloVGreetingBoxed);
    assertEquals("|greeting|", helloGreetingBVFlipped.row(1));
    assertEquals("|hello|   ", helloGreetingBVFlipped.row(4));
    TextBlock emptyVFlipped = new VerticallyFlipped(empty);
    assertEquals("", emptyVFlipped.row(0));
  }

  @Test
  public void tripleStarTest() throws Exception {
    TripleStarBlock helloTrpStar = new TripleStarBlock(hello);
    assertEquals("***********", helloTrpStar.row(0));
    assertEquals("***********", helloTrpStar.row(5));
    assertEquals("***hello***", helloTrpStar.row(3));
  }

  @Test
  public void equalTest() throws Exception {
    assertTrue(TBUtils.equal(new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello"))),
            new TextLine("Hello")));
    assertFalse(TBUtils.equal(greeting, hello));
    assertFalse(TBUtils.equal(helloBoxed, hello));
    assertTrue(TBUtils.equal(hello, hello2));
    assertTrue(TBUtils.equal(hello, hello));
  }

  @Test
  public void eqTest() {
    assertFalse(TBUtils.eq(new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello"))),
            new TextLine("Hello")));
    assertFalse(TBUtils.eq(greeting, hello));
    assertFalse(TBUtils.eq(helloBoxed, hello));
    assertTrue(TBUtils.eq(hello, hello2));
    assertTrue(TBUtils.eq(hello, hello));
  }

  @Test
  public void eqvTest() {
    assertFalse(TBUtils.eqv(new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello"))),
            new TextLine("Hello")));
    assertTrue(TBUtils.eqv(greeting, hello));
    assertFalse(TBUtils.eqv(helloBoxed, hello));
    assertTrue(TBUtils.eqv(hello, hello2));
    assertTrue(TBUtils.eqv(hello, hello));
  }

  @Test
  public void edgeCaseTest() throws Exception {
    assertEquals("", empty.row(0));
    assertEquals("||", emptyBoxed.row(1));

  }

}
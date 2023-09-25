import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class TextBlockTests {
  TextBlock hello = new TextLine("hello");
  TextBlock hello2 = hello;
  TextBlock greeting = new TextLine("greeting");
  BoxedBlock helloBoxed = new BoxedBlock(hello);
  BoxedBlock greetingBoxed = new BoxedBlock(greeting);
  VComposition helloVGreeting = new VComposition(hello, greeting);
  VComposition helloVGreetingBoxed = new VComposition(helloBoxed, greetingBoxed);
  @Test
  public void centerTests() throws Exception {
    Centered centeredLarger = new Centered(hello, 10);
    assertEquals("  hello  ", centeredLarger.row(0));
    Centered centeredSmaller = new Centered(hello, 3);
    assertEquals("hel", centeredSmaller.row(0));
    Centered centeredEqual = new Centered(hello, 5);
    assertEquals("hello", centeredEqual.row(0));
  }

  @Test
  public void rightTests() throws Exception {
    RightJustified rightLarger = new RightJustified(hello, 10);
    assertEquals("     hello", rightLarger.row(0));
    RightJustified rightSmaller = new RightJustified(hello, 3);
    assertEquals("hel", rightSmaller.row(0));
    RightJustified rightEqual = new RightJustified(hello,10);
    assertEquals("hello", rightEqual);
  }

  @Test
  public void truncatedTests() throws Exception {
    Truncated truncatedLarger = new Truncated(hello, 10);
    assertEquals("hello     ", truncatedLarger.row(0));
    Truncated truncatedSmaller = new Truncated(hello, 3);
    assertEquals("hel", truncatedSmaller.row(0));
    Truncated truncatedEqual = new Truncated(hello, 5);
    assertEquals("hello", truncatedEqual.row(0));
  }

  @Test
  public void horizontalTest() throws Exception {
    HorizontallyFlipped helloHFlipped = new HorizontallyFlipped(hello);
    assertEquals("olleh", helloHFlipped.row(0));
    HorizontallyFlipped helloBoxedHFlipped = new HorizontallyFlipped(helloBoxed);
    assertEquals("|olleh|", helloBoxedHFlipped.row(1));
  }

  @Test
  public void verticalTest() throws Exception {
    VerticallyFlipped helloGreetingVFlipped = new VerticallyFlipped(helloVGreeting);
    assertEquals("greeting", helloGreetingVFlipped.row(0));
    assertEquals("hello   ", helloGreetingVFlipped.row(1));
    VerticallyFlipped helloGreetingBVFlipped = new VerticallyFlipped(helloVGreetingBoxed);
    assertEquals("|greeting|", helloGreetingBVFlipped.row(1));
    assertEquals("|hello|   ", helloGreetingBVFlipped.row(4));
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
    assertEquals(true, TBUtils.equal( new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello"))),
    new TextLine("Hello")));
    assertEquals(false, TBUtils.equal(greeting, hello));
    assertEquals(false, TBUtils.equal(helloBoxed, hello));
    assertEquals(true, TBUtils.equal(hello, hello2));
    assertEquals(true, TBUtils.equal(hello, hello));
  }
  @Test 
  public void eqTest() throws Exception {
    assertEquals(false, TBUtils.eq( new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello"))),
    new TextLine("Hello")));
    assertEquals(false, TBUtils.eq(greeting, hello));
    assertEquals(false, TBUtils.eq(helloBoxed, hello));
    assertEquals(true, TBUtils.eq(hello, hello2));
    assertEquals(true, TBUtils.eq(hello, hello));
  }
  @Test 
  public void eqvTest() throws Exception {
    assertEquals(false, TBUtils.eqv( new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello"))),
    new TextLine("Hello")));
    assertEquals(true, TBUtils.eqv(greeting, hello));
    assertEquals(false, TBUtils.eqv(helloBoxed, hello));
    assertEquals(true, TBUtils.eqv(hello, hello2));
    assertEquals(true, TBUtils.eqv(hello, hello));
  }
}

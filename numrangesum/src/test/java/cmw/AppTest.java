package cmw;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

public class AppTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

    public AppTest() {
       
    }

    @Test
    public void testCollectNullInput() {
        Collection<Integer> result = summarizer.collect(null);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testCollectEmptyInput() {
        Collection<Integer> result = summarizer.collect("");
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testCollectValidInput() {
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> result = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertEquals(expected, result);
    }

    @Test
    public void testCollectWithWhitespace() {
        Collection<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> result = summarizer.collect("  1, 2,  3,4, 5  ");
        assertEquals(expected, result);
    }

    @Test
    public void testSummarizeNullInput() {
        String result = summarizer.summarizeCollection(null);
        assertEquals("", result);
    }

    @Test
    public void testSummarizeValidInput() {
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String result = summarizer.summarizeCollection(summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31"));
        assertEquals(expected, result);
    }

    @Test
    public void testSummarizeWithSingleNumber() {
        String expected = "42";
        String result = summarizer.summarizeCollection(summarizer.collect("42"));
        assertEquals(expected, result);
    }

    @Test
    public void testSummarizeWithNegativeNumbers() {
        String expected = "-5--3, 0, 2-4, 7-9";
        Collection<Integer> input = summarizer.collect("-5,-4,-3,0,2,3,4,7,8,9");
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result);
    }
}

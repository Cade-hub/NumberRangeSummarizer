package cmw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the NumberRangeSummarizer interface.
 * This class provides methods to collect and summarize a range of numbers.
 */
public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer {

    /**
     * Collects a collection of integers from a comma-separated string input.
     * 
     * @param input the comma-separated string of numbers
     * @return a collection of integers parsed from the input string
     */
    @Override
    public Collection<Integer> collect(String input) {
        // Handle null or empty input by printing an error message and returning an empty collection
        if (input == null) {
            System.err.println("Error: Input is null.");
            return Collections.emptyList();
        }
        if (input.isEmpty()) {
            System.err.println("Error: Input is an empty string.");
            return Collections.emptyList();
        }

        List<Integer> numbers = new ArrayList<>();
        String[] nums = input.split(",");

        // Iterate over each part of the input string
        for (String num : nums) {
            String trimmedNum = num.trim();
            if (!trimmedNum.isEmpty()) {
                try {
                    // Parse and add the number to the collection
                    numbers.add(Integer.parseInt(trimmedNum));
                } catch (NumberFormatException e) {
                    // Handle invalid input by printing an error message
                    System.err.println("Error: '" + trimmedNum + "' is not a valid input.");
                }
            }
        }
        return numbers;
    }

    /**
     * Summarizes a collection of integers into a comma-separated string with ranges.
     * 
     * @param input the collection of integers to summarize
     * @return a summarized string representation of the number ranges
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        // Handle null or empty input by returning an empty string
        if (input == null || input.isEmpty()) {
            return "";
        }

        List<Integer> sortedNums = new ArrayList<>(input);
        Collections.sort(sortedNums);

        StringBuilder result = new StringBuilder();
        int start = sortedNums.get(0);
        int end = start;

        // Iterate over the sorted numbers to find ranges
        for (int i = 1; i < sortedNums.size(); i++) {
            int current = sortedNums.get(i);
            if (current == end + 1) {
                // Extend the current range
                end = current;
            } else {
                // Append the current range to the result
                appendRange(result, start, end);
                start = current;
                end = current;
            }
        }
        // Append the final range to the result
        appendRange(result, start, end);

        return result.toString();
    }

    /**
     * Appends a range or a single number to the StringBuilder.
     * 
     * @param sb the StringBuilder to append to
     * @param start the start of the range
     * @param end the end of the range
     */
    private void appendRange(StringBuilder sb, int start, int end) {
        if (sb.length() > 0) {
            sb.append(", ");
        }
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("-").append(end);
        }
    }
}
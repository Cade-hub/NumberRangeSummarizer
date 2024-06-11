package cmw;

public class App {
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

        String input1 = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + summarizer.summarizeCollection(summarizer.collect(input1)));
        // Output: 1, 3, 6-8, 12-15, 21-24, 31

        String input2 = "1,2,3,4,5";
        System.out.println("\nInput: " + input2);
        System.out.println("Output: " + summarizer.summarizeCollection(summarizer.collect(input2)));
        // Output: 1-5

        String input3 = "1";
        System.out.println("\nInput: " + input3);
        System.out.println("Output: " + summarizer.summarizeCollection(summarizer.collect(input3)));
        // Output: 1

        String input4 = "";
        System.out.println("\nInput: " + input4);
        System.out.println("Output: " + summarizer.summarizeCollection(summarizer.collect(input4)));
        // Output: (Empty string)

        String input5 = null;
        System.out.println("\nInput: " + input5);
        System.out.println("Output: " + summarizer.summarizeCollection(summarizer.collect(input5)));
        // Output: (Empty string)

        String input6 = "-1,0,1,2,3,4,5,6,7,8,9,10";
        System.out.println("\nInput: " + input6);
        System.out.println("Output: " + summarizer.summarizeCollection(summarizer.collect(input6)));
        // Output: -1, 0-10
    }
}
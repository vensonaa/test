public class CodeIssues {

    public static void main(String[] args) {
        // Issue 1: Unused variable
        int unusedVariable = 10;

        // Issue 2: NullPointerException potential

        // System.out.println(str.length()); // Uncommenting this line will cause NullPointerException

        // Issue 3: Infinite loop
        // int i = 0;
        // while (i < 5) {
        //     System.out.println("Looping...");
        //     // Missing i++ to terminate the loop
        // }


        // Issue 4: Type mismatch - implicit narrowing conversion
        long largeNumber = 10000000000L;
        // int smallNumber = largeNumber; // This will cause a compile-time error without explicit cast

        // Issue 5: Array Index Out of Bounds
        int[] numbers = {1, 2, 3};


        // Issue 6: Resource leak - unclosed resource
        // try {
        //     java.io.FileWriter writer = new java.io.FileWriter("output.txt");
        //     writer.write("Hello");
        //     // writer.close(); // Missing close() call
        // } catch (java.io.IOException e) {
        //     e.printStackTrace();
        // }

        // Issue 7: Inefficient string concatenation in a loop
        String result = "";
        for (int j = 0; j < 5; j++) {
            result += j; // Inefficient, creates new String objects repeatedly
        }
        System.out.println("Concatenated string: " + result);

        // Issue 8: Incorrect comparison with == for String objects
        String s1 = new String("hello");
        String s2 = new String("hello");
        if (s1 == s2) { // This will evaluate to false, should use .equals()
            System.out.println("Strings are equal using ==");
        } else {
            System.out.println("Strings are not equal using ==");
        }

        // Issue 9: Missing break in switch statement
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
            case 2:
                System.out.println("Tuesday"); // Fall-through if no break
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }
    }
}

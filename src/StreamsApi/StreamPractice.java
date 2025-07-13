package StreamsApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 6, 4, 9, 5, 7, 2);
        System.out.println(list.stream()
                .sorted(Collections.reverseOrder())
                .distinct()
                .skip(2)
                .findFirst()
                .orElse(-1));
        /*
### 1. **Find the maximum element in a list using Stream API.**
   - Write a program to find the maximum element in a list of integers using Java Stream API.
   Solutions
   */
        System.out.println("Maximum element : " + list.stream().sorted((a, b) -> Integer.compare(b, a)).findFirst().get());
        System.out.println("Maximum element using max : " + list.stream().max((a, b) -> a-b).get());
        System.out.println("Minimum element using max : " + list.stream().max((a, b) -> b-a).get());
        System.out.println("Minimum element using min : " + list.stream().min((a, b) -> a-b).get());
        System.out.println("Maximum element using min : " + list.stream().min((a, b) -> b-a).get());


        /*

### 2. **Count the frequency of each element in a list.**
   - Given a list of elements, use the Stream API to count how many times each element occurs in the list.
   */
        System.out.println("Counting : " + list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        /*

### 3. **Find the average of numbers in a list.**
   - Write a program to find the average of numbers in a list using the Stream API.

*/
        System.out.println("Average in stream: " + list.stream().reduce((sum , element) -> sum += element).get() / list.size());
        System.out.println("Average in stream: " + list.stream().mapToInt(Integer::intValue).average());//min, max, sum etc...
  /*


### 4. **Find the first element greater than a given number.**
   - Given a list of integers and a number `n`, use the Stream API to find the first element that is greater than `n`.
   */
        int given = 5;
        System.out.println(list.stream().mapToInt(Integer::intValue));

        /*

### 5. **Remove all duplicates from a list of strings.**
   - Given a list of strings, use the Stream API to return a new list with all duplicates removed.

### 6. **Sort the list in ascending order and return the first `n` elements.**
   - Given a list of integers and a number `n`, sort the list in ascending order and return the first `n` elements.

### 7. **Check if a list contains any even numbers.**
   - Given a list of integers, use the Stream API to check if the list contains at least one even number.

### 8. **Concatenate all strings in a list.**
   - Given a list of strings, use the Stream API to concatenate all the strings into a single string.

### 9. **Find the longest string in a list.**
   - Write a program that finds the longest string in a list of strings using the Stream API.

### 10. **Filter and get a list of numbers greater than a specific threshold.**
   - Given a list of integers and a threshold value, use the Stream API to return a list of all elements greater than the threshold.

### 11. **Find the second smallest element in a list.**
   - Similar to finding the second largest, find the second smallest element in a list using Stream API.

### 12. **Check if all elements in a list are positive.**
   - Given a list of integers, use the Stream API to check if all the elements in the list are positive.

### 13. **Find the sum of squares of all even numbers in a list.**
   - Given a list of integers, use the Stream API to calculate the sum of squares of all even numbers.

### 14. **Group elements by length (for strings).**
   - Given a list of strings, group them by their length using the Stream API.

### 15. **Get the second largest distinct number using Stream API.**
   - Similar to the second largest, but with a specific requirement to handle distinct numbers only.

### 16. **Map a list of strings to uppercase.**
   - Given a list of strings, use the Stream API to convert all strings to uppercase.

### 17. **Find the most frequent element in a list.**
   - Write a program using the Stream API to find the element that appears the most in a list.

### 18. **Convert a list of integers to a list of their squares.**
   - Given a list of integers, use the Stream API to return a list of their squares.

### 19. **Join a list of strings with a specific delimiter.**
   - Given a list of strings, use the Stream API to join them into a single string with a delimiter (e.g., comma).

### 20. **Get the distinct elements from a list of objects based on a specific property.**
   - Given a list of custom objects, use the Stream API to return distinct elements based on one of their properties (e.g., a `Person` object with name and age, and you want distinct names).

These questions cover a range of common tasks and concepts that can be efficiently solved using Java Streams, including filtering, grouping, reducing, and mapping operations.
         */
    }
}

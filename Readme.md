
[Result1](Output1.png)
[Result2](Output2.png)

Answers:

2. Interpolation search is expected to perform better than linear search when the array is large and uniformly distributed. Interpolation search takes advantage of the sorted nature of the array and estimates the probable position of the search key, leading to faster convergence towards the target element.
Linear search scans the array sequentially, element by element, until it finds a match or reaches the end of the array. Its performance remains constant regardless of the distribution of the array.

3. Improved Linear Search:
The improved linear search method includes an optimization technique known as "early termination."
Similar to linear search, it starts scanning the array sequentially from the beginning.
However, if the current element is greater than the search key, it terminates the search, assuming the key is not present in the sorted array.
This early termination reduces the number of iterations required, especially when the search key is not found or located towards the beginning of the array.
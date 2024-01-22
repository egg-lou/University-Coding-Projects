import java.util.ArrayList;
import java.util.Scanner;

public class MaxHeap {
    private ArrayList<Integer> heap;
    
    /**
     * This is the constructor for the MaxHeap class.
     * It initializes the heap as an empty ArrayList of integers.
     * The heap property for a max heap is that the parent node is always larger than its child nodes.
     */
    public MaxHeap() {
        heap = new ArrayList<>();
    }

    /**
     * This method is used to build a max heap from an input array.
     * A max heap is a specialized tree-based data structure that satisfies the heap property.
     * In a max heap, for any given node I, the value of I is greater than or equal to the values of its children.
     *
     * @param array This is the input array from which the max heap is to be built.
     * It is an ArrayList of integers.
     *
     * The method first initializes the heap with the input array.
     * Then, starting from the middle of the array (heap.size() / 2), it calls the heapifyDown method for each element.
     * The reason for starting from the middle is that the elements after the middle are leaves and hence, do not need to be heapified.
     *
     * The heapifyDown method ensures that the heap property is maintained for the element at the index passed to it.
     * It does this by swapping the element with its largest child until the heap property is satisfied.
     */
    public void buildMaxHeap(ArrayList<Integer> array) {
        heap = new ArrayList<>(array);
        for (int i = heap.size() / 2; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    /**
     * This method is used to maintain the heap property in a max heap after an insertion.
     * In a max heap, for any given node I, the value of I is greater than or equal to the values of its children.
     *
     * @param index This is the index of the element that has been inserted.
     * It is an integer.
     *
     * The method starts by calculating the parent of the inserted element.
     * Then, it enters a loop that continues until the inserted element is either the root of the heap or it is less than or equal to its parent.
     *
     * Inside the loop, the method first swaps the inserted element with its parent if the inserted element is greater than its parent.
     * Then, it updates the index to be the index of the parent and recalculates the parent.
     */
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(index) > heap.get(parent)) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    /**
     * This method is used to maintain the heap property in a max heap after a deletion or replacement.
     * In a max heap, for any given node I, the value of I is greater than or equal to the values of its children.
     *
     * @param index This is the index of the element that has been deleted or replaced.
     * It is an integer.
     *
     * The method starts by calculating the indices of the left and right children of the element.
     * Then, it identifies the largest of the element and its children.
     *
     * If the largest element is not the element itself, it means that the heap property is violated.
     * In this case, the method swaps the element with the largest of its children and then recursively calls itself for the child.
     *
     * This ensures that the heap property is maintained not only for the element but also for its children.
     */
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;
        if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    /**
     * This method is used to insert a new element into a max heap.
     * In a max heap, for any given node I, the value of I is greater than or equal to the values of its children.
     *
     * @param num This is the new element that is to be inserted into the heap.
     * It is an integer.
     *
     * The method first adds the new element to the end of the heap.
     * Then, it calls the heapifyUp method for the new element to ensure that the heap property is maintained.
     *
     * The heapifyUp method ensures that the heap property is maintained for the new element.
     * It does this by swapping the new element with its parent until the heap property is satisfied.
     */
    public void insert(int num) {
        heap.add(num);
        heapifyUp(heap.size() - 1);
    }

    /**
     * This method is used to remove and return the maximum element from a max heap.
     * In a max heap, the maximum element is always at the root.
     *
     * The method first checks if the heap is empty. If it is, it returns -1.
     *
     * If the heap is not empty, the method stores the root element in a variable and removes the last element from the heap.
     * If the heap is still not empty after the removal of the last element, it replaces the root with the last element and calls the heapifyDown method for the root.
     *
     * The heapifyDown method ensures that the heap property is maintained for the root.
     * It does this by swapping the root with the largest of its children until the heap property is satisfied.
     *
     * Finally, the method returns the maximum element that was stored in a variable.
     *
     * @return The maximum element in the heap or -1 if the heap is empty.
     */
    public int extractMax() {
        if (heap.isEmpty()) {
            return -1;
        }
        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        if(!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return max;
    }

    /**
     * This method is used to sort the elements in the heap in ascending order using the heap sort algorithm.
     *
     * Heap sort is a comparison-based sorting algorithm that uses a binary heap data structure.
     * It works by transforming the input into a max heap and then repeatedly removing the maximum element from the heap and placing it at the end of the sorted section of the array.
     *
     * The method first stores the size of the heap in a variable.
     * Then, it enters a loop that starts from the end of the heap and continues until the second element of the heap.
     *
     * Inside the loop, the method first swaps the root of the heap with the element at the current index.
     * Then, it calls the heapifyDownForHeapSort method for the root and the current index.
     *
     * The heapifyDownForHeapSort method ensures that the heap property is maintained for the root in the unsorted section of the array.
     * It does this by swapping the root with the largest of its children in the unsorted section until the heap property is satisfied.
     */
    public void heapSort() {
        int size = heap.size();
        for(int i = size - 1; i> 0; i--) {
            swap(0, i);
            heapifyDownForHeapSort(0, i);
        }
    }

    /**
     * This method is used to maintain the heap property in a max heap during the heap sort algorithm.
     * In a max heap, for any given node I, the value of I is greater than or equal to the values of its children.
     *
     * @param index This is the index of the element that has been swapped with the last element of the unsorted section of the array.
     * It is an integer.
     * @param heapSize This is the size of the unsorted section of the array.
     * It is an integer.
     *
     * The method starts by calculating the indices of the left and right children of the element.
     * Then, it identifies the largest of the element and its children in the unsorted section of the array.
     *
     * If the largest element is not the element itself, it means that the heap property is violated.
     * In this case, the method swaps the element with the largest of its children and then recursively calls itself for the child and the updated size of the unsorted section.
     *
     * This ensures that the heap property is maintained not only for the element but also for its children in the unsorted section of the array.
     */
    private void heapifyDownForHeapSort(int index, int heapSize) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < heapSize && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }

        if (rightChild < heapSize && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDownForHeapSort(largest, heapSize);
        }
    }

    /**
     * This method is used to swap two elements in the heap.
     *
     * @param i This is the index of the first element to be swapped.
     * It is an integer.
     * @param j This is the index of the second element to be swapped.
     * It is an integer.
     *
     * The method first stores the element at index i in a temporary variable.
     * Then, it sets the element at index i to be the element at index j.
     * Finally, it sets the element at index j to be the value stored in the temporary variable.
     *
     * This ensures that the elements at indices i and j are swapped.
     */
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the number of elements: ");
        int numElements = sc.nextInt();

        ArrayList<Integer> array = new ArrayList<>();
        System.out.println("Enter the elements: ");

        for (int i = 0; i < numElements; i++) {
            System.out.print("number: ");
            array.add(sc.nextInt());
        }

        System.out.println("Array: " + array);

        heap.buildMaxHeap(array);
        System.out.println("Max Heap: " + heap.heap);

        System.out.print("Enter element to insert: ");
        int elementToInsert = sc.nextInt();
        heap.insert(elementToInsert);
        System.out.println("Heap After Insertion: " + heap.heap);
        
        int max = heap.extractMax();
        System.out.println("Max Element Extracted: " + max);
        System.out.println("Heap After Insertion: " + heap.heap);
        
        heap.heapSort();
        System.out.println("Sorted Array: " + heap.heap);
        
        sc.close();
    }
}
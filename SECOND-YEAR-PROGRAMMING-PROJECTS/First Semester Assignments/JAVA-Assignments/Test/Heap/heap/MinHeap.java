import java.util.ArrayList;
import java.util.Scanner;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    /**
     * This method is used to build a minimum heap from a given array of integers.
     * The method first copies the input array into the heap. Then, starting from the middle of the heap,
     * it calls the heapifyDown method on each element. This ensures that the heap property is maintained
     * for all elements. The heap property for a min heap is that the parent node is always smaller than its child nodes.
     *
     * @param array This is the input array of integers that needs to be converted into a min heap.
     */
    public void buildMinHeap(ArrayList<Integer> array) {
        heap = new ArrayList<>(array);
        for (int i = heap.size() / 2; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    /**
     * This method is used to maintain the heap property in a min heap after an element has been inserted.
     * The method compares the inserted element with its parent and if the inserted element is smaller,
     * it swaps the two elements. This process is repeated until the inserted element is larger than its parent
     * or it becomes the root of the heap (i.e., it reaches the top of the heap).
     *
     * @param index This is the index of the inserted element in the heap.
     */
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(index) < heap.get(parent)) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    /**
     * This method is used to maintain the heap property in a min heap after an element has been removed.
     * The method compares the root element with its children and if the root element is larger,
     * it swaps the root with the smallest child. This process is repeated until the root element is smaller than its children
     * or it becomes a leaf node (i.e., it reaches the bottom of the heap).
     *
     * @param index This is the index of the root element in the heap.
     */
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;
        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    /**
     * This method is used to insert a new element into the min heap.
     * The method first adds the new element at the end of the heap (i.e., the array list).
     * Then, it calls the heapifyUp method to maintain the heap property.
     * The heap property for a min heap is that the parent node is always smaller than its child nodes.
     *
     * @param num This is the new element that needs to be inserted into the min heap.
     */
    public void insert(int num) {
        heap.add(num);
        heapifyUp(heap.size() - 1);
    }

    /**
     * This method is used to remove and return the smallest element from the min heap.
     * If the heap is empty, the method returns -1.
     * Otherwise, it removes the root element (which is the smallest in a min heap) and replaces it with the last element in the heap.
     * Then, it calls the heapifyDown method to maintain the heap property.
     * The heap property for a min heap is that the parent node is always smaller than its child nodes.
     *
     * @return int This returns the smallest element from the min heap or -1 if the heap is empty.
     */
    public int extractMin() {
        if (heap.isEmpty()) {
            return -1;
        }
        int min = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        if(!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return min;
    }
    
    /**
     * This method is used to sort the elements in the min heap in ascending order.
     * The method works by repeatedly swapping the root of the heap with the last element and then
     * calling heapifyDownForHeapSort on the root. The heapifyDownForHeapSort method is similar to heapifyDown,
     * but it also takes the end index of the heap as a parameter and ensures that the heap property is maintained
     * only up to that index. This is because the elements after the end index are already sorted and should not be modified.
     * The process is repeated until all elements are sorted.
     */
    public void heapSort() {
        int size = heap.size();
        for(int i = size - 1; i> 0; i--) {
            swap(0, i);
            heapifyDownForHeapSort(0, i);
        }
    }

    /**
     * This method is used to maintain the heap property in a min heap during the heap sort process.
     * The method compares the root element with its children and if the root element is larger,
     * it swaps the root with the smallest child. This process is repeated until the root element is smaller than its children
     * or it becomes a leaf node (i.e., it reaches the bottom of the heap).
     * The method also takes the end index of the heap as a parameter and ensures that the heap property is maintained
     * only up to that index. This is because the elements after the end index are already sorted and should not be modified.
     *
     * @param index This is the index of the root element in the heap.
     * @param heapSize This is the end index of the heap.
     */
    private void heapifyDownForHeapSort(int index, int heapSize) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heapSize && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }

        if (rightChild < heapSize && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDownForHeapSort(smallest, heapSize);
        }
    }

    /**
     * This method is used to swap two elements in the heap.
     * It takes the indices of the two elements as parameters.
     * The method first saves the element at the first index in a temporary variable.
     * Then, it sets the element at the first index to the element at the second index.
     * Finally, it sets the element at the second index to the value saved in the temporary variable.
     *
     * @param i This is the index of the first element.
     * @param j This is the index of the second element.
     */
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

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

        heap.buildMinHeap(array);
        System.out.println("Max Heap: " + heap.heap);

        System.out.print("Enter element to insert: ");
        int elementToInsert = sc.nextInt();
        heap.insert(elementToInsert);
        System.out.println("Heap After Insertion: " + heap.heap);
        
        int max = heap.extractMin();
        System.out.println("Max Element Extracted: " + max);
        System.out.println("Heap After Insertion: " + heap.heap);
        
        heap.heapSort();
        System.out.println("Sorted Array: " + heap.heap);
        
        sc.close();
    }
}

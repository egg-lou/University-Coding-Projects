import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp();
    }

    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int maxValue = heap.get(0);
        int lastIndex = heap.size() - 1;

        swap(0, lastIndex);
        heap.remove(lastIndex);

        heapifyDown();

        return maxValue;
    }

    public void delete(int value) {
        int index = heap.indexOf(value);
        if (index == -1) {
            System.out.println("Element not found in the heap");
            return;
        }

        int lastIndex = heap.size() - 1;
        swap(index, lastIndex);
        heap.remove(lastIndex);

        heapifyUpHelper(index);
        heapifyDownHelper(index);
    }

    private void heapifyUp() {
        int currentIndex = heap.size() - 1;
        heapifyUpHelper(currentIndex);
    }

    private void heapifyUpHelper(int currentIndex) {
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex) > heap.get(parentIndex)) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int currentIndex = 0;
        heapifyDownHelper(currentIndex);
    }

    private void heapifyDownHelper(int currentIndex) {
        int lastIndex = heap.size() - 1;

        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            int largestChildIndex = -1;

            if (leftChildIndex <= lastIndex) {
                largestChildIndex = leftChildIndex;
            }

            if (rightChildIndex <= lastIndex && heap.get(rightChildIndex) > heap.get(leftChildIndex)) {
                largestChildIndex = rightChildIndex;
            }

            if (largestChildIndex != -1 && heap.get(largestChildIndex) > heap.get(currentIndex)) {
                swap(currentIndex, largestChildIndex);
                currentIndex = largestChildIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void displayMaxSorted() {
        System.out.print("MaxHeap: ");
        while (!isEmpty()) {
            System.out.print(extractMax() + " ");
        }
    }

    public void printMaxHeapOrder() {
    MaxHeap copy = new MaxHeap();
    for (int value : this.heap) {
        copy.insert(value);
    }

    while (!copy.isEmpty()) {
        System.out.print(copy.extractMax() + " ");
    }
    System.out.println();
}

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(7);
        maxHeap.insert(1);
        maxHeap.insert(9);
        
        System.out.print("MaxHeap order: ");
        maxHeap.printMaxHeapOrder();
        
        System.out.println("Heap: " + maxHeap.heap);
        System.out.println("Maximum: " + maxHeap.extractMax());
        System.out.println("Heap: " + maxHeap.heap);
        
        System.out.println("Maximum: " + maxHeap.extractMax());
        System.out.println("Heap: " + maxHeap.heap);
        
        System.out.print("MaxHeap order: ");
        maxHeap.printMaxHeapOrder();
    }
}

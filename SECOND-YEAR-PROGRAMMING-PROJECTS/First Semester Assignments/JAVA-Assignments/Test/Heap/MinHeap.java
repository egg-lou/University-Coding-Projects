import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp();
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int minValue = heap.get(0);
        int lastIndex = heap.size() - 1;

        swap(0, lastIndex);
        heap.remove(lastIndex);

        heapifyDown();

        return minValue;
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
            if (heap.get(currentIndex) < heap.get(parentIndex)) {
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
            int smallestChildIndex = -1;

            if (leftChildIndex <= lastIndex) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex <= lastIndex && heap.get(rightChildIndex) < heap.get(leftChildIndex)) {
                smallestChildIndex = rightChildIndex;
            }

            if (smallestChildIndex != -1 && heap.get(smallestChildIndex) < heap.get(currentIndex)) {
                swap(currentIndex, smallestChildIndex);
                currentIndex = smallestChildIndex;
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

    public void printMinHeapOrder() {
    MinHeap copy = new MinHeap();
    for (int value : this.heap) {
        copy.insert(value);
    }

    while (!copy.isEmpty()) {
        System.out.print(copy.extractMin() + " ");
    }
    System.out.println();
}

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(1);
        minHeap.insert(9);

        System.out.print("MinHeap order: ");
        minHeap.printMinHeapOrder();
        
        System.out.println("Heap: " + minHeap.heap);
        System.out.println("Minimum: " + minHeap.extractMin());
        System.out.println("Heap: " + minHeap.heap);
        
        System.out.println("Minimum: " + minHeap.extractMin());
        System.out.println("Heap: " + minHeap.heap);
        
        System.out.print("MinHeap order: ");
        minHeap.printMinHeapOrder();

    }
}

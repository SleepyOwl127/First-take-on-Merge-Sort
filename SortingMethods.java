import java.util.ArrayList;
import java.util.List;

public class SortingMethods<E extends Comparable<E>> implements Demonstrable {
    private static final int UPPER_LIMIT_FOR_SHOW = 15;
    StringBuilder steps = new StringBuilder();

    /**
     * DO NOT CHANGE THIS METHOD
     */
    public String show() {
        steps.setLength(steps.length() - 1);
        return steps.toString();
    }

    public void mergeSort(List<E> elements) {
        steps.setLength(0);
        int x = elements.size();
        List<E> arr = new ArrayList<>(x);

        if (x < UPPER_LIMIT_FOR_SHOW) {
            steps.append(elements.toString()).append('\n');
        }

        for (int size = 1; size < x; size = size * 2) {
            for (int left = 0; left < x - size; left += size * 2) {
                int mid = left + size - 1;
                int right = Math.min(left + size * 2 - 1, x - 1);

                merge(elements, arr, left, mid, right);
            }

            if (x < UPPER_LIMIT_FOR_SHOW) {
                steps.append(elements.toString()).append('\n');
            }
        }
    }

    private void merge(List<E> elements, List<E> arr, int left, int mid, int right) {
        int i = 0;
        int j = mid - left + 1;
        int k = left;

        List<E> temp = new ArrayList<>(elements.subList(left, right + 1));

        while (i < (mid - left + 1) && j < (right - left + 1)) {
            if (temp.get(i).compareTo(temp.get(j)) <= 0) {
                elements.set(k++, temp.get(i++));
            } else {
                elements.set(k++, temp.get(j++));
            }
        }

        while (i < (mid - left + 1)) {
            elements.set(k++, temp.get(i++));
        }

        while (j < (right - left + 1)) {
            elements.set(k++, temp.get(j++));
        }
    }

    public void insertionSort(List<E> elements) {
        steps.setLength(0);

        if (elements.size() < UPPER_LIMIT_FOR_SHOW) {
            steps.append(elements.toString()).append('\n');
        }

        int i = 1;
        while (i < elements.size()) {
            int j = i;

            while (j > 0 && elements.get(j).compareTo(elements.get(j - 1)) < 0) {
                E temp = elements.get(j);
                elements.set(j, elements.get(j - 1));
                elements.set(j - 1, temp);

                j--;
            }

            i++;

            if (elements.size() < UPPER_LIMIT_FOR_SHOW) {
                steps.append(elements.toString()).append('\n');
            }
        }
    }

    public void selectionSort(List<E> elements) {

        steps.setLength(0);

        if (elements.size() < UPPER_LIMIT_FOR_SHOW) {

            steps.append(elements.toString()).append('\n');

        }

        int boundary = 0;

        while (boundary < elements.size() - 1) {

            int minIndex = findMinIndex(elements, boundary);

            swap(elements, boundary++, minIndex);

            if (elements.size() < UPPER_LIMIT_FOR_SHOW)

                steps.append(elements.toString()).append('\n');

        }

    }



    private int findMinIndex(List<E> elements, int boundary) {

        int minIndex = boundary;

        if (boundary == elements.size() - 1)

            return minIndex;

        E min = elements.get(minIndex);

        for (int i = boundary + 1; i < elements.size(); i++) {

            E e = elements.get(i);

            if (e.compareTo(min) < 0) {min = e; minIndex = i;}

        }

        return minIndex;

    }

    private void swap(List<E> elements, int i, int j) {

        if (i < 0 || j < 0 || i >= elements.size() || j >= elements.size()) {

            String err = String.format("Cannot swap elements between positions %d and %d in list of %d elements.",

                    i, j, elements.size());

            throw new IndexOutOfBoundsException(err);

        }

        E tmp = elements.get(i);

        elements.set(i, elements.get(j));

        elements.set(j, tmp);

    }

}
import java.util.List;

class BinarySearch {

    private final List<Integer> list;

    BinarySearch(List<Integer> list) {
        this.list = list;
    }

    int indexOf(int n) throws ValueNotFoundException {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int m = list.get(mid);

            if (n < m) {
                end = mid - 1;
            } else if (n > m) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        throw new ValueNotFoundException("Value not in array");
    }
}

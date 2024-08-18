package Array;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] B = {3, 1};
        int[] C = {1};
        System.out.println(search4(C, 0, 1, 1));
    }

    static int search(int[] A, int l, int h, int key) {
        if (l > h) {
            return -1;
        }
        int mid = (l + h) / 2;

        if (A[mid] == key) return mid;

        if (A[l] <= A[mid]) {
            if (A[l] <= key && A[mid] >= key) {
                return search(A, l, mid , key);
            }
            return search(A, mid + 1, h, key);
        }
        if (key <= A[h] && key >= A[mid + 1]) {
            return search(A, mid + 1, h, key);
        }
        return search(A, l, mid, key);
    }
    static int search4(int[] A, int l, int h, int key){
        if(l>h) return -1;

        int mid = (l + h) / 2;
        if(A[mid] == key) {
            return mid;
        }
        if(A[l] <= A[mid]){
            if(key>=A[mid]){
                return search4(A, mid + 1, h, key);
            }
        }
        else {
            if(key>=A[mid] && key<=A[h]){
                return search4(A, mid, h, key);
            } else {
                return search4(A, l , mid-1,key);
            }
        }
        return -1;
    }
}

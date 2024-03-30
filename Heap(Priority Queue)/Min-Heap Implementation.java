public class Solution {

    static class MinHeap {
        int[] arr;
        int curr_size;
        int totalSize;

        // Constructor for the class.
        MinHeap(int size) {
            // Write your code here.
            arr = new int[size];
            curr_size = 0;
            totalSize = size;
        }

        // Implement the function to remove minimum element.
        int extractMinElement() {
            // Write you code here.
            if(curr_size == 0) return -1;

            int res = arr[0];

            arr[0] = arr[curr_size-1];
            curr_size--;

            Heapify(0);
            return res;
        }

        void Heapify(int idx){

            int lowest = idx;
            int left = 2*idx + 1;
            int right = 2*idx + 2;

            if(left  < curr_size && arr[left] < arr[lowest]){
                lowest = left;

            }

            if(right  < curr_size && arr[right] < arr[lowest]){
                lowest = right;

            }

            if(lowest != idx) {
                //swap
                int t = arr[idx];
                arr[idx] = arr[lowest];
                arr[lowest] = t;

                Heapify(lowest);
            }

        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            // Write you code here.

            if(curr_size <= ind) return;

            int poped = arr[ind];
            curr_size--;

            Heapify(ind);
            


        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            // Write you code here.

            if(curr_size == totalSize) return;

            arr[curr_size] = val;

            int pos = curr_size;

            curr_size++;

            while(pos > 0) {

                int par_idx = (pos-1)/2;

                if(arr[pos] < arr[par_idx]){

                    //swap
                    int t = arr[pos];
                    arr[pos] = arr[par_idx];
                    arr[par_idx] = t;

                    pos = par_idx;
                }
                else {
                    break;
                }
            }
        }
    }
};

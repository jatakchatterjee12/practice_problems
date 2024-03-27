import java.util.ArrayList;

public class Main {
	
	public static void moveZeroes(int[] nums) {
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
	
	private  static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static  void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }

	public static void main(String[] args) {

		int[] arr = {3,0,2,0,0, 5, 4, 0, 1, 0};
		int n = arr.length;
		
		mergeSort(arr,0, n-1); //O(nlogn)
		moveZeroes(arr); // O(n)
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
		
	}

}

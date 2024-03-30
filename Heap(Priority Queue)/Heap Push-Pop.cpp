void Heapify(int i, vector<int> &heap){
    int largest = i;

    int left = 2*i + 1;
    int right = 2*i + 2;

    //largest will store the index of the element which
    //is greatest among these 3 -> largest, left, right

    if(left < heap.size() && heap[left] > heap[largest]){
        largest = left;
    }

    if(right < heap.size() && heap[right] > heap[largest]){
        largest = right;
    }

    if(largest != i) {

        swap(heap[largest], heap[i]);
        Heapify(largest, heap);
    }

}


int pop(vector<int> &heap)
{
   
   if(heap.size() == 0) return -1;

   int n = heap.size();

   if(n ==1) {
       int pop = heap[0];
       heap.resize(0);
       return pop;
   }

   int pop = heap[0];

   heap[0] = heap[n-1];
   heap.resize(n-1);

   Heapify(0, heap);

   return pop;


}



// Code Snippet of the push function: 
//
//     void push(vector<int> &heap, int x)
//     {
//           heap.push_back(x);
//
//            // Posistion of the current inserted element.
//            int pos=heap.size()-1;
//
//            // Shifting the element up until it reaches the top most node if it is larger than its parent.
//            while(pos>0)
//            {
//                int parent = (pos-1)/2;
//                if(heap[pos] > heap[parent])
//                {
//                    swap(heap[parent],heap[pos]);
//                    pos=parent;
//               }
//              else
//              {
//                  // As parent is larger the element now is in its correct position. 
//                  break;
//              }
//          }
//      }

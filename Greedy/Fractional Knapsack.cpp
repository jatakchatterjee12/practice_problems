/*
    Company Tags : Microsoft
    Qn Link      : https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1#
*/

class Solution
{
    public:
    //Function to get the maximum total value in the knapsack.
    static bool cmp(struct Item a, struct Item b) {
        return (double)a.value / (double)a.weight > (double)b.value / (double)b.weight;
    }
 
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        sort(arr, arr+n, cmp);
        
        double profit = 0;
        for(int i = 0; i<n; i++) {
            double wt    = arr[i].weight;
            double val   = arr[i].value;
            double ratio = (double)val/(double)wt;
            if(wt <= W) {
                profit += val;
                W -= wt;
            } else {
                profit += ((double)val/(double)wt) * W;
                break;
            }
        }
        
        return profit;
    }
        
};
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//class implemented
/*
struct Item{
    int value;
    int weight;
};
*/


class Solution
{
    public:
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        vector<pair<double,int>> items; // {vaule per unit -> max wt I can pick}
        
        for(int i=0; i<n; i++){
            double value_per_weight = (double)arr[i].value / (double)arr[i].weight;
            items.emplace_back(value_per_weight, arr[i].weight);
        }
        
        sort(items.begin(), items.end(), [](pair<double, int> &a, pair<double, int> &b){
            return a.first > b.first;
        });
        
        double ans = 0;
        for(int i=0; i<n; i++){
            int take_weight = min(W, items[i].second);
            W -= take_weight;
            ans += (take_weight * items[i].first);
        }
        return ans;
    }
        
};

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


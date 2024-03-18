import java.util.*;

public class Solution
{
    static void inorder(Node root, List<Integer> ans){
        if(root == null) return ;

        inorder(root.left, ans);
        ans.add(root.data);
        //inorder(root.right, ans); // no need to go right as we are finding the min value only
    }
    public static int minValue(Node root) {

        if(root == null) return -1;
       
       List<Integer> list = new ArrayList<>();
       inorder(root, list);
       return  list.get(0);
       
    }
}

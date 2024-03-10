// Using String

class Solution {
    void solve(TreeNode root, String curr, List<String> ans) {

        if(root == null) return;
        

        curr += root.val + "->";

        if(root.left == null && root.right == null){
            curr = curr.substring(0, curr.length()-2);
            ans.add(curr);
            return;
        }

        solve(root.left, curr, ans);
        solve(root.right, curr, ans);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        String curr = "";
        List<String> ans = new ArrayList<>();
        solve(root, curr, ans);
        return ans;

    }
}


//Using String Builder
class Solution {
    void solve(TreeNode root, StringBuilder sb, List<String> ans) {

        if(root == null) return;

        int len = sb.length();
        if(len > 0) {
            sb.append("->");
        }
        sb.append(root.val);

        if(root.left == null && root.right == null){
           
            ans.add(sb.toString());
            
        }

        solve(root.left, sb, ans);
        solve(root.right, sb, ans);

        sb.setLength(len); // as i have to delete last two addings("->" + "root.val")

    }
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> ans = new ArrayList<>();
        solve(root, new StringBuilder(), ans);
        return ans;

    }
}

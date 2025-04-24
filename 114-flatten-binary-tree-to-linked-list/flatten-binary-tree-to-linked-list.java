class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return ;
        Stack<TreeNode> s= new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode curr=s.pop();
            if(curr.right!=null){
                s.add(curr.right);

            }
            if(curr.left!=null){
                s.add(curr.left);
            }
            if(!s.isEmpty()){
                curr.right=s.peek();
            }
            curr.left=null;
        }
    }
}
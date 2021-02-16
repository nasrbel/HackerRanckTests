package solutions;

public class IsItBinaryTree {

    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {

        if (root==null){return true ;}
        if(root.right ==null && root.left == null){
            return true ;
        }
        if(root.left != null && root.right != null && (root.left.data <root.data && root.right.data > root.data)){
            return true ;
        }
        Boolean checkLeft = checkBST(root.left);
        Boolean checkRight = checkBST(root.right);

        return checkLeft && checkRight;
    }
}

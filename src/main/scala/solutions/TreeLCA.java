package solutions;
/**
 * @author : Nassereddine BELGHITH Feb 2021
 * @Source: HackerRank challenges
 * @Language Java 8 , scala seems not as efficient as java because of the null handling
 */

import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeLCA {


    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/


    public static TreeNode lca(TreeNode root, int v1, int v2) {
/**
 *this method is base on searching v1 in left and v2 in right until finding them
 * if we find one of them so we return back the parent and so on
 * complexity = O(tree.size)
 *
 */
        if (v1 == v2) { return null; }

        if(root != null && (root.data == v1 || root.data == v2)){
            return root;
        }
        if (root == null) { return null; }

        TreeNode leftNode = lca(root.left, v1, v2);
        TreeNode rightNode = lca(root.right, v1, v2);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode == null && rightNode == null) {
            return null;

        }
        return (!(leftNode == null)) ? leftNode : rightNode;


    }


    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        TreeNode ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}
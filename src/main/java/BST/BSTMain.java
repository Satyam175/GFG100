package BST;

import java.util.ArrayList;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

//        System.out.println(bst.KthSmallestElement(bst.root,2));
        System.out.println("BFS");
        System.out.println(bst.BFS());
        System.out.println();

        ArrayList<Integer> in = new ArrayList<>();
        System.out.println("Inorder");
        bst.inorderTraversal(bst.root, in);
        System.out.println(in);
        System.out.println();


        ArrayList<Integer> post = new ArrayList<>();
        System.out.println("postorder");
        bst.postorderTraversal(bst.root, post);
        System.out.println(post);
        System.out.println();


        ArrayList<Integer> pre = new ArrayList<>();
        System.out.println("Preorder");
        bst.preorderTraversal(bst.root,pre);
        System.out.println(pre);
    }
}

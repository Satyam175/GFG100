package BST;

public class KthSmallestInBST {

    // Return the Kth smallest element in the given BST
//    public int KthSmallestElement(Node root, int K) {
//        ArrayList<Integer> list = Inorder(root, new ArrayList<>());
//        if(list.size() < K) return -1;
//        return list.get(K-1);
//    }
//
//    public ArrayList<Integer> Inorder(Node root, ArrayList<Integer> list){
//        if(root==null){
//            return list;
//        }
//
//        list = Inorder(root.left, list);
//        list.add(root.data);
//        list = Inorder(root.right, list);
//        return list;
//    }


//    O(N) and Space 0(1)
//public class Solution {
//    private int count = 0;
//    private int result = -1;
//
//    public int kthSmallest(Node root, int k) {
//        inorderTraversal(root, k);
//        return result;
//    }
//
//    private void inorderTraversal(Node node, int k) {
//        if (node == null || count >= k) {
//            return;
//        }
//
//        inorderTraversal(node.left, k);
//
//        count++;
//        if (count == k) {
//            result = node.data;
//            return;
//        }
//
//        inorderTraversal(node.right, k);
//    }
//}

}

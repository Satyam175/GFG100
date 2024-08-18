package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public Node root;

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (temp.value == newNode.value) {
                return false;
            }
            if (temp.value > newNode.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    public Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (temp.value < value) {
                temp = temp.right;
            } else if (temp.value > value) {
                temp = temp.left;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean rContains(Node currentNode, int val) {
        if (currentNode == null) return false;
        if (currentNode.value == val) return true;
        if (currentNode.value < val) {
            return rContains(currentNode.right, val);
        } else {
            return rContains(currentNode.left, val);
        }
    }

    public int KthSmallestElement(Node root, int K) {
        ArrayList<Integer> list = DFSInorder();
        int[] count = {0};
        int[] result = {0};
        getKthSmallest(root, K, count, result);
        return result[0];
    }

    public void getKthSmallest(Node root, int K, int[] count, int[] result) {
        if (root != null) {
            getKthSmallest(root.left, K, count, result);
            count[0]++;
            if (count[0] == K) {
                result[0] = root.value;
                return;
            }
            getKthSmallest(root.right, K, count, result);
        }
    }


    public void delete(int value) {
        rDelete(root, value);
    }

    public Node rDelete(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (currentNode.value < value) {
            currentNode.right = rDelete(currentNode.right, value);
        } else if (currentNode.value > value) {
            currentNode.left = rDelete(currentNode.left, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
                currentNode.right = null;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
                currentNode.left = null;
            } else {
                int minSubTree = minNode(currentNode.right);
                currentNode.value = minSubTree;
                currentNode.right = rDelete(currentNode.right, minSubTree);
            }
        }
        return currentNode;
    }

    public int minNode(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public ArrayList<Integer> BFS() {
        Node currentNode;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            result.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return result;
    }

//    public ArrayList<Integer> DFSPreorder(){
//        ArrayList<Integer> result = new ArrayList<>();
//        traverse(result, root);
//        return result;
//    }
//
//    public void traverse(ArrayList<Integer> list, Node currentNode){
//        if (currentNode == null) return;
//        list.add(currentNode.value);
//        traverse(list, currentNode.left);
//        traverse(list, currentNode.right);
//    }

    public ArrayList<Integer> DFSPreorder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode == null) return;
                results.add(currentNode.value);
                new Traverse(currentNode.left);
                new Traverse(currentNode.right);
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostorder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode == null) return;
                new Traverse(currentNode.left);
                new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInorder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode == null) return;
                new Traverse(currentNode.left);
                results.add(currentNode.value);
                new Traverse(currentNode.right);
            }
        }

        new Traverse(root);
        return results;
    }

    public static void preorderTraversal(Node root, ArrayList<Integer> results) {
        if (root != null) {
            results.add(root.value);
            preorderTraversal(root.left, results);
            preorderTraversal(root.right, results);
        }
    }

    public static void inorderTraversal(Node root, ArrayList<Integer> results) {
        if (root != null) {
            inorderTraversal(root.left, results);
            results.add(root.value);
            inorderTraversal(root.right, results);
        }
    }

    public static void postorderTraversal(Node root, ArrayList<Integer> results) {
        if (root != null) {
            postorderTraversal(root.left, results);
            postorderTraversal(root.right, results);
            results.add(root.value);
        }
    }

}

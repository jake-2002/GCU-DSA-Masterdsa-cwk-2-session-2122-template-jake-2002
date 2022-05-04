/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author rla
 */
public class BinaryTree<E> {
    protected Node<E> root;

    /**
     * Default Constructor
     * Creates an empty binary tree
     */
    public BinaryTree() {
        root = new Node<>();
    }
    /**
     * Construct a new binary tree with data in its root and
     * leftTree as the left subtree
     * rightTree as the right subtree
     * @param data The data to be stored
     * @param leftTree the left subtree
     * @param rightTree the right subtree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        this.root = new Node<>(data);
        if (leftTree != null) {
            this.root.leftNode = leftTree.root;
        } else {
            this.root.leftNode = null;
        }
        if (rightTree != null) {
            this.root.rightNode = rightTree.root;
        } else {
            this.root.rightNode = null;
        }
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    /**
     * For subclass use only.
     * Creates a binary tree with a specified root
     * @param root specified root for binary tree
     */
    private BinaryTree(Node<E> root){
        this.root = root;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public BinaryTree<E> getLeftTree(){
        if(this.root != null && this.root.leftNode != null){
            return new BinaryTree<>(this.root.leftNode);
        }
        else {
            return null;
        }
    }
    
    public BinaryTree<E> getRightTree(){
        if(this.root != null && this.root.rightNode != null){
            return new BinaryTree<>(this.root.rightNode);
        }
        else {
            return null;
        }
    }    
    
    public E getItemData(){
        if(!isEmpty()){
            return this.root.getNodeData();
        }
        else {
            return null;
        }
    }
    
    public boolean isLeaf(){
        return (this.root == null || (this.root.leftNode == null && this.root.rightNode == null));
    }
    
    @Override
    public String toString() {
        if (this.root == null){
            throw new NullPointerException("The tree is empty!");
        }
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, 1, sb);
        return sb.toString();
    }

    /**
     * Used by the toString method.
     * @param node
     * @param depth
     * @param sb 
     */
    private void preOrderTraversal(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraversal(node.leftNode, depth + 1, sb);
            preOrderTraversal(node.rightNode, depth + 1, sb);
        }
    }
    
    // Methods for traversing the tree
    // Preorder
    // inorder
    // postorder
    
    public String preorderTraversal() {
        StringBuilder printTree = new StringBuilder();
        preorderTraversal(printTree, root);
        return printTree.toString();
    }

    private void preorderTraversal(StringBuilder stb, Node<E> root) {
        stb.append(root.getNodeData().toString());
        if (root.leftNode != null) {
            stb.append("\n");
            preorderTraversal(stb, root.leftNode);
        }
        if (root.rightNode != null) {
            stb.append("\n");
            preorderTraversal(stb, root.rightNode);
        }
    }

    public E preorderTraversal(Node<E> root) {
        if (root.leftNode != null) {
            preorderTraversal(root.leftNode);
        }
        if (root.rightNode != null) {
            preorderTraversal(root.rightNode);
        }
        return root.getNodeData();
    }

    public String inorderTraversal() {
        StringBuilder stb = new StringBuilder();
        inorderTraversal(stb, root);
        return stb.toString();
    }

    private void inorderTraversal(StringBuilder stb, Node<E> root) {
        if (root.leftNode != null) {
            inorderTraversal(stb, root.leftNode);
        }
        stb.append(root);
        stb.append("\n");
        if (root.rightNode != null) {
            inorderTraversal(stb, root.rightNode);
        }
        
    }

    public String postorderTraversal() {
        StringBuilder stb = new StringBuilder();
        postorderTraversal(stb, root);
        return stb.toString();
    }

    private void postorderTraversal(StringBuilder stb, Node<E> root) {
        if (root.leftNode != null) {
            postorderTraversal(stb, root.leftNode);
            //stb.append(" ");
        }
        if (root.rightNode != null) {
            postorderTraversal(stb, root.rightNode);
            //stb.append(" ");
        }
        stb.append(root);
        stb.append("\n");
    }
    
}

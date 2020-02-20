package org.josh.singh.ctci.chapter4;

import org.josh.singh.ctci.chapter4.util.BasicTreeNode;

// Implement a function to check if a binary tree is a binary search tree.
public class ValidateBST {

    public boolean validate(BasicTreeNode<Integer> root) {
        if (root == null) return true;
        if (root.left != null && root.left.data > root.data) {
                return false;
        }
        if (root.right != null && root.right.data <= root.data) {
          return false;
        }
        return validate(root.left) && validate(root.right);
    }

}

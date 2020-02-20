package org.josh.singh.ctci.chapter4;

import org.josh.singh.ctci.chapter4.util.BasicTreeNode;

//  Implement a function to check if a binary tree is balanced.
//  For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
public class CheckBalanced {

    public boolean checkBalanced(BasicTreeNode<Integer> root){
        if(Math.abs(getHeight(root.left)-getHeight(root.right)) >1)
            return false;
        else return checkBalanced(root.left) && checkBalanced(root.right);

    }


    public int getHeight(BasicTreeNode<Integer> node){
        if(node == null) return 0;
        else return 1+ Math.max(getHeight(node.left),getHeight(node.right));
    }
}

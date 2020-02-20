package org.josh.singh.ctci.chapter4;

import org.josh.singh.ctci.chapter4.util.BasicTreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
// (e.g., if you have a tree with depth D, you'll have D linked lists).
public class ListOfDepths {

    //dfs keeping track of the depth youre on.
    //have a map of level to linked list

    private void generateListByDepthDFSRecursion(BasicTreeNode<Integer> root, Map<Integer, LinkedList<Integer>> mapOfLists, int level) {
        if (root == null) return;
        LinkedList<Integer> myList = mapOfLists.putIfAbsent(level, new LinkedList<>());
        myList.add(root.data);
        generateListByDepthDFSRecursion(root.left, mapOfLists, level + 1);
        generateListByDepthDFSRecursion(root.right, mapOfLists, level + 1);
    }

    public Map<Integer, LinkedList<Integer>> generateListByDepth(BasicTreeNode<Integer> root) {
        Map<Integer, LinkedList<Integer>> mapOfLists = new HashMap<>();
        generateListByDepthDFSRecursion(root, mapOfLists, 0);
        return mapOfLists;
    }

    private void generateListByDepthBFS(BasicTreeNode<Integer> root, Map<Integer, LinkedList<Integer>> mapOfLists) {
        if (root == null) return;

        Queue<BasicTreeNode<Integer>> queue =  new PriorityQueue<>();
        queue.add(root);
        queue.add(null);

        int level =0;
        while(!queue.isEmpty()){
            BasicTreeNode<Integer> item = queue.poll();
            if(item != null){
                LinkedList<Integer> myList = mapOfLists.putIfAbsent(level, new LinkedList<>());
                myList.add(item.data);
                if(item.left != null){
                    queue.add(item.left);
                }
                if(item.right != null){
                    queue.add(item.right);
                }
                queue.add(null);
            }else{
                level++;
            }
        }

    }


}

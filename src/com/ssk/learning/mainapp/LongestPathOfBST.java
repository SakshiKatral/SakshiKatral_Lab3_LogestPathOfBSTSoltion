package com.ssk.learning.mainapp;

import java.util.ArrayList;

import com.ssk.learning.data.BinarySearchTree;
import com.ssk.learning.data.Node;
import com.ssk.learning.operation.TreeNodeOperation;

public class LongestPathOfBST {

	static Node node;
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();

		node = binarySearchTree.createBSTree();
		TreeNodeOperation treeNodeOperation = new TreeNodeOperation();
		binarySearchTree.getValueFromUser();
		System.out.println("Exited successfully");
		
	}
	

}

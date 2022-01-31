package com.ssk.learning.data;

import java.util.ArrayList;
import java.util.Scanner;

import com.ssk.learning.operation.TreeNodeOperation;

public class BinarySearchTree {

	Node root;
	Scanner scanner = new Scanner(System.in);
	String string = "" ;
	TreeNodeOperation treeNodeOperation = new TreeNodeOperation();                   

	public BinarySearchTree() {
		root = null;
	}
	public Node getValueFromUser() {
		System.out.println("\nDo you want to test with other input" + "\nIf yes press 'y' else press any key to exit");
		string = scanner.next();
		BinarySearchTree tree = new BinarySearchTree();

		do {
			if(string.equalsIgnoreCase("y")) {
				System.out.println("Enter the number of nodes you want");
				int nodes = scanner.nextInt();
				System.out.println("Enter node values");
				int[] data = new int[nodes];
				for(int i = 0; i < nodes; i++) {
					data[i] = scanner.nextInt();
					if( i >= 1) {
						for(int j = 0; j <= i; j++) {
							for(int k = j+1; k <= i; k++ ) {
								if(data[j] == data[k]) {
									System.out.println("this value is already present please enter other value");
									i --;
								}
								else {
									tree.insert(data[i]);
									continue;
								}
							}
						}
					}
					else{
						tree.insert(data[i]);
					}
				}
				System.out.println("Logest Path of tree is");
				ArrayList<Integer> output = treeNodeOperation.findLongestPathOfTree(tree.root);
				treeNodeOperation.displayPath(output);
				System.out.println("\nDo you want to continue if yes press 'y' else press any key to exit");
				string = scanner.next();
			}
		}while(string.equalsIgnoreCase("y"));

		return root;
	}
	Node insert(int key) {
		root = insertRecord(root, key);
		return root; 
	}

	Node insertRecord(Node root, int key) {
		if(root == null) {
			root = new Node(key);
			return root;
		}
		if(key < root.getData()) {
			root.setLeft(insertRecord(root.getLeft(), key));
		}
		else if(key > root.getData()) {
			root.setRight(insertRecord(root.getRight(), key));
		}

		return root;
	}	

	public Node createBSTree() {
		BinarySearchTree tree = new BinarySearchTree();

		tree.root = new Node(100);

		tree.root.setLeft(new Node(20));
		tree.root.setRight(new Node(130));

		tree.root.getLeft().setLeft(new Node(10));
		tree.root.getLeft().setRight(new Node(50));

		tree.root.getLeft().getLeft().setLeft(new Node(5));

		tree.root.getRight().setLeft(new Node(110));
		tree.root.getRight().setRight(new Node(140));

		System.out.println("Logest Path of tree is");
		ArrayList<Integer> output = treeNodeOperation.findLongestPathOfTree(tree.root);
		treeNodeOperation.displayPath(output);
		return tree.root;
	}
}

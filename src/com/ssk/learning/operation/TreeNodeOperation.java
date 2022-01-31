package com.ssk.learning.operation;

import java.util.ArrayList;

import com.ssk.learning.data.Node;

public class TreeNodeOperation {
	public ArrayList<Integer> findLongestPathOfTree(Node node) {
		if(node == null) {
			ArrayList<Integer> al = new ArrayList<>();
			return al;
		}

		ArrayList<Integer> leftNode = findLongestPathOfTree(node.getLeft());
		ArrayList<Integer> rightNode = findLongestPathOfTree(node.getRight());
		if(leftNode.size() > rightNode.size()) {
			leftNode.add(node.getData());
		}
		else {
			rightNode.add(node.getData());
		}

		if(leftNode.size() > rightNode.size()) {
			return leftNode;
		}
		else {
			return rightNode;
		}
	}

	public void displayPath(ArrayList<Integer> arrayList){

		int size = arrayList.size();
		if(size == 0) {
			System.out.println("Node is empty");
		}
		else {
			for(int i = size -1 ; i >= 0; i--) {
				System.out.print(arrayList.get(i));
				if(i!=0) {
					System.out.print("->");
				}
			}
		}

	}
}
package com.qunar.fxd.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Preorder {


    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();
        preorderRec(root, list);
        return list;
    }


    public void preorderRec(Node root, List<Integer> res) {

        if (root == null) {
            return;
        }

        res.add(root.val);

        for (Node node : root.children) {
            preorderRec(node, res);
        }

    }


}

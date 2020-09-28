package edu.forty.bits.datastructures.tree;

public class NodeLevel {

    public static int getLevelUtil(TreeNode node, int data, int level) {
        if (node == null) return 0;
        if (node.data == data) return level;
        int downlevel = getLevelUtil(node.left, data, level + 1);
        if (downlevel != 0) return downlevel;
        downlevel = getLevelUtil(node.right, data, level + 1);
        return downlevel;
    }

    /* Returns level of given data value */
    public static int getLevel(TreeNode node, int data) {
        return getLevelUtil(node, data, 1);
    }
}

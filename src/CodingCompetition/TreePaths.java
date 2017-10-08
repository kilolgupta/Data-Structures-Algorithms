package CodingCompetition;

import java.net.Inet4Address;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.lang.*;


public class TreePaths {

    public static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public int solution(Tree root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        int max=0;
        for(String ans : answer){
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<ans.length();i++) {
                if(Character.isDigit(ans.charAt(i))) {
                    set.add(Character.getNumericValue(ans.charAt(i)));
                }
            }
            if(set.size()>max) max=set.size();
        }
        return max;
    }
    private static void searchBT(Tree root, String path, List<String> answer) {
        if (root.l == null && root.r == null) answer.add(path + root.x);
        if (root.l != null) searchBT(root.l, path + root.x + "->", answer);
        if (root.r != null) searchBT(root.r, path + root.x + "->", answer);
    }


    public static void main(String[] args) {
        Tree node2 = new Tree();
        node2.x = 6;
        node2.l=null;
        node2.l=null;

        Tree node3 = new Tree();
        node3.x = 2;
        node3.l=null;
        node3.r=null;

        Tree node1 = new Tree();
        node1.x = 5;
        node1.l=node2;
        node1.r=node3;

        Tree node6 = new Tree();
        node6.x=1;
        node6.l = null;
        node6.r=null;

        Tree node5 = new Tree();
        node5.x=3;
        node5.l=node6;
        node5.r=null;


        Tree node4 = new Tree();
        node4.x = 6;
        node4.l=node5;
        node4.r=null;

        Tree node = new Tree();
        node.x = 6;
        node.l=node1;
        node.r=node4;

        List<String> answer = new ArrayList<String>();
        if (node != null) searchBT(node, "", answer);
        System.out.print(answer);

    }
}

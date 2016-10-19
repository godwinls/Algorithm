package HihoCoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yunzhuo on 10/15/2016.
 * http://hihocoder.com/contest/hihointerview20/problem/2
 */
public class BuildingHeap {
    class Node {
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        BuildingHeap bh = new BuildingHeap();
        int[] res = bh.solve(arr);
        for(int i=0; i<n; i++){
            System.out.print(res[i]+" ");
        }
        sc.close();
    }
    private int[] solve(int[] arr){
        Node root = buildTree(arr, 0, arr.length-1);
        ArrayList<Integer> res = new ArrayList();
        traverse(root, res);
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
    private Node buildTree(int[] arr, int s, int e){
        if(s<0||s>=arr.length||e<0||e>=arr.length||s>e)
            return null;
        if(s==e)
            return new Node(arr[s]);
        int min= s;
        for(int i=s; i<=e; i++){
            if(arr[min]>arr[i]){
                min = i;
            }
        }
        Node root = new Node(arr[min]);
        root.left = buildTree(arr, s, min-1);
        root.right = buildTree(arr, min+1, e);
        return root;
    }
    private void traverse(Node root, ArrayList<Integer> res){
        if(root==null)
            return;
        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }
}

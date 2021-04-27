package com.Wallmart;


/*
Tree -> root node - 5

               5

           2         10

          1   3     7



          5 -> 28/6 = 4.6

          2 -> 6/3 = 2
          1 ->  1
          3 -> 3
          7->7
          10 -> 8.5

 */
public class Wallmart {
    static class Node{
        int data;
        int sum;
        int counter = 1;
        Node left,right;
        Node(int it){
            data = it;
            left = right = null;
        }

        public void getNodeAverage(Node n){
            if(n!=null)
            {
                System.out.println(sum);
                if(n.left!=null)
                {
                    sum +=n.left.data;
                    counter++;
                    getNodeAverage(n.left);
                }
                if(n.right!=null){
                    counter ++;
                    sum += n.right.data;
                    getNodeAverage(n.right);
                }
            }
        }

        public double getAverage(Node node){
            if(node!=null){
                sum+=node.data;
                getNodeAverage(node);
            }
            System.out.println(sum);
            return (double)sum/counter;
        }

    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        n1.left = new Node(2);
        n1.right = new Node(10);
        n1.left.left = new Node(1);
        n1.left.right = new Node(3);
        n1.right.left = new Node(7);
        System.out.println(n1.getAverage(n1));
    }



}

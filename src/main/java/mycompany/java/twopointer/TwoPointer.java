package mycompany.java.twopointer;

import java.util.Arrays;

public class TwoPointer {

    public static void main(String[] args) {
        //1.1
        String[] a = { "D65W", "C77E", "D65W", "A38K", "C41Q",
                        "C77E", "C77E", "A38K", "W68E", "Z15K"};
        for(int i = 1; i < a.length; i++){
            Arrays.sort(a);
            System.out.println(a[i]);
//            A38K
//            C41Q
//            C77E
//            C77E
//            C77E
//            D65W
//            D65W
//            W68E
//            Z15K
        }
        
        //1.2
        char[] b = "ABCDEFGHIJKL".toCharArray();
        arrenge(b, 4);
        String w = new String(b);
        System.out.println(w); //EFGHIJKLABCD
        
        //1.3 Recursive
        Node c = create1( 2, 5, 6, 7, 9 );
        Node d = create1( 1, 2, 2, 4, 6, 8, 8);
        Node e = merge1(c, d);
        print1(e); //1 2 2 2 4 5 6 6 7 8 8 9
        
        //1.4 Non Recursive
        Node f = create2( 2, 5, 6, 7, 9 );
        Node g = create2( 1, 2, 2, 4, 6, 8, 8);
        Node h = merge2(f, g);
        print2(h); //1 2 2 2 4 5 6 6 7 8 8 9
    }
    
    //1.2
    static void arrenge(char[] b, int p) {
        rotate(b, 0, p-1);
        rotate(b, p, b.length-1);
        rotate(b, 0, b.length-1);
    }
 
    static void rotate(char[] b, int left, int right) {
        while (true) {
            char temporary = b[left];
            b[left] = b[right];
            b[right] = temporary;
            left++; right--;
            if (left >= right) break;
        }
    }
    //------------------------------------------------------------------------\\
    
    //1.3 
    //This way is call recursive function.
    static Node merge1(Node c, Node d) {
        if (c == null && d == null) return null;
        if (c != null && d == null) return c;
        if (c == null && d != null) return d;
        //if (c != null && d != null) {}
        if (c.value < d.value) {
            // c < d chosed first c data.
            Node best = c;
            best.next = merge1(c.next, d);
            return best;
        } else {
            // d < c chosed d
            d.next = merge1(c, d.next);
            return d;
        }
    }
    
    static void print1(Node head) {
        for( Node e = head; e != null; e = e.next) {
            System.out.println(e.value);
        }
    }
    
    static Node create1( int ... data) {
        if (data.length == 0) return null; //emtry data not create.
        //if have 1 data
        Node head = new Node();
        head.value = data[0];
        Node last = head;
        
        //Loop the first data to last data.
        for (int i = 0; i < data.length; i++) {
            Node current = new Node();
            current.value = data[i];
            last.next = current;
            last = last.next;
        }
        return head;
    }
    
    //------------------------------------------------------------------------\\
    //1.4
    //This way is call Non recursive and this way is truely to coding.
    static Node merge2(Node f, Node g) {
        Node head2 = null;
        Node tail2 = null;
        while (true) {
            char side = 'x';
            if (f == null && g == null) { break; }
            if (f != null && g == null) { side = 'f'; }
            if (f == null && g != null) { side = 'g'; }
            if (f != null && g != null) {
                if(f.value < g.value) side = 'f';
                if(f.value >= g.value) side = 'g';
            }
            if (side == 'f') {
                if (head2 == null) {
                    head2 = f;
                    tail2 = head2;
                } else {
                    tail2.next = f;
                    tail2 = tail2.next;
                }
                f = f.next;
            }
            if (side == 'g') {
                if (head2 == null) {
                    head2 = g;
                    tail2 = head2;
                } else {
                    tail2.next = g;
                    tail2 = tail2.next;
                }
                g = g.next;
            }
        }
        return head2;
    }
    
    static void print2(Node head2) {
        for( Node h = head2; h != null; h = h.next) {
            System.out.println(h.value);
        }
    }
    
    static Node create2( int ... agrs) {
        if (agrs.length == 0) return null; //emtry data not create.
        //if have 1 data
        Node head2 = new Node();
        head2.value = agrs[0];
        Node last = head2;
        
        //Loop the first data to last data.
        for (int z = 0; z < agrs.length; z++) {
            Node current2 = new Node();
            current2.value = agrs[z];
            last.next = current2;
            last = last.next;
        }
        return head2;
    }
    
}

//1.3
class Node {
    int value;
    Node next;
}

//write funtion to checj Palindrome as
//check("ABC")
//check("RACECAR")
//check("WELCOME")
//check("K")
//It can use the way it's call Two Pointers
//------------------>           <--------------------

//1.2 Prescribed operation it like a snap card as
// A B C D E F G F I J K L
//         ^----------------Cut at E or (4)
// E F G F I J K L A B C D
// arrenge( char[] a, int p )
// Thw way to check it call Triple Rotation it call Two pointer.

//Data Structur as
//1. Array
//2. Linked List, Brockchane
//3. Tree
//4. Binary Tree
//5. Binary search tree

//Array and Linked list it can sort by Binary Search tree
//Linked list can sort data by only way is merge sort.


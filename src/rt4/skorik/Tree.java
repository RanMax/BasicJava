/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rt4.skorik;

import java.util.*;

public class Tree {
  //public TreeSet<Integer> tree;
  
  //public Tree(){
  //tree = new TreeSet<Integer>();
  //Random rand = new Random();
    //for (int i=1;i<10;i++){
    //    tree.add(rand.nextInt(100));
    //}
  //}
  
  public static void main(String[] args) {
        
        System.out.println("Tree Set\n");
        
        TreeSet <Integer>tree = new TreeSet<Integer>();
    //fill the tree-------------------------------------------------------------    
        tree.add(12);
        tree.add(23);
        tree.add(34);
        tree.add(45);
    //create iterator-----------------------------------------------------------
        Iterator<Integer> iterator;
        iterator = tree.iterator();
    //--------------------------------------------------------------------------
    //---------------------------------------------------print out tree contents     
    System.out.print("Tree set contains: ");    
    while (iterator.hasNext()){
        System.out.print(iterator.next() + " ");
    }
    //--------------------------------------------------------------------------
    
    System.out.println();
    
    //---------------------------------------------------------------empty check
    if (tree.isEmpty()){
        System.out.print("Tree Set is empty.");
    }
    else{
        System.out.println("Tree Set size: " + tree.size());
    }
    //--------------------------------------------------------------------------
    
    //------------------------------------------------get first and next element
    System.out.println("First data: " + tree.first());
    System.out.println("Last data: " + tree.last());
    //--------------------------------------------------------------------------
    
    //-------------------------------------------------------remove 12 from tree
    if (tree.remove(12)){ //removes specific object.
        System.out.println("Data is removed from tree set");
    }
    else{
        System.out.println("Data doesn't exist!");
    }
    //--------------------------------------------------------------------------
    
    //------------------------------------------------------new content of a set
    System.out.print("Now the tree set contain: ");
    iterator = tree.iterator(); //put the iterator on the beginning of a set
    
    while (iterator.hasNext()){
        System.out.print(iterator.next() + " ");
    }
    System.out.println();
    System.out.println("Now the size of tree set: " + tree.size());
    //--------------------------------------------------------------------------
    
    //Integer i;
    //i = iterator.next();
    //i.compareTo(i);
    iterator = tree.iterator();
    //String i = iterator.next();
    System.out.println(iterator.next());
    if (iterator.next().equals(iterator.next()))
    {
        System.out.println("Compared");   
    }
    else
    {
        System.out.println("NOT Compared");
    }
    //--------------------------------------------------------remove set content
    tree.clear();
        if (tree.isEmpty()){
            System.out.print("Tree Set is empty.");
        }
        else{
            System.out.println("Tree Set size: " + tree.size());
        }
  }
}

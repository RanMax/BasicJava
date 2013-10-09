/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.basicjava.rt4.skorik;

import java.util.*;

public class Sets {
    
    private HashSet<Integer> hashSet;
    private TreeSet<Integer> treeSet;
    private LinkedHashSet<Integer> linkedHashSet;
    private Map<Integer,String> hashMap;
    private ArrayList<String> arrayList;
 
    public Sets(int count){
        hashSet = new HashSet<Integer>();
        treeSet = new TreeSet<Integer>();
        linkedHashSet = new LinkedHashSet<Integer>();
        hashMap = new HashMap<Integer,String>(); //(capacity,loadFactor)
        arrayList = new ArrayList<String>();
        fillSets(count);
    }
 
    public void fillSets(int count){
        Random rand = new Random();
        for(int i = 0; i < count; i++){
            Integer element = rand.nextInt(100);
            hashSet.add(element);
            treeSet.add(element);
            linkedHashSet.add(element);
            hashMap.put(i,element.toString());
            arrayList.add(element.toString());
        }
    }
 
    public void print(){
        System.out.println("HashSet: \t" + hashSet.toString() + " (" + hashSet.size() + ")");
        System.out.println("TreeSet: \t" + treeSet.toString() + " (" + treeSet.size() + ")");
        System.out.println("LinkedHashSet: \t" + linkedHashSet.toString() + " (" + linkedHashSet.size() + ")");
        //System.out.println("HashMap: \t" + hashMap.entrySet().toString() + " (" + hashMap.size() + ")");
        for (Integer key: hashMap.keySet())
            System.out.print(hashMap.get(key));
        System.out.println("ArrayList: \t" + arrayList.toString() + " (" + arrayList.size() + ")");

        System.out.println("");
    }
 
    public void clear(){
        hashSet.clear();
    }
 
    public void removeMax(){
        Integer max = treeSet.last();
        treeSet.remove(max);
    }
 
    public void iterate(){
        Iterator<Integer> it = linkedHashSet.iterator();
        while(it.hasNext()){
            Integer element = it.next();
            if(element % 2 == 0){
                it.remove();
            }
        }
    }
 
    public void create(){
        hashSet = new HashSet<Integer>(treeSet);
    }
    
    public void remove(){
        arrayList.remove(1);
    }
    
    public void removeAll(){
        hashSet.removeAll(linkedHashSet);
    }
 
    public void retainAll(){
        hashSet.retainAll(linkedHashSet);
    }
    
    public static void main(String[] args) {
         //if(args.length < 1){
            //printUsage();
            //System.exit(0);
        //}
 
        int count;
 
        //try{
        //    count = Integer.valueOf(args[0]);
 
            Sets samples = new Sets(6);
            System.out.println("-- Begin --");
            samples.print();
            samples.clear();
            System.out.println("-- Clear --");
            samples.print();
            samples.removeMax();
            System.out.println("-- Remove max --");
            samples.print();
            samples.iterate();
            System.out.println("-- Iterate --");
            samples.print();
            samples.create();
            System.out.println("-- Create --");
            samples.print();
            samples.removeAll();
            System.out.println("-- Remove all --");
            samples.print();
            samples.create();
            System.out.println("-- Retain all --");
            samples.retainAll();
            samples.print();
 
        //}catch(NumberFormatException e){
            //printUsage();
        //}
 
    }
 
    public static void printUsage(){
        System.out.println("Usage: java Sets numberOfElements");
    }
    
}

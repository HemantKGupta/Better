package com.hkg.test;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class MyGraphTest {

	public static void main(String[] args) {
		//Graph g = new Graph(5, 11);
		Graph g = new Graph();
		System.out.println(g.toString());
	}
}

class Graph{
	
	public int v;
	public int e;
	Set<Integer>[] adj = null;
	/*
	public Graph(int v) {
        if (v < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.v = v;
        this.e = 0;
        adj =  (HashSet<Integer>[]) new HashSet[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<Integer>();
        }
    }
	*/
	 public Graph(int v, int e) {
	        this.v =v;
	        this.e =e;
	        adj =  (HashSet<Integer>[]) new HashSet[v];
	        for (int i = 0; i < v; i++) {
	            adj[i] = new HashSet<Integer>();
	        }
	        if (e < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
	        for (int i = 0; i < e; i++) {
	            int ver1 = (int) (Math.random() * v);
	            int ver2 = (int) (Math.random() * v);
	            addEdge(ver1, ver2);
	        }
	        
	        for (int i = 0; i < v; i++) {
	            adj[i].remove(i);
	        }
	    }
	  
	 public void addEdge(int ver1, int ver2) {
	        if (ver1 < 0 || ver1 >= v) throw new IndexOutOfBoundsException();
	        if (ver2 < 0 || ver2 >= v) throw new IndexOutOfBoundsException();
	        e++;
	        adj[ver1].add(ver2);
	        adj[ver2].add(ver1);
	    }
	 
	 public Iterable<Integer> adj(int i) {
	        if (i < 0 || i >= v) throw new IndexOutOfBoundsException();
	        return adj[i];
	    }
	 
	 public String toString() {
	        StringBuilder s = new StringBuilder();
	        String NEWLINE = System.getProperty("line.separator");
	        s.append(v + " vertices, " + e + " edges " + NEWLINE);
	        for (int i = 0; i < v; i++) {
	            s.append(i + ": ");
	            for (int w : adj[i]) {
	                s.append(w + " ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }
	 
	 public Graph() {
			
			try {
				Scanner s = new Scanner(new File("D:/MyGitRepo/Job/TestProject/src/com/hkg/test/tinyG.txt"));
	        	this.v = new Integer(s.nextLine());
	        	this.e = new Integer(s.nextLine());
	        	adj = (Set<Integer>[]) new Set[v];
	 	        for (int i = 0; i < v; i++) {
	 	            adj[i] = new HashSet<Integer>();
	 	        }
	            while (s.hasNextLine()) {
	            	String line = s.nextLine();
	            	line = line.trim();
	            	String[] vers = line.split("\\p{javaWhitespace}+");
	                int ver1 = new Integer(vers[0]);
	                int ver2 = new Integer(vers[1]);
	                addEdge(ver1, ver2);
	            }
	        } catch (IOException e) {
	            System.err.println(e);
	            System.exit(1);
	        }       
	    }
}

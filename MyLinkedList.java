
public class MyLinkedList {
	   private static int counter;
	    
	    private Node head;
	    
	    // default constructor
	    public MyLinkedList() {
	        
	    }
	    
	    public void add(Object data) {
	        
	        // initialize the head node
	        if (head == null) {
	            head = new Node(data);
	        }
	        
	        Node mylinkedlist_tempnode = new Node(data);
	        Node mylinkedlist_currentnode = head;
	        
	        // check NPE 
	        if (mylinkedlist_currentnode != null) {
	            
	            while (mylinkedlist_currentnode.getNext() != null) {
	                mylinkedlist_currentnode = mylinkedlist_currentnode.getNext();
	            }
	            
	            // the last nodes reference set to our curent nodes
	            mylinkedlist_currentnode.setNext(mylinkedlist_tempnode);
	            
	            incrementCounter();
	        }    
	         
	    }
	     
	    private static int getCounter() {
	        return counter;
	    }
	        
	    private static void incrementCounter() {
	      counter++;
	    }
	            
	    private static void decrementCounter() {
	      counter--;
	    }
	            
	            
	            
	    public void add(Object data, int index) {
	        
	           // initialize the head node
	        if (head == null) {
	            head = new Node(data);
	        }
	        
	        Node mylinkedlist_tempnode = new Node(data);
	        Node mylinkedlist_currentnode = head;
	        
	        // check NPE 
	        if (mylinkedlist_currentnode != null) {
	            
	            for (int i = 1; i < index && mylinkedlist_currentnode.getNext() != null; i++) {
	                mylinkedlist_currentnode = mylinkedlist_currentnode.getNext();
	            }
	            
	           	// set the new node's next-node reference to this node's next-node reference
	           	
	           	mylinkedlist_tempnode.setNext(mylinkedlist_currentnode.getNext());
	            
	            // the last nodes reference set to our curent nodes
	            mylinkedlist_currentnode.setNext(mylinkedlist_tempnode);
	            
	            incrementCounter();
	        }    
	        
	    }
	    
	    public Object get(int index) {
	        
	        if (index <= 0) {
	            return null;
	        }
	        
	        Node mylinkedlist_currentnode = null;
	        
	        if (head != null) {
	            
	            mylinkedlist_currentnode = head.getNext();
	            for (int i = 0; i < index; i++) {
	                if (mylinkedlist_currentnode.getNext() == null) {
	                    return null;
	                }  
	                
	                mylinkedlist_currentnode = mylinkedlist_currentnode.getNext();
	                
	                    
	                }
	                
	                return mylinkedlist_currentnode.getData();
	            }
	            
	            return mylinkedlist_currentnode;
	        }
	    
	    
	    public boolean remove(int index) {
	        
	        // is the index out of IndexOutOfBoundsException
	        if (index < 1  || index > size()) {
	            return false;
	        }
	        
	        Node mylinkedlist_currentnode = head;
	        if (head != null) {
	            for (int i = 0; i < index; i++) {
	                if (mylinkedlist_currentnode.getNext() == null) {
	                    return false;
	                }
	                
	                mylinkedlist_currentnode = mylinkedlist_currentnode.getNext();
	            }
	            
	            mylinkedlist_currentnode.setNext(mylinkedlist_currentnode.getNext().getNext());
	            
	            decrementCounter();
	            
	            return true;
	        }
	        
	        return false;

	    }
	    
	    public int size() {
	        return getCounter();
	    }
	    
	    public String toString() {
		  String output = "";
	 
			if (head != null) {
				Node crunchifyCurrent = head.getNext();
				while (crunchifyCurrent != null) {
					output += "[" + crunchifyCurrent.getData().toString() + "]";
					crunchifyCurrent = crunchifyCurrent.getNext();
				}
	 
			}
			return output;
		}
	    

	  private class Node {
	      
	      
	      Node next;
	      
	      Object data;
	      
	      // node constructor
	      public Node(Object dataValue) {
	          next = null;
	          data = dataValue;
	      }
	      
	      // another Node constructor if we want to specify the node to point to.
			@SuppressWarnings("unused")
			public Node(Object dataValue, Node nextValue) {
				next = nextValue;
				data = dataValue;
			}
			
			public Object getData() {
			    return data;
			}
			
			public Node getNext() {
			    return next;
			}
			
			public void setdata(Object dataValue) {
			    data = dataValue;
			}
			
			public void setNext(Node nextValue) {
			    next = nextValue;
			}
	 
	  }
	    
	    
	}

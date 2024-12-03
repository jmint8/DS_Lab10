import java.lang.Comparable;
import java.util.function.Consumer;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;



   public BSTNode(T val)
   {
      this(val,null,null);
   }
    

   public BSTNode(T val, BSTNode<T> l,BSTNode<T> r)
   {
	   this.val = val;
	   this.left = l;
	   this.right =r;
   }

	
	  public T getVal() // additional method for starting summation and largest methods. 
	  { 
		  return this.val; 
	  }
	  public BSTNode<T> getL()
	  {
		  return this.left;
	  }
	  public BSTNode<T> getR()
	  {
		  return this.right;
	  }

   /*
     Uses recursion to insert the target into the tree
    */
   public void insert(T target)
   {
		/*
		 * if(target==this.val) { return; }
		 */
	   if (this.val.compareTo(target)>0)
	   {
		   if(this.left==null)
		   {
			   left = new BSTNode<T>(target);
			   
		   }
		   else 
		   {
			   this.left.insert(target);
		   }
	   }
	   else
	   {
		   if(this.right==null)
		   {
			   right = new BSTNode<T>(target);
			   
		   }
		   else
		   {
			   this.right.insert(target);
		   }
	   } 
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
	   if(this.val.equals(target))
	   {
		   return target;
	   }
	   if(this.left != null && this.val.compareTo(target)>0)
	   {
		   return this.left.retrieve(target);
	   }
	   else if(this.right != null && this.val.compareTo(target)<0)
	   {
		   return this.right.retrieve(target);
	   }
	   else 
	   {
	   return null;
	   }
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target,int depth)
   {
	   if(this.val == target)
	   {
		   return depth;
	   }
	   if (this.val.compareTo(target)>0 && this.left!=null)
	   {
		   return this.left.retrieveDepth(target, depth+1);
	   }
	   else if(this.val.compareTo(target)<0 && this.right!=null)
	   {
		   return this.right.retrieveDepth(target, depth+1);
	   }
	   else 
	   {
		   return depth+1;
	   }
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
	   if(this.right==null) {
		   return this.val;
	   }
	   else 
	   {
	   return this.right.getLargest();
	   }
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume) 
   {
	   if(this.left != null) {
		   
		   this.left.inOrderTraversal(consume);
	   }
	   consume.accept(this.val);
	   if(this.right != null) {
		   this.right.inOrderTraversal(consume);
	   }
   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that) //TODO
   {
	   if(that == null)
	   {
		   return false;
	   }
	   if(!this.val.equals(that.val))
	   {
		   return false;
	   }
	   if ((this.right == null && that.right != null) || (this.right != null && !this.right.myEquals(that.right))) 
	   {
	       return false;
	   }
	   if ((this.left == null && that.left != null) || (this.left != null && !this.left.myEquals(that.left))) 
	   {
	       return false;
	   }
	   return true;
   }

}

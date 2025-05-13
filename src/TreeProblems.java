import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeProblems 
{
   // Post-order traversal for Node class version
   public static <T> void postOrder(Node<T> root) 
   {
    // Base case: if root is null, do nothing
    if (root == null) return;

    
    if (root.children != null) 
    {
      // First, recursively visit all children
      for (Node<T> child : root.children) 
      {
      
        postOrder(child);
      }
    }
    // Then, print the value of the current node
    System.out.println(root.value);
  }

  /*
   postOrder (Node Version)
   -----------
   Given the root of a tree print out the values of the nodes in post-order.
   Print each value on a separate line.

   Example:
   If the tree is:
          5
       /  |  \
      3   9   8
        / | \  
       4  1  2
   The output should be:
   3
   4
   1
   2
   9
   8
   5

   If the root is null, do nothing.
   */




  public static <T> void postOrder(Node<T> root) 
    {
      // Base case: if root is null, do nothing
      if (root == null) return;
  
      
      if (root.children != null) 
      {
        // First, recursively visit all children
        for (Node<T> child : root.children) 
        {
        
          postOrder(child);
        }
      }
      // Then, print the value of the current node
      System.out.println(root.value);
    }


  /*
   postOrder (Node Version)
   -----------
   Given the root of a tree print out the values of the nodes in post-order.
   Print each value on a separate line.
   If the tree is null or does not contain the root, do nothing.

   Example:
   For a tree represented as:
     5 -> [3, 9, 8]
     3 -> []
     9 -> [4, 1, 2]
     4 -> []
     1 -> []
     2 -> []
   The output should be:
   3
   4
   1
   2
   9
   8
   5
   */

  public static <T> void postOrder(Map<T, List<T>> tree, T root) 
  {
    //base case 
    //if tree or root is null or tree is root return
    if (tree == null || root == null || !tree.containsKey(root)) return;

    
    if (tree.get(root) != null) 
    {
      // First, recursively process all children of the current root
      for (T child : tree.get(root)) 
      {
        postOrder(tree, child);
      }

    }
    // Then, print the current root value
    System.out.println(root);
  }




  /*
   sumTree (Node Version)
   -----------
   Given a tree built with the Node class (with integer values), compute and return the sum of all the node values.
   Example:
   If the tree is:
          5
       /  |  \
      3   9   8
        / | \  
       4  1  2
   then the method should return 32.
   A null tree should return 0
  */


  public static int sumTree(Node<Integer> root) 
  {
    //base case if tree is empty root is null retirn 0
    if (root == null) return 0;

    // Start with the value of the current node
    int sum = root.value;

    //if current nod has children we have to add the values
    if (root.children != null) 
    {
      // Add the sum of all children's subtrees
      //loop through each child node
      for (Node<Integer> child : root.children) 
      {
        //call sum tree and add result to sum
        sum += sumTree(child);
      }
    }

    return sum;
  }





  /*
   sumTree (Map Version)
   -----------
   Given a tree represented as a map (where every node appears as a key and leaf nodes map to an empty list),
   compute the sum of all nodes.
   Example:
   For a tree represented as:
     5 -> [3, 9, 8]
     3 -> []
     9 -> [4, 1, 2]
     4 -> []
     1 -> []
     2 -> []
   the method should return 32.

   A null tree should return 0

   Hint: There's a simple way to do this!
  */
  public static int sumTree(Map<Integer, List<Integer>> tree) 
  {
    //base case if tree is null or empty
    if (tree == null || tree.isEmpty()) return 0;

    //tracker variable
    int sum = 0;

    //all the values ocrur in the key within the map
    //so use a for each loop
    for(int num : tree.keySet())
    {
      //add nodes vallue to sum
      sum += num;
    }
    //return final sum of all nodes
    return sum;
  }



  /*
   findRoot
   -----------
   Given a tree represented as a map where each key is a parent node and the value is a list of its children,
   find the root of the tree. The root is the node with no parents.
   Example:
   If the tree is represented as:
     20 -> [40]
     8  -> []
     30 -> []
     10 -> [20, 30, 99]
     40 -> []
     99 -> [8]
   then the method should return 10.

  You can assume the tree is non-null and well-formed.

   Hint: No recursion needed! Think about how you would do this by hand.
  */
  public static <T> T findRoot(Map<T, List<T>> tree) 
  {
    //Make a set of all nodes that appear as children
    Set<T> children = new HashSet<>();

    //move through the list of children and add them to children set
    for (List<T> childList : tree.values()) 
    {
      children.addAll(childList);
    }

    //The root is a node that is not in the set of children
    for (T node : tree.keySet()) 
    {
      //if node wasnt a child then its a root
      if (!children.contains(node)) 
      {
        return node;
      }
    }

    return null; // Should not happen if the tree is well-formed
  }




  /*
   maxDepth (Node Version)
   -----------
   Compute the maximum depth of a tree using the Node class. The depth is the number of nodes along
   the longest path from the root down to the farthest leaf. The root is at depth 1. If the tree is null, return 0.
   Example:
   For a tree structured as:
          A
       /  |  \
      B   E   C
      |      / \
      E     D   Q
             \ 
              Z
   the maximum depth is 4.

   
  */
  public static <T> int maxDepth(Node<T> root) 
  {
    //base case if null return 0
    if (root == null) return 0;

    //tracker equals 0
    int max = 0;

    // Check each child to find the deepest branch
    for (Node<T> child : root.children) 
    {
        int childDepth = maxDepth(child); // Get depth of this child

        // Update max if this child's depth is greater
        if (childDepth > max) 
        {
            max = childDepth;
        }
    }

    return 1 + max; // Add 1 for the current node
  }






  /*
   maxDepth (Map Version)
   -----------
   Compute the maximum depth of a tree using the Node class. The depth is the number of nodes along
   the longest path from the root down to the farthest leaf. The root is at depth 1. If the tree is null, return 0.
   Example:
   For a tree structured as:
    A -> [B, E, C]
    B -> [E]
    E -> []
    C -> [D, Q]
    D -> [Z]
    Q -> []
    Z -> []
   the maximum depth is 4 (A->C->D->Z).

   Hint: Use findRoot to start. Then, make a recursive helper method.
  */
  public static int maxDepth(Map<String, List<String>> tree) 
  {
    //check if tree is null or empty
    if (tree == null || tree.isEmpty()) return 0;

    //Find the root
    String root = findRoot(tree);

    //Use helper to find max depth
    return maxDepthHelper(tree, root);
  }

  public static int maxDepthHelper(Map<String, List<String>> tree, String node)
  {

     //tracker equals 0
     int max = 0;
 
     // Check each child to find the deepest branch
     //passing in node as node represents the keys
     for (String child : tree.get(node)) 
     {
          //pass in the tree referencing the map 
          //pass in the child string to make sure we search the tree
         int childDepth = maxDepthHelper(tree, child); // Get depth of this child
 
         // Update max if this child's depth is greater
         if (childDepth > max) 
         {
             max = childDepth;
         }
     }
 
     return 1 + max; // Add 1 for the current node
  }
}

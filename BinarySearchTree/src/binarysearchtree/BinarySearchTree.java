package binarysearchtree;
class Node{
    int data;
    Node left;
    Node right;
}
class BST{
public Node insertion(Node root,int val){
if (root==null){
    return createnewnode(val);
}
if (val>root.data){
root.right= insertion(root.right,val);
}
else if(val<root.data){
root.left = insertion(root.left,val);
}
return root;
}
public Node createnewnode(int val){
    Node newnode=new Node();
    newnode.data=val;
    newnode.left=null;
    newnode.right=null;
    return newnode;
}
public void inorder(Node Root){
if(Root==null){
return;}
inorder(Root.left);
System.out.println(Root.data);
inorder(Root.right);
}
public void preorder(Node Root){
if(Root==null){
return;}
System.out.println(Root.data);
preorder(Root.left);
preorder(Root.right);
}
public void postorder(Node Root){
if(Root==null){
return;}
postorder(Root.left);
postorder(Root.right);
System.out.println(Root.data);
}
public int getheightoftree (Node root){
if (root==null){
    return -1;}
return Math.max(getheightoftree(root.left), getheightoftree(root.right))+1;
}
public Node getsuccessor(Node root){
if (root==null){
return root;}
Node temp=root.right;
while(temp.left!=null){
temp=temp.left;}
return temp;
}
public Node deletion(Node root,int val){
if (root==null){
return root;}
if(val>root.data){
root.right=deletion(root.right,val);}
else if(val<root.data){
 root.left=deletion(root.left,val);}
else{
if(root.left==null || root.right==null){
Node temp= root.left !=null ? root.left : root.right;
if(temp==null){return null;} else return temp;}
else {Node successor = getsuccessor(root);
root.data=successor.data;
root.right=deletion(root.right,successor.data);
return root;}
}
return root;
}
public int getmax(Node root){
if(root==null){
System.out.println("the tree is empty");
return -1;}
while(root.right!=null){
root=root.right;}
return root.data;}

public void search(Node node, int val){
if(node == null) {
System.out.println(val+" is not here");}
if(val < node.data) {
search(node.left, val);
} else if(val > node.data) {
search(node.right, val);
}
else if (val == node.data){
System.out.println(val +" is here");}
}
public boolean ifNodePresent(Node node, int val) {
if(node == null) { return false; } 
boolean isPresent = false; 
while(node != null) {
if(val < node.data) { node = node.left; }
else if(val > node.data) { node = node.right; }
else { isPresent = true; break; }
} 
return isPresent;
}
}

public class BinarySearchTree {
    public static void main(String[] args) {
      BST a = new BST();
Node root = null;
root = a.insertion(root, 8);
root = a.insertion(root, 3);
root = a.insertion(root, 6);
root = a.insertion(root, 10);
root = a.insertion(root, 4);
root = a.insertion(root, 7);
root = a.insertion(root, 1);
root = a.insertion(root, 14);
root = a.insertion(root, 13); 
System.out.println("the height of tree is  " +a.getheightoftree(root));
a.search(root, 8);
a.deletion(root, 10);
a.inorder(root);

      }
    
}

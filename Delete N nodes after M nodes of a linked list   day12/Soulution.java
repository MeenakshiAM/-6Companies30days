class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
    Node current = head;
        Node temp;
        
        while (current != null) {

            for (int count = 1; count < M && current != null; count++) {
                current = current.next;
            }
            
            if (current == null) {
                return;
            }
            
            temp = current.next;
            for (int count = 1; count <= N && temp != null; count++) {
                Node nodeToDelete = temp;
                temp = temp.next;
                nodeToDelete = null;
            }
            
            current.next = temp;
            current = temp;
        }
    }
}

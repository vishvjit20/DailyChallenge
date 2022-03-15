import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class leetcode138 {
    // public Node copyRandomList(Node head) {
    // Map<Node, Node> map = new HashMap<>();
    // Node nHead = new Node(-1);
    // Node curr = head, prev = nHead;
    // while (curr != null) {
    // Node node = new Node(curr.val);
    // prev.next = node;
    // map.put(curr, prev.next);
    // prev = prev.next;
    // curr = curr.next;
    // }
    // curr = head;
    // nHead = nHead.next;
    // while (curr != null) {
    // Node copyNode = map.get(curr);
    // copyNode.random = map.get(curr.random);
    // curr = curr.next;
    // }
    // return nHead;
    // }

    private void copyList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node fwd = curr.next;
            Node node = new Node(curr.val);
            curr.next = node;
            node.next = fwd;

            curr = fwd;
        }
    }

    private void copyRandomPoiters(Node head) {
        Node curr = head;
        while (curr != null) {
            Node random = curr.random;
            if (random != null) {
                curr.next.random = random.next;
            }
            curr = curr.next.next;
        }
    }

    private Node extractDeepCopy(Node head) {
        Node dummy = new Node(-1);
        Node prev = dummy, curr = head;

        while (curr != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;

            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        copyList(head);
        copyRandomPoiters(head);
        return extractDeepCopy(head);
    }
}

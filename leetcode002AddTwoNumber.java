public class leetcode002AddTwoNumber {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(){}
        public ListNode(int val){ this.val = val;}
        public ListNode(int val, ListNode next){ this.val = val; this.next = next;}
    } 

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode t = l;
        int carry = 0;
        while(l1 != null || l2 != null) {           
            int sum = 0;
            if(l1 == null) {
                sum = l2.val + carry;                
                l2 = l2.next;
            } else if(l2 == null) {
                sum = l1.val + carry;                
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;                
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            l.next = newNode;
            l = newNode;
        }

        if(carry == 1) {
            ListNode newNode = new ListNode(1);
            l.next = newNode;
            l = newNode;
        }
        return t.next;
    }

    private static void printList(ListNode l) {
        while(l != null) {
            System.out.print(l.val + "  ");
            l = l.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        printList(l1);
        System.out.println();

        ListNode l2 = new ListNode(1);
        printList(l2);
        System.out.println();

        ListNode l = addTwoNumbers(l1, l2);
        printList(l);
    }
}
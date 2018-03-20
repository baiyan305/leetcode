// 2. Add Two Numbers

class AddTwoNumbers {
    
    public static void main(String[] args) {
        ListNode l1 = Util.generateLinkedListFromArray(new int[]{1,2,3,5,9});
        ListNode l2 = Util.generateLinkedListFromArray(new int[]{4,5,6,5});

        ListNode sum = addTwoNumbers(l1, l2);

        while(sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }
    } // end of main

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode cursor = new ListNode(0);
        ListNode dummyHead = cursor;

        while(l1 != null || l2 != null) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(sum%10);
            cursor.next = node;
            cursor = cursor.next;

            sum /= 10;
        }

        if(sum != 0) {
            ListNode node = new ListNode(sum);
            cursor.next = node;
        }

        return dummyHead.next; 
    } //end of addTwoNumbers

}

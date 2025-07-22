// 節點類別
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PrintReverse {

    // 遞迴方式反向列印
    public static void printReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);       // 先遞迴到尾巴
        System.out.print(head.val + " "); // 再印出自己（後進先出）
    }

    public static void main(String[] args) {
        // 建立測試用鏈結串列：1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("反向列印結果: ");
        printReverse(head); // 預期輸出：4 3 2 1
    }
}
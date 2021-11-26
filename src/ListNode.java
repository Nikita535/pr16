public class ListNode {
    protected ListNode next;
    protected Item value;

    public ListNode() {
        this.next = null;
    }

    public ListNode(ListNode next, Item value) {
        this.next = next;
        this.value = value;
    }
}

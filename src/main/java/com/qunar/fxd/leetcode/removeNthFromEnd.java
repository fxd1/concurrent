package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * 上述算法可以优化为只使用一次遍历。我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1n+1 步，而第二个指针将从列表的开头出发。现在，这两个指针被 nn 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 nn 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
 *
 * 。哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部
 */
public class removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode dummyNode = new ListNode(-1);
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        dummyNode.next = head;

        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;

        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }


}

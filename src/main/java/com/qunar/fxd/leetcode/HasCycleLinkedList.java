package com.qunar.fxd.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 */
public class HasCycleLinkedList {

    // 利用 哈希表 来判断 是否有重复的节点
    public boolean hasCycle(ListNode head) {

        Set<ListNode> listNodeSet = new HashSet<>();

        while (head != null) {
            if (!listNodeSet.contains(head)) {
                listNodeSet.add(head);
                head = head.next;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * 双指针
     * @param head
     * @return
     *思路
     *
     * 想象一下，两名运动员以不同的速度在环形赛道上跑步会发生什么？
     *
     * 算法
     *
     * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。慢指针每次移动一步，而快指针每次移动两步。
     *
     * 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
     *
     * 现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。而快跑者最终一定会追上慢跑者。这是为什么呢？考虑下面这种情况（记作情况 A） - 假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。
     *
     * 其他情况又会怎样呢？例如，我们没有考虑快跑者在慢跑者之后两步或三步的情况。但其实不难想到，因为在下一次或者下下次迭代后，又会变成上面提到的情况 A。
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)， 让我们将 nn 设为链表中结点的总数。为了分析时间复杂度，我们分别考虑下面两种情况。
     *
     * 链表中不存在环：
     * 快指针将会首先到达尾部，其时间取决于列表的长度，也就是 O(n)O(n)。
     *
     * 链表中存在环：
     * 我们将慢指针的移动过程划分为两个阶段：非环部分与环形部分：
     *
     * 慢指针在走完非环部分阶段后将进入环形部分：此时，快指针已经进入环中 \text{迭代次数} = \text{非环部分长度} = N迭代次数=非环部分长度=N
     *
     * 两个指针都在环形区域中：考虑两个在环形赛道上的运动员 - 快跑者每次移动两步而慢跑者每次只移动一步。其速度的差值为1，因此需要经过 \dfrac{\text{二者之间距离}}{\text{速度差值}}
     * 速度差值
     * 二者之间距离
     * ​
     *   次循环后，快跑者可以追上慢跑者。这个距离几乎就是 "\text{环形部分长度 K}环形部分长度 K" 且速度差值为 1，我们得出这样的结论 \text{迭代次数} = \text{近似于}迭代次数=近似于 "\text{环形部分长度 K}环形部分长度 K".
     *
     * 因此，在最糟糕的情形下，时间复杂度为 O(N+K)O(N+K)，也就是 O(n)O(n)。
     *
     * 空间复杂度：O(1)O(1)， 我们只使用了慢指针和快指针两个结点，所以空间复杂度为 O(1)O(1)。
     */
    public boolean hasCycle1(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 *
 * 解题：http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
 */
public class FindDuplicate {
    /**
     * 快慢指针，一个时间复杂度为O(N)的算法。
     *
     * 其一，对于链表问题，使用快慢指针可以判断是否有环。
     *
     * 其二，本题可以使用数组配合下标，抽象成链表问题。但是难点是要定位环的入口位置。
     *
     * 举个例子：nums = [2,5, 9 ,6,9,3,8, 9 ,7,1]，构造成链表就是：2->[9]->1->5->3->6->8->7->[9]，也就是在[9]处循环。
     *
     * 其三，快慢指针问题，会在环内的[9]->1->5->3->6->8->7->[9]任何一个节点追上，不一定是在[9]处相碰，事实上会在7处碰上。
     *
     * 其四，必须另起一个for循环定位环入口位置[9]。这里需要数学证明。
     *
     * http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
     *
     * 对“其四”简单说明一下，既然快慢指针在环内的某处已经相碰了。那么，第二个for循环遍历时，res指针还是在不停的绕环走，但是必定和i指针在环入口处相碰。
     */

    public int findDuplicate(int[] nums) {

        int fast = 0;
        int slow = 0;
        //快指针 追上慢 指针 ，表示  有环
        while (fast < nums.length){

            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast){
                break;
            }
        }

        //从头开始遍历  当两个指针相遇的时候，就是环的入口
        fast  =0;
        while (true){
            slow = nums[slow];
            fast = nums[fast];

            if (slow == fast){
                return slow;
            }
        }


    }


}

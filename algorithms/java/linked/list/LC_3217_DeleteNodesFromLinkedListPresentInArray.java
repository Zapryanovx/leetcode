// https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/

package linked.list;

import java.util.HashSet;
import java.util.Set;

public class LC_3217_DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode start = new ListNode(-1, head);

        Set<Integer> toRemove = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            toRemove.add(nums[i]);
        }

        removeAll(start, toRemove);
        return start.next;
    }

    private void removeAll(ListNode start, Set<Integer> toRemove) {
        ListNode curr = start;
        while (curr.next != null) {
            if (toRemove.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }
}

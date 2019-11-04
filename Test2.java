//编写一个程序，找到两个单链表相交的起始节点。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode pL=headA;
        ListNode pS=headB;
        int len1=getLen(headA);
        int len2=getLen(headB);
        int len=len1-len2;
        if(len<0){
            pL=headB;
            pS=headA;
            len=-len;
        }
        while(len!=0){
            pL=pL.next;
            len--;
        }
        while(pL!=pS){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pL!=null){
            return pL;
        }
        return null;
    }
    public int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
         ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        for(int i=0;i<m-1;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next;
        for(int i=m;i<n;i++){
            ListNode curNext=cur.next;
            cur.next=curNext.next;
            curNext.next=pre.next;
            pre.next=curNext;
        }
        return dummy.next;
    }
}

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        int len=getLen(head);
        ListNode pre=dummy;
        ListNode cur=dummy.next;
        for(int i=0;i<len/k;i++){
            for(int j=0;j<k-1;j++){
                ListNode curNext=cur.next;
                cur.next=curNext.next;
                curNext.next=pre.next;
                pre.next=curNext;
            }
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
        
    }
    public int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}


给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=dummy.next;
        int len=getLen(head);
        for(int i=0;i<len/2;i++){
                ListNode curNext=cur.next;
                cur.next=curNext.next;
                curNext.next=pre.next;
                pre.next=curNext;
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
    public int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}


//删除链表的倒数第n个节点并返回链表的头指针
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n<=0){
            return head;
        }
        if(n==getLen(head)){
            return head.next;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(n!=0){
                fast=fast.next;
                n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
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

//将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead=new ListNode(-1);
        ListNode cur=newHead;
        ListNode head1=l1;
        ListNode head2=l2;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                cur.next=head1;
                cur=cur.next;
                head1=head1.next;
            }else{
                cur.next=head2;
                cur=cur.next;
                head2=head2.next;
            }
        }
        if(head1==null){
            cur.next=head2;
        }else{
            cur.next=head1;
        }
        return newHead.next;
    }
}

//给出一个排好序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        ListNode pre=newHead;
        ListNode cur=pre.next;
        while(cur!=null){
            if(cur.next!=null&&cur.next.val==cur.val){
                while(cur.next!=null&&cur.next.val==cur.val){
                    cur=cur.next;
                }
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return newHead.next;
    }
}
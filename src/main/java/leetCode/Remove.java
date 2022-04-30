package leetCode;

/**
 * @author 河南张国荣
 * @create 2020-12-03 10:14
 */
public class Remove {
    public boolean removeNode(ListNode pNode) {

        // write code here
        if(pNode.next==null){
            return false;
        }
        pNode.val=pNode.next.val;
        pNode.next=pNode.next.next;
        return true;
    }
}

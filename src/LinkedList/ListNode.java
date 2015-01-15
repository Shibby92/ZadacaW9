package LinkedList;

/**
 * Node interface for read-only walking through list.
 * 
 * @author harisarifovic
 *
 */
public interface ListNode {
	/**
	 * @return value held by this node
	 */
	Object getValue();
	
	/**
	 * @return next list node if available
	 */
	ListNode getNext();
}

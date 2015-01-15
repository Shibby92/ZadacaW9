package LinkedList;

/**
 * Runtime exception thrown if index based list operations failed.
 * 
 * @author harisarifovic
 *
 */
public class ListIndexExceededException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ListIndexExceededException(int index) {
		super("Invalid index " + index);
	}
}

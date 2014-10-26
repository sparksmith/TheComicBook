/**
 * 
 */
package exceptions;

/**
 * @author sparksmith
 *
 */
public class fileNotFound extends Exception {
	private static final long serialVersionUID = 4664456874499611218L;
	private String errorCode = "Comic Book File not found !";

	public fileNotFound(String message) {
		super(message);
	}

	public String getErrorCode() {
		return this.errorCode;
	}

}

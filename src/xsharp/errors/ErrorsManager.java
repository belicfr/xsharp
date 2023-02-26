/*
 * ErrorsManagement.java
 * by belicfr
 * 02.26.23
 */
package xsharp.errors;

/**
 * Errors manager class.
 * 
 * <p>
 *  This class is used to display, in defined output, internal or 
 *  triggered errors.
 * </p>
 * 
 * @author belicfr
 */
public class ErrorsManager {
    /**
     * Internal error layout that is used by internalError class 
     * method.
     * 
     * It allows interpreter to display internal error header and 
     * the given reason.
     */
    private static final String INTERNAL_ERROR_LAYOUT
        = "(!) Xsharp internal error!\n"
        + "Reason: %s";
    
    /**
     * Internal error displaying method.
     * 
     * Allows interpreter to display internal error, based on 
     * internal error layout.
     * 
     * @param reason Given error reason to display
     */
    public static void internalError(String reason) {
        System.out.printf(INTERNAL_ERROR_LAYOUT, reason);
    }
}

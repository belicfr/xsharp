/*
 * Xsharp.java
 * by belicfr
 * 02.26.23
 */
package xsharp;

import xsharp.errors.ErrorsManager;
import xsharp.prompt.Prompt;

/**
 * Xsharp main class.
 * 
 * <p>
 * This class must be runned to use Xsharp interpreter. It allows him
 * to run interpreter with two ways: 
 * </p>
 * 
 * <ul>
 *  <li>
 *      <strong>Without arguments:</strong> the prompt is opened,
 *      and the user can put instructions line per line.
 *  </li>
 *  <li>
 *      <strong>With one argument:</strong> the given file path is
 *      used by interpreter to open corresponding file.
 *  </li>
 * </ul>
 * 
 * @author belicfr
 * @version 2023.1.1nu (NOT USABLE - PUBLIC AND DEVELOPMENT VERSION)
 */
class Xsharp {
    /**
     * This method asks an optional parameter: args.
     * 
     * Take a look to class javadoc to learn more about args usage.
     * This method is the entry door to interprete given file or 
     * given line(s) in the prompt.
     * 
     * @param args (optional) Given file path to use with interpreter
     */
    public static void main(String[] args) {
        
        final int ARGS_LENGTH = args.length;

        /*
         * args length =>  == 0 => open prompt
         *                 == 1 => open file in interpreter
         *                 else => error
         */
        
        if (ARGS_LENGTH == 0) {
            Prompt.run();
        } else if (ARGS_LENGTH == 1) {
            // TODO: open file with interpreter
        } else {
            ErrorsManager.internalError("Wrong args length");
        }

    }
}
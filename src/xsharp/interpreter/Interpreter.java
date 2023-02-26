/*
 * Interpreter.java
 * by belicfr
 * 02.26.23
 */
package xsharp.interpreter;

import xsharp.interpreter.components.Comments;
import xsharp.interpreter.components.Variables;

/**
 * Interpreter main class.
 * 
 * <p>
 *  This class can be used to analyse given line and do what needs 
 *  to be done.
 * </p>
 */
public class Interpreter {
    /**
     * Current interpreter Variables class instance.
     */
    private static Variables interpreterVariables;

    /**
     * This method analyze given line and do what needs to be done.
     * 
     * @param line Given line to analyze
     */
    public static void analyze(String line) {
        System.out.println("LINE ANALYSING: " + line);

        /*
         * Is the line an alone comment?
         */
        if (Comments.isAloneInlineComment(line)) {
            return;
        }

        /*
         * Is the line a variable definition?
         */
        // FIXME: NullPointerException on variable definition
        if (interpreterVariables.isVariableCreation(line)) {
            interpreterVariables.define(line);
        }

        // TODO: continue analyzing
    }
}

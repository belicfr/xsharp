/*
 * Prompt.java
 * by belicfr
 * 02.26.23
 */
package xsharp.prompt;

import java.util.Scanner;

import xsharp.interpreter.Interpreter;

/**
 * Prompt class.
 * 
 * <p>
 *  The prompt allows developer to put lines of code to directly run
 *  by interpreter, without any file to load.
 * </p>
 * 
 * <p>
 *  It is useful to test language: the prompt can be a playground for
 *  developer.
 * </p>
 * 
 * @author belicfr
 */
public class Prompt {
    /**
     * Scanner instance for Prompt class.
     */
    private static final Scanner INPUT_STREAM = new Scanner(System.in);

    /**
     * Prompt running method that is used to use prompt. It creates
     * a loop to put lines of code and prompt commands.
     * 
     * <p>
     *  Prompt commands line always begins with ':' character.
     *  For example: <em>:exit</em>
     * </p>
     */
    public static void run() {
        final String EXIT_MESSAGE = "(!) Xsharp prompt ended.";

        String line;

        do {
            line = INPUT_STREAM.nextLine();

            Interpreter.analyze(line);
        } while (!line.equals(":exit"));

        System.out.println(EXIT_MESSAGE);
    }
}

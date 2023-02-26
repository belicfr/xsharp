/*
 * Comments.java
 * by belicfr
 * 02.26.23
 */
package xsharp.interpreter.components;

/**
 * Comments managing class.
 * 
 * <p>
 *  This class can determine if given line is contains comment 
 *  or not.
 * </p>
 * 
 * <p>
 *  Comments can be created by several ways:
 * </p>
 * 
 * <ul>
 *  <li>
 *      double ':' as an inline comment. <br />
 *      For example: <em>":: It is an inline comment!"</em>
 *  </li>
 * </ul>
 */
public class Comments {
    /**
     * Inline comment prefix.
     * Default: "::"
     */
    private static final String INLINE_COMMENT_PREFIX = "::";

    /**
     * Returns if given string is an alone inline comment.
     * 
     * <p>
     *  An alone inline comment is a line where there is only an 
     *  inline comment.
     * </p>
     * 
     * @param line The line to analyze
     * @return If the given line is an alone inline comment or not
     */
    public static boolean isAloneInlineComment(String line) {
        String commentPrefix;

        commentPrefix = line.substring(0, 2);

        return commentPrefix.equals(INLINE_COMMENT_PREFIX);
    }
}

/*
 * Variables.java
 * by belicfr
 * 02.26.23
 */
package xsharp.interpreter.components;

import xsharp.interpreter.precepts.Types;
import java.util.regex.*;

public class Variables {
    /**
     * Variable name RegEx.
     */
    private final String REGEX_VARIABLE_NAME 
        = "(([a-z]+)([a-zA-Z0-9]+))";

    /**
     * Variable type RegEx.
     */
    private final String REGEX_VARIABLE_TYPE
        = "([a-zA-Z]+)";

    private final String REGEX_VARIABLE_VALUE
        = "(.*)";

    /**
     * Variable definition RegEx.
     */
    public final String REGEX_VARIABLE_CREATION 
        = "^" 
        + REGEX_VARIABLE_NAME 
        + ":([ ]+)?" 
        + REGEX_VARIABLE_TYPE 
        + "([ ]+)?=([ ]+)?"
        + REGEX_VARIABLE_VALUE
        + "$";

    /**
     * Variables names array.
     */
    private String[] variablesNames 
        = new String[Types.VARIABLES_ARRAY_LENGTH];

    /**
     * Variables types array.
     */
    private String[] variablesTypes 
        = new String[Types.VARIABLES_ARRAY_LENGTH];

    /**
     * Variables values array.
     */
    private String[] variablesValues 
        = new String[Types.VARIABLES_ARRAY_LENGTH];

    /**
     * Current index for variables arrays management.
     */
    private int currentVariablesArrayIndex = 0;

    /**
     * This method returns the variable index by name.
     * 
     * @param variableName Variable name used to get variable index
     * @return Variable index
     */
    private int getIndexByName(String variableName) {
        for (int index = 0; index < variablesNames.length; index++) {
            if (variablesNames[index].equals(variableName)) {
                return index;
            }
        }

        return -1;
    }

    /**
     * This method returns the variable value.
     * 
     * @param variableName Variable name used to get its value
     * @return Variable value
     */
    public String getValue(String variableName) {
        int variableIndex;

        variableIndex = getIndexByName(variableName);

        return variablesValues[variableIndex];
    }

    /**
     * This method returns variable definition Pattern class 
     * instance.
     * 
     * @return Pattern class instance
     */
    private Pattern getVariableDefinitionPattern() {
        Pattern variableDefinitionPattern;

        variableDefinitionPattern = Pattern.compile(REGEX_VARIABLE_CREATION);

        return variableDefinitionPattern;
    }

    /**
     * This method returns variable definition Matcher class 
     * instance.
     * 
     * @param variableDefinitionPattern Pattern class instance
     * @param line Given line
     * @return Matcher class instance
     */
    private Matcher getVariableDefinitionMatcher(
        Pattern variableDefinitionPattern, 
        String line
    ) {

        Matcher variableDefinitionMatcher;

        variableDefinitionMatcher = variableDefinitionPattern.matcher(line);

        return variableDefinitionMatcher;

    }

    /**
     * Add given variable information to instance variables arrays.
     * 
     * @param line Given line
     */
    public void define(String line) {
        Pattern variableDefinitionPattern;
        Matcher variableDefinitionMatcher;

        variableDefinitionPattern = getVariableDefinitionPattern();

        variableDefinitionMatcher 
            = getVariableDefinitionMatcher(variableDefinitionPattern, line);
        
        variablesNames[currentVariablesArrayIndex]  = variableDefinitionMatcher.group(1);
        variablesTypes[currentVariablesArrayIndex]  = variableDefinitionMatcher.group(5);
        variablesValues[currentVariablesArrayIndex] = variableDefinitionMatcher.group(8);

        System.out.println(variableDefinitionMatcher.group(1));
        System.out.println(variableDefinitionMatcher.group(5));
        System.out.println(variableDefinitionMatcher.group(8));
        
        currentVariablesArrayIndex++;
    }

    public boolean isVariableCreation(String line) {
        Pattern variableDefinitionPattern;
        Matcher variableDefinitionMatcher;

        variableDefinitionPattern = getVariableDefinitionPattern();

        variableDefinitionMatcher 
            = getVariableDefinitionMatcher(variableDefinitionPattern, line);

        return variableDefinitionMatcher.find();
    }
}

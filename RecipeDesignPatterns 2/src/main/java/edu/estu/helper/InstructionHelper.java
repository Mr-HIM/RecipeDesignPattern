package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InstructionHelper {
    public String createInstructions() {
        System.out.println();
        System.out.println("<<<<Instructions>>>>");
        return ConsoleUtils.readLine("Please enter instructions in a single line and then click enter:\n");
    }
}

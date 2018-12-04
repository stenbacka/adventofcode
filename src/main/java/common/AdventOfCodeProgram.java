package common;

import java.util.List;

public abstract class AdventOfCodeProgram {

    private DataService dataService = new DataService();

    protected void execute() {
        List<String> data = dataService.getInputData(getClass());
        Output outputFirstStep = processData(data);
        System.out.println("Result: " + outputFirstStep.get());
    }

    protected abstract Output processData(List<String> dataPoints);
}

package com.goit.mosule2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ANTON on 24.08.2016.
 */
public class SerialExecutor<T> implements Executor<T> {

    private Map<Task<? extends T>, Validator<? super T>> map = new HashMap<>();
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();

    private boolean isExecuted = false;
    private boolean isExecutingNow = false;

    @Override
    public void addTask(Task<? extends T> task) throws IllegalStateException {
        if (isExecuted) {
            throw new IllegalStateException("Execution is already done");
        }
        map.put(task, null);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        if (isExecuted) {
            throw new IllegalStateException("Execution is already done");
        }
        map.put(task, validator);
    }

    @Override
    public void execute() {
        isExecutingNow = true;
        if (map.isEmpty()) {
            throw new IllegalStateException("Error: nothing to execute!");
        }

        for (Map.Entry<Task<? extends T>, Validator<? super T>> pair : map.entrySet()) {

            Task<? extends T> task = pair.getKey();
            Validator<? super T> validator = pair.getValue();

            if (validator == null) {
                task.execute();
                validResults.add(task.getResult());
            } else {
                task.execute();
                if(validator.isValid(task.getResult())){
                    validResults.add(task.getResult());
                } else {
                    invalidResults.add(task.getResult());
                }
            }
        }
        isExecutingNow = false;
        isExecuted = true;
    }

    @Override
    public List<T> getValidResults() {

        if (!isExecuted) {
            throw new IllegalStateException("Error: Tasks are not executed!");
        }

        for (T validResult : validResults) {
            System.out.println("Valid result: " +validResult);
        }

        return validResults;
    }

    @Override
    public List<T> getInvalidResults() {

        if (!isExecuted) {
            throw new IllegalStateException("Error: Tasks are not executed!");
        }

        for (T invalidResult : invalidResults) {
            System.out.println("Invalid result: " + invalidResult);
        }

        return invalidResults;
    }
}

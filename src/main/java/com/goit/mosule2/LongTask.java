package com.goit.mosule2;

/**
 * Created by ANTON on 25.08.2016.
 */
public class LongTask implements Task<Long> {

    private long arg1;
    private long arg2;
    private long result;

    public LongTask(long arg1, long arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public void execute() {
        result = arg1+ arg2;
    }

    @Override
    public Long getResult() {
        return result;
    }
}

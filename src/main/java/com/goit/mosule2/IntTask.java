package com.goit.mosule2;

/**
 * Created by ANTON on 24.08.2016.
 */
public class IntTask  implements Task<Integer>{

    private int arg1;
    private int arg2;
    private int result;

    public IntTask(int arg1, int arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public void execute() {
        result = arg1 + arg2;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}

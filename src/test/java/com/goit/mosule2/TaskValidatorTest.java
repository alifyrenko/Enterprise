package com.goit.mosule2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ANTON on 25.08.2016.
 */
public class TaskValidatorTest {
    @Test
    public void isValidTest() throws Exception {

        boolean result;

        Validator validator = new TaskValidator();
        Task<Long> task = new LongTask(-50L, 0L);

        task.execute();
        result = validator.isValid(task);

        Assert.assertFalse(result);

    }

}
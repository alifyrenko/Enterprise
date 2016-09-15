package com.goit.mosule2;


/**
 * Created by ANTON on 23.08.2016.
 */
public interface Validator<T> {

    boolean isValid(T result);

}

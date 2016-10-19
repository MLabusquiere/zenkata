package io.maxlab.utils;

/**
 * Created by maxence on 19/10/16.
 */
public class Tuple<T,V>  {
    public final T _left;
    public final V _right;

    private Tuple(T left, V right) {
        this._left = left;
        this._right = right;
    }

    public static <T,V> Tuple<T,V> of(T right,V left)   {
        return new Tuple<>(right,left);
    }
}
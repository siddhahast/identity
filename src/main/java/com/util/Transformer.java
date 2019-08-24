package com.util;

import com.exception.TransformException;

public interface Transformer<I, O>
{
    public O transform(I input) throws TransformException;
}

package com.CustomContainer;

import java.io.IOException;

public class IoCException extends Throwable {
    public IoCException(Exception e)  {
        super(e);
    }
}

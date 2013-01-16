package com.facebook.katana.service;

public enum BackgroundRequestService$Operation
{
  static
  {
    HTTP_REQUEST = new Operation("HTTP_REQUEST", 1);
    ACTIONS_LOG = new Operation("ACTIONS_LOG", 2);
    Operation[] arrayOfOperation = new Operation[3];
    arrayOfOperation[0] = LOG;
    arrayOfOperation[1] = HTTP_REQUEST;
    arrayOfOperation[2] = ACTIONS_LOG;
    $VALUES = arrayOfOperation;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.BackgroundRequestService.Operation
 * JD-Core Version:    0.6.0
 */
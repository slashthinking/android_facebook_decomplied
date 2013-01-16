package com.facebook.orca.server.handlers;

import com.facebook.orca.server.OperationResult;

public abstract interface ApiMethodServiceHandler$ResultConverter<RESULT>
{
  public abstract OperationResult a(RESULT paramRESULT);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.handlers.ApiMethodServiceHandler.ResultConverter
 * JD-Core Version:    0.6.0
 */
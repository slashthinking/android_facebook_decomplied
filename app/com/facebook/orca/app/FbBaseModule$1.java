package com.facebook.orca.app;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.ExecutionList.UncaughtExceptionHandler;

final class FbBaseModule$1
  implements ExecutionList.UncaughtExceptionHandler
{
  public void a(Throwable paramThrowable)
  {
    throw Throwables.propagate(paramThrowable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.1
 * JD-Core Version:    0.6.0
 */
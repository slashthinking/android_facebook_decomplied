package com.facebook.orca.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil
{
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null);
    StringWriter localStringWriter;
    for (String str = ""; ; str = localStringWriter.toString())
    {
      return str;
      localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.ExceptionUtil
 * JD-Core Version:    0.6.0
 */
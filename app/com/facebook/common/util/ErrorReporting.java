package com.facebook.common.util;

import com.facebook.base.BuildConstants;
import java.util.Random;
import org.acra.ErrorReporter;
import org.acra.sender.HttpPostSender;

@Deprecated
public class ErrorReporting
{
  static final Random a = new Random();
  private static String b;
  private static FbErrorReporter c;

  public static void a(FbErrorReporter paramFbErrorReporter)
  {
    c = paramFbErrorReporter;
  }

  @Deprecated
  public static final void a(String paramString)
  {
    if (c != null)
      c.a(paramString);
    while (true)
    {
      return;
      b = paramString;
      ErrorReporter.getInstance().setReportSender(new HttpPostSender(b, null));
    }
  }

  @Deprecated
  public static final void a(String paramString1, String paramString2)
  {
    if (c != null)
      c.a(paramString1, paramString2);
    while (true)
    {
      return;
      a(paramString1, paramString2, null, false, 1000);
    }
  }

  @Deprecated
  public static final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (c != null)
      c.a(paramString1, paramString2, paramThrowable);
    while (true)
    {
      return;
      a(paramString1, paramString2, paramThrowable, false, 1000);
    }
  }

  @Deprecated
  public static final void a(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean)
  {
    if (c != null)
      c.a(paramString1, paramString2, paramThrowable, paramBoolean);
    while (true)
    {
      return;
      a(paramString1, paramString2, paramThrowable, paramBoolean, 1000);
    }
  }

  @Deprecated
  public static final void a(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    if (c != null)
      c.a(paramString1, paramString2, paramThrowable, paramBoolean, paramInt);
    while (true)
    {
      return;
      boolean bool = BuildConstants.a();
      if ((paramBoolean) && (bool))
        throw new RuntimeException("Soft error FAILING HARDER: " + paramString1 + " " + paramString2, paramThrowable);
      if (bool)
        break;
      if (a.nextInt() % paramInt != 0)
        continue;
      if (paramInt == 1)
        break;
      paramString1 = paramString1 + " [freq=" + paramInt + "]";
    }
    if (paramThrowable != null);
    while (true)
    {
      new Thread(new ErrorReporting.1(paramString1, paramString2, paramThrowable)).start();
      break;
      paramThrowable = new Exception("Soft error", paramThrowable);
    }
  }

  @Deprecated
  public static final void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (c != null)
      c.a(paramString1, paramString2, paramBoolean);
    while (true)
    {
      return;
      a(paramString1, paramString2, null, paramBoolean, 1000);
    }
  }

  @Deprecated
  public static final void b(String paramString)
  {
    if (c != null)
      c.b(paramString);
    while (true)
    {
      return;
      ErrorReporter.getInstance().removeCustomData(paramString);
    }
  }

  @Deprecated
  public static final void b(String paramString1, String paramString2)
  {
    if (c != null)
      c.b(paramString1, paramString2);
    while (true)
    {
      return;
      ErrorReporter.getInstance().putCustomData(paramString1, paramString2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ErrorReporting
 * JD-Core Version:    0.6.0
 */
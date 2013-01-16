package com.facebook.common.util;

import com.facebook.base.BuildConstants;
import java.util.Random;
import javax.inject.Provider;
import org.acra.ErrorReporter;
import org.acra.sender.HttpPostSender;

public class FbErrorReporterImpl
  implements FbErrorReporter
{
  final Random a = new Random();
  String b;
  private final Provider<TriState> c;

  public FbErrorReporterImpl(Provider<TriState> paramProvider)
  {
    this.c = paramProvider;
  }

  public void a(String paramString)
  {
    this.b = paramString;
    ErrorReporter.getInstance().setReportSender(new HttpPostSender(this.b, null));
  }

  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null, false, 1000);
  }

  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramString1, paramString2, paramThrowable, false, 1000);
  }

  public void a(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramThrowable, paramBoolean, 1000);
  }

  public void a(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    if ((BuildConstants.a()) || (this.c.b() == TriState.YES));
    for (int i = 1; (paramBoolean) && (i != 0); i = 0)
      throw new RuntimeException("Soft error FAILING HARDER: " + paramString1 + " " + paramString2, paramThrowable);
    if (i == 0)
    {
      if (this.a.nextInt() % paramInt != 0)
        return;
      if (paramInt != 1)
        paramString1 = paramString1 + " [freq=" + paramInt + "]";
    }
    if (paramThrowable != null);
    while (true)
    {
      new Thread(new FbErrorReporterImpl.1(this, paramString1, paramString2, paramThrowable)).start();
      break;
      paramThrowable = new Exception("Soft error", paramThrowable);
    }
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramString2, null, paramBoolean, 1000);
  }

  public void b(String paramString)
  {
    ErrorReporter.getInstance().removeCustomData(paramString);
  }

  public void b(String paramString1, String paramString2)
  {
    ErrorReporter.getInstance().putCustomData(paramString1, paramString2);
  }

  public void c(String paramString)
  {
    ErrorReporter.getInstance().registerActivity(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FbErrorReporterImpl
 * JD-Core Version:    0.6.0
 */
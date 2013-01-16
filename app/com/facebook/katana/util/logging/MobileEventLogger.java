package com.facebook.katana.util.logging;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.BackgroundRequestService;
import com.facebook.katana.service.BackgroundRequestService.Operation;
import java.util.concurrent.LinkedBlockingQueue;

public class MobileEventLogger
{
  private static MobileEventLogger b = null;
  protected LinkedBlockingQueue<MobileEvent> a = new LinkedBlockingQueue();
  private Long c = null;
  private MobileEventLogger.ConnectionType d = MobileEventLogger.ConnectionType.a;
  private long e = -1L;
  private Boolean f = null;
  private String g = null;
  private String h = null;
  private long i = 0L;
  private boolean j = false;

  public static MobileEventLogger a()
  {
    monitorenter;
    try
    {
      if (b == null)
        b = new MobileEventLogger();
      MobileEventLogger localMobileEventLogger = b;
      monitorexit;
      return localMobileEventLogger;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private static void f(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, BackgroundRequestService.class);
    localIntent.putExtra("com.facebook.katana.service.BackgroundRequestService.operation", BackgroundRequestService.Operation.ACTIONS_LOG);
    paramContext.startService(localIntent);
  }

  public void a(Context paramContext)
  {
    MobileEventLogger.MobileEventLogConfig.a(paramContext);
  }

  public void a(Context paramContext, MobileEvent paramMobileEvent)
  {
    if (!d(paramContext));
    while (true)
    {
      return;
      b(paramContext, paramMobileEvent);
    }
  }

  protected boolean a(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.c == null))
      b(paramContext);
    if (this.c.longValue() != -1L);
    for (int k = 1; ; k = 0)
      return k;
  }

  protected void b(Context paramContext)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    this.c = Long.valueOf(-1L);
    if (localAppSession != null)
      this.c = Long.valueOf(localAppSession.b().userId);
  }

  protected void b(Context paramContext, MobileEvent paramMobileEvent)
  {
    monitorenter;
    try
    {
      this.a.offer(paramMobileEvent);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  protected boolean c(Context paramContext)
  {
    return MobileEventLogger.MobileEventLogConfig.a(paramContext).a();
  }

  protected boolean d(Context paramContext)
  {
    boolean bool1 = c(paramContext);
    int k = 0;
    if (bool1)
    {
      boolean bool2 = a(paramContext, false);
      k = 0;
      if (bool2)
        k = 1;
    }
    return k;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.MobileEventLogger
 * JD-Core Version:    0.6.0
 */
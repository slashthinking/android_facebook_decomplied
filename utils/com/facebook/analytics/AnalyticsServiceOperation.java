package com.facebook.analytics;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;

public class AnalyticsServiceOperation
{
  private static final Class<?> a = AnalyticsServiceOperation.class;
  private final Context b;
  private final ServiceConnection c;
  private AnalyticsServiceEvent d;

  public AnalyticsServiceOperation(Context paramContext)
  {
    this.b = paramContext;
    this.c = new AnalyticsServiceOperation.AnalyticsServiceConnection(this, null);
  }

  private void a(IAnalyticsService paramIAnalyticsService)
  {
    try
    {
      paramIAnalyticsService.a(this.d);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        BLog.e(a, "Failed to report event " + this.d.e().toString(), localRemoteException);
        this.b.unbindService(this.c);
      }
    }
    finally
    {
      this.b.unbindService(this.c);
    }
  }

  public void a(AnalyticsServiceEvent paramAnalyticsServiceEvent)
  {
    if (paramAnalyticsServiceEvent != null);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "Invalid event to report.");
      AnalyticsServiceEvent localAnalyticsServiceEvent = this.d;
      boolean bool2 = false;
      if (localAnalyticsServiceEvent == null)
        bool2 = true;
      Preconditions.checkState(bool2, "Service operation already started!");
      this.d = paramAnalyticsServiceEvent;
      Intent localIntent = new Intent(this.b, AnalyticsService.class);
      if (!this.b.bindService(localIntent, this.c, 1))
        BLog.e(a, "Failed to get service interface.");
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsServiceOperation
 * JD-Core Version:    0.6.2
 */
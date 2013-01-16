package com.facebook.notifications.provider;

import android.os.Bundle;
import com.facebook.notifications.protocol.FetchNotificationsResult;
import com.facebook.notifications.server.FetchNotificationsParams;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.google.common.collect.ImmutableList;

public class NotificationsContentProviderHandler
  implements OrcaServiceHandler.Filter
{
  private final NotificationsContentProviderHelper a;

  public NotificationsContentProviderHandler(NotificationsContentProviderHelper paramNotificationsContentProviderHelper)
  {
    this.a = paramNotificationsContentProviderHelper;
  }

  private OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchNotificationsParams localFetchNotificationsParams = (FetchNotificationsParams)paramOperationParams.b().getParcelable("fetchNotificationsParams");
    int i;
    OperationResult localOperationResult1;
    OperationResult localOperationResult3;
    if (DataFreshnessParam.STALE_DATA_OKAY == localFetchNotificationsParams.a())
    {
      i = 1;
      localOperationResult1 = null;
      if (i != 0)
      {
        FetchNotificationsResult localFetchNotificationsResult2 = this.a.a(localFetchNotificationsParams);
        DataFreshnessResult localDataFreshnessResult1 = DataFreshnessResult.NO_DATA;
        DataFreshnessResult localDataFreshnessResult2 = localFetchNotificationsResult2.e();
        localOperationResult1 = null;
        if (localDataFreshnessResult1 != localDataFreshnessResult2)
          localOperationResult1 = OperationResult.a(localFetchNotificationsResult2);
      }
      if (localOperationResult1 != null)
        break label147;
      localOperationResult3 = paramOrcaServiceHandler.a(paramOperationParams);
      if (localOperationResult3.c())
      {
        FetchNotificationsResult localFetchNotificationsResult1 = (FetchNotificationsResult)localOperationResult3.h();
        if (localFetchNotificationsResult1.a.size() > 0)
          this.a.a(localFetchNotificationsParams, localFetchNotificationsResult1.a, localFetchNotificationsResult1.b);
      }
    }
    label147: for (OperationResult localOperationResult2 = localOperationResult3; ; localOperationResult2 = localOperationResult1)
    {
      return localOperationResult2;
      i = 0;
      break;
    }
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (paramOperationParams.a().equals("fetch_notifications"));
    for (OperationResult localOperationResult = b(paramOperationParams, paramOrcaServiceHandler); ; localOperationResult = paramOrcaServiceHandler.a(paramOperationParams))
      return localOperationResult;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.provider.NotificationsContentProviderHandler
 * JD-Core Version:    0.6.2
 */
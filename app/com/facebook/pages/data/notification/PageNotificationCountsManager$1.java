package com.facebook.pages.data.notification;

import com.facebook.orca.server.OperationResult;
import com.facebook.pages.data.model.PageNotificationCounts;
import com.facebook.pages.data.server.FetchNotificationCountsResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class PageNotificationCountsManager$1
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FetchNotificationCountsResult localFetchNotificationCountsResult = (FetchNotificationCountsResult)paramOperationResult.h();
    if (localFetchNotificationCountsResult != null)
    {
      Iterator localIterator = localFetchNotificationCountsResult.a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Long localLong = (Long)localEntry.getKey();
        PageNotificationCounts localPageNotificationCounts = (PageNotificationCounts)localEntry.getValue();
        PageNotificationCountsManager.a(this.a, localLong.longValue(), localPageNotificationCounts);
      }
    }
  }

  public void a(Throwable paramThrowable)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.notification.PageNotificationCountsManager.1
 * JD-Core Version:    0.6.0
 */
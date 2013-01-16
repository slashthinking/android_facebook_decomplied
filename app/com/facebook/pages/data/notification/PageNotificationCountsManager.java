package com.facebook.pages.data.notification;

import android.os.Bundle;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.pages.data.model.PageNotificationCounts;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PageNotificationCountsManager
{
  private static final Class<?> a = PageNotificationCountsManager.class;
  private Map<Long, PageNotificationCounts> b = new HashMap();
  private Set<PageNotificationCountsChangeListener> c = Sets.a();
  private AndroidThreadUtil d;
  private OrcaServiceOperationFactory e;

  private void a(long paramLong, PageNotificationCounts paramPageNotificationCounts)
  {
    if ((this.b.containsKey(Long.valueOf(paramLong))) && (((PageNotificationCounts)this.b.get(Long.valueOf(paramLong))).equals(paramPageNotificationCounts)));
    while (true)
    {
      return;
      this.b.put(Long.valueOf(paramLong), paramPageNotificationCounts);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((PageNotificationCountsChangeListener)localIterator.next()).a(Long.valueOf(paramLong), paramPageNotificationCounts);
    }
  }

  public void a()
  {
    ListenableFuture localListenableFuture = this.e.a("fetch_notification_counts", new Bundle()).d();
    this.d.a(localListenableFuture, new PageNotificationCountsManager.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.notification.PageNotificationCountsManager
 * JD-Core Version:    0.6.0
 */
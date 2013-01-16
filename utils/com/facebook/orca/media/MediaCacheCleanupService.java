package com.facebook.orca.media;

import android.app.IntentService;
import android.content.Intent;
import com.facebook.orca.inject.FbInjector;
import java.util.Iterator;
import java.util.Set;

public class MediaCacheCleanupService extends IntentService
{
  public MediaCacheCleanupService()
  {
    super("orca:MediaCacheCleanupService");
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    Iterator localIterator = FbInjector.a(this).c(MediaCache.class).iterator();
    while (localIterator.hasNext())
      ((MediaCache)localIterator.next()).a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaCacheCleanupService
 * JD-Core Version:    0.6.2
 */
package com.facebook.feed.db;

import com.facebook.common.util.Log;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.orca.debug.Tracer;

class DbFeedHomeStoriesHandler$1
  implements Runnable
{
  public void run()
  {
    Tracer localTracer = Tracer.a("DbFeedHomeStoriesHandler.insertHomeStoriesToDbAsync");
    try
    {
      this.b.b(this.a);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a("Exception when insert new stories to newsfeed disk cache.", localException);
        localTracer.a();
      }
    }
    finally
    {
      localTracer.a();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbFeedHomeStoriesHandler.1
 * JD-Core Version:    0.6.0
 */
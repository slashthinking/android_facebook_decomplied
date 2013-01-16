package com.facebook.katana.activity.composer;

import android.os.AsyncTask;
import com.facebook.composer.protocol.PublishPostParams;
import com.facebook.feed.util.composer.UniqueRequestIdGenerator;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import java.util.Iterator;
import java.util.Set;

final class SharePostMethod$1 extends AsyncTask<PublishPostParams, Void, SharePostMethod.SharePostResult>
{
  protected SharePostMethod.SharePostResult a(PublishPostParams[] paramArrayOfPublishPostParams)
  {
    SharePostMethod localSharePostMethod = new SharePostMethod();
    SingleMethodRunner localSingleMethodRunner = (SingleMethodRunner)this.a.a(SingleMethodRunner.class);
    try
    {
      localSharePostResult = (SharePostMethod.SharePostResult)localSingleMethodRunner.a(localSharePostMethod, this.b);
      return localSharePostResult;
    }
    catch (Exception localException)
    {
      while (true)
      {
        BLog.d(SharePostMethod.a, "Exception on share post", localException);
        SharePostMethod.SharePostResult localSharePostResult = null;
      }
    }
  }

  protected void a(SharePostMethod.SharePostResult paramSharePostResult)
  {
    if (paramSharePostResult == null);
    for (int i = 0; ; i = paramSharePostResult.b)
    {
      String str = ((UniqueRequestIdGenerator)this.a.a(UniqueRequestIdGenerator.class)).a();
      Iterator localIterator = this.c.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).e(this.c, str, i, null, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.SharePostMethod.1
 * JD-Core Version:    0.6.0
 */
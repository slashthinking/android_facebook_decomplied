package com.facebook.feed.data;

import android.os.Bundle;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.feed.model.FetchResultState;

class AbstractDataLoader$8
  implements FeedDataLoaderListener
{
  public void a()
  {
    Log.a(this.a.i(), "onLoadingBegin of empty listener");
  }

  public void a(boolean paramBoolean)
  {
    Log.a(this.a.i(), "onDataChanged of empty listener");
  }

  public void a(boolean paramBoolean, FetchResultState paramFetchResultState, Bundle paramBundle, int paramInt)
  {
    if (paramFetchResultState == FetchResultState.SUCCESS)
      this.a.k.a("default_listener_loading_complete", this.a.i() + " At Head: " + paramBoolean + " New Stories: " + paramInt, false);
    Log.a(this.a.i(), "onLoadingComplete of empty listener");
  }

  public void b()
  {
    Log.a(this.a.i(), "onOptimisticInsertionFailure of empty listener");
  }

  public void b(boolean paramBoolean)
  {
    Log.a(this.a.i(), "onConnectivityChanged of empty listener");
  }

  public boolean c()
  {
    Log.a(this.a.i(), "isFragmentAdded of empty listener");
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AbstractDataLoader.8
 * JD-Core Version:    0.6.0
 */
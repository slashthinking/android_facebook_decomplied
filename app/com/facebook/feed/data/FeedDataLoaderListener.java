package com.facebook.feed.data;

import android.os.Bundle;
import com.facebook.feed.model.FetchResultState;

public abstract interface FeedDataLoaderListener
{
  public abstract void a();

  public abstract void a(boolean paramBoolean);

  public abstract void a(boolean paramBoolean, FetchResultState paramFetchResultState, Bundle paramBundle, int paramInt);

  public abstract void b();

  public abstract void b(boolean paramBoolean);

  public abstract boolean c();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.FeedDataLoaderListener
 * JD-Core Version:    0.6.0
 */
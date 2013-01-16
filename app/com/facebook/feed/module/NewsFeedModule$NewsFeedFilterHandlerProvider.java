package com.facebook.feed.module;

import android.content.Context;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.server.NewsFeedFilterHandler;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedFilterHandlerProvider extends AbstractProvider<NewsFeedFilterHandler>
{
  private NewsFeedModule$NewsFeedFilterHandlerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedFilterHandler a()
  {
    return new NewsFeedFilterHandler((Context)b(Context.class, FromApplication.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedFilterHandlerProvider
 * JD-Core Version:    0.6.0
 */
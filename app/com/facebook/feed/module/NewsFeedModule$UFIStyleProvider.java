package com.facebook.feed.module;

import android.content.res.Resources;
import com.facebook.feed.ui.footer.UFIStyle;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$UFIStyleProvider extends AbstractProvider<UFIStyle>
{
  private NewsFeedModule$UFIStyleProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public UFIStyle a()
  {
    return new UFIStyle().a((Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.UFIStyleProvider
 * JD-Core Version:    0.6.0
 */
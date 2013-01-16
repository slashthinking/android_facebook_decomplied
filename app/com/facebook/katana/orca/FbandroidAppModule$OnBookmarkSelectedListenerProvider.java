package com.facebook.katana.orca;

import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.ui.event.OnBookmarkSelectedListener;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.ui.bookmark.BookmarkMenuController;
import com.facebook.katana.ui.bookmark.FB4ABookmarkSelectedListener;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.widget.ScreenSlider;

class FbandroidAppModule$OnBookmarkSelectedListenerProvider extends AbstractProvider<OnBookmarkSelectedListener>
{
  private FbandroidAppModule$OnBookmarkSelectedListenerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public OnBookmarkSelectedListener a()
  {
    return new FB4ABookmarkSelectedListener((ScreenSlider)b(BookmarkMenuController.class), (BookmarkManager)b(BookmarkManager.class), (FacebookActivityDelegate)b(FacebookActivityDelegate.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.OnBookmarkSelectedListenerProvider
 * JD-Core Version:    0.6.0
 */
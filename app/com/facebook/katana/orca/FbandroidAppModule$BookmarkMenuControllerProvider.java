package com.facebook.katana.orca;

import com.facebook.katana.ui.bookmark.BookmarkMenuController;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$BookmarkMenuControllerProvider extends AbstractProvider<BookmarkMenuController>
{
  private FbandroidAppModule$BookmarkMenuControllerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public BookmarkMenuController a()
  {
    return new BookmarkMenuController((UserInteractionController)b(UserInteractionController.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.BookmarkMenuControllerProvider
 * JD-Core Version:    0.6.0
 */
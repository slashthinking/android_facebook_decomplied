package com.facebook.bookmark.provider;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.app.IHaveUserData;

public class BookmarkDBUserDataCleaner
  implements IHaveUserData
{
  private final DBBookmarkHelper a;
  private final FbErrorReporter b;

  public BookmarkDBUserDataCleaner(DBBookmarkHelper paramDBBookmarkHelper, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramDBBookmarkHelper;
    this.b = paramFbErrorReporter;
  }

  public void f()
  {
    try
    {
      this.a.d();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.b.a("bookmarks", "Failed to clear bookmarks in db.", localException);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.provider.BookmarkDBUserDataCleaner
 * JD-Core Version:    0.6.2
 */
package com.facebook.bookmark;

import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.orca.app.IHaveUserData;
import java.util.List;

public abstract interface BookmarkManager extends IHaveUserData
{
  public abstract List<BookmarksGroup> a();

  public abstract void a(long paramLong, int paramInt);

  public abstract void a(BookmarkManager.BookmarkCallback paramBookmarkCallback);

  public abstract void a(List<Long> paramList);

  public abstract void b();

  public abstract void b(BookmarkManager.BookmarkCallback paramBookmarkCallback);

  public abstract FetchBookmarksResult c();

  public abstract void d();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.BookmarkManager
 * JD-Core Version:    0.6.2
 */
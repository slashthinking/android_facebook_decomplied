package com.facebook.bookmark;

import android.content.Context;
import android.support.v4.content.Loader;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.orca.ops.ServiceException;

public class BookmarkLoaderCallbacks$BookmarkLoader extends Loader<Void>
  implements BookmarkManager.BookmarkCallback
{
  private boolean a = false;
  private final BookmarkManager b;
  private final boolean c;
  private final BookmarkManager.BookmarkCallback d;

  public BookmarkLoaderCallbacks$BookmarkLoader(Context paramContext, BookmarkManager paramBookmarkManager, boolean paramBoolean, BookmarkManager.BookmarkCallback paramBookmarkCallback)
  {
    super(paramContext);
    this.b = paramBookmarkManager;
    this.c = paramBoolean;
    this.d = paramBookmarkCallback;
  }

  public void a(FetchBookmarksResult paramFetchBookmarksResult, boolean paramBoolean)
  {
    if (k())
      this.d.a(paramFetchBookmarksResult, paramBoolean);
    while (true)
    {
      return;
      u();
    }
  }

  public void a(Bookmark paramBookmark)
  {
    if (k())
      this.d.a(paramBookmark);
    while (true)
    {
      return;
      u();
    }
  }

  public void a(BookmarksGroup paramBookmarksGroup)
  {
    if (k())
      this.d.a(paramBookmarksGroup);
    while (true)
    {
      return;
      u();
    }
  }

  public void a(ServiceException paramServiceException)
  {
    if (k())
      this.d.a(paramServiceException);
  }

  protected void g()
  {
    super.g();
    if (!this.a)
    {
      this.b.a(this);
      this.a = true;
    }
    boolean bool = t();
    FetchBookmarksResult localFetchBookmarksResult = this.b.c();
    switch (BookmarkLoaderCallbacks.1.a[localFetchBookmarksResult.e().ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      this.b.b();
      continue;
      if ((this.c) && (bool))
        this.d.a(localFetchBookmarksResult, false);
      this.b.d();
      continue;
      if (bool)
        this.d.a(localFetchBookmarksResult, false);
    }
  }

  protected void i()
  {
    super.i();
    this.b.b(this);
    this.a = false;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.BookmarkLoaderCallbacks.BookmarkLoader
 * JD-Core Version:    0.6.2
 */
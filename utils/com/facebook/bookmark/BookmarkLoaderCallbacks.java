package com.facebook.bookmark;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

public class BookmarkLoaderCallbacks
  implements LoaderManager.LoaderCallbacks<Void>
{
  private final Context a;
  private final BookmarkManager b;
  private final boolean c;
  private final BookmarkManager.BookmarkCallback d;

  public BookmarkLoaderCallbacks(Context paramContext, BookmarkManager paramBookmarkManager, boolean paramBoolean, BookmarkManager.BookmarkCallback paramBookmarkCallback)
  {
    this.a = paramContext;
    this.b = paramBookmarkManager;
    this.c = paramBoolean;
    this.d = paramBookmarkCallback;
  }

  public Loader a(int paramInt, Bundle paramBundle)
  {
    return new BookmarkLoaderCallbacks.BookmarkLoader(this.a, this.b, this.c, this.d);
  }

  public void a(Loader<Void> paramLoader)
  {
  }

  public void a(Loader<Void> paramLoader, Void paramVoid)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.BookmarkLoaderCallbacks
 * JD-Core Version:    0.6.2
 */
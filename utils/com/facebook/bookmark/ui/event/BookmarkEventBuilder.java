package com.facebook.bookmark.ui.event;

import android.app.Activity;
import android.os.Parcelable;
import com.facebook.bookmark.model.Bookmark;

public class BookmarkEventBuilder
{
  private Activity a;
  private Bookmark b;
  private String c;
  private boolean d = false;
  private Parcelable e;

  public BookmarkEvent a()
  {
    return new BookmarkEvent(this.a, this.b, this.c, this.d, this.e);
  }

  public BookmarkEventBuilder a(Activity paramActivity)
  {
    this.a = paramActivity;
    return this;
  }

  public BookmarkEventBuilder a(Parcelable paramParcelable)
  {
    this.e = paramParcelable;
    return this;
  }

  public BookmarkEventBuilder a(Bookmark paramBookmark)
  {
    this.b = paramBookmark;
    return this;
  }

  public BookmarkEventBuilder a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public BookmarkEventBuilder a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.event.BookmarkEventBuilder
 * JD-Core Version:    0.6.2
 */
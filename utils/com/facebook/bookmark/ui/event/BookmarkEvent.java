package com.facebook.bookmark.ui.event;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.bookmark.model.Bookmark;
import com.google.common.base.Preconditions;

public class BookmarkEvent
{
  public final Activity a;
  public final Bookmark b;
  public final String c;
  public final boolean d;
  private final Parcelable e;
  private Bundle f = null;

  BookmarkEvent(Activity paramActivity, Bookmark paramBookmark, String paramString, boolean paramBoolean, Parcelable paramParcelable)
  {
    this.a = ((Activity)Preconditions.checkNotNull(paramActivity));
    if ((paramBookmark == null) && (paramString == null))
      throw new IllegalArgumentException("bookmark and url are both null.");
    this.b = paramBookmark;
    this.c = paramString;
    this.d = paramBoolean;
    this.e = paramParcelable;
  }

  public static BookmarkEventBuilder newBuilder()
  {
    return new BookmarkEventBuilder();
  }

  public <T extends Parcelable> T a()
  {
    return this.e;
  }

  public String b()
  {
    if (this.c != null);
    for (String str = this.c; ; str = this.b.url)
      return str;
  }

  Bundle c()
  {
    if (this.f == null)
    {
      this.f = new Bundle();
      this.f.putString("url", b());
      if (this.e != null)
        this.f.putParcelable("data", this.e);
      this.f.putBoolean("long_click", this.d);
    }
    return this.f;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.event.BookmarkEvent
 * JD-Core Version:    0.6.2
 */
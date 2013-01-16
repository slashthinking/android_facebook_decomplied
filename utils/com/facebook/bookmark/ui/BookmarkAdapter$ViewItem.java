package com.facebook.bookmark.ui;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.bookmark.model.Bookmark;

public abstract interface BookmarkAdapter$ViewItem
{
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);

  public abstract BookmarkAdapter.RowType a();

  public abstract Bookmark c();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BookmarkAdapter.ViewItem
 * JD-Core Version:    0.6.2
 */
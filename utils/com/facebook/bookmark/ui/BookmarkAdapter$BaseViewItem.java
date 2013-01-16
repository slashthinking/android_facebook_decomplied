package com.facebook.bookmark.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.bookmark.model.Bookmark;

public abstract class BookmarkAdapter$BaseViewItem<H, D>
  implements BookmarkAdapter.ViewItem
{
  protected final BookmarkAdapter.RowType b;
  protected final int c;
  protected final D d;
  protected final LayoutInflater e;

  public BookmarkAdapter$BaseViewItem(BookmarkAdapter.RowType paramRowType, int paramInt, D paramD, LayoutInflater paramLayoutInflater)
  {
    this.b = paramRowType;
    this.c = paramInt;
    this.d = paramD;
    this.e = paramLayoutInflater;
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.e.inflate(this.c, paramViewGroup, false);
      localObject = b(paramView);
      paramView.setTag(localObject);
    }
    while (true)
    {
      a(localObject);
      return paramView;
      localObject = paramView.getTag();
    }
  }

  public BookmarkAdapter.RowType a()
  {
    return this.b;
  }

  public abstract void a(H paramH);

  public D b()
  {
    return this.d;
  }

  public abstract H b(View paramView);

  public Bookmark c()
  {
    if ((this.d != null) && ((this.d instanceof Bookmark)));
    for (Bookmark localBookmark = (Bookmark)this.d; ; localBookmark = null)
      return localBookmark;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem
 * JD-Core Version:    0.6.2
 */
package com.facebook.bookmark.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.bookmark.model.Bookmark;

public class BaseViewItemFactory$BookmarkViewItem extends BookmarkAdapter.BaseViewItem<BaseViewItemFactory.BookmarkViewHolder, Bookmark>
{
  private final int f;

  public BaseViewItemFactory$BookmarkViewItem(BaseViewItemFactory paramBaseViewItemFactory, BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark, int paramInt)
  {
    super(paramRowType, 2130903070, paramBookmark, paramBaseViewItemFactory.b);
    this.f = paramInt;
  }

  public BaseViewItemFactory.BookmarkViewHolder a(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131296410);
    this.e.inflate(2130903069, localRelativeLayout, true);
    return new BaseViewItemFactory.BookmarkViewHolder(paramView);
  }

  public void a(BaseViewItemFactory.BookmarkViewHolder paramBookmarkViewHolder)
  {
    this.a.a(paramBookmarkViewHolder, (Bookmark)this.d, this.f);
    if (((Bookmark)this.d).a() > 0)
    {
      paramBookmarkViewHolder.c.setVisibility(0);
      paramBookmarkViewHolder.c.setText(String.valueOf(((Bookmark)this.d).a()));
    }
    while (true)
    {
      return;
      paramBookmarkViewHolder.c.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BaseViewItemFactory.BookmarkViewItem
 * JD-Core Version:    0.6.2
 */
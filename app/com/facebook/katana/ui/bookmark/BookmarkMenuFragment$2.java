package com.facebook.katana.ui.bookmark;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;

class BookmarkMenuFragment$2 extends BookmarkAdapter.BaseViewItem<FB4AViewItemFactory.BookmarkEditViewHolder, Void>
{
  public FB4AViewItemFactory.BookmarkEditViewHolder a(View paramView)
  {
    return new FB4AViewItemFactory.BookmarkEditViewHolder(paramView);
  }

  public void a(FB4AViewItemFactory.BookmarkEditViewHolder paramBookmarkEditViewHolder)
  {
    if (BookmarkMenuFragment.b(this.a))
    {
      paramBookmarkEditViewHolder.a();
      paramBookmarkEditViewHolder.e.setText(2131362840);
    }
    while (true)
    {
      return;
      paramBookmarkEditViewHolder.b();
      paramBookmarkEditViewHolder.e.setText(2131362838);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkMenuFragment.2
 * JD-Core Version:    0.6.0
 */
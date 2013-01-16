package com.facebook.katana.ui.bookmark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.bookmark.ui.BookmarkAdapter.ViewItem;

class FB4AViewItemFactory$1
  implements BookmarkAdapter.ViewItem
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    while (true)
    {
      return paramView;
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903072, paramViewGroup, false);
      ((TextView)paramView.findViewById(2131296409)).setText(paramViewGroup.getContext().getText(2131362038));
    }
  }

  public BookmarkAdapter.RowType a()
  {
    return this.a;
  }

  public Bookmark c()
  {
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.FB4AViewItemFactory.1
 * JD-Core Version:    0.6.0
 */
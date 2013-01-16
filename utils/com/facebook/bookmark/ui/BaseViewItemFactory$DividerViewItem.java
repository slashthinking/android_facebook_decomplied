package com.facebook.bookmark.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.bookmark.model.BookmarksGroup;

public class BaseViewItemFactory$DividerViewItem extends BookmarkAdapter.BaseViewItem<BaseViewItemFactory.TextLabelViewHolder, BookmarksGroup>
{
  private final boolean f;

  public BaseViewItemFactory$DividerViewItem(BaseViewItemFactory paramBaseViewItemFactory, BookmarkAdapter.RowType paramRowType, BookmarksGroup paramBookmarksGroup, boolean paramBoolean)
  {
    super(paramRowType, 2130903067, paramBookmarksGroup, paramBaseViewItemFactory.b);
    this.f = paramBoolean;
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.a(paramInt, paramView, paramViewGroup);
    if (this.f)
      localView.setPadding(0, (int)this.a.a.getResources().getDimension(2131230827), 0, 0);
    while (true)
    {
      return localView;
      localView.setPadding(0, 0, 0, 0);
    }
  }

  public BaseViewItemFactory.TextLabelViewHolder a(View paramView)
  {
    return new BaseViewItemFactory.TextLabelViewHolder(paramView);
  }

  public void a(BaseViewItemFactory.TextLabelViewHolder paramTextLabelViewHolder)
  {
    paramTextLabelViewHolder.e.setText(((BookmarksGroup)this.d).name.toUpperCase());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BaseViewItemFactory.DividerViewItem
 * JD-Core Version:    0.6.2
 */
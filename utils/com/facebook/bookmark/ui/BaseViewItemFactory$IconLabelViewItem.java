package com.facebook.bookmark.ui;

import android.view.View;
import android.widget.TextView;
import com.facebook.widget.UrlImage;

public class BaseViewItemFactory$IconLabelViewItem<D> extends BookmarkAdapter.BaseViewItem<BaseViewItemFactory.IconLabelViewHolder, D>
{
  private int f;
  private int g;

  public BaseViewItemFactory$IconLabelViewItem(BookmarkAdapter.RowType paramRowType, D paramD, int paramInt1, int paramInt2)
  {
    super(paramD, 2130903070, paramInt1, paramRowType.b);
    this.f = paramInt2;
    int i;
    this.g = i;
  }

  public BaseViewItemFactory.IconLabelViewHolder a(View paramView)
  {
    return new BaseViewItemFactory.IconLabelViewHolder(paramView);
  }

  public void a(BaseViewItemFactory.IconLabelViewHolder paramIconLabelViewHolder)
  {
    paramIconLabelViewHolder.d.setPlaceHolderResourceId(this.f);
    paramIconLabelViewHolder.e.setText(this.g);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BaseViewItemFactory.IconLabelViewItem
 * JD-Core Version:    0.6.2
 */
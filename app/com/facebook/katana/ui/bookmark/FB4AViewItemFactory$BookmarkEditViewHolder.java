package com.facebook.katana.ui.bookmark;

import android.view.View;
import android.widget.ProgressBar;
import com.facebook.bookmark.ui.BaseViewItemFactory.IconLabelViewHolder;
import com.facebook.widget.UrlImage;

public class FB4AViewItemFactory$BookmarkEditViewHolder extends BaseViewItemFactory.IconLabelViewHolder
{
  public ProgressBar a;

  public FB4AViewItemFactory$BookmarkEditViewHolder(View paramView)
  {
    super(paramView);
    this.a = ((ProgressBar)paramView.findViewById(2131296412));
  }

  public void a()
  {
    this.d.setVisibility(8);
    this.a.setVisibility(0);
  }

  public void b()
  {
    this.d.setVisibility(0);
    this.a.setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.FB4AViewItemFactory.BookmarkEditViewHolder
 * JD-Core Version:    0.6.0
 */
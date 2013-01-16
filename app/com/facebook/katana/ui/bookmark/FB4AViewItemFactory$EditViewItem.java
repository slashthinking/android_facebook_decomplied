package com.facebook.katana.ui.bookmark;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.widget.UrlImage;

class FB4AViewItemFactory$EditViewItem extends BookmarkAdapter.BaseViewItem<FB4AViewItemFactory.EditingBookmarkItemViewHolder, Bookmark>
{
  private final boolean f;
  private final boolean g;
  private final View.OnClickListener h;

  public FB4AViewItemFactory$EditViewItem(FB4AViewItemFactory paramFB4AViewItemFactory, BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    super(paramRowType, 2130903129, paramBookmark, FB4AViewItemFactory.k(paramFB4AViewItemFactory));
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.h = paramOnClickListener;
  }

  public FB4AViewItemFactory.EditingBookmarkItemViewHolder a(View paramView)
  {
    return new FB4AViewItemFactory.EditingBookmarkItemViewHolder(paramView);
  }

  public void a(FB4AViewItemFactory.EditingBookmarkItemViewHolder paramEditingBookmarkItemViewHolder)
  {
    if (((Bookmark)this.d).pic != null)
      paramEditingBookmarkItemViewHolder.d.setImageParams(Uri.parse(((Bookmark)this.d).pic));
    paramEditingBookmarkItemViewHolder.e.setText(((Bookmark)this.d).name);
    if (this.g)
    {
      paramEditingBookmarkItemViewHolder.c.setVisibility(0);
      if (!this.f)
        break label105;
      paramEditingBookmarkItemViewHolder.a.setImageResource(2130837574);
    }
    while (true)
    {
      paramEditingBookmarkItemViewHolder.b.setOnClickListener(this.h);
      return;
      paramEditingBookmarkItemViewHolder.c.setVisibility(8);
      break;
      label105: paramEditingBookmarkItemViewHolder.a.setImageResource(2130837577);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.FB4AViewItemFactory.EditViewItem
 * JD-Core Version:    0.6.0
 */
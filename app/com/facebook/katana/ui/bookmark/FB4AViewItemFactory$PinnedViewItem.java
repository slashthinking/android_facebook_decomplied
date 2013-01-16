package com.facebook.katana.ui.bookmark;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.widget.UrlImage;

public class FB4AViewItemFactory$PinnedViewItem extends BookmarkAdapter.BaseViewItem<FB4AViewItemFactory.EditingBookmarkItemViewHolder, Bookmark>
{
  public FB4AViewItemFactory$PinnedViewItem(FB4AViewItemFactory paramFB4AViewItemFactory, BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark)
  {
    super(paramRowType, 2130903129, paramBookmark, FB4AViewItemFactory.i(paramFB4AViewItemFactory));
  }

  public FB4AViewItemFactory.EditingBookmarkItemViewHolder a(View paramView)
  {
    FB4AViewItemFactory.EditingBookmarkItemViewHolder localEditingBookmarkItemViewHolder = new FB4AViewItemFactory.EditingBookmarkItemViewHolder(paramView);
    localEditingBookmarkItemViewHolder.a.setVisibility(4);
    localEditingBookmarkItemViewHolder.c.setVisibility(8);
    localEditingBookmarkItemViewHolder.e.setTextColor(FB4AViewItemFactory.j(this.a).getResources().getColor(2131165457));
    return localEditingBookmarkItemViewHolder;
  }

  public void a(FB4AViewItemFactory.EditingBookmarkItemViewHolder paramEditingBookmarkItemViewHolder)
  {
    if (((Bookmark)this.d).pic != null)
      paramEditingBookmarkItemViewHolder.d.setImageParams(Uri.parse(((Bookmark)this.d).pic));
    paramEditingBookmarkItemViewHolder.e.setText(((Bookmark)this.d).name);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.FB4AViewItemFactory.PinnedViewItem
 * JD-Core Version:    0.6.0
 */
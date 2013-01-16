package com.facebook.katana.ui.bookmark;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BaseViewItemFactory;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.bookmark.ui.BookmarkAdapter.ViewItem;
import com.facebook.bookmark.ui.event.OnBookmarkSelectedListener;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;

public class FB4AViewItemFactory extends BaseViewItemFactory
{
  private final OrcaSharedPreferences d;

  public FB4AViewItemFactory(Activity paramActivity, LayoutInflater paramLayoutInflater)
  {
    super(paramActivity, paramLayoutInflater);
    this.d = ((OrcaSharedPreferences)FbInjector.a(paramActivity).a(OrcaSharedPreferences.class));
  }

  public BookmarkAdapter.ViewItem a(BookmarkAdapter.RowType paramRowType)
  {
    return new FB4AViewItemFactory.1(this, paramRowType);
  }

  public FB4AViewItemFactory.EditViewItem a(BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    return new FB4AViewItemFactory.EditViewItem(this, paramRowType, paramBookmark, paramBoolean1, paramBoolean2, paramOnClickListener);
  }

  public FB4AViewItemFactory.NewsFeedViewItem a(BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark, int paramInt, OnBookmarkSelectedListener paramOnBookmarkSelectedListener)
  {
    return new FB4AViewItemFactory.NewsFeedViewItem(this, paramRowType, paramBookmark, paramInt, paramOnBookmarkSelectedListener);
  }

  public FB4AViewItemFactory.PinnedViewItem b(BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark)
  {
    return new FB4AViewItemFactory.PinnedViewItem(this, paramRowType, paramBookmark);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.FB4AViewItemFactory
 * JD-Core Version:    0.6.0
 */
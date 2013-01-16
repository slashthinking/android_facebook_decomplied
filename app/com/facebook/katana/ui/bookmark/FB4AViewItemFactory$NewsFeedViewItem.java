package com.facebook.katana.ui.bookmark;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.bookmark.ui.event.OnBookmarkSelectedListener;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.google.common.base.Preconditions;

public class FB4AViewItemFactory$NewsFeedViewItem extends BookmarkAdapter.BaseViewItem<FB4AViewItemFactory.NewsFeedViewHolder, Bookmark>
{
  private final int f;
  private final OnBookmarkSelectedListener g;

  public FB4AViewItemFactory$NewsFeedViewItem(FB4AViewItemFactory paramFB4AViewItemFactory, BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark, int paramInt, OnBookmarkSelectedListener paramOnBookmarkSelectedListener)
  {
    super(paramRowType, 2130903070, paramBookmark, FB4AViewItemFactory.a(paramFB4AViewItemFactory));
    this.f = paramInt;
    this.g = ((OnBookmarkSelectedListener)Preconditions.checkNotNull(paramOnBookmarkSelectedListener));
  }

  private void a(Bookmark paramBookmark)
  {
    int i = 2131363455;
    int j;
    CharSequence[] arrayOfCharSequence;
    int k;
    label58: Activity localActivity2;
    if (FB4AViewItemFactory.b(this.a).a(FbandroidPrefKeys.m, NewsFeedType.TOP_STORIES.ordinal()) == NewsFeedType.TOP_STORIES.ordinal())
    {
      j = 1;
      arrayOfCharSequence = new CharSequence[2];
      Activity localActivity1 = FB4AViewItemFactory.d(this.a);
      if (j == 0)
        break label178;
      k = 2131363454;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = FB4AViewItemFactory.c(this.a).getString(2131363452);
      arrayOfCharSequence[0] = localActivity1.getString(k, arrayOfObject1);
      localActivity2 = FB4AViewItemFactory.f(this.a);
      if (j == 0)
        break label184;
    }
    while (true)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = FB4AViewItemFactory.e(this.a).getString(2131363453);
      arrayOfCharSequence[1] = localActivity2.getString(i, arrayOfObject2);
      new AlertDialog.Builder(FB4AViewItemFactory.h(this.a)).setItems(arrayOfCharSequence, new FB4AViewItemFactory.NewsFeedViewItem.2(this, paramBookmark)).show();
      return;
      j = 0;
      break;
      label178: k = i;
      break label58;
      label184: i = 2131363454;
    }
  }

  public FB4AViewItemFactory.NewsFeedViewHolder a(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131296410);
    this.e.inflate(2130903071, localRelativeLayout, true);
    return new FB4AViewItemFactory.NewsFeedViewHolder(paramView);
  }

  public void a(FB4AViewItemFactory.NewsFeedViewHolder paramNewsFeedViewHolder)
  {
    FB4AViewItemFactory.a(this.a, paramNewsFeedViewHolder, (Bookmark)this.d, this.f);
    paramNewsFeedViewHolder.c.setOnClickListener(new FB4AViewItemFactory.NewsFeedViewItem.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.FB4AViewItemFactory.NewsFeedViewItem
 * JD-Core Version:    0.6.0
 */
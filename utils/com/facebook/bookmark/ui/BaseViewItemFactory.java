package com.facebook.bookmark.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;
import java.util.Map;

public class BaseViewItemFactory
{
  protected static final Map<String, Integer> c = new BaseViewItemFactory.1();
  private static int d = -1;
  private static int e = -1;
  protected final Activity a;
  protected final LayoutInflater b;

  public BaseViewItemFactory(Activity paramActivity, LayoutInflater paramLayoutInflater)
  {
    this.a = ((Activity)Preconditions.checkNotNull(paramActivity));
    this.b = ((LayoutInflater)Preconditions.checkNotNull(paramLayoutInflater));
  }

  protected int a(Bookmark paramBookmark)
  {
    int i;
    if ((paramBookmark == null) || (paramBookmark.icon == null))
      i = 0;
    while (true)
    {
      return i;
      String str1 = paramBookmark.icon;
      if (("app".equals(paramBookmark.type)) && (str1.endsWith("/images/im_online.gif")))
      {
        i = 2130838165;
      }
      else
      {
        Uri localUri = Uri.parse(str1);
        if ((localUri == null) || (!localUri.getPath().startsWith("/images/icons/")))
        {
          i = 0;
        }
        else
        {
          String str2 = localUri.getPath().substring("/images/icons/".length());
          if (c.containsKey(str2))
          {
            i = ((Integer)c.get(str2)).intValue();
          }
          else if (("group".equals(paramBookmark.type)) && (str2.startsWith("group-types/")))
          {
            String str3 = str2.substring("group-types/".length());
            int j = str3.lastIndexOf('.');
            if (j != -1)
              str3 = str3.substring(0, j);
            String str4 = "group_types_" + str3.replace('-', '_');
            i = this.a.getResources().getIdentifier(str4, "drawable", this.a.getPackageName());
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }

  public BaseViewItemFactory.BookmarkViewItem a(BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark, int paramInt)
  {
    return new BaseViewItemFactory.BookmarkViewItem(this, paramRowType, paramBookmark, paramInt);
  }

  public BaseViewItemFactory.DividerViewItem a(BookmarkAdapter.RowType paramRowType, BookmarksGroup paramBookmarksGroup, boolean paramBoolean)
  {
    return new BaseViewItemFactory.DividerViewItem(this, paramRowType, paramBookmarksGroup, paramBoolean);
  }

  public <D> BaseViewItemFactory.IconLabelViewItem<D> a(BookmarkAdapter.RowType paramRowType, D paramD, int paramInt1, int paramInt2)
  {
    return new BaseViewItemFactory.IconLabelViewItem(this, paramRowType, paramD, paramInt1, paramInt2);
  }

  public BaseViewItemFactory.ProfileViewItem a(BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark)
  {
    return new BaseViewItemFactory.ProfileViewItem(this, paramRowType, paramBookmark);
  }

  protected void a(BaseViewItemFactory.BaseBookmarkViewHolder paramBaseBookmarkViewHolder, Bookmark paramBookmark, int paramInt)
  {
    int i = a(paramBookmark);
    if (i > 0)
    {
      paramBaseBookmarkViewHolder.d.setImageParams((FetchImageParams)null);
      paramBaseBookmarkViewHolder.d.setPlaceHolderResourceId(i);
      paramBaseBookmarkViewHolder.e.setText(paramBookmark.name);
      if (paramInt != 0)
        break label92;
      paramBaseBookmarkViewHolder.b.setVisibility(4);
    }
    while (true)
    {
      paramBaseBookmarkViewHolder.e.setTextColor(this.a.getResources().getColor(2131165336));
      return;
      paramBaseBookmarkViewHolder.d.setImageParams(Uri.parse(paramBookmark.pic));
      break;
      label92: paramBaseBookmarkViewHolder.b.setVisibility(0);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BaseViewItemFactory
 * JD-Core Version:    0.6.2
 */
package com.facebook.bookmark.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;

public class BookmarkAdapter extends BaseAdapter
{
  protected final List<BookmarkAdapter.ViewItem> a = Lists.a();
  protected final int b;

  public BookmarkAdapter(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(List<BookmarkAdapter.ViewItem> paramList)
  {
    this.a.clear();
    this.a.addAll((Collection)Preconditions.checkNotNull(paramList));
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return ((BookmarkAdapter.ViewItem)this.a.get(paramInt)).a().ordinal();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return ((BookmarkAdapter.ViewItem)this.a.get(paramInt)).a(paramInt, paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BookmarkAdapter
 * JD-Core Version:    0.6.2
 */
package com.facebook.bugreporter.tasklist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.debug.Assert;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class TagListAdapter extends BaseAdapter
{
  private final Context a;
  private ImmutableList<TagListItem> b;

  public TagListAdapter(Context paramContext)
  {
    this.a = paramContext;
  }

  public TagListItem a(int paramInt)
  {
    return (TagListItem)this.b.get(paramInt);
  }

  public ImmutableList<TagListItem> a()
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      TagListItem localTagListItem = (TagListItem)localIterator.next();
      if (!localTagListItem.c())
        continue;
      localBuilder.b(localTagListItem);
    }
    return localBuilder.b();
  }

  public void a(ImmutableList<TagListItem> paramImmutableList)
  {
    this.b = paramImmutableList;
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.b.size();
  }

  public long getItemId(int paramInt)
  {
    return ((TagListItem)this.b.get(paramInt)).b();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TagListItemView localTagListItemView = (TagListItemView)paramView;
    if (paramInt <= this.b.size());
    for (boolean bool = true; ; bool = false)
    {
      Assert.b("index is a list index", bool);
      if (localTagListItemView == null)
        localTagListItemView = new TagListItemView(this.a);
      localTagListItemView.setTagListItem(a(paramInt));
      return localTagListItemView;
    }
  }

  public boolean hasStableIds()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TagListAdapter
 * JD-Core Version:    0.6.0
 */
package com.facebook.feed.pages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.pages.data.model.StoryInsightsDetailItem;
import com.facebook.pages.data.model.StoryInsightsDetailItem.StoryInsightsDetailItemType;
import com.google.common.collect.ImmutableList;

public class StoryInsightsAdapter extends BaseAdapter
{
  private static final String a = StoryInsightsAdapter.class.getName();
  private final LayoutInflater b;
  private ImmutableList<StoryInsightsDetailItem> c;

  public StoryInsightsAdapter(LayoutInflater paramLayoutInflater)
  {
    this.b = paramLayoutInflater;
    this.c = null;
  }

  public StoryInsightsDetailItem a(int paramInt)
  {
    if (this.c != null);
    for (StoryInsightsDetailItem localStoryInsightsDetailItem = (StoryInsightsDetailItem)this.c.get(paramInt); ; localStoryInsightsDetailItem = null)
      return localStoryInsightsDetailItem;
  }

  public void a(ImmutableList<StoryInsightsDetailItem> paramImmutableList)
  {
    this.c = paramImmutableList;
  }

  public int getCount()
  {
    if (this.c != null);
    for (int i = this.c.size(); ; i = 0)
      return i;
  }

  public long getItemId(int paramInt)
  {
    long l;
    if (a(paramInt) != null)
      l = paramInt;
    while (true)
    {
      return l;
      l = -1L;
    }
  }

  public int getItemViewType(int paramInt)
  {
    StoryInsightsDetailItem localStoryInsightsDetailItem = a(paramInt);
    if (localStoryInsightsDetailItem != null);
    for (int i = localStoryInsightsDetailItem.e().ordinal(); ; i = -1)
      return i;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    StoryInsightsDetailItem localStoryInsightsDetailItem = a(paramInt);
    if (localStoryInsightsDetailItem == null);
    for (paramView = null; ; paramView = null)
    {
      return paramView;
      switch (StoryInsightsAdapter.1.a[StoryInsightsDetailItem.StoryInsightsDetailItemType.values()[i].ordinal()])
      {
      default:
        Log.a(a, "Unknown view type for story insights adapter : " + StoryInsightsDetailItem.StoryInsightsDetailItemType.values()[i]);
      case 1:
      case 2:
      }
    }
    StoryInsightsAdapter.ViewHolderHeader localViewHolderHeader2;
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903560, null);
      localViewHolderHeader2 = new StoryInsightsAdapter.ViewHolderHeader(this, null);
      localViewHolderHeader2.a = ((TextView)paramView.findViewById(2131297847));
      paramView.setTag(localViewHolderHeader2);
    }
    for (StoryInsightsAdapter.ViewHolderHeader localViewHolderHeader1 = localViewHolderHeader2; ; localViewHolderHeader1 = (StoryInsightsAdapter.ViewHolderHeader)paramView.getTag())
    {
      localViewHolderHeader1.a.setText(localStoryInsightsDetailItem.d());
      break;
    }
    StoryInsightsAdapter.ViewHolder localViewHolder2;
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903559, null);
      localViewHolder2 = new StoryInsightsAdapter.ViewHolder(this, null);
      localViewHolder2.a = ((StoryInsightsBarView)paramView.findViewById(2131297845));
      localViewHolder2.b = ((TextView)paramView.findViewById(2131297846));
      paramView.setTag(localViewHolder2);
    }
    for (StoryInsightsAdapter.ViewHolder localViewHolder1 = localViewHolder2; ; localViewHolder1 = (StoryInsightsAdapter.ViewHolder)paramView.getTag())
    {
      localViewHolder1.a.setColor(localStoryInsightsDetailItem.c());
      localViewHolder1.a.setPercentage((float)localStoryInsightsDetailItem.b() / (float)localStoryInsightsDetailItem.a());
      localViewHolder1.b.setText(localStoryInsightsDetailItem.d());
      localViewHolder1.b.setTextColor(localStoryInsightsDetailItem.c());
      break;
    }
  }

  public int getViewTypeCount()
  {
    return StoryInsightsDetailItem.StoryInsightsDetailItemType.values().length;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.pages.StoryInsightsAdapter
 * JD-Core Version:    0.6.0
 */
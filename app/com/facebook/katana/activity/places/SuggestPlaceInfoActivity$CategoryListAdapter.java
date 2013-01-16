package com.facebook.katana.activity.places;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.katana.model.PageTopic;
import java.util.HashSet;
import java.util.Set;

class SuggestPlaceInfoActivity$CategoryListAdapter extends ArrayAdapter<PageTopic>
{
  private Context b;
  private int c;
  private Set<PageTopic> d = new HashSet();

  public SuggestPlaceInfoActivity$CategoryListAdapter(SuggestPlaceInfoActivity paramSuggestPlaceInfoActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.c = paramInt;
  }

  public void a(PageTopic paramPageTopic)
  {
    if (this.d.contains(paramPageTopic));
    while (true)
    {
      return;
      this.d.add(paramPageTopic);
      super.add(paramPageTopic);
    }
  }

  public void b(PageTopic paramPageTopic)
  {
    this.d.remove(paramPageTopic);
    super.remove(paramPageTopic);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SuggestPlaceInfoActivity.CategoryListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = ((Activity)this.b).getLayoutInflater().inflate(this.c, paramViewGroup, false);
      localViewHolder = new SuggestPlaceInfoActivity.CategoryListAdapter.ViewHolder(this, null);
      localViewHolder.b = ((TextView)paramView.findViewById(2131297683));
      localViewHolder.a = ((ImageButton)paramView.findViewById(2131297684));
      paramView.setTag(localViewHolder);
    }
    while (true)
    {
      PageTopic localPageTopic = (PageTopic)getItem(paramInt);
      localViewHolder.a.setOnClickListener(new SuggestPlaceInfoActivity.CategoryListAdapter.1(this, paramInt));
      localViewHolder.b.setText(localPageTopic.displayName);
      return paramView;
      localViewHolder = (SuggestPlaceInfoActivity.CategoryListAdapter.ViewHolder)paramView.getTag();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SuggestPlaceInfoActivity.CategoryListAdapter
 * JD-Core Version:    0.6.0
 */
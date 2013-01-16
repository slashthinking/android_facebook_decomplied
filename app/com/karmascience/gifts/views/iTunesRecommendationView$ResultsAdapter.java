package com.karmascience.gifts.views;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.iTunesContent;
import java.util.List;

final class iTunesRecommendationView$ResultsAdapter extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int a = 0;
  final int b = 1;
  final List<iTunesContent> c;
  final LayoutInflater d;

  private iTunesRecommendationView$ResultsAdapter(List<iTunesContent> paramList)
  {
    Object localObject;
    this.c = localObject;
    this.d = ((LayoutInflater)paramList.g().getSystemService("layout_inflater"));
  }

  public int getCount()
  {
    if (this.c.size() == 0);
    for (int i = 1; ; i = this.c.size())
      return i;
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public int getItemViewType(int paramInt)
  {
    if (this.c.size() == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      paramView = this.d.inflate(2130903254, paramViewGroup, false);
      paramView.setOnClickListener(new iTunesRecommendationView.ResultsAdapter.1(this));
    }
    while (true)
    {
      return paramView;
      if (paramView == null)
      {
        paramView = this.d.inflate(2130903253, paramViewGroup, false);
        iTunesRecommendationView.ResultsAdapter.ViewHolder localViewHolder2 = new iTunesRecommendationView.ResultsAdapter.ViewHolder(this, null);
        localViewHolder2.c = ((UrlImage)paramView.findViewById(2131297026));
        localViewHolder2.b = ((TextView)paramView.findViewById(2131297028));
        localViewHolder2.a = ((TextView)paramView.findViewById(2131297027));
        paramView.setTag(localViewHolder2);
      }
      iTunesRecommendationView.ResultsAdapter.ViewHolder localViewHolder1 = (iTunesRecommendationView.ResultsAdapter.ViewHolder)paramView.getTag();
      iTunesContent localiTunesContent = (iTunesContent)this.c.get(paramInt);
      localViewHolder1.c.setImageParams(Uri.parse(localiTunesContent.d()));
      localViewHolder1.b.setText(localiTunesContent.a());
      localViewHolder1.a.setText(localiTunesContent.b());
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    iTunesContent localiTunesContent = (iTunesContent)this.c.get(paramInt - 1);
    iTunesRecommendationView.d(this.e).a("itunes_has_recommended", Boolean.toString(Boolean.TRUE.booleanValue()));
    iTunesRecommendationView.d(this.e).a("itunes_recommended_content_info", localiTunesContent.a());
    iTunesRecommendationView.d(this.e).a("itunes_recommended_content_title", localiTunesContent.b());
    iTunesRecommendationView.d(this.e).a("itunes_recommended_image_url", localiTunesContent.d());
    iTunesRecommendationView.d(this.e).a("itunes_recommended_itunes_id", localiTunesContent.c());
    Bundle localBundle = CommonViewUtils.a(12);
    localBundle.putParcelable("product_parcelable", iTunesRecommendationView.d(this.e));
    localBundle.putParcelable("sku_parcelable", iTunesRecommendationView.e(this.e));
    this.e.n().c("Added iTunes Recommendation").a("itunes_id", localiTunesContent.c()).a();
    this.e.b(localBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesRecommendationView.ResultsAdapter
 * JD-Core Version:    0.6.0
 */
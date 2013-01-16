package com.facebook.nearby.search;

import android.content.Context;
import android.widget.TextView;
import com.facebook.nearby.model.NearbyTopic;
import com.facebook.widget.CustomViewGroup;

class NearbySearchTopicRowView extends CustomViewGroup
{
  private final TextView a;

  public NearbySearchTopicRowView(Context paramContext)
  {
    super(paramContext);
    setContentView(2130903292);
    this.a = ((TextView)findViewById(2131297153));
  }

  public void a(NearbyTopic paramNearbyTopic)
  {
    this.a.setText(paramNearbyTopic.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.NearbySearchTopicRowView
 * JD-Core Version:    0.6.0
 */
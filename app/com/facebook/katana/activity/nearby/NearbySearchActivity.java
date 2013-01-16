package com.facebook.katana.activity.nearby;

import android.os.Bundle;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.FbFragmentActivity;

public class NearbySearchActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  public String a()
  {
    return "places_search";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903293);
    ((TextView)findViewById(2131296686)).setText(2131361891);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.nearby.NearbySearchActivity
 * JD-Core Version:    0.6.0
 */
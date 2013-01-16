package com.facebook.katana.activity.pageidentity;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.katana.IntentUriHandler;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.pages.identity.ui.PageRecommendationRowView;

public class RecommendationListActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  private boolean a(String paramString)
  {
    return IntentUriHandler.b(this, StringLocaleUtil.a("fb://profile/%s", new Object[] { paramString }));
  }

  public String a()
  {
    return "page_recommendation_list";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903469);
    PageRecommendationRowView.setOnFriendRatingClickedListener(new RecommendationListActivity.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.pageidentity.RecommendationListActivity
 * JD-Core Version:    0.6.0
 */
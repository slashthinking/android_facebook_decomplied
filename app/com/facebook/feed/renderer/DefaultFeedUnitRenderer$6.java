package com.facebook.feed.renderer;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.GraphQLProfile;

class DefaultFeedUnitRenderer$6
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    GraphQLProfile localGraphQLProfile = (GraphQLProfile)paramView.getTag(2131296269);
    String str = DefaultFeedUnitRenderer.a(this.a, localGraphQLProfile);
    if (str == null);
    while (true)
    {
      return;
      DefaultFeedUnitRenderer.a(this.a).b((HoneyClientEvent)paramView.getTag(2131296270));
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("gql_profile", localGraphQLProfile);
      DefaultFeedUnitRenderer.d(this.a).a(DefaultFeedUnitRenderer.b(this.a), str, localBundle);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.DefaultFeedUnitRenderer.6
 * JD-Core Version:    0.6.0
 */
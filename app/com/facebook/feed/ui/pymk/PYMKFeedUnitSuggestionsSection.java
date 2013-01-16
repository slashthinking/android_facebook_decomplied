package com.facebook.feed.ui.pymk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;

public class PYMKFeedUnitSuggestionsSection extends CustomLinearLayout
{
  private final NewsFeedAnalyticsEventBuilder a;
  private final AnalyticsLogger b;
  private final FriendingClient c;
  private final IFeedUnitRenderer d;
  private final LayoutInflater e;
  private final Context f;
  private PeopleYouMayKnowFeedUnit g;

  public PYMKFeedUnitSuggestionsSection(Context paramContext)
  {
    this(paramContext, null);
  }

  public PYMKFeedUnitSuggestionsSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext;
    this.g = null;
    setOrientation(1);
    FbInjector localFbInjector = getInjector();
    this.e = ((LayoutInflater)localFbInjector.a(LayoutInflater.class));
    this.d = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.c = ((FriendingClient)localFbInjector.a(FriendingClient.class));
    this.b = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.a = ((NewsFeedAnalyticsEventBuilder)localFbInjector.a(NewsFeedAnalyticsEventBuilder.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.pymk.PYMKFeedUnitSuggestionsSection
 * JD-Core Version:    0.6.0
 */
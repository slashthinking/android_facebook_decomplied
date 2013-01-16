package com.facebook.feed.renderer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.feed.flyout.FlyoutClickSource;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.ui.BindableFeedUnitView;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.graphql.model.CelebrationsFeedUnit;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.MegaphoneStory;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnit;
import com.facebook.graphql.model.UnknownFeedUnit;
import com.facebook.megaphone.ui.MegaphoneStoryView;
import com.google.common.base.Preconditions;

public class DefaultFeedUnitRenderer
  implements IFeedUnitRenderer
{
  private final Context a;
  private final IFeedIntentBuilder b;
  private final FeedLinkifyUtil c;
  private final AnalyticsLogger d;
  private final FlyoutAnimationHandler e;
  private final SecureContextHelper f;
  private final View.OnClickListener g;
  private final View.OnClickListener h;
  private final View.OnClickListener i;
  private final View.OnClickListener j;
  private final View.OnClickListener k;
  private final View.OnClickListener l;

  public DefaultFeedUnitRenderer(Activity paramActivity, IFeedIntentBuilder paramIFeedIntentBuilder, AnalyticsLogger paramAnalyticsLogger, FeedLinkifyUtil paramFeedLinkifyUtil, FlyoutAnimationHandler paramFlyoutAnimationHandler, SecureContextHelper paramSecureContextHelper)
  {
    this.a = paramActivity;
    this.b = paramIFeedIntentBuilder;
    this.d = paramAnalyticsLogger;
    this.c = paramFeedLinkifyUtil;
    this.e = paramFlyoutAnimationHandler;
    this.f = paramSecureContextHelper;
    this.g = new DefaultFeedUnitRenderer.1(this);
    this.h = new DefaultFeedUnitRenderer.2(this);
    this.i = new DefaultFeedUnitRenderer.3(this);
    this.j = new DefaultFeedUnitRenderer.4(this);
    this.k = new DefaultFeedUnitRenderer.5(this);
    this.l = new DefaultFeedUnitRenderer.6(this);
  }

  private String a(GraphQLProfile paramGraphQLProfile)
  {
    Preconditions.checkNotNull(paramGraphQLProfile);
    return this.c.a(paramGraphQLProfile.objectType, paramGraphQLProfile.id);
  }

  private void a(TextView paramTextView, FeedStory paramFeedStory, boolean paramBoolean)
  {
    this.c.b(paramFeedStory);
    FlyoutClickSource localFlyoutClickSource = (FlyoutClickSource)paramTextView.getTag(2131296266);
    Spannable localSpannable;
    if (FlyoutClickSource.MESSAGE.equals(localFlyoutClickSource))
    {
      localSpannable = paramFeedStory.J();
      if ((!paramBoolean) || (localSpannable == null));
    }
    while (true)
    {
      paramTextView.setText(localSpannable);
      return;
      localSpannable = paramFeedStory.I();
      continue;
      localSpannable = paramFeedStory.H();
    }
  }

  public View a(View paramView, ViewGroup paramViewGroup, MegaphoneStory paramMegaphoneStory)
  {
    if (paramView == null);
    for (MegaphoneStoryView localMegaphoneStoryView = new MegaphoneStoryView(this.a); ; localMegaphoneStoryView = (MegaphoneStoryView)paramView)
    {
      localMegaphoneStoryView.setMegaphoneStory(paramMegaphoneStory);
      return localMegaphoneStoryView;
    }
  }

  public View a(View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int m = this.a.getResources().getDimensionPixelSize(2131230810);
    if (m != paramView.getHeight())
      paramView.findViewById(2131296824).getLayoutParams().height = m;
    View localView = paramView.findViewById(2131296825);
    if (paramBoolean);
    for (int n = 8; ; n = 0)
    {
      localView.setVisibility(n);
      return paramView;
    }
  }

  public View a(FeedUnit paramFeedUnit, View paramView, ViewGroup paramViewGroup, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    if ((paramView instanceof BindableFeedUnitView))
    {
      if (!(paramFeedUnit instanceof FeedStory))
        break label40;
      ((FeedStory)paramFeedUnit).G();
      ((BindableFeedUnitView)paramView).a((FeedStory)paramFeedUnit, paramFeedUnitViewStyle, paramBoolean);
    }
    while (true)
    {
      return paramView;
      label40: if ((paramFeedUnit instanceof PeopleYouMayKnowFeedUnit))
      {
        ((BindableFeedUnitView)paramView).a((PeopleYouMayKnowFeedUnit)paramFeedUnit, paramFeedUnitViewStyle, paramBoolean);
        continue;
      }
      if ((paramFeedUnit instanceof PagesYouMayLikeFeedUnit))
      {
        ((BindableFeedUnitView)paramView).a((PagesYouMayLikeFeedUnit)paramFeedUnit, paramFeedUnitViewStyle, paramBoolean);
        continue;
      }
      if ((paramFeedUnit instanceof CelebrationsFeedUnit))
      {
        ((BindableFeedUnitView)paramView).a((CelebrationsFeedUnit)paramFeedUnit, paramFeedUnitViewStyle, paramBoolean);
        continue;
      }
      if ((paramFeedUnit instanceof RecommendedApplicationsFeedUnit))
      {
        ((BindableFeedUnitView)paramView).a((RecommendedApplicationsFeedUnit)paramFeedUnit, paramFeedUnitViewStyle, paramBoolean);
        continue;
      }
      if (!(paramFeedUnit instanceof UnknownFeedUnit))
        continue;
      ((BindableFeedUnitView)paramView).a((UnknownFeedUnit)paramFeedUnit, paramFeedUnitViewStyle, paramBoolean);
    }
  }

  public void a(View paramView, Intent paramIntent, HoneyClientEvent paramHoneyClientEvent)
  {
    if ((paramView != null) && (paramIntent != null))
    {
      paramView.setTag(2131296270, paramHoneyClientEvent);
      paramView.setTag(2131296271, paramIntent);
      paramView.setOnClickListener(this.g);
    }
  }

  public void a(View paramView, FeedStory paramFeedStory, HoneyClientEvent paramHoneyClientEvent)
  {
    if ((paramView != null) && (paramFeedStory != null))
    {
      paramView.setTag(2131296270, paramHoneyClientEvent);
      paramView.setTag(2131296275, paramFeedStory);
      paramView.setOnClickListener(this.i);
    }
  }

  public void a(View paramView, Feedback paramFeedback, FeedbackLoggingParams paramFeedbackLoggingParams, HoneyClientEvent paramHoneyClientEvent)
  {
    if ((paramView != null) && (paramFeedback != null))
    {
      paramView.setTag(2131296270, paramHoneyClientEvent);
      paramView.setTag(2131296272, paramFeedback);
      paramView.setTag(2131296273, paramFeedbackLoggingParams);
      paramView.setOnClickListener(this.h);
    }
  }

  public void a(View paramView, GraphQLProfile paramGraphQLProfile, HoneyClientEvent paramHoneyClientEvent)
  {
    if ((paramView != null) && (paramGraphQLProfile != null))
    {
      paramView.setTag(2131296269, paramGraphQLProfile);
      paramView.setOnClickListener(this.l);
    }
    while (true)
    {
      return;
      paramView.setOnClickListener(null);
    }
  }

  public void a(View paramView, String paramString, HoneyClientEvent paramHoneyClientEvent)
  {
    if ((paramView != null) && (paramString != null))
    {
      paramView.setTag(2131296270, paramHoneyClientEvent);
      paramView.setTag(2131296274, paramString);
      paramView.setOnClickListener(this.j);
    }
  }

  public void a(TextView paramTextView, GraphQLTextWithEntities paramGraphQLTextWithEntities, FeedStory paramFeedStory, boolean paramBoolean)
  {
    if (paramGraphQLTextWithEntities.ranges == null)
      paramTextView.setText(paramGraphQLTextWithEntities.text);
    while (true)
    {
      return;
      a(paramTextView, paramFeedStory, paramBoolean);
    }
  }

  public void b(View paramView, FeedStory paramFeedStory, HoneyClientEvent paramHoneyClientEvent)
  {
    if ((paramView != null) && (paramFeedStory != null))
    {
      paramView.setTag(2131296270, paramHoneyClientEvent);
      paramView.setTag(2131296275, paramFeedStory);
      paramView.setOnClickListener(this.k);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.DefaultFeedUnitRenderer
 * JD-Core Version:    0.6.0
 */
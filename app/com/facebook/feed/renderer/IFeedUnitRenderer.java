package com.facebook.feed.renderer;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.MegaphoneStory;

public abstract interface IFeedUnitRenderer
{
  public abstract View a(View paramView, ViewGroup paramViewGroup, MegaphoneStory paramMegaphoneStory);

  public abstract View a(View paramView, ViewGroup paramViewGroup, boolean paramBoolean);

  public abstract View a(FeedUnit paramFeedUnit, View paramView, ViewGroup paramViewGroup, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean);

  public abstract void a(View paramView, Intent paramIntent, HoneyClientEvent paramHoneyClientEvent);

  public abstract void a(View paramView, FeedStory paramFeedStory, HoneyClientEvent paramHoneyClientEvent);

  public abstract void a(View paramView, Feedback paramFeedback, FeedbackLoggingParams paramFeedbackLoggingParams, HoneyClientEvent paramHoneyClientEvent);

  public abstract void a(View paramView, GraphQLProfile paramGraphQLProfile, HoneyClientEvent paramHoneyClientEvent);

  public abstract void a(View paramView, String paramString, HoneyClientEvent paramHoneyClientEvent);

  public abstract void a(TextView paramTextView, GraphQLTextWithEntities paramGraphQLTextWithEntities, FeedStory paramFeedStory, boolean paramBoolean);

  public abstract void b(View paramView, FeedStory paramFeedStory, HoneyClientEvent paramHoneyClientEvent);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.IFeedUnitRenderer
 * JD-Core Version:    0.6.0
 */
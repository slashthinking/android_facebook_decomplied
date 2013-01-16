package com.facebook.feed.protocol;

import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import com.google.common.base.Preconditions;

public class ToggleLikeParams$Builder
{
  private String a;
  private boolean b;
  private GraphQLProfile c;
  private FeedbackLoggingParams d;
  private Feedback e;
  private String f;
  private String g;

  public Builder a(FeedbackLoggingParams paramFeedbackLoggingParams)
  {
    this.d = paramFeedbackLoggingParams;
    return this;
  }

  public Builder a(Feedback paramFeedback)
  {
    this.e = paramFeedback;
    return this;
  }

  public Builder a(GraphQLProfile paramGraphQLProfile)
  {
    this.c = paramGraphQLProfile;
    return this;
  }

  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public Builder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public ToggleLikeParams a()
  {
    Preconditions.checkNotNull(this.a);
    return new ToggleLikeParams(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
  }

  public Builder b(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public Builder c(String paramString)
  {
    this.g = paramString;
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.ToggleLikeParams.Builder
 * JD-Core Version:    0.6.0
 */
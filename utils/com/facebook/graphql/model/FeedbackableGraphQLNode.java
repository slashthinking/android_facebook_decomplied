package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackableGraphQLNode
{

  @JsonIgnore
  private long a;

  @JsonProperty("feedback")
  private final Feedback feedback;

  protected FeedbackableGraphQLNode()
  {
    this.feedback = null;
    this.a = -1L;
  }

  protected FeedbackableGraphQLNode(Feedback paramFeedback)
  {
    this.feedback = paramFeedback;
    this.a = -1L;
  }

  public FeedbackableGraphQLNode(FeedbackableGraphQLNodeBuilder paramFeedbackableGraphQLNodeBuilder)
  {
    this.feedback = paramFeedbackableGraphQLNodeBuilder.a();
    this.a = paramFeedbackableGraphQLNodeBuilder.b();
  }

  private void a()
  {
    if ((S() == null) || (S().legacyApiPostId == null) || (this.a == -2L))
      this.a = -2L;
    while (true)
    {
      return;
      int i = S().legacyApiPostId.indexOf('_');
      try
      {
        this.a = Long.parseLong(S().legacyApiPostId.substring(i + 1));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        this.a = -2L;
      }
    }
  }

  private boolean a(long paramLong)
  {
    if (Q() == paramLong);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean P()
  {
    boolean bool2;
    if (S() != null)
    {
      boolean bool3 = S().canViewerComment;
      bool2 = false;
      if (bool3);
    }
    while (true)
    {
      return bool2;
      boolean bool1 = a(-2L);
      bool2 = false;
      if (!bool1)
        bool2 = true;
    }
  }

  @JsonIgnore
  public long Q()
  {
    if (this.a == -1L)
      a();
    return this.a;
  }

  public boolean R()
  {
    if (S() != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Feedback S()
  {
    return this.feedback;
  }

  public boolean b()
  {
    boolean bool2;
    if (S() != null)
    {
      boolean bool3 = S().canViewerLike;
      bool2 = false;
      if (bool3);
    }
    while (true)
    {
      return bool2;
      boolean bool1 = a(-2L);
      bool2 = false;
      if (!bool1)
        bool2 = true;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedbackableGraphQLNode
 * JD-Core Version:    0.6.2
 */
package com.facebook.graphql.model;

import com.google.common.base.Preconditions;

public enum FeedStory$SeenState
{
  private final String mSeenStateGQLString;

  static
  {
    SeenState[] arrayOfSeenState = new SeenState[3];
    arrayOfSeenState[0] = SEEN_AND_READ;
    arrayOfSeenState[1] = SEEN_BUT_UNREAD;
    arrayOfSeenState[2] = UNSEEN_AND_UNREAD;
  }

  private FeedStory$SeenState(String paramString)
  {
    this.mSeenStateGQLString = paramString;
  }

  public String toGQLString()
  {
    return (String)Preconditions.checkNotNull(this.mSeenStateGQLString);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStory.SeenState
 * JD-Core Version:    0.6.2
 */
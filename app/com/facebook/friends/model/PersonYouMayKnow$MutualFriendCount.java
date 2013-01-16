package com.facebook.friends.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class PersonYouMayKnow$MutualFriendCount
{

  @JsonProperty("count")
  private final int count;

  private PersonYouMayKnow$MutualFriendCount()
  {
    this.count = 0;
  }

  private PersonYouMayKnow$MutualFriendCount(int paramInt)
  {
    this.count = paramInt;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.model.PersonYouMayKnow.MutualFriendCount
 * JD-Core Version:    0.6.0
 */
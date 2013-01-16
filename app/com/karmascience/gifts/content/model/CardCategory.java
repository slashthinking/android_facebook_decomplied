package com.karmascience.gifts.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardCategory
{

  @JsonProperty("id")
  private final String mId = null;

  @JsonProperty("name")
  private final String mName = null;

  public String a()
  {
    return this.mId;
  }

  public String b()
  {
    return this.mName;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.CardCategory
 * JD-Core Version:    0.6.0
 */
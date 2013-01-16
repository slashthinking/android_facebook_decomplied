package com.karmascience.gifts.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCategory
{

  @JsonProperty("classification")
  private final String mClassification = null;

  @JsonProperty("id")
  private final String mId = null;

  @JsonProperty("name")
  private final String mName = null;

  public String a()
  {
    return this.mName;
  }

  public String b()
  {
    return this.mId;
  }

  public String c()
  {
    return this.mClassification;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.ProductCategory
 * JD-Core Version:    0.6.0
 */
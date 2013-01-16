package com.karmascience.gifts.content.model;

import com.facebook.common.util.Log;
import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CardFront
{

  @JsonProperty("background_color")
  private final String mBackgroundColor = null;

  @JsonProperty("closings")
  private final List<String> mClosings = null;

  @JsonProperty("default_message")
  private final String mDefaultMessage = null;

  @JsonProperty("id")
  private final String mId = null;

  @JsonProperty("image")
  private final Image mImage = null;

  @JsonProperty("name")
  private final String mName = null;

  public Image a()
  {
    return this.mImage;
  }

  public String b()
  {
    return this.mId;
  }

  public String c()
  {
    return this.mName;
  }

  public String d()
  {
    return this.mDefaultMessage;
  }

  public List<String> e()
  {
    return this.mClosings;
  }

  public int f()
  {
    int i = -9647903;
    try
    {
      if (!StringUtil.a(this.mBackgroundColor))
      {
        int j = Integer.parseInt(this.mBackgroundColor, 16);
        i = j | 0xFF000000;
      }
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        Log.e("Non-hex background color for card front returned from API call: " + this.mBackgroundColor);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.CardFront
 * JD-Core Version:    0.6.0
 */
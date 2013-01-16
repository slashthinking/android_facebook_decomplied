package com.facebook.katana.service.method;

import com.facebook.common.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public enum PlacesCreate$HomePrivacyType
{
  public final String apiValue;
  public final int iconResId;
  public final int nameResId;
  public final String privacyTypeValue;

  static
  {
    FRIENDS = new HomePrivacyType("FRIENDS", 1, "ALL_FRIENDS", 2131363056, 2130837545);
    ONLY_ME = new HomePrivacyType("ONLY_ME", 2, "SELF", 2131363058, 2130837547);
    HomePrivacyType[] arrayOfHomePrivacyType = new HomePrivacyType[3];
    arrayOfHomePrivacyType[0] = PUBLIC;
    arrayOfHomePrivacyType[1] = FRIENDS;
    arrayOfHomePrivacyType[2] = ONLY_ME;
    $VALUES = arrayOfHomePrivacyType;
  }

  private PlacesCreate$HomePrivacyType(String paramString, int paramInt1, int paramInt2)
  {
    this.privacyTypeValue = paramString;
    this.nameResId = paramInt1;
    this.iconResId = paramInt2;
    Object localObject = "";
    try
    {
      String str2;
      if (paramString.equals("SELF"))
        str2 = new JSONObject().put("value", "CUSTOM").put("friends", "SELF").toString();
      String str1;
      for (localObject = str2; ; localObject = str1)
      {
        this.apiValue = ((String)localObject);
        return;
        str1 = new JSONObject().put("value", paramString).toString();
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
        Log.a(PlacesCreate.a, "JSONException when ENCODING data: " + localJSONException.getMessage());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesCreate.HomePrivacyType
 * JD-Core Version:    0.6.0
 */
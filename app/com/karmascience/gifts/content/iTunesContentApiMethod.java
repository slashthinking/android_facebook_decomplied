package com.karmascience.gifts.content;

import com.karmascience.gifts.ThreadingService;
import org.json.JSONArray;

public abstract class iTunesContentApiMethod<T> extends GraphPOJOApiMethod<T>
{
  public iTunesContentApiMethod(String paramString1, int paramInt, String paramString2, ThreadingService paramThreadingService, Class<T> paramClass)
  {
    super("GetiTunesContentViaSearch", paramThreadingService, 0, paramClass, "GET", "me/gift_itunes_search");
    a("type", paramString1);
    a("q", paramString2);
    a("limit", Integer.toString(paramInt));
  }

  public iTunesContentApiMethod(String[] paramArrayOfString, int paramInt, ThreadingService paramThreadingService, Class<T> paramClass)
  {
    super("GetiTunesContent", paramThreadingService, 0, paramClass, "GET", "me/gift_itunes_top_content");
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int j = paramArrayOfString.length;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfString[i].toUpperCase());
        i++;
      }
      a("media_types", localJSONArray.toString());
      label67: a("limit", Integer.toString(paramInt));
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.iTunesContentApiMethod
 * JD-Core Version:    0.6.0
 */
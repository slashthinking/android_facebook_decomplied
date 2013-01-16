package com.facebook.katana.model;

import com.facebook.common.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookPhotoWithTag extends FacebookPhotoTagBase
{
  public final long a;

  public FacebookPhotoWithTag(long paramLong)
  {
    this.a = paramLong;
  }

  public JSONObject i()
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject().put("tag_uid", Long.toString(this.a));
      localJSONObject1 = localJSONObject2;
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        Log.a("", "inconceivable JSON exception", localJSONException);
        JSONObject localJSONObject1 = null;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPhotoWithTag
 * JD-Core Version:    0.6.0
 */
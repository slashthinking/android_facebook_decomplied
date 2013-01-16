package com.facebook.katana.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class FacebookPhotoTagBase
{
  public static String a(List<? extends FacebookPhotoTagBase> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FacebookPhotoTagBase localFacebookPhotoTagBase = (FacebookPhotoTagBase)localIterator.next();
      if (localFacebookPhotoTagBase.i() == null)
        continue;
      localJSONArray.put(localFacebookPhotoTagBase.i());
    }
    return localJSONArray.toString();
  }

  public abstract JSONObject i();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPhotoTagBase
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.katana.Constants.URL;
import java.util.HashMap;
import java.util.Map;

public class GraphFeedPublish$GraphFeedLocationMethod extends GraphApiMethod
{
  public GraphFeedPublish$GraphFeedLocationMethod(Context paramContext, GraphFeedPublish.ImplicitLocation paramImplicitLocation)
  {
    super(paramContext, "POST", "me/settings", Constants.URL.d(paramContext));
    HashMap localHashMap = new HashMap();
    localHashMap.put("project", "structured_composer");
    localHashMap.put("setting", "composer_share_location");
    localHashMap.put("value", Integer.toString(paramImplicitLocation.getCode()));
    this.e.putAll(localHashMap);
  }

  public int i()
  {
    return Integer.valueOf((String)this.e.get("value")).intValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphFeedPublish.GraphFeedLocationMethod
 * JD-Core Version:    0.6.0
 */
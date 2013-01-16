package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.util.StringUtils;
import java.util.Map;
import java.util.Set;

public class GraphFeedPublish$GraphFeedPublishMethod extends GraphApiMethod
{
  private Set<Long> a;

  public GraphFeedPublish$GraphFeedPublishMethod(Context paramContext, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, Set<Long> paramSet, String paramString4, String paramString5)
  {
    super(paramContext, "POST", paramString1, Constants.URL.d(paramContext));
    if (paramString5 != null)
      this.e.put("link", paramString5);
    this.e.put("message", paramString2);
    if (paramLong2 == paramLong1)
    {
      if (!StringUtils.c(paramString4))
        this.e.put("privacy", paramString4);
    }
    else
    {
      if (!StringUtils.c(paramString3))
        this.e.put("place", paramString3);
      if ((paramSet != null) && (paramSet.size() > 0))
      {
        this.a = paramSet;
        this.e.put("tags", StreamPublish.a(paramSet));
      }
      return;
    }
    throw new RuntimeException("Privacy not set when publishing status to wall");
  }

  public String i()
  {
    if (this.e.containsKey("place"));
    for (String str = (String)this.e.get("place"); ; str = null)
      return str;
  }

  public Set<Long> j()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphFeedPublish.GraphFeedPublishMethod
 * JD-Core Version:    0.6.0
 */
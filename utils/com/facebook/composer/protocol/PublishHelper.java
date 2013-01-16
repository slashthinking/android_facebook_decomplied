package com.facebook.composer.protocol;

import com.facebook.orca.common.util.StringUtil;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class PublishHelper
{
  private static String a(Set<Long> paramSet)
  {
    return "[" + Joiner.on(',').skipNulls().join(paramSet) + "]";
  }

  public static List<NameValuePair> a(PublishPostParams paramPublishPostParams)
  {
    if (paramPublishPostParams.b > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      ArrayList localArrayList = Lists.a();
      if (paramPublishPostParams.b == paramPublishPostParams.j)
      {
        Preconditions.checkNotNull(paramPublishPostParams.h);
        localArrayList.add(new BasicNameValuePair("privacy", paramPublishPostParams.h));
      }
      if (!StringUtil.a(paramPublishPostParams.i))
        localArrayList.add(new BasicNameValuePair("link", paramPublishPostParams.i));
      if (!StringUtil.a(paramPublishPostParams.c))
        localArrayList.add(new BasicNameValuePair("message", paramPublishPostParams.c));
      if (!StringUtil.a(paramPublishPostParams.d))
        localArrayList.add(new BasicNameValuePair("place", paramPublishPostParams.d));
      if (!StringUtil.a(paramPublishPostParams.m))
        localArrayList.add(new BasicNameValuePair("nectar_module", paramPublishPostParams.m));
      if ((paramPublishPostParams.g != null) && (paramPublishPostParams.g.size() > 0))
        localArrayList.add(new BasicNameValuePair("tags", a(paramPublishPostParams.g)));
      localArrayList.add(new BasicNameValuePair("format", "json"));
      return localArrayList;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishHelper
 * JD-Core Version:    0.6.2
 */
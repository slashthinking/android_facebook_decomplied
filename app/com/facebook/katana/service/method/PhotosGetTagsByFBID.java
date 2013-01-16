package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.StringUtils.StringProcessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhotosGetTagsByFBID extends FqlQuery
  implements ApiMethodCallback
{
  private static final String[] a = { "pid", "subject", "text", "xcoord", "ycoord", "created", "object_id" };
  private static StringUtils.StringProcessor g = new PhotosGetTagsByFBID.1();
  private final List<Long> b;
  private Map<Long, List<FacebookPhotoTag>> f = new HashMap();

  private PhotosGetTagsByFBID(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, List<Long> paramList)
  {
    super(paramContext, paramIntent, paramString, a(paramList), paramServiceOperationListener);
    this.b = paramList;
  }

  public static String a(Context paramContext, long paramLong)
  {
    Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(paramLong);
    return a(paramContext, Arrays.asList(arrayOfLong));
  }

  public static String a(Context paramContext, List<Long> paramList)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new PhotosGetTagsByFBID(paramContext, null, localAppSession.b().sessionKey, null, paramList), 1001, 1020, null);
    }
  }

  private static String a(List<Long> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SELECT ");
    StringUtils.a(localStringBuilder, ",", g, (Object[])a);
    localStringBuilder.append(" FROM photo_tag WHERE ").append("pid IN (SELECT pid FROM photo WHERE object_id IN (");
    StringUtils.a(localStringBuilder, ",", g, paramList.toArray());
    localStringBuilder.append("))");
    return localStringBuilder.toString();
  }

  public static List<FacebookPhotoTag> b(JsonParser paramJsonParser)
  {
    ArrayList localArrayList = new ArrayList();
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
      throw new FacebookApiException(paramJsonParser);
    if (localJsonToken == JsonToken.START_ARRAY)
      while (localJsonToken != JsonToken.END_ARRAY)
      {
        if (localJsonToken == JsonToken.START_OBJECT)
          localArrayList.add(new FacebookPhotoTag(paramJsonParser));
        localJsonToken = FbJsonChecker.a(paramJsonParser);
      }
    throw new IOException("Malformed JSON");
    return localArrayList;
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.b, this.f);
  }

  protected void a(JsonParser paramJsonParser)
  {
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      long l = ((Long)localIterator1.next()).longValue();
      this.f.put(Long.valueOf(l), new ArrayList());
    }
    Iterator localIterator2 = b(paramJsonParser).iterator();
    while (localIterator2.hasNext())
    {
      FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)localIterator2.next();
      if ((localFacebookPhotoTag.c() <= 0.0D) && (localFacebookPhotoTag.d() <= 0.0D))
        continue;
      ((List)this.f.get(Long.valueOf(localFacebookPhotoTag.g()))).add(localFacebookPhotoTag);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosGetTagsByFBID
 * JD-Core Version:    0.6.0
 */
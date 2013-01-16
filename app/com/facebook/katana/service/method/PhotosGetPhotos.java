package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.Factory;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PhotosGetPhotos extends FqlQuery
  implements ApiMethodCallback
{
  private static ArrayList<FacebookPhoto> a;
  private static String b;
  private final String f;
  private final long g;
  private final List<FacebookPhoto> h;
  private final boolean i;

  public PhotosGetPhotos(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, c(paramString2), paramServiceOperationListener);
    this.h = new ArrayList();
    this.i = true;
    this.f = null;
    this.g = -1L;
  }

  public PhotosGetPhotos(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2, String paramString3)
  {
    super(paramContext, paramIntent, paramString1, a(paramString2, paramString3), paramServiceOperationListener);
    this.h = new ArrayList();
    this.i = true;
    this.f = null;
    this.g = -1L;
  }

  public PhotosGetPhotos(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Collection<Long> paramCollection)
  {
    super(paramContext, paramIntent, paramString, a(paramCollection), paramServiceOperationListener);
    this.h = new ArrayList();
    this.i = true;
    this.f = null;
    this.g = -1L;
  }

  public PhotosGetPhotos(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String[] paramArrayOfString, long paramLong, int paramInt1, int paramInt2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString1, a(paramString2, paramArrayOfString, paramLong, paramInt1, paramInt2), paramServiceOperationListener);
    this.f = paramString2;
    this.g = paramLong;
    this.h = new ArrayList();
    if (paramInt2 < 0);
    for (boolean bool = true; ; bool = false)
    {
      this.i = bool;
      if ((paramInt1 == 0) && (this.f != null))
      {
        a = new ArrayList();
        b = this.f;
      }
      return;
    }
  }

  public static String a(Context paramContext, Collection<Long> paramCollection)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession != null)
    {
      FacebookSessionInfo localFacebookSessionInfo = localAppSession.b();
      str = null;
      if (localFacebookSessionInfo != null)
        break label27;
    }
    while (true)
    {
      return str;
      label27: str = localAppSession.a(paramContext, new PhotosGetPhotos(paramContext, null, localAppSession.b().sessionKey, null, paramCollection), 1001, 1020, null);
    }
  }

  private static String a(String paramString1, String paramString2)
  {
    return c(a(paramString1, paramString2, null, null, -1, -1));
  }

  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT ").append(paramString2).append(" FROM ").append(paramString1);
    if (paramString3 != null)
      localStringBuilder.append(" WHERE ").append(paramString3);
    if (paramString4 != null)
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    if (paramInt1 >= 0)
      if (paramInt2 >= 0)
        localStringBuilder.append(" LIMIT ").append(paramInt1).append(",").append(paramInt2);
    while (true)
    {
      return localStringBuilder.toString();
      if (paramInt2 < 0)
        continue;
      localStringBuilder.append(" LIMIT ").append(paramInt2);
    }
  }

  private static String a(String paramString, String[] paramArrayOfString, long paramLong, int paramInt1, int paramInt2)
  {
    String str1;
    if (paramArrayOfString != null)
    {
      str1 = "SELECT pid,aid,owner,src_small,src_big,src,caption,created,position,object_id,can_tag FROM photo WHERE " + "pid IN(" + a(paramArrayOfString) + ")";
      if ((-1L != paramLong) && (!FqlGetTaggedUserAlbum.a(paramString, paramLong)))
        str1 = str1 + " AND owner = " + paramLong;
      if (paramArrayOfString != null)
        str1 = str1 + " ORDER BY position ASC";
      if (paramInt2 < 0)
        break label185;
    }
    label185: for (String str2 = str1 + " LIMIT " + paramInt1 + "," + paramInt2; ; str2 = str1 + " LIMIT " + paramInt1 + "," + 1000000)
    {
      return str2;
      str1 = "SELECT pid,aid,owner,src_small,src_big,src,caption,created,position,object_id,can_tag FROM photo WHERE " + "aid='" + paramString + "'";
      break;
    }
  }

  private static String a(Collection<Long> paramCollection)
  {
    return "SELECT " + "pid,aid,owner,src_small,src_big,src,caption,created,position,object_id,can_tag" + " FROM photo WHERE" + " object_id IN (" + StringUtils.a(",", new Object[] { paramCollection }) + ")";
  }

  private static String a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      localStringBuilder = new StringBuilder();
      StringUtils.a(localStringBuilder, ",", StringUtils.b, (Object[])paramArrayOfString);
    }
    for (String str = localStringBuilder.toString(); ; str = null)
      return str;
  }

  private static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT ").append("pid,aid,owner,src_small,src_big,src,caption,created,position,object_id,can_tag").append(" FROM photo WHERE ").append("pid IN (").append(paramString).append(") ORDER BY modified DESC");
    return localStringBuilder.toString();
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).c(paramAppSession, paramString1, paramInt, paramString2, paramException, this.h);
  }

  protected void a(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    this.q.a_(paramServiceOperation, paramInt, paramString, paramException);
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    int k;
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      FacebookApiException localFacebookApiException = new FacebookApiException(paramJsonParser);
      if (localFacebookApiException.a() != -1)
        throw localFacebookApiException;
    }
    else
    {
      if (localJsonToken != JsonToken.START_ARRAY)
        break label283;
      while (localJsonToken != JsonToken.END_ARRAY)
      {
        if (localJsonToken == JsonToken.START_OBJECT)
          this.h.add(FacebookPhoto.a(paramJsonParser));
        localJsonToken = FbJsonChecker.a(paramJsonParser);
      }
      if ((this.f != null) && (this.f.equals(b)))
        a.addAll(this.h);
      int j;
      if (this.f != null)
      {
        j = 1;
        if ((j == 0) || (!this.i))
          break label203;
      }
      label203: for (k = 1; ; k = 0)
      {
        if (j == 0)
          break label267;
        String str = FqlGetTaggedUserAlbum.a(this.g);
        if (!FqlGetTaggedUserAlbum.a(this.f, this.g))
          break label209;
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext())
          ((FacebookPhoto)localIterator.next()).a(str);
        j = 0;
        break;
      }
    }
    label209: for (Factory localFactory = PhotoSyncModel.b(this.o, this.f); ; localFactory = PhotoSyncModel.b(this.o, this.h))
    {
      PhotoSyncModel.a(this.o, this.h, localFactory, true, true, false, this.f);
      if (k != 0)
        PhotoSyncModel.a(this.o, a, localFactory, true, true, true, this.f);
      return;
    }
    label267: label283: throw new IOException("Malformed JSON");
  }

  public List<FacebookPhoto> g()
  {
    return this.h;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosGetPhotos
 * JD-Core Version:    0.6.0
 */
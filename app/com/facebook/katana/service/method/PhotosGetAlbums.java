package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookApiException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhotosGetAlbums extends FqlQuery
{
  private final List<FacebookAlbum> a = new ArrayList();

  public PhotosGetAlbums(Context paramContext, Intent paramIntent, String paramString1, long paramLong1, String paramString2, ServiceOperationListener paramServiceOperationListener, long paramLong2, long paramLong3)
  {
    super(paramContext, paramIntent, paramString1, a(paramLong1, paramString2, paramLong2, paramLong3), paramServiceOperationListener);
  }

  private static String a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    String str1;
    String str2;
    if (paramString != null)
    {
      str1 = "SELECT aid,owner,cover_pid,name,created,modified,description,location,size,link,visible,type,object_id FROM album WHERE " + "aid IN(" + paramString + ")";
      str2 = str1 + " ORDER BY created DESC";
      if (paramLong3 <= 0L)
        break label132;
    }
    label132: for (String str3 = str2 + " LIMIT " + paramLong2 + "," + paramLong3; ; str3 = str2 + " LIMIT " + paramLong2 + "," + 1000000L)
    {
      return str3;
      str1 = "SELECT aid,owner,cover_pid,name,created,modified,description,location,size,link,visible,type,object_id FROM album WHERE " + "owner=" + paramLong1;
      break;
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      FacebookApiException localFacebookApiException = new FacebookApiException(paramJsonParser);
      if (localFacebookApiException.a() != -1)
        throw localFacebookApiException;
    }
    else
    {
      if (localJsonToken == JsonToken.START_ARRAY)
        while (localJsonToken != JsonToken.END_ARRAY)
        {
          if (localJsonToken == JsonToken.START_OBJECT)
            this.a.add(new FacebookAlbum(paramJsonParser));
          localJsonToken = FbJsonChecker.a(paramJsonParser);
        }
      throw new IOException("Malformed JSON");
    }
  }

  public List<FacebookAlbum> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosGetAlbums
 * JD-Core Version:    0.6.0
 */
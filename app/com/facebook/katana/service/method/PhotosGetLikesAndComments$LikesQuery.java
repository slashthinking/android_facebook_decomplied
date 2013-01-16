package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class PhotosGetLikesAndComments$LikesQuery extends FqlQuery
{
  private Set<Long> a = new HashSet();

  public PhotosGetLikesAndComments$LikesQuery(Context paramContext, Intent paramIntent, String paramString, long paramLong, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, a(paramLong), paramServiceOperationListener);
  }

  private static String a(long paramLong)
  {
    return "SELECT user_id FROM like WHERE " + "object_id = " + paramLong;
  }

  protected void a(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() != JsonToken.START_ARRAY)
      throw new IOException("Unexpected JSON response");
    for (JsonToken localJsonToken = FbJsonChecker.a(paramJsonParser); localJsonToken != JsonToken.END_ARRAY; localJsonToken = FbJsonChecker.a(paramJsonParser))
    {
      if ((localJsonToken != JsonToken.FIELD_NAME) || (!FbJsonChecker.a(paramJsonParser).isNumeric()))
        continue;
      this.a.add(Long.valueOf(paramJsonParser.getLongValue()));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosGetLikesAndComments.LikesQuery
 * JD-Core Version:    0.6.0
 */
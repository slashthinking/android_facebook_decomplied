package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

class PhotosGetLikesAndComments$CommentsQuery extends FqlQuery
{
  private int a;

  public PhotosGetLikesAndComments$CommentsQuery(Context paramContext, Intent paramIntent, String paramString, long paramLong, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, a(paramLong), paramServiceOperationListener);
  }

  private static String a(long paramLong)
  {
    return "SELECT id FROM comment WHERE " + "object_id = " + paramLong;
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = 0;
    if (paramJsonParser.getCurrentToken() != JsonToken.START_ARRAY)
      throw new IOException("Unexpected JSON response");
    for (JsonToken localJsonToken = FbJsonChecker.a(paramJsonParser); localJsonToken != JsonToken.END_ARRAY; localJsonToken = FbJsonChecker.a(paramJsonParser))
    {
      if (localJsonToken != JsonToken.START_OBJECT)
        continue;
      this.a = (1 + this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosGetLikesAndComments.CommentsQuery
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public class FqlGetUsersFriendStatus extends FqlQuery
{
  private long b;
  private long f;
  private boolean g;

  static
  {
    if (!FqlGetUsersFriendStatus.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      return;
    }
  }

  public FqlGetUsersFriendStatus(Context paramContext, Intent paramIntent, String paramString, long paramLong1, long paramLong2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, "SELECT uid1, uid2 FROM friend WHERE uid1=" + paramLong1 + " AND uid2=" + paramLong2, paramServiceOperationListener);
    this.b = paramLong1;
    this.f = paramLong2;
  }

  protected void a(JsonParser paramJsonParser)
  {
    Long localLong1 = null;
    if (paramJsonParser.getCurrentToken() != JsonToken.START_ARRAY)
      throw new IOException("Unexpected JSON response");
    JsonToken localJsonToken1 = FbJsonChecker.a(paramJsonParser);
    Long localLong2;
    if (localJsonToken1 == JsonToken.END_ARRAY)
    {
      localLong2 = null;
      paramJsonParser.nextToken();
      if ((localLong2 == null) || (localLong1 == null) || (localLong2.longValue() != this.b) || (localLong1.longValue() != this.f))
        break label252;
    }
    label162: label252: for (this.g = true; ; this.g = false)
    {
      return;
      if ((!a) && (localJsonToken1 != JsonToken.START_OBJECT))
        throw new AssertionError();
      JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser);
      localLong2 = null;
      if (localJsonToken2 != JsonToken.END_OBJECT)
      {
        String str;
        if (localJsonToken2 == JsonToken.VALUE_STRING)
        {
          str = paramJsonParser.getCurrentName();
          if (!str.equals("uid1"))
            break label162;
          localLong2 = Long.valueOf(paramJsonParser.getText());
        }
        while (true)
        {
          localJsonToken2 = FbJsonChecker.a(paramJsonParser);
          break;
          if (!str.equals("uid2"))
            continue;
          localLong1 = Long.valueOf(paramJsonParser.getText());
        }
      }
      do
      {
        do
        {
          localJsonToken2 = FbJsonChecker.a(paramJsonParser);
          if (localJsonToken2 == JsonToken.END_ARRAY)
            break;
        }
        while ((localJsonToken2 != JsonToken.START_ARRAY) && (localJsonToken2 != JsonToken.START_OBJECT));
        paramJsonParser.skipChildren();
      }
      while ((a) || (paramJsonParser.getCurrentToken() == JsonToken.END_ARRAY) || (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT));
      throw new AssertionError();
    }
  }

  public boolean g()
  {
    return this.g;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetUsersFriendStatus
 * JD-Core Version:    0.6.0
 */
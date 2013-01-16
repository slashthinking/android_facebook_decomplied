package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.Map;

public class FriendRequestRespond extends ApiMethod
{
  private long a;
  private boolean b;

  public FriendRequestRespond(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong, boolean paramBoolean)
  {
    super(paramContext, paramIntent, "POST", "facebook.friends.confirm", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("session_key", paramString);
    this.e.put("uid", Long.toString(paramLong));
    Map localMap = this.e;
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      localMap.put("confirm", str);
      this.a = paramLong;
      this.b = false;
      return;
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_TRUE)
      this.b = true;
  }

  public long g()
  {
    return this.a;
  }

  public boolean h()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FriendRequestRespond
 * JD-Core Version:    0.6.0
 */
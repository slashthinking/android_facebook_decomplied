package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.model.FacebookProfile;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FqlGetProfileGeneric<T extends FacebookProfile> extends FqlGeneratedQuery
{
  protected final Map<Long, T> a = new HashMap();
  protected final Class<? extends T> b;

  FqlGetProfileGeneric(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2, Class<? extends T> paramClass)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "profile", paramString2, paramClass);
    this.b = paramClass;
  }

  protected void a(JsonParser paramJsonParser)
  {
    Iterator localIterator = JMParser.b(paramJsonParser, this.b).iterator();
    while (localIterator.hasNext())
    {
      FacebookProfile localFacebookProfile = (FacebookProfile)localIterator.next();
      this.a.put(Long.valueOf(localFacebookProfile.mId), localFacebookProfile);
    }
  }

  protected Map<Long, T> g()
  {
    return Collections.unmodifiableMap(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetProfileGeneric
 * JD-Core Version:    0.6.0
 */
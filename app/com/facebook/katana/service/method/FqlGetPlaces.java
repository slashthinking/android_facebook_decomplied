package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class FqlGetPlaces extends FqlGeneratedQuery
{
  private static final Class<?> a = FqlGetPlaces.class;
  private Map<Long, FacebookPlace> b;

  public FqlGetPlaces(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "place", paramString2, FacebookPlace.class);
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookPlace.class);
    this.b = new LinkedHashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FacebookPlace localFacebookPlace = (FacebookPlace)localIterator.next();
      this.b.put(Long.valueOf(localFacebookPlace.mPageId), localFacebookPlace);
    }
  }

  public Map<Long, FacebookPlace> g()
  {
    return Collections.unmodifiableMap(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetPlaces
 * JD-Core Version:    0.6.0
 */
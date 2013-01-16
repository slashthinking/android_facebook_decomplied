package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FqlGetUsersProfile extends FqlGeneratedQuery
{
  private static final Class<?> a = FqlGetUsersProfile.class;
  private final Object b;
  private final Map<Long, FacebookUser> f;
  private final Class<? extends FacebookUser> g;
  private final boolean h;

  public FqlGetUsersProfile(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2, Class<? extends FacebookUser> paramClass)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "user", paramString2, paramClass);
    this.f = new LinkedHashMap();
    this.b = null;
    this.g = paramClass;
    this.h = false;
  }

  public FqlGetUsersProfile(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Map<Long, FacebookUser> paramMap, Class<? extends FacebookUser> paramClass)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "user", a(paramMap), paramClass);
    this.f = paramMap;
    this.b = null;
    this.g = paramClass;
    this.h = true;
  }

  public FqlGetUsersProfile(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Map<Long, FacebookUser> paramMap, Object paramObject)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "user", a(paramMap), FacebookUser.class);
    this.f = paramMap;
    this.b = paramObject;
    this.g = FacebookUser.class;
    this.h = true;
  }

  private static String a(Map<Long, FacebookUser> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder("uid IN(");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramMap.keySet();
    StringUtils.a(localStringBuilder, ",", null, arrayOfObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, this.g);
    if (localList != null)
    {
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        FacebookUser localFacebookUser2 = (FacebookUser)localIterator2.next();
        this.f.put(Long.valueOf(localFacebookUser2.mUserId), localFacebookUser2);
      }
    }
    if (this.h)
    {
      Iterator localIterator1 = this.f.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        if (localEntry.getValue() != null)
          continue;
        FacebookUser localFacebookUser1 = FacebookUser.a(this.g, this.o.getString(2131362934));
        this.f.put(localEntry.getKey(), localFacebookUser1);
      }
    }
  }

  public Map<Long, FacebookUser> g()
  {
    return this.f;
  }

  public Object h()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetUsersProfile
 * JD-Core Version:    0.6.0
 */
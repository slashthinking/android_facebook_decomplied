package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMDictDestination;
import com.facebook.katana.util.FqlQueryBuilderUtils;
import java.util.Set;

public abstract class FqlGeneratedQuery extends FqlQuery
{
  public FqlGeneratedQuery(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2, String paramString3, Class<? extends JMDictDestination> paramClass)
  {
    this(paramContext, paramIntent, paramString1, paramServiceOperationListener, paramString2, paramString3, a(paramClass));
  }

  public FqlGeneratedQuery(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2, String paramString3, Set<String> paramSet)
  {
    super(paramContext, paramIntent, paramString1, a(paramString2, paramString3, paramSet), paramServiceOperationListener);
  }

  protected static String a(String paramString1, String paramString2, Set<String> paramSet)
  {
    return new FqlQueryBuilderUtils().a(paramString1, paramString2, paramSet);
  }

  protected static Set<String> a(Class<? extends JMDictDestination> paramClass)
  {
    return new FqlQueryBuilderUtils().a(paramClass);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGeneratedQuery
 * JD-Core Version:    0.6.0
 */
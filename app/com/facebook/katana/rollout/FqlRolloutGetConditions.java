package com.facebook.katana.rollout;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.method.ApiMethodCallback;
import com.facebook.katana.service.method.FqlGeneratedQuery;
import com.facebook.katana.service.method.ServiceOperationListener;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FqlRolloutGetConditions extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  protected NetworkRequestCallback<String, String> a;
  protected Map<String, String> b = new HashMap();

  public FqlRolloutGetConditions(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Set<String> paramSet, NetworkRequestCallback<String, String> paramNetworkRequestCallback)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "rollout", a(paramSet), FqlRolloutGetConditions.RolloutExperiment.class);
    this.a = paramNetworkRequestCallback;
  }

  public static String a(Context paramContext, Set<String> paramSet, NetworkRequestCallback<String, String> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new FqlRolloutGetConditions(paramContext, null, localAppSession.b().sessionKey, null, paramSet, paramNetworkRequestCallback), 1001, 1020, null);
    }
  }

  protected static String a(Set<String> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("experiment IN(");
    StringUtils.a(localStringBuilder, ",", StringUtils.a, new Object[] { paramSet });
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      String str2 = (String)localEntry.getValue();
      if ((paramInt == 200) && (str1 != null));
      for (boolean bool = true; ; bool = false)
      {
        this.a.a(paramContext, bool, str1, str2, str2);
        break;
      }
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FqlRolloutGetConditions.RolloutExperiment.class);
    if (localList == null);
    while (true)
    {
      return;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FqlRolloutGetConditions.RolloutExperiment localRolloutExperiment = (FqlRolloutGetConditions.RolloutExperiment)localIterator.next();
        this.b.put(localRolloutExperiment.mExperimentName, localRolloutExperiment.mCondition);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.rollout.FqlRolloutGetConditions
 * JD-Core Version:    0.6.0
 */
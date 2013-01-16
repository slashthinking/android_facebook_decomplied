package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.model.FacebookGroup;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;

class FqlGetGroups$Info extends FqlGeneratedQuery
{
  List<FacebookGroup> a;

  protected FqlGetGroups$Info(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "group", c(paramString2), FacebookGroup.class);
  }

  protected static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gid IN (SELECT gid FROM ").append(paramString).append(") AND version>0 ORDER BY update_time DESC");
    return localStringBuilder.toString();
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = JMParser.b(paramJsonParser, FacebookGroup.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetGroups.Info
 * JD-Core Version:    0.6.0
 */
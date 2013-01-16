package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.ipc.model.PrivacySetting.Category;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;

class AudienceSettings$FqlGetPrivacySetting extends FqlGeneratedQuery
{
  PrivacySetting a;

  protected AudienceSettings$FqlGetPrivacySetting(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, PrivacySetting.Category paramCategory)
  {
    this(paramContext, paramIntent, paramString, paramServiceOperationListener, a(paramCategory));
  }

  protected AudienceSettings$FqlGetPrivacySetting(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "privacy_setting", paramString2, PrivacySetting.class);
  }

  protected static String a(PrivacySetting.Category paramCategory)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    StringUtils.a(localStringBuilder, paramCategory.toString());
    return localStringBuilder.toString();
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, PrivacySetting.class);
    if (!localList.isEmpty())
      this.a = ((PrivacySetting)localList.get(0));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AudienceSettings.FqlGetPrivacySetting
 * JD-Core Version:    0.6.0
 */
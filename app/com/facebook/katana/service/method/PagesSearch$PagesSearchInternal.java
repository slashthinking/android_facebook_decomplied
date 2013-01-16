package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.katana.model.FacebookPage;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;

class PagesSearch$PagesSearchInternal extends FqlGetPages
{
  public PagesSearch$PagesSearchInternal(Context paramContext, Intent paramIntent, ServiceOperationListener paramServiceOperationListener, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, a(paramString2, paramInt1, paramInt2), FacebookPage.class);
  }

  private static String a(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("contains(");
    StringUtils.a(localStringBuilder, paramString);
    localStringBuilder.append(") ").append(" AND is_community_page!='true' ").append("LIMIT ").append(paramInt1).append(",").append(paramInt2);
    return localStringBuilder.toString();
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PagesSearch.PagesSearchInternal
 * JD-Core Version:    0.6.0
 */
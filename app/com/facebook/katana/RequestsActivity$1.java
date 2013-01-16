package com.facebook.katana;

import com.facebook.common.util.Toaster;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import java.util.Map;

class RequestsActivity$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, Map<Long, FacebookUser> paramMap)
  {
    if (paramMap == null)
      Toaster.a(this.a, 2131363135);
    while (true)
    {
      paramAppSession.b(this);
      return;
      RequestsActivity.a(this.a);
      RequestsActivity.a(this.a, paramMap);
      if (paramMap.size() != 0)
        continue;
      RequestsActivity.b(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RequestsActivity.1
 * JD-Core Version:    0.6.0
 */
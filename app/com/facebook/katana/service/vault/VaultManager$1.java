package com.facebook.katana.service.vault;

import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;

class VaultManager$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, boolean paramBoolean)
  {
    if ((paramInt == 200) && ("vault".equals(paramString3)))
    {
      Log.e(VaultManager.h(), "vault GK fetched with value: " + paramBoolean);
      if (paramBoolean)
        this.a.b();
      paramAppSession.b(VaultManager.a(this.a));
      VaultManager.a(this.a, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultManager.1
 * JD-Core Version:    0.6.0
 */
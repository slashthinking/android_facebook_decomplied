package com.facebook.katana.service.vault;

import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.service.vault.methods.VaultBlacklistedSyncPathsGet.Callback;
import com.facebook.orca.common.util.StringUtil;
import java.util.List;

class VaultManager$2 extends VaultBlacklistedSyncPathsGet.Callback
{
  public void a(int paramInt)
  {
    Log.e(VaultManager.h(), "Error fetching blacklisted sync paths: " + paramInt);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    ErrorReporting.a("Error fetching blacklisted sync paths", StringUtil.a("Error fetching blacklisted sync paths: %d", arrayOfObject), true);
    VaultManager.b(this.a);
  }

  public void a(List<String> paramList)
  {
    VaultManager.b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultManager.2
 * JD-Core Version:    0.6.0
 */
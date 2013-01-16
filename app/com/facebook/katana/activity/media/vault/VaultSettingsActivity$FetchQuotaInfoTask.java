package com.facebook.katana.activity.media.vault;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.katana.service.vault.methods.VaultQuotaGetMethod;
import com.facebook.katana.service.vault.methods.VaultQuotaGetResult;
import com.facebook.katana.util.Utils;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class VaultSettingsActivity$FetchQuotaInfoTask extends AsyncTask<Void, Void, VaultQuotaGetResult>
{
  Activity a;

  public VaultSettingsActivity$FetchQuotaInfoTask(VaultSettingsActivity paramVaultSettingsActivity)
  {
    this.a = paramVaultSettingsActivity;
  }

  protected VaultQuotaGetResult a(Void[] paramArrayOfVoid)
  {
    FbInjector localFbInjector = FbInjector.a(this.a);
    VaultQuotaGetMethod localVaultQuotaGetMethod = (VaultQuotaGetMethod)localFbInjector.a(VaultQuotaGetMethod.class);
    SingleMethodRunner localSingleMethodRunner = (SingleMethodRunner)localFbInjector.a(SingleMethodRunner.class);
    try
    {
      localVaultQuotaGetResult = (VaultQuotaGetResult)localSingleMethodRunner.a(localVaultQuotaGetMethod, null);
      return localVaultQuotaGetResult;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a("failed to retrieve quota information: " + localException);
        VaultQuotaGetResult localVaultQuotaGetResult = null;
      }
    }
  }

  protected void a(VaultQuotaGetResult paramVaultQuotaGetResult)
  {
    TextView localTextView1 = (TextView)this.a.findViewById(2131297976);
    TextView localTextView2 = (TextView)this.a.findViewById(2131297977);
    if (paramVaultQuotaGetResult == null)
    {
      localTextView1.setText(this.a.getString(2131363597));
      localTextView2.setText(this.a.getString(2131363597));
    }
    while (true)
    {
      return;
      String str1 = Utils.a(paramVaultQuotaGetResult.b(), this.a);
      int i = Math.round((float)(100L * paramVaultQuotaGetResult.a() / paramVaultQuotaGetResult.b()));
      Activity localActivity = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
      String str2 = localActivity.getString(2131363596, arrayOfObject);
      localTextView1.setText(str1);
      localTextView2.setText(str2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSettingsActivity.FetchQuotaInfoTask
 * JD-Core Version:    0.6.0
 */
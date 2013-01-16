package com.facebook.katana.activity.media.vault;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.binding.UploadManagerConnectivity;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.vault.VaultHelpers;
import com.facebook.orca.inject.FbInjector;

public class VaultSyncScreenErrorBar extends LinearLayout
{
  private Context a;
  private ImageView b;
  private TextView c;
  private VaultSyncScreenErrorBar.State d;

  public VaultSyncScreenErrorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.d = VaultSyncScreenErrorBar.State.INVISIBLE;
  }

  private void c()
  {
    switch (VaultSyncScreenErrorBar.1.a[this.d.ordinal()])
    {
    default:
      setVisibility(8);
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      this.b.setImageResource(2130839022);
      this.c.setText(this.a.getString(2131363606));
      setVisibility(0);
      continue;
      this.b.setImageResource(2130839033);
      this.c.setText(this.a.getString(2131363605));
      setVisibility(0);
      continue;
      this.b.setImageResource(2130838186);
      this.c.setText(this.a.getString(2131363604));
      setVisibility(0);
      continue;
      this.b.setImageResource(2130839016);
      this.c.setText(this.a.getString(2131363607));
      setVisibility(0);
    }
  }

  public void a()
  {
    switch (VaultSyncScreenErrorBar.1.a[this.d.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      ((SecureContextHelper)FbInjector.a(this.a).a(SecureContextHelper.class)).a(new Intent(this.a, VaultSettingsActivity.class), this.a);
    }
  }

  public void b()
  {
    String str = UserValuesManager.j(this.a);
    if ((str.equals("WIFI_ONLY")) && (!UploadManagerConnectivity.b(this.a)))
      this.d = VaultSyncScreenErrorBar.State.REQUIRES_WIFI;
    while (true)
    {
      c();
      return;
      if ((str.equals("MOBILE_RADIO")) && (!UploadManagerConnectivity.a(this.a)))
      {
        this.d = VaultSyncScreenErrorBar.State.NO_INTERNET;
        continue;
      }
      if (str.equals("OFF"))
      {
        this.d = VaultSyncScreenErrorBar.State.SYNC_IS_OFF;
        continue;
      }
      if (VaultHelpers.e(this.a))
      {
        this.d = VaultSyncScreenErrorBar.State.LOW_BATTERY;
        continue;
      }
      this.d = VaultSyncScreenErrorBar.State.INVISIBLE;
    }
  }

  protected void onFinishInflate()
  {
    this.b = ((ImageView)findViewById(2131297960));
    this.c = ((TextView)findViewById(2131297961));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenErrorBar
 * JD-Core Version:    0.6.0
 */
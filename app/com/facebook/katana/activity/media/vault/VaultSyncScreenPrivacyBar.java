package com.facebook.katana.activity.media.vault;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.katana.service.vault.VaultHelpers;
import com.facebook.katana.service.vault.VaultNotificationManager;
import com.facebook.orca.inject.FbInjector;

public class VaultSyncScreenPrivacyBar extends RelativeLayout
{
  private Context a;
  private VaultNotificationManager b;
  private ImageView c;
  private ImageView d;
  private Animation e;

  public VaultSyncScreenPrivacyBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.b = ((VaultNotificationManager)FbInjector.a(this.a).a(VaultNotificationManager.class));
  }

  public void a()
  {
    if (this.b.d().equals("end_vault_upload"))
      d();
    while (true)
    {
      return;
      c();
    }
  }

  public void b()
  {
    this.d.setVisibility(8);
    this.d.clearAnimation();
    this.c.setVisibility(8);
  }

  public void c()
  {
    if (VaultHelpers.a(this.a, 12))
    {
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.d.startAnimation(this.e);
    }
    while (true)
    {
      return;
      b();
    }
  }

  public void d()
  {
    if (VaultHelpers.a(this.a, 12))
    {
      this.d.setVisibility(8);
      this.d.clearAnimation();
      this.c.setVisibility(0);
    }
    while (true)
    {
      return;
      b();
    }
  }

  protected void onFinishInflate()
  {
    this.c = ((ImageView)findViewById(2131297957));
    this.c.setOnClickListener(new VaultSyncScreenPrivacyBar.1(this));
    this.d = ((ImageView)findViewById(2131297958));
    this.e = AnimationUtils.loadAnimation(this.a, 2130968627);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenPrivacyBar
 * JD-Core Version:    0.6.0
 */
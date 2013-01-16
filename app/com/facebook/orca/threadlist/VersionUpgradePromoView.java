package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.app.Product;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.appconfig.AppConfig;
import com.facebook.orca.appconfig.VersionChecker;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.MessengerPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Objects;

public class VersionUpgradePromoView extends CustomFrameLayout
{
  private VersionChecker a;
  private OrcaSharedPreferences b;
  private OrcaAppType c;
  private AppConfig d;
  private TextView e;
  private Button f;

  public VersionUpgradePromoView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public VersionUpgradePromoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public VersionUpgradePromoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a()
  {
    if ((this.d == null) || (this.d.b() == null) || (this.c.i() != Product.MESSENGER))
      setVisibility(8);
    while (true)
    {
      return;
      if (!Objects.equal(this.b.a(MessengerPrefKeys.w, null), this.d.b()))
      {
        if (this.a.a())
        {
          setVisibility(0);
          continue;
        }
        setVisibility(8);
        continue;
      }
    }
  }

  private void a(Context paramContext)
  {
    FbInjector localFbInjector = getInjector();
    this.a = ((VersionChecker)localFbInjector.a(VersionChecker.class));
    this.b = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.c = ((OrcaAppType)localFbInjector.a(OrcaAppType.class));
    setContentView(2130903435);
    this.e = ((TextView)b(2131297528));
    this.f = ((Button)b(2131297529));
    this.f.setOnClickListener(new VersionUpgradePromoView.1(this));
    setVisibility(8);
  }

  private void b()
  {
    if ((this.d != null) && (this.d.c() != null));
    for (Uri localUri = Uri.parse(this.d.c()); ; localUri = Uri.parse(this.c.g()))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
      getContext().startActivity(localIntent);
      return;
    }
  }

  public void setAppConfig(AppConfig paramAppConfig)
  {
    if (this.d != paramAppConfig)
    {
      this.d = paramAppConfig;
      a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.VersionUpgradePromoView
 * JD-Core Version:    0.6.0
 */
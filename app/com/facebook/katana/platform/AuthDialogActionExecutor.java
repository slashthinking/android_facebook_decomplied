package com.facebook.katana.platform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.orca.debug.BLog;
import java.util.List;

public class AuthDialogActionExecutor extends AbstractPlatformActionExecutor
  implements GDPDialog.GDPStatusCallback
{
  private static final Class<?> a = AuthDialogActionExecutor.class;
  private GDPDialog b;
  private final FragmentManager c;
  private final String d;
  private final String e;
  private final PlatformPackageUtilities f;
  private final List<String> g;
  private final String h;
  private AbstractPlatformActionExecutor.CompletionCallback i;

  public AuthDialogActionExecutor(FragmentManager paramFragmentManager, String paramString1, String paramString2, PlatformPackageUtilities paramPlatformPackageUtilities, List<String> paramList, String paramString3)
  {
    this.c = paramFragmentManager;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramPlatformPackageUtilities;
    this.g = paramList;
    this.h = paramString3;
  }

  private GDPDialog h(Bundle paramBundle)
  {
    BLog.b(a, "createOrRestoreDialog " + paramBundle);
    if (paramBundle != null);
    for (GDPDialog localGDPDialog = (GDPDialog)this.c.a(paramBundle, "ProxyAuthDialogFragment"); ; localGDPDialog = null)
    {
      String str1;
      if (localGDPDialog == null)
      {
        str1 = this.f.b(this.e);
        if (str1 == null)
        {
          i(AuthorizeAppResults.a("ProtocolError", "Application name could not be found"));
          localGDPDialog = null;
        }
      }
      while (true)
      {
        return localGDPDialog;
        String str2 = this.f.a(this.e);
        if (str2 == null)
        {
          i(AuthorizeAppResults.a("ProtocolError", "Application key hash could not be computed"));
          localGDPDialog = null;
          continue;
        }
        String str3 = this.h;
        localGDPDialog = GDPDialog.a(this.g, str3, this.d, str2, str1);
        localGDPDialog.a(0, 2131492970);
        localGDPDialog.a(this.c.a(), "ProxyAuthDialog", true);
        localGDPDialog.a(this);
      }
    }
  }

  private void i(Bundle paramBundle)
  {
    if (this.i != null)
      this.i.c(paramBundle);
  }

  public void D()
  {
    if (this.b != null)
      this.b.a(null);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public void a(Bundle paramBundle)
  {
    this.b = h(paramBundle);
  }

  public void a(AbstractPlatformActionExecutor.CompletionCallback paramCompletionCallback)
  {
    this.i = paramCompletionCallback;
  }

  public void c(Bundle paramBundle)
  {
    BLog.b(a, "finish success: " + paramBundle);
    this.b.a();
    if (this.i != null)
      this.i.b(paramBundle);
  }

  public void e(Bundle paramBundle)
  {
    if (this.b != null)
      this.c.a(paramBundle, "ProxyAuthDialogFragment", this.b);
  }

  public void g(Bundle paramBundle)
  {
    this.b.a();
    i(paramBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.AuthDialogActionExecutor
 * JD-Core Version:    0.6.0
 */
package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class DialogFragment extends NestedFragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  int a = 0;
  int b = 0;
  boolean c = true;
  boolean d = true;
  int e = -1;
  Dialog f;
  boolean g;
  boolean h;
  boolean i;

  public int a(FragmentTransaction paramFragmentTransaction, String paramString)
  {
    this.h = false;
    this.i = true;
    paramFragmentTransaction.a(this, paramString);
    this.g = false;
    this.e = paramFragmentTransaction.a();
    return this.e;
  }

  public int a(FragmentTransaction paramFragmentTransaction, String paramString, boolean paramBoolean)
  {
    this.h = false;
    this.i = true;
    paramFragmentTransaction.a(this, paramString);
    this.g = false;
    if (paramBoolean);
    for (int j = paramFragmentTransaction.b(); ; j = paramFragmentTransaction.a())
    {
      this.e = j;
      return this.e;
    }
  }

  public void a()
  {
    a(false);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    if ((this.a == 2) || (this.a == 3))
      this.b = 16973913;
    if (paramInt2 != 0)
      this.b = paramInt2;
  }

  public void a(Context paramContext)
  {
    super.a(paramContext);
    if (!this.i)
      this.h = false;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.G == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      if (paramBundle != null)
      {
        this.a = paramBundle.getInt("android:style", 0);
        this.b = paramBundle.getInt("android:theme", 0);
        this.c = paramBundle.getBoolean("android:cancelable", true);
        this.d = paramBundle.getBoolean("android:showsDialog", this.d);
        this.e = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }

  public void a(FragmentManager paramFragmentManager, String paramString)
  {
    this.h = false;
    this.i = true;
    FragmentTransaction localFragmentTransaction = paramFragmentManager.a();
    localFragmentTransaction.a(this, paramString);
    localFragmentTransaction.a();
  }

  void a(boolean paramBoolean)
  {
    if (this.h);
    while (true)
    {
      return;
      this.h = true;
      this.i = false;
      if (this.f != null)
      {
        this.f.dismiss();
        this.f = null;
      }
      this.g = true;
      if (this.e >= 0)
      {
        r().a(this.e, 1);
        this.e = -1;
        continue;
      }
      FragmentTransaction localFragmentTransaction = r().a();
      localFragmentTransaction.a(this);
      if (paramBoolean)
      {
        localFragmentTransaction.b();
        continue;
      }
      localFragmentTransaction.a();
    }
  }

  public LayoutInflater b(Bundle paramBundle)
  {
    LayoutInflater localLayoutInflater;
    if (!this.d)
      localLayoutInflater = super.b(paramBundle);
    while (true)
    {
      return localLayoutInflater;
      this.f = c(paramBundle);
      switch (this.a)
      {
      default:
      case 3:
      case 1:
      case 2:
      }
      while (true)
      {
        if (this.f == null)
          break label106;
        localLayoutInflater = (LayoutInflater)this.f.getContext().getSystemService("layout_inflater");
        break;
        this.f.getWindow().addFlags(24);
        this.f.requestWindowFeature(1);
      }
      label106: localLayoutInflater = (LayoutInflater)this.D.a().getSystemService("layout_inflater");
    }
  }

  public void b()
  {
    a(true);
  }

  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.f != null)
      this.f.setCancelable(paramBoolean);
  }

  public Dialog c()
  {
    return this.f;
  }

  public Dialog c(Bundle paramBundle)
  {
    return new Dialog(p(), d());
  }

  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public int d()
  {
    return this.b;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (!this.d);
    while (true)
    {
      return;
      View localView = A();
      if (localView != null)
      {
        if (localView.getParent() != null)
          throw new IllegalStateException("DialogFragment can not be attached to a container view");
        this.f.setContentView(localView);
      }
      this.f.setOwnerActivity((Activity)p());
      this.f.setCancelable(this.c);
      this.f.setOnCancelListener(this);
      this.f.setOnDismissListener(this);
      if (paramBundle == null)
        continue;
      Bundle localBundle = paramBundle.getBundle("android:savedDialogState");
      if (localBundle == null)
        continue;
      this.f.onRestoreInstanceState(localBundle);
    }
  }

  public void e()
  {
    super.e();
    if ((!this.i) && (!this.h))
      this.h = true;
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.f != null)
    {
      Bundle localBundle = this.f.onSaveInstanceState();
      if (localBundle != null)
        paramBundle.putBundle("android:savedDialogState", localBundle);
    }
    if (this.a != 0)
      paramBundle.putInt("android:style", this.a);
    if (this.b != 0)
      paramBundle.putInt("android:theme", this.b);
    if (!this.c)
      paramBundle.putBoolean("android:cancelable", this.c);
    if (!this.d)
      paramBundle.putBoolean("android:showsDialog", this.d);
    if (this.e != -1)
      paramBundle.putInt("android:backStackId", this.e);
  }

  public void f()
  {
    super.f();
    if (this.f != null)
    {
      this.g = false;
      this.f.show();
    }
  }

  public void g()
  {
    super.g();
    if (this.f != null)
      this.f.hide();
  }

  public void h()
  {
    super.h();
    if (this.f != null)
    {
      this.g = true;
      this.f.dismiss();
      this.f = null;
    }
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.g)
      a(true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.DialogFragment
 * JD-Core Version:    0.6.0
 */
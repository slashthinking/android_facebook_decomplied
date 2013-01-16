package com.facebook.orca.common.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.ServiceException;
import javax.inject.Provider;

public class ErrorDialogBuilder
{
  private final Context a;
  private final ErrorMessageGenerator b;
  private final AnalyticsLogger c;
  private String d;
  private String e;
  private ServiceException f;
  private DialogInterface.OnClickListener g;
  private Activity h;
  private Provider<IntendedAudience> i;

  public ErrorDialogBuilder(Context paramContext, ErrorMessageGenerator paramErrorMessageGenerator, Provider<IntendedAudience> paramProvider, AnalyticsLogger paramAnalyticsLogger)
  {
    this.a = paramContext;
    this.b = paramErrorMessageGenerator;
    this.i = paramProvider;
    this.c = paramAnalyticsLogger;
  }

  public static ErrorDialogBuilder a(Context paramContext)
  {
    FbInjector localFbInjector = FbInjector.a(paramContext);
    return new ErrorDialogBuilder(paramContext, (ErrorMessageGenerator)localFbInjector.a(ErrorMessageGenerator.class), localFbInjector.b(IntendedAudience.class), (AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
  }

  public AlertDialog a()
  {
    if (this.f != null)
    {
      str = this.b.a(this.f, false, false);
      if (str != null);
    }
    for (String str = this.e; ; str = this.e)
    {
      if (str == null)
        str = this.a.getString(2131362196);
      Object localObject = this.g;
      if (localObject == null)
        localObject = new ErrorDialogBuilder.1(this);
      ErrorDialogBuilder.2 local2 = new ErrorDialogBuilder.2(this);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.a);
      localBuilder.setTitle(this.d);
      localBuilder.setMessage(str);
      localBuilder.setPositiveButton(this.a.getString(2131362167), (DialogInterface.OnClickListener)localObject);
      if ((this.f != null) && (this.i.b() != IntendedAudience.PUBLIC))
        localBuilder.setNeutralButton(this.a.getString(2131362198), local2);
      this.c.a("error_dialog", true);
      AlertDialog localAlertDialog = localBuilder.create();
      localAlertDialog.show();
      return localAlertDialog;
    }
  }

  public ErrorDialogBuilder a(int paramInt)
  {
    this.d = this.a.getString(paramInt);
    return this;
  }

  public ErrorDialogBuilder a(Activity paramActivity)
  {
    this.h = paramActivity;
    return this;
  }

  public ErrorDialogBuilder a(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
    return this;
  }

  public ErrorDialogBuilder a(ServiceException paramServiceException)
  {
    this.f = paramServiceException;
    return this;
  }

  public ErrorDialogBuilder a(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public ErrorDialogBuilder b(int paramInt)
  {
    this.e = this.a.getString(paramInt);
    return this;
  }

  public ErrorDialogBuilder b(String paramString)
  {
    this.e = paramString;
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.dialogs.ErrorDialogBuilder
 * JD-Core Version:    0.6.2
 */
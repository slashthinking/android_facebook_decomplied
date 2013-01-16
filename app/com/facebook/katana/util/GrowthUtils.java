package com.facebook.katana.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.katana.activity.findfriends.FindFriendsActivity;
import com.facebook.katana.activity.findfriends.LegalDisclaimerActivity;
import com.facebook.katana.activity.findfriends.StepIntroActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.server.protocol.UserSetContactInfoMethod.Params;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.google.common.util.concurrent.Futures;

public final class GrowthUtils
{
  private static GrowthUtils a = null;

  public static GrowthUtils a()
  {
    if (a == null)
      a = new GrowthUtils();
    return a;
  }

  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, StepIntroActivity.class);
    localIntent.putExtra("is_part_of_nux", false);
    paramActivity.startActivity(localIntent);
  }

  private String b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(Long.toString(AppSession.a(paramContext, false).b().userId));
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }

  private boolean c(Activity paramActivity)
  {
    AppSession localAppSession = AppSession.b(paramActivity, false);
    int i = 0;
    if (localAppSession == null);
    while (true)
    {
      return i;
      Boolean localBoolean = Gatekeeper.a(paramActivity, "android_ci_alert_enabled");
      long l1 = KeyValueManager.a(paramActivity, b(paramActivity, "numTimesFindFriendsShown"), 0L);
      i = 0;
      if (localBoolean == null)
        continue;
      boolean bool1 = Boolean.FALSE.equals(localBoolean);
      i = 0;
      if (bool1)
        continue;
      boolean bool2 = l1 < 3L;
      i = 0;
      if (!bool2)
        continue;
      int j = paramActivity.getIntent().getIntExtra("target_fragment", 0);
      i = 0;
      if (j != 1)
        continue;
      long l2 = KeyValueManager.a(paramActivity, b(paramActivity, "lastTimeFindFriendsShown"), -1L);
      if (l2 > 0L)
      {
        boolean bool3 = l2 + 1296000000L < SystemClock.elapsedRealtime();
        i = 0;
        if (bool3)
          continue;
      }
      i = 1;
    }
  }

  private boolean j(Context paramContext)
  {
    int i = 1;
    if (c(paramContext));
    while (true)
    {
      return i;
      Boolean localBoolean = Gatekeeper.a(paramContext, "android_ci_legal_screen");
      if ((localBoolean != null) && (!localBoolean.booleanValue()))
      {
        i = 0;
        continue;
      }
      if (!KeyValueManager.a(paramContext, b(paramContext, "findFriendsConsentApproved")))
        continue;
      i = 0;
    }
  }

  public void a(Context paramContext)
  {
    KeyValueManager.a(paramContext, b(paramContext, "findFriendsConsentApproved"), new Boolean(true));
  }

  public void a(Context paramContext, String paramString)
  {
    KeyValueManager.a(paramContext, b(paramContext, "lastPhoneNumberUpdated"), paramString);
  }

  public boolean a(Activity paramActivity, int paramInt)
  {
    if (!j(paramActivity))
    {
      paramActivity.startActivity(new Intent(paramActivity, FindFriendsActivity.class));
      f(paramActivity);
    }
    for (int i = 1; ; i = 0)
    {
      return i;
      paramActivity.startActivityForResult(new Intent(paramActivity, LegalDisclaimerActivity.class), paramInt);
    }
  }

  public String b(Context paramContext)
  {
    return KeyValueManager.a(paramContext, b(paramContext, "lastPhoneNumberUpdated"), null);
  }

  public void b(Activity paramActivity)
  {
    if (c(paramActivity))
    {
      new AlertDialog.Builder(paramActivity).setCancelable(true).setTitle(2131363381).setMessage(2131363382).setPositiveButton(2131363383, new GrowthUtils.2(this, paramActivity)).setNegativeButton(2131363323, new GrowthUtils.1(this)).create().show();
      KeyValueManager.a(paramActivity, b(paramActivity, "lastTimeFindFriendsShown"), Long.valueOf(SystemClock.elapsedRealtime()));
    }
  }

  public boolean c(Context paramContext)
  {
    String str = Build.BRAND;
    if ((str != null) && (str.equalsIgnoreCase("KDDI")) && (Boolean.TRUE.equals(Gatekeeper.a(paramContext, "android_ci_kddi_intro_enabled"))));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void d(Context paramContext)
  {
    KeyValueManager.a(paramContext, b(paramContext, "findFriendsLegalBarShown"), new Boolean(true));
  }

  public boolean e(Context paramContext)
  {
    int i = 1;
    Boolean localBoolean = Gatekeeper.a(paramContext, "android_ci_legal_bar");
    if ((localBoolean == null) || (localBoolean.booleanValue()));
    while (true)
    {
      return i;
      if (!KeyValueManager.a(paramContext, b(paramContext, "findFriendsLegalBarShown")))
        continue;
      i = 0;
    }
  }

  public void f(Context paramContext)
  {
    KeyValueManager.a(paramContext, b(paramContext, "numTimesFindFriendsShown"), Integer.valueOf(3));
  }

  public void g(Context paramContext)
  {
    long l = KeyValueManager.a(paramContext, b(paramContext, "numTimesFindFriendsShown"), 0L);
    KeyValueManager.a(paramContext, b(paramContext, "numTimesFindFriendsShown"), Long.valueOf(l + 1L));
  }

  public boolean h(Context paramContext)
  {
    return Boolean.TRUE.equals(Gatekeeper.a(paramContext, "android_update_user_phone_in_ci"));
  }

  public void i(Context paramContext)
  {
    String str = Utils.a(paramContext);
    if (!h(paramContext));
    while (true)
    {
      return;
      if ((str != null) && (!StringUtils.c(str)))
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("user_set_contact_info", new UserSetContactInfoMethod.Params(str, true));
        Futures.a(((OrcaServiceOperationFactory)FbInjector.a(paramContext).a(OrcaServiceOperationFactory.class)).a("user_set_contact_info", localBundle).d(), new GrowthUtils.3(this, paramContext, str));
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.GrowthUtils
 * JD-Core Version:    0.6.0
 */
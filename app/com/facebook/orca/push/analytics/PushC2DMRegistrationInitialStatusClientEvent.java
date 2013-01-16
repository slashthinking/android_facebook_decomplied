package com.facebook.orca.push.analytics;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.ReliabilityAnalyticsClientEvent;
import com.facebook.orca.push.c2dm.C2DMRegistrar.RegistrationStatus;

public final class PushC2DMRegistrationInitialStatusClientEvent
{
  public static HoneyClientEvent a(C2DMRegistrar.RegistrationStatus paramRegistrationStatus, String paramString)
  {
    return ReliabilityAnalyticsClientEvent.a("push_reg_gcm_initial_status", a(paramRegistrationStatus), null, "registration_id", paramString);
  }

  private static String a(C2DMRegistrar.RegistrationStatus paramRegistrationStatus)
  {
    String str;
    if (paramRegistrationStatus == null)
      str = "not_applicable";
    while (true)
    {
      return str;
      switch (PushC2DMRegistrationInitialStatusClientEvent.1.a[paramRegistrationStatus.ordinal()])
      {
      default:
        str = "unknown";
        break;
      case 1:
        str = "current";
        break;
      case 2:
        str = "expired";
        break;
      case 3:
        str = "wrong_type";
        break;
      case 4:
        str = "none";
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.analytics.PushC2DMRegistrationInitialStatusClientEvent
 * JD-Core Version:    0.6.0
 */
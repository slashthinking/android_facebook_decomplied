package com.facebook.katana.activity;

import android.view.View;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.model.FacebookNotifications;
import com.facebook.katana.service.method.MarkJewelSeen.Jewel;
import com.facebook.katana.service.method.NotificationsGet;
import com.facebook.katana.ui.JewelTitleBar.OnJewelClickListener;
import com.facebook.katana.ui.PopupViewDelegate;
import com.facebook.katana.ui.PopupViewDelegate.PopupState;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Parameters;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.orca.common.util.StringUtil;

class FacebookActivityDelegate$2
  implements JewelTitleBar.OnJewelClickListener
{
  public void a(MarkJewelSeen.Jewel paramJewel, View paramView)
  {
    switch (FacebookActivityDelegate.13.a[paramJewel.ordinal()])
    {
    default:
      throw new IllegalStateException(StringUtil.a("Unknown jewel type %s", new Object[] { paramJewel }));
    case 1:
      if (FacebookActivityDelegate.a(this.a, PopupViewDelegate.PopupState.FRIEND_REQUESTS, "fb://friends/requests/", true))
        break;
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      HoneyClientEvent localHoneyClientEvent3 = new HoneyClientEvent("click").f(FB4A_AnalyticEntities.UIElements.j).e("button").d(FB4A_AnalyticEntities.Modules.e).a(FB4A_AnalyticEntities.Parameters.a, NotificationsGet.a(FacebookActivityDelegate.b(this.a)).b()).a(FB4A_AnalyticEntities.Parameters.b, NotificationsGet.a(FacebookActivityDelegate.b(this.a)).a());
      FacebookActivityDelegate.a(this.a, localHoneyClientEvent3);
      FacebookActivityDelegate.a(this.a).a(localHoneyClientEvent3);
      if ((FacebookActivityDelegate.c(this.a) != null) && (!FacebookActivityDelegate.c(this.a).d()))
        continue;
      FacebookActivityDelegate.a(this.a, MarkJewelSeen.Jewel.FRIEND_REQUESTS);
      continue;
      if (!FacebookActivityDelegate.a(this.a, PopupViewDelegate.PopupState.MESSAGES, "fb://messaging/nosearch", true))
        continue;
      HoneyClientEvent localHoneyClientEvent2 = new HoneyClientEvent("click").f(FB4A_AnalyticEntities.UIElements.k).e("button").d(FB4A_AnalyticEntities.Modules.f);
      FacebookActivityDelegate.a(this.a, localHoneyClientEvent2);
      FacebookActivityDelegate.a(this.a).a(localHoneyClientEvent2);
      if ((FacebookActivityDelegate.c(this.a) != null) && (!FacebookActivityDelegate.c(this.a).d()))
        continue;
      FacebookActivityDelegate.a(this.a, MarkJewelSeen.Jewel.INBOX);
      continue;
      if (!FacebookActivityDelegate.a(this.a, PopupViewDelegate.PopupState.NOTIFICATIONS, "fb://notifications", true))
        continue;
      HoneyClientEvent localHoneyClientEvent1 = new HoneyClientEvent("click").f(FB4A_AnalyticEntities.UIElements.i).e("button").d(FB4A_AnalyticEntities.Modules.c).a(FB4A_AnalyticEntities.Parameters.a, NotificationsGet.a(FacebookActivityDelegate.b(this.a)).c());
      FacebookActivityDelegate.a(this.a, localHoneyClientEvent1);
      FacebookActivityDelegate.a(this.a).a(localHoneyClientEvent1);
      if ((FacebookActivityDelegate.c(this.a) != null) && (!FacebookActivityDelegate.c(this.a).d()))
        continue;
      FacebookActivityDelegate.a(this.a, MarkJewelSeen.Jewel.NOTIFICATIONS);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.2
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.gifts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.IntentUriHandler;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.karmascience.gifts.ui.KSViewManager;
import com.karmascience.gifts.ui.ViewHandler;

class GiftsActivity$KarmaHandler extends ViewHandler
{
  public GiftsActivity$KarmaHandler(GiftsActivity paramGiftsActivity, KSViewManager paramKSViewManager)
  {
    super(paramKSViewManager);
  }

  public void handleMessage(Message paramMessage)
  {
    boolean bool1 = paramMessage.obj instanceof Bundle;
    Bundle localBundle = null;
    if (bool1)
      localBundle = (Bundle)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    default:
      super.handleMessage(paramMessage);
    case 4:
    case 3:
    case 12:
    case 13:
    case 11:
    }
    while (true)
    {
      return;
      GiftsActivity.a(this.a);
      continue;
      boolean bool2 = localBundle.getBoolean("dismissable", true);
      GiftsActivity.a(this.a, bool2);
      continue;
      String str3 = localBundle.getString("gift_id");
      if (localBundle.getBoolean("pay_now_required"));
      for (String str4 = StringLocaleUtil.a("gifts/paynow/%s", new Object[] { str3 }); ; str4 = StringLocaleUtil.a("gifts/%s", new Object[] { str3 }))
      {
        String str5 = IntentUriHandler.a(Uri.parse(Constants.URL.b(this.a, str4)));
        Intent localIntent3 = IntentUriHandler.a(this.a, str5);
        this.a.startActivity(localIntent3);
        break;
      }
      String str2 = IntentUriHandler.a(Uri.parse(localBundle.getString("url")));
      Intent localIntent2 = IntentUriHandler.a(this.a, str2);
      this.a.startActivity(localIntent2);
      continue;
      String str1 = String.format("fb://profile/%s", new Object[] { localBundle.getString("recipient_facebook_id") });
      Intent localIntent1 = IntentUriHandler.a(this.a, str1);
      this.a.startActivity(localIntent1);
      this.a.finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.gifts.GiftsActivity.KarmaHandler
 * JD-Core Version:    0.6.0
 */
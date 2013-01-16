package com.facebook.orca.push.sms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.annotations.IsSmsNotifyEnabled;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.nux.OrcaNuxManager;
import com.facebook.orca.phonenumber.identification.VerifyPhoneNumberSmsConsumer;
import java.util.ArrayList;
import java.util.List;

public class SmsReceivedAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  static void a(BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    paramBroadcastReceiverLike.setResult(-1, null, null);
    paramBroadcastReceiverLike.abortBroadcast();
  }

  public final void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    AppInitLockHelper.a(paramContext);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    boolean bool = ((Boolean)localFbInjector.a(Boolean.class, IsSmsNotifyEnabled.class)).booleanValue();
    OrcaNuxManager localOrcaNuxManager = (OrcaNuxManager)localFbInjector.a(OrcaNuxManager.class);
    VerifyPhoneNumberSmsConsumer localVerifyPhoneNumberSmsConsumer = (VerifyPhoneNumberSmsConsumer)localFbInjector.a(VerifyPhoneNumberSmsConsumer.class);
    Object[] arrayOfObject = (Object[])(Object[])paramIntent.getExtras().get("pdus");
    if (arrayOfObject == null);
    while (true)
    {
      return;
      if (localVerifyPhoneNumberSmsConsumer.b())
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        if (i < arrayOfObject.length)
        {
          SmsMessage localSmsMessage = SmsMessage.createFromPdu((byte[])(byte[])arrayOfObject[i]);
          if ((localSmsMessage == null) || (localSmsMessage.getMessageBody() == null));
          while (true)
          {
            i++;
            break;
            localArrayList.add(localSmsMessage.getMessageBody());
          }
        }
        if (localVerifyPhoneNumberSmsConsumer.a(localArrayList))
        {
          a(paramBroadcastReceiverLike);
          continue;
        }
      }
      if ((!bool) || (!localOrcaNuxManager.f()))
        continue;
      SmsReceiver.a(paramContext, paramIntent);
      a(paramBroadcastReceiverLike);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.sms.SmsReceivedAction
 * JD-Core Version:    0.6.0
 */
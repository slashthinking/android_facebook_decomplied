package com.facebook.contacts.contactcard;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.notify.NotificationSettingsUtil;
import java.util.Date;

public class ConversationSettingsView$NotificationsSettingsDialogFragment extends DialogFragment
{
  private int Y;
  private String Z;
  private ConversationSettingsView.NotificationsSettingsDialogFragment.NotificationsSettingsDialogListener aa;

  public void a(ConversationSettingsView.NotificationsSettingsDialogFragment.NotificationsSettingsDialogListener paramNotificationsSettingsDialogListener)
  {
    this.aa = paramNotificationsSettingsDialogListener;
  }

  public void a(String paramString, int paramInt)
  {
    this.Z = paramString;
    this.Y = paramInt;
  }

  public Dialog c(Bundle paramBundle)
  {
    Context localContext = p();
    NotificationSettingsUtil localNotificationSettingsUtil = (NotificationSettingsUtil)FbInjector.a(localContext).a(NotificationSettingsUtil.class);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext);
    localBuilder.setTitle(2131362475);
    Date localDate1 = localNotificationSettingsUtil.b();
    String str1 = android.text.format.DateFormat.getTimeFormat(localContext).format(localDate1);
    Date localDate2;
    if (this.Y == 2)
      localDate2 = new Date(1000L * localNotificationSettingsUtil.a(this.Z).b());
    for (String str2 = localContext.getString(2131362473, new Object[] { android.text.format.DateFormat.getTimeFormat(localContext).format(localDate2) }); ; str2 = localContext.getString(2131362472))
    {
      CharSequence[] arrayOfCharSequence = new CharSequence[4];
      arrayOfCharSequence[0] = localContext.getString(2131362470);
      arrayOfCharSequence[1] = localContext.getString(2131362471);
      arrayOfCharSequence[2] = str2;
      arrayOfCharSequence[3] = localContext.getString(2131362473, new Object[] { str1 });
      localBuilder.setSingleChoiceItems(arrayOfCharSequence, this.Y, new ConversationSettingsView.NotificationsSettingsDialogFragment.1(this));
      return localBuilder.create();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.ConversationSettingsView.NotificationsSettingsDialogFragment
 * JD-Core Version:    0.6.0
 */
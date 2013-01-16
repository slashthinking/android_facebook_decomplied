package com.facebook.katana.activity.notifications;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import com.facebook.katana.SettingsActivity;
import com.facebook.katana.fragment.dialog.ProgressDialogFragment;
import com.facebook.katana.util.StringUtils;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

public class PushNotificationsSettingsMigrationActivity extends FbFragmentActivity
{
  private static final Class<?> n = PushNotificationsSettingsMigrationActivity.class;
  private static final ImmutableMap<String, String> s = ImmutableMap.k().b("notif_wall_posts", "Wall_Posts").b("notif_friend_requests", "Friend_Requests").b("notif_friend_confirmations", "Friend_Confirmations").b("notif_photo_tags", "Photo_Tags").b("notif_event_invites", "Events").b("notif_comments", "Comments").b("notif_place_tags", "Photo_Tags").b("notif_nearby_friends", "Nearby_Friends").b("notif_app_requests", "Application_Requests").b("notif_groups", "Group_Activity").b();
  private PushNotificationsSettingsMigrationActivity.State o = PushNotificationsSettingsMigrationActivity.State.NONE;
  private DialogFragment p;
  private AndroidThreadUtil q;
  private NotificationsUtils r;

  private void i()
  {
    this.o = PushNotificationsSettingsMigrationActivity.State.NONE;
    this.p.a();
  }

  private void j()
  {
    this.o = PushNotificationsSettingsMigrationActivity.State.PROCESSING;
    this.p.a(g(), null);
  }

  private void k()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String[] arrayOfString = SettingsActivity.b;
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfString[j];
      if (localSharedPreferences.contains(str))
      {
        if (!Boolean.valueOf(localSharedPreferences.getBoolean(str, true)).booleanValue())
          break label98;
        localArrayList1.add(s.get(str));
      }
      while (true)
      {
        j++;
        break;
        label98: localArrayList2.add(s.get(str));
      }
    }
    ListenableFuture localListenableFuture = this.r.a(StringUtils.a(",", new Object[] { localArrayList1 }), StringUtils.a(",", new Object[] { localArrayList2 }));
    this.q.a(localListenableFuture, new PushNotificationsSettingsMigrationActivity.1(this));
    j();
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.p = ProgressDialogFragment.a(2131362850, true, false);
    this.q = ((AndroidThreadUtil)C().a(AndroidThreadUtil.class));
    this.r = ((NotificationsUtils)C().a(NotificationsUtils.class));
    k();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.PushNotificationsSettingsMigrationActivity
 * JD-Core Version:    0.6.0
 */
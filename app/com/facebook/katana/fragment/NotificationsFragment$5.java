package com.facebook.katana.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.model.FeedStory;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.NativeThirdPartyUriHelper;
import com.facebook.katana.activity.notifications.NotificationsAdapter;
import com.facebook.katana.model.NotificationHelper;
import com.facebook.katana.util.logging.NotificationsLogger;
import com.facebook.katana.util.logging.NotificationsLogger.Event;
import com.facebook.katana.util.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHelper;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;

class NotificationsFragment$5
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (NotificationsFragment.i(this.a))
    {
      Cursor localCursor2 = NotificationsFragment.a(this.a).a();
      localCursor2.moveToPosition(paramInt);
      FeedStory localFeedStory = NotificationsFragment.j(this.a).a(localCursor2);
      if (localFeedStory != null)
        NotificationsFragment.a(this.a, localFeedStory, paramView);
      while (true)
      {
        return;
        ((FbErrorReporter)this.a.c().a(FbErrorReporter.class)).a(NotificationsFragment.i.getSimpleName(), "Error retrieving notification story ", true);
      }
    }
    Cursor localCursor1 = NotificationsFragment.a(this.a).a();
    localCursor1.moveToPosition(paramInt);
    String str1 = localCursor1.getString(localCursor1.getColumnIndex("object_type"));
    String str2 = localCursor1.getString(localCursor1.getColumnIndex("object_id"));
    String str3 = localCursor1.getString(localCursor1.getColumnIndex("href"));
    String str4 = localCursor1.getString(localCursor1.getColumnIndex("join_data_string"));
    String str5 = NotificationHelper.a(str4);
    boolean bool1;
    label216: Intent localIntent1;
    Intent localIntent2;
    if (1 == localCursor1.getInt(localCursor1.getColumnIndex("is_unread")))
    {
      bool1 = true;
      localIntent1 = NotificationsFragment.k(this.a).a(str1, str2, str3, str4);
      if (localIntent1 != null)
        break label475;
      if (Constants.URL.c(str3))
      {
        Uri localUri = Uri.parse(str3);
        str3 = StringLocaleUtil.a("fb://faceweb/f?href=%s", new Object[] { new Uri.Builder().path(localUri.getPath()).query(localUri.getQuery()).fragment(localUri.getFragment()).toString() });
      }
      localIntent2 = IntentUriHandler.a(this.a.n(), str3);
    }
    for (boolean bool2 = false; ; bool2 = true)
    {
      NativeThirdPartyUriHelper.a(this.a.n(), localIntent2);
      NotificationsFragment.a(this.a, localIntent2);
      this.a.a(localIntent2);
      NotificationsLogger.NotificationLogObject localNotificationLogObject = new NotificationsLogger.NotificationLogObject().a(localCursor1.getLong(localCursor1.getColumnIndex("notif_id"))).b(str2).c(str1).d(str5).a(bool2).b(bool1);
      NotificationsLogger.b(this.a.n().getApplicationContext(), localNotificationLogObject, NotificationsLogger.Event.NOTIFICATION_CLICK);
      long[] arrayOfLong = new long[1];
      arrayOfLong[0] = localCursor1.getLong(localCursor1.getColumnIndex("notif_id"));
      NotificationsFragment.a(NotificationsFragment.c(this.a), this.a.n(), arrayOfLong);
      break;
      bool1 = false;
      break label216;
      label475: localIntent2 = localIntent1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.fragment.NotificationsFragment.5
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.activity.notifications;

import android.content.Context;
import android.database.Cursor;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.katana.Constants.URL;

public class NotificationsAdapter$FQLNotificationsRenderer extends NotificationsAdapter.NotificationsRenderer
{
  public NotificationsAdapter$FQLNotificationsRenderer(Context paramContext)
  {
    super(paramContext);
  }

  void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    Long localLong = Long.valueOf(paramCursor.getLong(paramCursor.getColumnIndex("sender_id")));
    String str1 = Constants.URL.d(paramContext) + localLong + "/picture?type=large";
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("sender_name"));
    String str3 = paramCursor.getString(paramCursor.getColumnIndex("title"));
    Object localObject;
    if (str2 != null)
    {
      localObject = a(str2, str3);
      if (paramCursor.getInt(paramCursor.getColumnIndex("is_unread")) != 0)
        break label181;
    }
    label181: for (boolean bool = true; ; bool = false)
    {
      a(paramView, paramContext, bool, str1, paramCursor.getString(paramCursor.getColumnIndex("icon_url")), (Spannable)localObject, paramCursor.getLong(paramCursor.getColumnIndex("updated")), paramCursor.getString(paramCursor.getColumnIndex("object_photo_url")));
      return;
      localObject = new SpannableStringBuilder(str3);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.NotificationsAdapter.FQLNotificationsRenderer
 * JD-Core Version:    0.6.0
 */
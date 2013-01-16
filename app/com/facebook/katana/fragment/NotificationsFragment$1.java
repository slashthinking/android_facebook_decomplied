package com.facebook.katana.fragment;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.facebook.ipc.notifications.GQLNotificationsContract;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.katana.activity.notifications.NotificationsAdapter;
import com.facebook.katana.activity.notifications.NotificationsAdapter.NotificationsQuery;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;

class NotificationsFragment$1
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  public Loader<Cursor> a(int paramInt, Bundle paramBundle)
  {
    CursorLoader localCursorLoader;
    switch (paramInt)
    {
    default:
      Class localClass = NotificationsFragment.i;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt);
      BLog.e(localClass, "Unexpected onCreateLoader: %d", arrayOfObject2);
      localCursorLoader = null;
    case 100:
    case 101:
    }
    while (true)
    {
      return localCursorLoader;
      FragmentActivity localFragmentActivity = this.a.n();
      Uri localUri = NotificationsFragment.b(this.a).e;
      String[] arrayOfString = GQLNotificationsContract.a;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = "recipient_id";
      arrayOfObject1[1] = Long.valueOf(NotificationsFragment.c(this.a).b().userId);
      localCursorLoader = new CursorLoader(localFragmentActivity, localUri, arrayOfString, StringUtil.a("%s = %d", arrayOfObject1), null, null);
      continue;
      localCursorLoader = new CursorLoader(this.a.n(), NotificationsFragment.d(this.a).c, NotificationsAdapter.NotificationsQuery.a, null, null, null);
    }
  }

  public void a(Loader<Cursor> paramLoader)
  {
    NotificationsFragment.a(this.a).a(null);
  }

  public void a(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    NotificationsFragment.a(this.a).a(paramCursor);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.fragment.NotificationsFragment.1
 * JD-Core Version:    0.6.0
 */
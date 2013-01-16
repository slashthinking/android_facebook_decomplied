package com.facebook.katana.activity.profilelist;

import android.database.Cursor;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.util.StringUtils;

public class FriendMultiSelectorActivity$FriendMultiSelectorAppSessionListener extends ProfileListActivity.ProfileListListener
{
  protected FriendMultiSelectorActivity$FriendMultiSelectorAppSessionListener(FriendMultiSelectorActivity paramFriendMultiSelectorActivity)
  {
    super(paramFriendMultiSelectorActivity);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    FriendMultiSelectorActivity.a(this.a, 2, false);
    if (paramInt == 200)
    {
      SelectableProfileListNaiveCursorAdapter localSelectableProfileListNaiveCursorAdapter = (SelectableProfileListNaiveCursorAdapter)this.a.B;
      Cursor localCursor = localSelectableProfileListNaiveCursorAdapter.e();
      if (localCursor != null)
      {
        localCursor.requery();
        localSelectableProfileListNaiveCursorAdapter.b(localCursor);
      }
    }
    while (true)
    {
      return;
      String str = StringUtils.a(this.a, this.a.getString(2131362939), paramInt, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.FriendMultiSelectorActivity.FriendMultiSelectorAppSessionListener
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.activity.profilelist;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import com.facebook.katana.binding.AppSession;

final class FriendSingleSelectorActivity$QueryHandler extends AsyncQueryHandler
{
  public FriendSingleSelectorActivity$QueryHandler(FriendSingleSelectorActivity paramFriendSingleSelectorActivity, Context paramContext)
  {
    super(paramContext.getContentResolver());
  }

  protected void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    if (this.a.isFinishing())
      paramCursor.close();
    while (true)
    {
      return;
      FriendSingleSelectorActivity.a(this.a, 1, false);
      this.a.startManagingCursor(paramCursor);
      ((SelectableProfileListNaiveCursorAdapter)this.a.B).b(paramCursor);
      if (!FriendSingleSelectorActivity.a(this.a).e())
      {
        if (this.a.B.b() != 0)
          continue;
        FriendSingleSelectorActivity.b(this.a).e(this.a);
        FriendSingleSelectorActivity.a(this.a, 2, true);
        continue;
      }
      FriendSingleSelectorActivity.a(this.a, 2, true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.FriendSingleSelectorActivity.QueryHandler
 * JD-Core Version:    0.6.0
 */
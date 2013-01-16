package com.facebook.katana.activity.profilelist;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import com.facebook.katana.binding.AppSession;

final class FriendMultiSelectorActivity$QueryHandler extends AsyncQueryHandler
{
  public FriendMultiSelectorActivity$QueryHandler(FriendMultiSelectorActivity paramFriendMultiSelectorActivity, Context paramContext)
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
      FriendMultiSelectorActivity.a(this.a, 1, false);
      this.a.startManagingCursor(paramCursor);
      ((SelectableProfileListNaiveCursorAdapter)this.a.B).b(paramCursor);
      if (!FriendMultiSelectorActivity.a(this.a).e())
      {
        if (this.a.B.b() != 0)
          continue;
        FriendMultiSelectorActivity.b(this.a).e(this.a);
        FriendMultiSelectorActivity.a(this.a, 2, true);
        continue;
      }
      FriendMultiSelectorActivity.a(this.a, 2, true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.FriendMultiSelectorActivity.QueryHandler
 * JD-Core Version:    0.6.0
 */
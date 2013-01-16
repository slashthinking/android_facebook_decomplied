package com.facebook.katana;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;

public final class FriendsActivity$UserSearchQueryHandler extends AsyncQueryHandler
{
  public FriendsActivity$UserSearchQueryHandler(FriendsActivity paramFriendsActivity, Context paramContext)
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
      this.a.a(4, false);
      this.a.startManagingCursor(paramCursor);
      FriendsActivity.a(this.a).a(true);
      FriendsActivity.a(this.a).a_(paramCursor);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FriendsActivity.UserSearchQueryHandler
 * JD-Core Version:    0.6.0
 */
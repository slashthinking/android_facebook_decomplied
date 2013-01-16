package com.facebook.katana;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import com.facebook.katana.binding.AppSession;

final class FriendsActivity$FriendsQueryHandler extends AsyncQueryHandler
{
  public FriendsActivity$FriendsQueryHandler(FriendsActivity paramFriendsActivity, Context paramContext)
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
      this.a.a(1, false);
      this.a.startManagingCursor(paramCursor);
      FriendsActivity.a(this.a).b(paramCursor);
      if (!FriendsActivity.b(this.a).e())
      {
        if (FriendsActivity.a(this.a).b() != 0)
          continue;
        FriendsActivity.b(this.a).e(this.a);
        FriendsActivity.c(this.a);
        this.a.a(2, true);
        continue;
      }
      this.a.a(2, true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FriendsActivity.FriendsQueryHandler
 * JD-Core Version:    0.6.0
 */
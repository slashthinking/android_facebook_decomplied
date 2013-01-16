package com.facebook.katana;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;

public final class ProfileSearchResultsActivity$QueryHandler extends AsyncQueryHandler
{
  public ProfileSearchResultsActivity$QueryHandler(ProfileSearchResultsActivity paramProfileSearchResultsActivity, Context paramContext)
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
      this.a.p.a(paramCursor);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ProfileSearchResultsActivity.QueryHandler
 * JD-Core Version:    0.6.0
 */
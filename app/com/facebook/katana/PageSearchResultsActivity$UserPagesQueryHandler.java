package com.facebook.katana;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;

public final class PageSearchResultsActivity$UserPagesQueryHandler extends AsyncQueryHandler
{
  public PageSearchResultsActivity$UserPagesQueryHandler(PageSearchResultsActivity paramPageSearchResultsActivity, Context paramContext)
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
      PageSearchResultsActivity.a(this.a).b(paramCursor);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.PageSearchResultsActivity.UserPagesQueryHandler
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.activity.profilelist;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import com.facebook.katana.PageListAdapter;

public final class PageSelectorActivity$UserPagesQueryHandler extends AsyncQueryHandler
{
  public PageSelectorActivity$UserPagesQueryHandler(PageSelectorActivity paramPageSelectorActivity, Context paramContext)
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
      PageSelectorActivity.a(this.a, 1, false);
      this.a.startManagingCursor(paramCursor);
      PageSelectorActivity.a(this.a).b(paramCursor);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.PageSelectorActivity.UserPagesQueryHandler
 * JD-Core Version:    0.6.0
 */
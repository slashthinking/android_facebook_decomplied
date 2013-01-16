package com.facebook.katana;

import android.content.Context;
import android.database.Cursor;
import com.facebook.common.util.ErrorReporting;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListCursorAdapter.Section;
import com.facebook.katana.binding.StreamPhotosCache;
import java.util.ArrayList;
import java.util.List;

public class PageSearchResultsAdapter extends ProfileSearchResultsAdapter
{
  public PageSearchResultsAdapter(Context paramContext, Cursor paramCursor, StreamPhotosCache paramStreamPhotosCache)
  {
    super(paramContext, paramCursor, paramStreamPhotosCache);
  }

  public Object a(int paramInt1, int paramInt2)
  {
    if (!this.e.moveToPosition(d(paramInt1, paramInt2)))
      ErrorReporting.a("PageSearchResultAdapter:getChild", "mCursor is point to non-existing row in the db. sectionPosition: " + paramInt1 + "childPosition" + paramInt2);
    for (FacebookProfile localFacebookProfile = null; ; localFacebookProfile = new FacebookProfile(this.e.getLong(this.e.getColumnIndex("page_id")), this.e.getString(this.e.getColumnIndex("display_name")), this.e.getString(this.e.getColumnIndex("pic")), 1))
      return localFacebookProfile;
  }

  public void a(Cursor paramCursor)
  {
    this.e = paramCursor;
    this.f = new ArrayList();
    if (paramCursor == null);
    while (true)
    {
      return;
      this.f.add(new ProfileListCursorAdapter.Section(this.a.getString(2131363024), 0, paramCursor.getCount()));
      j();
    }
  }

  public int d_()
  {
    if ((this.e == null) || (this.e.getCount() == 0));
    for (int i = 0; ; i = this.f.size())
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.PageSearchResultsAdapter
 * JD-Core Version:    0.6.0
 */
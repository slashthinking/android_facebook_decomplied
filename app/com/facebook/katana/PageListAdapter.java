package com.facebook.katana;

import android.content.Context;
import android.database.Cursor;
import android.widget.Filter;
import com.facebook.common.util.ErrorReporting;
import com.facebook.ipc.connections.ConnectionsContract.ConnectionType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListImageCacheAdapter;
import com.facebook.katana.binding.ProfileImagesCache;

public class PageListAdapter extends ProfileListImageCacheAdapter
{
  Filter a = new PageListAdapter.1(this);

  public PageListAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache, Cursor paramCursor)
  {
    super(paramContext, paramProfileImagesCache, paramCursor);
  }

  public Filter a()
  {
    return this.a;
  }

  public Object a(int paramInt1, int paramInt2)
  {
    if (!this.e.moveToPosition(d(paramInt1, paramInt2)))
      ErrorReporting.a("PageListAdapter:getChild", "mCursor is point to non-existing row in the db. sectionPosition: " + paramInt1 + "childPosition" + paramInt2);
    for (FacebookProfile localFacebookProfile = null; ; localFacebookProfile = new FacebookProfile(this.e.getLong(this.e.getColumnIndex("user_id")), this.e.getString(this.e.getColumnIndex("display_name")), this.e.getString(this.e.getColumnIndex("user_image_url")), 1))
      return localFacebookProfile;
  }

  protected Object a(Cursor paramCursor)
  {
    return Integer.valueOf(paramCursor.getInt(paramCursor.getColumnIndex("connection_type")));
  }

  protected String a(Object paramObject)
  {
    String str;
    if (paramObject.equals(Integer.valueOf(ConnectionsContract.ConnectionType.PAGE_ADMIN.ordinal())))
      str = this.g.getString(2131363025);
    while (true)
    {
      return str;
      if (paramObject.equals(Integer.valueOf(ConnectionsContract.ConnectionType.PAGE_FAN.ordinal())))
      {
        str = this.g.getString(2131363026);
        continue;
      }
      str = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.PageListAdapter
 * JD-Core Version:    0.6.0
 */
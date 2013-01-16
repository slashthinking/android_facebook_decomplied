package com.facebook.katana.activity.profilelist;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.ipc.connections.ConnectionsContract;

class ProfileListNaiveCursorAdapter$1 extends Filter
{
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Uri localUri;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      localUri = Uri.withAppendedPath(ConnectionsContract.g, paramCharSequence.toString());
    for (Cursor localCursor = ((Activity)this.a.g).managedQuery(localUri, ProfileListNaiveCursorAdapter.FriendsQuery.a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null); ; localCursor = ((Activity)this.a.g).managedQuery(ConnectionsContract.d, ProfileListNaiveCursorAdapter.FriendsQuery.a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null))
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      localFilterResults.count = localCursor.getCount();
      localFilterResults.values = localCursor;
      return localFilterResults;
    }
  }

  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if (paramFilterResults.values != null)
    {
      Cursor localCursor = (Cursor)paramFilterResults.values;
      this.a.b(localCursor);
    }
    this.a.j();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter.1
 * JD-Core Version:    0.6.0
 */
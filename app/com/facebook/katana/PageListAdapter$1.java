package com.facebook.katana;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.ipc.connections.ConnectionsContract;

class PageListAdapter$1 extends Filter
{
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Uri localUri;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      localUri = Uri.withAppendedPath(ConnectionsContract.k, paramCharSequence.toString());
    for (Cursor localCursor = ((Activity)PageListAdapter.a(this.a)).managedQuery(localUri, PageListAdapter.UserPagesQuery.a, null, null, "connection_type, display_name"); ; localCursor = ((Activity)PageListAdapter.b(this.a)).managedQuery(ConnectionsContract.i, PageListAdapter.UserPagesQuery.a, null, null, "connection_type, display_name"))
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
 * Qualified Name:     com.facebook.katana.PageListAdapter.1
 * JD-Core Version:    0.6.0
 */
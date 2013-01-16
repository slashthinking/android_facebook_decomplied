package com.facebook.katana.activity.media;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DropdownTagUsersAdapter$1 extends Filter
{
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    ArrayList localArrayList = new ArrayList();
    AppSession localAppSession = AppSession.a(DropdownTagUsersAdapter.a(this.a), false);
    if (localAppSession != null)
    {
      FacebookUser localFacebookUser = localAppSession.b().a();
      if ((paramCharSequence == null) || (paramCharSequence.toString().length() == 0) || (localFacebookUser.mDisplayName.toLowerCase().indexOf(paramCharSequence.toString().toLowerCase()) != -1))
      {
        UserHolder localUserHolder3 = new UserHolder();
        localUserHolder3.a(localFacebookUser.mUserId);
        localUserHolder3.a(localFacebookUser.mDisplayName);
        localUserHolder3.b(localFacebookUser.mImageUrl);
        localArrayList.add(localUserHolder3);
      }
    }
    if ((paramCharSequence != null) && (paramCharSequence.toString().length() > 0))
    {
      Uri localUri = Uri.withAppendedPath(ConnectionsContract.f, Uri.encode(paramCharSequence.toString()));
      Cursor localCursor = ((Activity)DropdownTagUsersAdapter.a(this.a)).managedQuery(localUri, DropdownTagUsersAdapter.FriendsQuery.a, null, null, null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        int i = localCursor.getColumnIndex("user_id");
        int j = localCursor.getColumnIndex("display_name");
        int k = localCursor.getColumnIndex("user_image_url");
        do
        {
          UserHolder localUserHolder2 = new UserHolder();
          localUserHolder2.a(localCursor.getLong(i));
          localUserHolder2.a(localCursor.getString(j));
          localUserHolder2.b(localCursor.getString(k));
          localArrayList.add(localUserHolder2);
        }
        while (localCursor.moveToNext());
      }
      UserHolder localUserHolder1 = new UserHolder();
      localUserHolder1.a(-1L);
      localUserHolder1.a(paramCharSequence.toString());
      localUserHolder1.b(null);
      localArrayList.add(localUserHolder1);
    }
    localFilterResults.count = localArrayList.size();
    localFilterResults.values = localArrayList;
    return localFilterResults;
  }

  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if (paramFilterResults.values != null)
    {
      List localList = (List)paramFilterResults.values;
      this.a.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        UserHolder localUserHolder = (UserHolder)localIterator.next();
        this.a.add(localUserHolder);
      }
      this.a.notifyDataSetChanged();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.DropdownTagUsersAdapter.1
 * JD-Core Version:    0.6.0
 */
package com.facebook.bookmark.ui.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseBookmarkSelectedListener
  implements OnBookmarkSelectedListener
{
  private static boolean a(Bundle paramBundle1, Bundle paramBundle2)
  {
    boolean bool;
    if ((paramBundle1 == null) && (paramBundle2 == null))
      bool = true;
    while (true)
    {
      return bool;
      if ((paramBundle1 == null) || (paramBundle2 == null))
      {
        bool = false;
      }
      else if (paramBundle1.size() != paramBundle2.size())
      {
        bool = false;
      }
      else
      {
        Iterator localIterator = paramBundle1.keySet().iterator();
        while (true)
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object localObject1 = paramBundle1.get(str);
            Object localObject2 = paramBundle2.get(str);
            if (((localObject1 != null) || (localObject2 != null)) && ((localObject1 == null) || (!localObject1.equals(localObject2))))
            {
              bool = false;
              break;
            }
          }
        bool = true;
      }
    }
  }

  protected abstract void a(Activity paramActivity);

  protected void a(BookmarkEvent paramBookmarkEvent, Intent paramIntent)
  {
  }

  public boolean a(BookmarkEvent paramBookmarkEvent)
  {
    boolean bool = true;
    if (c(paramBookmarkEvent));
    while (true)
    {
      return bool;
      Bundle localBundle = paramBookmarkEvent.a.getIntent().getBundleExtra("bookmark_identifier");
      if (a(paramBookmarkEvent.c(), localBundle))
      {
        a(paramBookmarkEvent.a);
      }
      else
      {
        Intent localIntent = b(paramBookmarkEvent);
        a(paramBookmarkEvent, localIntent);
        if (localIntent != null)
        {
          localIntent.putExtra("bookmark_identifier", paramBookmarkEvent.c());
          paramBookmarkEvent.a.startActivity(localIntent);
          paramBookmarkEvent.a.overridePendingTransition(2130968612, 2130968596);
        }
        else
        {
          bool = false;
        }
      }
    }
  }

  protected abstract Intent b(BookmarkEvent paramBookmarkEvent);

  protected boolean c(BookmarkEvent paramBookmarkEvent)
  {
    return false;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.event.BaseBookmarkSelectedListener
 * JD-Core Version:    0.6.2
 */
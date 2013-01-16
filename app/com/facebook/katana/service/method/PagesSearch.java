package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookPage;
import com.facebook.ipc.pages.PagesContract;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PagesSearch extends ServiceOperation
  implements ApiMethodCallback, ServiceOperationListener
{
  private static long a = -1L;
  private final long b;
  private PagesSearch.PagesSearchInternal c;
  private Handler d;
  private String e;
  private String f;
  private int g;
  private int h;

  public PagesSearch(Context paramContext, Intent paramIntent, String paramString1, String paramString2, int paramInt1, int paramInt2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramServiceOperationListener);
    a = System.currentTimeMillis();
    this.b = a;
    this.e = paramString2;
    this.f = paramString1;
    this.g = paramInt1;
    this.h = paramInt2;
    this.d = new Handler();
  }

  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new PagesSearch(paramContext, null, localAppSession.b().sessionKey, paramString, paramInt1, paramInt2, null), 1001, 1020, null);
    }
  }

  private void a(Map<Long, FacebookPage> paramMap)
  {
    monitorenter;
    while (true)
    {
      ContentResolver localContentResolver;
      ContentValues[] arrayOfContentValues;
      try
      {
        long l1 = this.b;
        long l2 = a;
        if (l1 < l2)
          return;
        localContentResolver = this.o.getContentResolver();
        if (this.g != 0)
          continue;
        localContentResolver.delete(PagesContract.c, null, null);
        if (paramMap.size() == 0)
          continue;
        arrayOfContentValues = new ContentValues[paramMap.size()];
        Iterator localIterator = paramMap.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          FacebookPage localFacebookPage = (FacebookPage)localIterator.next();
          ContentValues localContentValues = new ContentValues();
          arrayOfContentValues[i] = localContentValues;
          i++;
          localContentValues.put("page_id", Long.valueOf(localFacebookPage.mPageId));
          localContentValues.put("display_name", localFacebookPage.mDisplayName);
          localContentValues.put("pic", localFacebookPage.mPicSmall);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localContentResolver.bulkInsert(PagesContract.c, arrayOfContentValues);
    }
  }

  private static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0));
    for (int i = 0; ; i = 1)
      return i;
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.g);
  }

  public void a(ServiceOperation paramServiceOperation, long paramLong1, long paramLong2)
  {
  }

  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }

  public void a_(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    this.q.a_(this, paramInt, paramString, paramException);
  }

  public void b()
  {
    if (a(this.e))
    {
      this.c = new PagesSearch.PagesSearchInternal(this.o, this.p, this, this.f, this.e, this.g, this.h);
      this.c.b();
    }
    while (true)
    {
      return;
      new PagesSearch.DeleteThread(this, null).start();
    }
  }

  public void b(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    Assert.b(paramServiceOperation instanceof PagesSearch.PagesSearchInternal);
    a(((PagesSearch.PagesSearchInternal)paramServiceOperation).g());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PagesSearch
 * JD-Core Version:    0.6.0
 */
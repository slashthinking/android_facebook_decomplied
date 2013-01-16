package com.facebook.uberbar.resolvers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class LocalUberbarResultResolver
{
  protected final String[] a;
  protected final Function<Cursor, List<UberbarResult>> b;
  private final Uri c;
  private final AsyncCursorReaderUtil<List<UberbarResult>> d;

  public LocalUberbarResultResolver(ContentResolver paramContentResolver, AndroidThreadUtil paramAndroidThreadUtil, Uri paramUri, String[] paramArrayOfString, Function<Cursor, List<UberbarResult>> paramFunction)
  {
    this.d = new AsyncCursorReaderUtil(paramContentResolver, paramAndroidThreadUtil);
    this.c = paramUri;
    this.a = paramArrayOfString;
    this.b = paramFunction;
  }

  private DataQuery b(String paramString)
  {
    return new DataQuery.Builder().a(Uri.withAppendedPath(this.c, paramString)).a(this.a).e();
  }

  public ListenableFuture<List<UberbarResult>> a(String paramString)
  {
    return this.d.a(b(paramString), null, this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.resolvers.LocalUberbarResultResolver
 * JD-Core Version:    0.6.2
 */
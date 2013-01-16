package com.facebook.katana.activity.media;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;
import java.util.ArrayList;
import java.util.List;

public class AlbumsAdapter extends CursorAdapter
{
  private final Context a;
  private final AppSession b;
  private final long c;
  private final List<ViewHolder<String>> d;

  public AlbumsAdapter(Context paramContext, Uri paramUri, String paramString, AppSession paramAppSession)
  {
    this(paramContext, paramUri, paramString, null, paramAppSession);
  }

  public AlbumsAdapter(Context paramContext, Uri paramUri, String paramString1, String paramString2, AppSession paramAppSession)
  {
    super(paramContext, ((Activity)paramContext).managedQuery(paramUri, AlbumsAdapter.AlbumsQuery.a, paramString1, null, paramString2), true);
    this.a = paramContext;
    this.b = paramAppSession;
    this.c = Long.valueOf((String)paramUri.getPathSegments().get(2)).longValue();
    this.d = new ArrayList();
  }

  public static AlbumsAdapter a(Context paramContext, AppSession paramAppSession, long paramLong)
  {
    return new AlbumsAdapter(paramContext, Uri.withAppendedPath(PhotosProvider.g, String.valueOf(paramLong)), "type <> 'tagged'", paramAppSession);
  }

  public long a()
  {
    return this.c;
  }

  public String a(Cursor paramCursor)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("aid"));
  }

  public long b(Cursor paramCursor)
  {
    return paramCursor.getLong(paramCursor.getColumnIndex("object_id"));
  }

  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("aid"));
    ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
    localViewHolder.a(str1);
    byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("thumbnail"));
    if (arrayOfByte != null);
    while (true)
    {
      try
      {
        localViewHolder.a.setImageBitmap(ImageUtils.b(arrayOfByte));
        ((TextView)paramView.findViewById(2131296357)).setText(paramCursor.getString(paramCursor.getColumnIndex("name")));
        ((TextView)paramView.findViewById(2131296356)).setText(Integer.toString(paramCursor.getInt(paramCursor.getColumnIndex("size"))));
        return;
      }
      catch (ImageUtils.ImageException localImageException)
      {
        Log.a("AlbumsAdapter", "cannot decode image byte", localImageException);
        continue;
      }
      String str2 = paramCursor.getString(paramCursor.getColumnIndex("cover_url"));
      if (str2 != null)
      {
        localViewHolder.a.setImageResource(2130838835);
        String str3 = paramCursor.getString(paramCursor.getColumnIndex("cover_pid"));
        this.b.a(this.a, this.c, str1, str3, str2);
        continue;
      }
      localViewHolder.a.setImageResource(2130838835);
    }
  }

  public String c(Cursor paramCursor)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("name"));
  }

  public int d(Cursor paramCursor)
  {
    return paramCursor.getInt(paramCursor.getColumnIndex("size"));
  }

  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    View localView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903044, null);
    ViewHolder localViewHolder = new ViewHolder(localView, 2131296355);
    localView.setTag(localViewHolder);
    this.d.add(localViewHolder);
    return localView;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.AlbumsAdapter
 * JD-Core Version:    0.6.0
 */
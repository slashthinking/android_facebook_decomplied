package com.facebook.katana.activity.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.MediaStore.Video.Media;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.katana.activity.media.crop.CropDatabaseHelper;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.model.VideoItem;
import com.facebook.katana.provider.LocalPhotoTagProvider;
import com.facebook.katana.view.vault.PickerGalleryView;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MediaPickerActivity$LocalMediaLoader extends AsyncTask<Context, Void, List<MediaItem>>
{
  private MediaPickerActivity$LocalMediaLoader(MediaPickerActivity paramMediaPickerActivity)
  {
  }

  private List<MediaItem> a(Map<String, MediaItem> paramMap)
  {
    ArrayList localArrayList = Lists.a();
    Map localMap = a();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      MediaItem localMediaItem = (MediaItem)paramMap.get(str1);
      if (localMediaItem == null)
      {
        String str2 = StringLocaleUtil.a("%s = ?", new Object[] { "image_hash" });
        String[] arrayOfString = { str1 };
        this.a.getContentResolver().delete(LocalPhotoTagProvider.a, str2, arrayOfString);
        continue;
      }
      if (localMediaItem.e() != MediaItem.MediaType.PHOTO)
        continue;
      FacebookPhotoTagSet localFacebookPhotoTagSet = (FacebookPhotoTagSet)localMap.get(str1);
      ((PhotoItem)localMediaItem).a(localFacebookPhotoTagSet);
    }
    CropDatabaseHelper.a(paramMap, this.a.getContentResolver());
    localArrayList.addAll(paramMap.values());
    return localArrayList;
  }

  private Map<String, FacebookPhotoTagSet> a()
  {
    HashMap localHashMap = Maps.a();
    Cursor localCursor = this.a.getContentResolver().query(LocalPhotoTagProvider.a, this.a.n, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        String str = localCursor.getString(5);
        if (!localHashMap.containsKey(str))
          localHashMap.put(str, new FacebookPhotoTagSet());
        FacebookPhotoTag localFacebookPhotoTag = new FacebookPhotoTag("", localCursor.getLong(0), localCursor.getDouble(1), localCursor.getDouble(2), localCursor.getLong(3), localCursor.getString(4));
        ((FacebookPhotoTagSet)localHashMap.get(str)).a(localFacebookPhotoTag);
      }
      localCursor.close();
    }
    return localHashMap;
  }

  private List<VideoItem> b()
  {
    ArrayList localArrayList1 = Lists.a();
    Cursor localCursor = this.a.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, MediaPickerActivity.k(), null, null, "date_modified DESC");
    if (localCursor == null)
      MediaPickerActivity.c(this.a, true);
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = localArrayList1)
    {
      return localArrayList2;
      while (localCursor.moveToNext())
      {
        String str1 = localCursor.getString(2);
        if (str1 == null)
          continue;
        String str2 = localCursor.getString(1);
        if (str2 == null)
          continue;
        String str3 = localCursor.getString(3);
        if ((str3 == null) || (str3.startsWith("*/")))
        {
          str3 = MediaItemFactory.a(str2);
          if (str3 == null)
            continue;
        }
        localArrayList1.add(new VideoItem(localCursor.getLong(0), str2, str1, str3, localCursor.getLong(4), -1L));
      }
      localCursor.close();
    }
  }

  protected List<MediaItem> a(Context[] paramArrayOfContext)
  {
    MediaPickerActivity.b(this.a, false);
    MediaPickerActivity.c(this.a, false);
    Context localContext = paramArrayOfContext[0];
    Map localMap = MediaPickerActivity.a(this.a, localContext);
    ArrayList localArrayList = Lists.a();
    if (MediaPickerActivity.f(this.a).c())
      localArrayList.addAll(b());
    localArrayList.addAll(a(localMap));
    return localArrayList;
  }

  protected void a(List<MediaItem> paramList)
  {
    if ((MediaPickerActivity.g(this.a)) || (MediaPickerActivity.h(this.a)))
      MediaPickerActivity.d(this.a, MediaPickerActivity.h(this.a));
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        MediaPickerActivity.i(this.a).setVisibility(0);
        this.a.findViewById(2131297082).setVisibility(8);
      }
      while (true)
      {
        MediaPickerActivity.d(this.a).a(paramList);
        MediaPickerActivity.c(this.a).setMedia(paramList);
        MediaPickerActivity.c(this.a).a(this.a.f_());
        MediaPickerActivity.a(this.a, Maps.a());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MediaItem localMediaItem = (MediaItem)localIterator.next();
          MediaPickerActivity.j(this.a).put(Long.valueOf(localMediaItem.a()), localMediaItem);
        }
        MediaPickerActivity.i(this.a).setVisibility(8);
        if (MediaPickerActivity.f(this.a).a())
          continue;
        this.a.findViewById(2131297082).setVisibility(0);
      }
      this.a.findViewById(2131297085).setOnClickListener(this.a);
      MediaPickerActivity.k(this.a);
      MediaPickerActivity.l(this.a);
      MediaPickerActivity.d(this.a).a(MediaPickerActivity.m(this.a));
      MediaPickerActivity.c(this.a).setMode(MediaPickerActivity.m(this.a));
      if (MediaPickerActivity.n(this.a) > 0L)
        MediaPickerActivity.a(this.a, (MediaItem)MediaPickerActivity.j(this.a).get(Long.valueOf(MediaPickerActivity.n(this.a))), false, false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerActivity.LocalMediaLoader
 * JD-Core Version:    0.6.0
 */
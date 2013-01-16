package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FqlGetAlbums extends FqlMultiQuery
{
  protected List<FacebookAlbum> a;

  public FqlGetAlbums(Context paramContext, Intent paramIntent, String paramString, long paramLong1, String[] paramArrayOfString, ServiceOperationListener paramServiceOperationListener, long paramLong2, long paramLong3)
  {
    super(paramContext, paramIntent, paramString, a(paramContext, paramIntent, paramString, paramLong1, paramArrayOfString, paramLong2, paramLong3), paramServiceOperationListener);
  }

  protected static LinkedHashMap<String, FqlQuery> a(Context paramContext, Intent paramIntent, String paramString, long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfString == null);
    int j;
    for (int m = 1; ; m = j)
    {
      StringBuilder localStringBuilder;
      if (localArrayList.size() > 0)
      {
        localStringBuilder = new StringBuilder();
        StringUtils.a(localStringBuilder, ",", StringUtils.a, localArrayList.toArray());
      }
      for (String str1 = localStringBuilder.toString(); ; str1 = null)
      {
        if ((paramArrayOfString == null) || (localArrayList.size() > 0))
        {
          localLinkedHashMap.put("album_info", new PhotosGetAlbums(paramContext, paramIntent, paramString, paramLong1, str1, null, paramLong2, paramLong3));
          localLinkedHashMap.put("album_cover", new PhotosGetPhotos(paramContext, paramIntent, paramString, null, "#album_info", "cover_pid"));
        }
        if ((m != 0) && (paramLong2 == 0L))
        {
          localLinkedHashMap.put("tagged_photos", new FqlGetTaggedUserAlbum(paramContext, paramIntent, paramString, paramLong1, null));
          localLinkedHashMap.put("tagged_photos_cover", new PhotosGetPhotos(paramContext, paramIntent, paramString, null, PhotosGetPhotos.a("photo_tag", "pid", "subject=" + paramLong1, "created DESC", 0, 1)));
        }
        return localLinkedHashMap;
        int i = paramArrayOfString.length;
        j = 0;
        int k = 0;
        if (k >= i)
          break;
        String str2 = paramArrayOfString[k];
        if (!FqlGetTaggedUserAlbum.a(str2, paramLong1))
          localArrayList.add(str2);
        while (true)
        {
          k++;
          break;
          j = 1;
        }
      }
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
    PhotosGetAlbums localPhotosGetAlbums = (PhotosGetAlbums)c("album_info");
    PhotosGetPhotos localPhotosGetPhotos1 = (PhotosGetPhotos)c("album_cover");
    FacebookAlbum localFacebookAlbum;
    PhotosGetPhotos localPhotosGetPhotos2;
    if (localPhotosGetAlbums != null)
    {
      this.a = localPhotosGetAlbums.g();
      if (localPhotosGetPhotos1 != null)
        AlbumSyncModel.a(localPhotosGetPhotos1.g(), this.a);
      FqlGetTaggedUserAlbum localFqlGetTaggedUserAlbum = (FqlGetTaggedUserAlbum)c("tagged_photos");
      if (localFqlGetTaggedUserAlbum != null)
      {
        List localList1 = localFqlGetTaggedUserAlbum.g();
        if (!localList1.isEmpty())
        {
          localFacebookAlbum = (FacebookAlbum)localList1.get(0);
          this.a.add(localFacebookAlbum);
          localPhotosGetPhotos2 = (PhotosGetPhotos)c("tagged_photos_cover");
          if (localPhotosGetPhotos2 != null)
            break label192;
        }
      }
    }
    label192: for (List localList2 = null; ; localList2 = localPhotosGetPhotos2.g())
    {
      if ((localList2 != null) && (!localList2.isEmpty()))
      {
        FacebookPhoto localFacebookPhoto = (FacebookPhoto)localList2.get(0);
        localFacebookAlbum.a(localFacebookPhoto.h());
        localFacebookAlbum.b(localFacebookPhoto.a());
      }
      return;
      this.a = new ArrayList();
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetAlbums
 * JD-Core Version:    0.6.0
 */
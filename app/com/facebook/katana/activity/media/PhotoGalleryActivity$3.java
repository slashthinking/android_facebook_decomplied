package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookPhotoSet;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.service.method.GraphObjectLike.Operation;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageDecodeException;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;
import com.facebook.katana.util.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class PhotoGalleryActivity$3 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, long paramLong, Set<Long> paramSet, int paramInt2)
  {
    if ((paramInt1 == 200) && (paramException == null))
    {
      PhotoGalleryActivity.h(this.a).put(Long.valueOf(paramLong), new PhotoGalleryActivity.FeedbackData(paramSet, paramInt2));
      if (paramLong == PhotoGalleryActivity.i(this.a))
        PhotoGalleryActivity.a(this.a, paramSet, paramInt2);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, FacebookPhotoSet paramFacebookPhotoSet)
  {
    if (!StringUtils.a(paramString3, PhotoGalleryActivity.b(this.a)));
    while (true)
    {
      return;
      if ((paramInt == 200) && (paramException == null))
      {
        if (paramFacebookPhotoSet != null)
        {
          PhotoGalleryActivity.a(this.a, paramFacebookPhotoSet);
          continue;
        }
        PhotoGalleryActivity.a(this.a, FacebookPhotoSet.c(PhotoGalleryActivity.c(this.a)));
        continue;
      }
      ErrorReporting.a("photoset-gallery", "error loading photoset " + PhotoGalleryActivity.b(this.a) + " " + paramString2);
      if (PhotoGalleryActivity.d(this.a) != null)
        continue;
      Toaster.a(this.a, 2131363040);
      this.a.finish();
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, GraphObjectLike.Operation paramOperation)
  {
    while (true)
    {
      try
      {
        String str1 = (String)PhotoGalleryActivity.m(this.a).get(Long.valueOf(Long.parseLong(paramString3)));
        if (str1 != null)
        {
          FetchFeedbackResult localFetchFeedbackResult = PhotoGalleryActivity.n(this.a).d(str1);
          if ((localFetchFeedbackResult == null) || (localFetchFeedbackResult.a == null))
            continue;
          NewsFeedCache localNewsFeedCache = PhotoGalleryActivity.n(this.a);
          String str2 = localFetchFeedbackResult.a.legacyApiPostId;
          GraphQLProfile localGraphQLProfile = PhotoGalleryActivity.o(this.a);
          if (localFetchFeedbackResult.a.doesViewerLike)
            break label172;
          bool = true;
          localNewsFeedCache.a(str2, localGraphQLProfile, bool);
          break label171;
          PhotoGalleryActivity.p(this.a).a("NewsFeedCacheNoFeedback", "Graph object like cannot find feedback object, which is impossible");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        PhotoGalleryActivity.p(this.a).a("NUMBER FORMAT EXCEPTION", "object id cannot be converted to a long " + paramString3, true);
      }
      label171: return;
      label172: boolean bool = false;
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, String paramString4)
  {
    this.a.removeDialog(3);
    PhotoGalleryActivity.a(this.a, null);
    if (paramInt == 200)
      if (PhotoGalleryActivity.b(this.a) != null)
        FacebookPhotoSet.a(this.a, PhotoGalleryActivity.b(this.a));
    while (true)
    {
      return;
      String str = StringUtils.a(this.a, this.a.getString(2131363037), paramInt, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, String paramString4, long paramLong, byte[] paramArrayOfByte)
  {
    if (paramInt == 200);
    while (true)
    {
      try
      {
        Bitmap localBitmap = ImageUtils.b(paramArrayOfByte);
        PhotoGalleryActivity.f(this.a).a(Long.valueOf(paramLong), localBitmap);
        PhotoGalleryActivity.f(this.a).notifyDataSetChanged();
        return;
      }
      catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
      {
        Log.a("Out Of Memory. Failed to decode photo data.", localImageOutOfMemoryException);
        continue;
      }
      catch (ImageUtils.ImageDecodeException localImageDecodeException)
      {
        Log.a("Failed to decode photo data.", localImageDecodeException);
        continue;
      }
      Toaster.a(this.a, 2131363041);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<Long> paramList, Map<Long, List<FacebookPhotoTag>> paramMap)
  {
    if ((paramInt == 200) && (paramException == null))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        long l = ((Long)localEntry.getKey()).longValue();
        List localList = (List)localEntry.getValue();
        FacebookPhotoTagSet localFacebookPhotoTagSet = new FacebookPhotoTagSet();
        localFacebookPhotoTagSet.a(localList);
        PhotoGalleryActivity.j(this.a).put(Long.valueOf(l), localFacebookPhotoTagSet);
        if (PhotoGalleryActivity.i(this.a) != l)
          continue;
        PhotoGalleryActivity.a(this.a, localFacebookPhotoTagSet);
        if (PhotoGalleryActivity.k(this.a) != PhotoGalleryActivity.ViewMode.CONTROLS)
          continue;
        PhotoGalleryActivity.l(this.a);
      }
    }
  }

  public void c(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookPhoto> paramList)
  {
    if (!StringUtils.a(paramString1, PhotoGalleryActivity.e(this.a)));
    while (true)
    {
      return;
      if ((paramInt != 200) || (paramException != null))
      {
        ErrorReporting.a("photoset-gallery", "error loading metadata " + PhotoGalleryActivity.b(this.a) + " " + paramString2);
        continue;
      }
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FacebookPhoto localFacebookPhoto = (FacebookPhoto)localIterator.next();
        localHashMap.put(Long.valueOf(localFacebookPhoto.j()), localFacebookPhoto);
      }
      PhotoGalleryActivity.a(this.a, localHashMap);
      PhotoGalleryActivity.a(this.a, PhotoGalleryActivity.ViewMode.CONTROLS);
      PhotoGalleryActivity.f(this.a).notifyDataSetChanged();
    }
  }

  public void f(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    this.a.dismissDialog(1);
    if (paramInt == 200)
    {
      AppSession.a(this.a, PhotoGalleryActivity.g(this.a));
      Toaster.a(this.a, 2131363267);
    }
    while (true)
    {
      return;
      Toaster.a(this.a, 2131363266);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.3
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.service.method;

import android.app.Notification;
import android.content.Intent;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.SystemTrayNotificationManager;
import com.facebook.katana.binding.SystemTrayNotificationManager.MyNotification;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookVideoUploadResponse;
import com.facebook.katana.util.ReentrantCallback;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MediaUploaderController$MediaUploaderAppSessionListener extends AppSessionListener
{
  static
  {
    if (!MediaUploaderController.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      return;
    }
  }

  private MediaUploaderController$MediaUploaderAppSessionListener(MediaUploaderController paramMediaUploaderController)
  {
  }

  private void a()
  {
    MediaUploaderController.n(this.b).b(MediaUploaderController.m(this.b));
    Iterator localIterator1 = this.b.a.a().iterator();
    while (localIterator1.hasNext())
    {
      MediaUploaderController.MediaUploadListener localMediaUploadListener = (MediaUploaderController.MediaUploadListener)localIterator1.next();
      ArrayList localArrayList1 = Lists.a(MediaUploaderController.i(this.b));
      ArrayList localArrayList2 = Lists.a();
      Iterator localIterator2 = MediaUploaderController.c(this.b).iterator();
      String str1 = "0";
      String str2 = "MediaUploaderController";
      for (boolean bool1 = false; localIterator2.hasNext(); bool1 = true)
      {
        MediaUploaderController.VaultMediaUploadRequestState localVaultMediaUploadRequestState = (MediaUploaderController.VaultMediaUploadRequestState)localIterator2.next();
        localArrayList2.add(localVaultMediaUploadRequestState.e());
        str1 = localVaultMediaUploadRequestState.a();
        str2 = Long.toString(localVaultMediaUploadRequestState.g());
      }
      Iterator localIterator3 = MediaUploaderController.d(this.b).iterator();
      String str3 = str2;
      String str4 = str1;
      for (boolean bool2 = bool1; localIterator3.hasNext(); bool2 = false)
      {
        MediaUploaderController.FileMediaUploadRequestState localFileMediaUploadRequestState = (MediaUploaderController.FileMediaUploadRequestState)localIterator3.next();
        localArrayList2.add(localFileMediaUploadRequestState.e());
        str4 = localFileMediaUploadRequestState.a();
        str3 = localFileMediaUploadRequestState.d().l().getAbsolutePath();
      }
      if ((localArrayList2.size() > 0) && (MediaUploaderController.o(this.b).size() > 0))
      {
        MediaUploaderController.MediaUploadRequest localMediaUploadRequest = (MediaUploaderController.MediaUploadRequest)MediaUploaderController.o(this.b).get(0);
        Intent localIntent = localMediaUploadRequest.m();
        ArrayList localArrayList3 = Lists.a(MediaUploaderController.i(this.b));
        if ((localArrayList3 != null) && (localArrayList3.size() > 0))
          localIntent.putParcelableArrayListExtra("extra_media_unpublished_items", localArrayList3);
        String str5 = localMediaUploadRequest.b();
        localIntent.putExtra("extra_media_retry_waterfall_id", MediaUploaderController.h(this.b));
        a(str4, bool2, localIntent, str5, str3);
      }
      localMediaUploadListener.a(localArrayList1, localArrayList2);
    }
    MediaUploaderController.i(this.b).clear();
    MediaUploaderController.d(this.b).clear();
    MediaUploaderController.c(this.b).clear();
    MediaUploaderController.b(this.b).clear();
    MediaUploaderController.a(this.b).clear();
  }

  private void a(String paramString1, boolean paramBoolean, Intent paramIntent, String paramString2, String paramString3)
  {
    if (paramBoolean)
    {
      Map localMap = SystemTrayNotificationManager.a();
      Notification localNotification = new Notification(2130838952, null, System.currentTimeMillis());
      localNotification.flags = (0x2 | localNotification.flags);
      SystemTrayNotificationManager.MyNotification localMyNotification = new SystemTrayNotificationManager.MyNotification(100, localNotification, 0, paramString2, paramString3, 0, 10, 10);
      localMap.put(Integer.valueOf(Integer.parseInt(paramString1)), localMyNotification);
    }
    MediaUploaderController.n(this.b).a(paramString3, paramIntent);
    SystemTrayNotificationManager.a(MediaUploaderController.g(this.b), Integer.parseInt(paramString1), 500, paramString3, null, null, -1);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2, FacebookPhoto paramFacebookPhoto, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i;
    MediaUploaderController.VaultMediaUploadRequestState localVaultMediaUploadRequestState1;
    if (MediaUploaderController.a(this.b).containsKey(paramString1))
    {
      i = 1;
      MediaUploaderController.VaultMediaUploadRequestState localVaultMediaUploadRequestState3 = (MediaUploaderController.VaultMediaUploadRequestState)MediaUploaderController.a(this.b).get(paramString1);
      if ((!a) && (localVaultMediaUploadRequestState3 == null))
        throw new AssertionError();
      localVaultMediaUploadRequestState3.g();
      localVaultMediaUploadRequestState1 = localVaultMediaUploadRequestState3;
    }
    while (true)
    {
      MediaUploaderController.FileMediaUploadRequestState localFileMediaUploadRequestState1;
      Object localObject3;
      int j;
      Object localObject2;
      if ((paramInt1 != 200) || (paramFacebookPhoto == null) || (paramFacebookPhoto.j() == -1L))
      {
        Log.e("MediaUploaderController", "Error uploading photo: " + paramString2);
        Iterator localIterator1 = this.b.a.a().iterator();
        while (localIterator1.hasNext())
        {
          ((MediaUploaderController.MediaUploadListener)localIterator1.next()).a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramLong1, paramLong2);
          continue;
          if (!MediaUploaderController.b(this.b).containsKey(paramString1))
            break label531;
          localFileMediaUploadRequestState1 = (MediaUploaderController.FileMediaUploadRequestState)MediaUploaderController.b(this.b).get(paramString1);
          if ((a) || (localFileMediaUploadRequestState1 != null))
            break label853;
          throw new AssertionError();
        }
        if ((i == 0) || (paramFacebookPhoto.j() != -1L))
          break label838;
        Log.e("MediaUploaderController", "photo publish with vault id failed, falling back to upload");
        MediaUploaderController.FileMediaUploadRequestState localFileMediaUploadRequestState2 = new MediaUploaderController.FileMediaUploadRequestState(localVaultMediaUploadRequestState1);
        MediaUploaderController.a(this.b).remove(paramString1);
        localObject3 = null;
        j = 0;
        localObject2 = localFileMediaUploadRequestState2;
      }
      while (true)
      {
        int k;
        if (j != 0)
          k = ((MediaUploaderController.VaultMediaUploadRequestState)localObject3).b();
        while (true)
        {
          boolean bool;
          if (j != 0)
          {
            bool = ((MediaUploaderController.VaultMediaUploadRequestState)localObject3).f();
            label312: if ((k < 1) && (bool))
              break;
            if (j == 0)
              break label434;
            MediaUploaderController.c(this.b).add(localObject3);
            label341: monitorenter;
          }
          try
          {
            MediaUploaderController.e(this.b);
            monitorexit;
            Iterator localIterator2 = this.b.a.a().iterator();
            while (localIterator2.hasNext())
              ((MediaUploaderController.MediaUploadListener)localIterator2.next()).a(paramString1, paramInt1, paramString2, paramFacebookPhoto, paramString3, paramInt2, paramLong1, paramLong2, paramBoolean);
            k = ((MediaUploaderController.FileMediaUploadRequestState)localObject2).b();
            continue;
            bool = ((MediaUploaderController.FileMediaUploadRequestState)localObject2).f();
            break label312;
            label434: MediaUploaderController.d(this.b).add(localObject2);
            break label341;
          }
          finally
          {
            monitorexit;
          }
        }
        MediaUploaderController.f(this.b).b(true);
        if (j != 0)
        {
          Log.e("MediaUploaderController", "Re-try vault upload: " + k);
          MediaUploaderController.a(this.b).remove(paramString1);
          MediaUploaderController.a(this.b, MediaUploaderController.g(this.b), (MediaUploaderController.VaultMediaUploadRequestState)localObject3);
        }
        while (true)
        {
          label531: return;
          Log.e("MediaUploaderController", "Re-try file upload: " + k);
          MediaUploaderController.b(this.b).remove(paramString1);
          MediaUploaderController.a(this.b, MediaUploaderController.g(this.b), (MediaUploaderController.FileMediaUploadRequestState)localObject2, false);
        }
        if (i != 0)
        {
          MediaUploaderController.VaultMediaUploadRequestState localVaultMediaUploadRequestState2 = (MediaUploaderController.VaultMediaUploadRequestState)MediaUploaderController.a(this.b).get(paramString1);
          MediaUploaderController.MediaUnpublishedPhoto localMediaUnpublishedPhoto2 = new MediaUploaderController.MediaUnpublishedPhoto(MediaUploaderController.MediaUnpublishedPhoto.SourceType.FROM_VAULT, String.valueOf(localVaultMediaUploadRequestState2.g()), paramFacebookPhoto.j(), MediaUploaderController.h(this.b));
          MediaUploaderController.i(this.b).add(localMediaUnpublishedPhoto2);
          MediaUploaderController.a(this.b).remove(paramString1);
        }
        while (true)
        {
          while (true)
          {
            monitorenter;
            try
            {
              MediaUploaderController.e(this.b);
              monitorexit;
              break;
            }
            finally
            {
              localObject5 = finally;
              monitorexit;
              throw localObject5;
            }
          }
          MediaUploaderController.FileMediaUploadRequestState localFileMediaUploadRequestState3 = (MediaUploaderController.FileMediaUploadRequestState)MediaUploaderController.b(this.b).get(paramString1);
          MediaUploaderController.MediaUnpublishedPhoto localMediaUnpublishedPhoto1 = new MediaUploaderController.MediaUnpublishedPhoto(MediaUploaderController.MediaUnpublishedPhoto.SourceType.FROM_LOCAL_FILE, localFileMediaUploadRequestState3.g(), paramFacebookPhoto.j(), MediaUploaderController.h(this.b));
          MediaUploaderController.i(this.b).add(localMediaUnpublishedPhoto1);
          MediaUploaderController.b(this.b).remove(paramString1);
        }
        if (MediaUploaderController.j(this.b) >= MediaUploaderController.k(this.b).size());
        for (int m = 1; ; m = 0)
        {
          if ((m == 0) && (!MediaUploaderController.l(this.b)))
            Log.e("MediaUploaderController", "No more media items to upload. Wait for final callback.");
          if (m == 0)
            break;
          a();
          break;
        }
        label838: localObject2 = localObject1;
        localObject3 = localVaultMediaUploadRequestState1;
        j = i;
      }
      label853: localObject1 = localFileMediaUploadRequestState1;
      localVaultMediaUploadRequestState1 = null;
      i = 0;
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, FacebookVideoUploadResponse paramFacebookVideoUploadResponse, String paramString3, int paramInt2)
  {
  }

  public void a(MediaUploaderController.MediaUnpublishedPhoto paramMediaUnpublishedPhoto, String paramString)
  {
    MediaUploaderController.i(this.b).add(paramMediaUnpublishedPhoto);
    monitorenter;
    while (true)
    {
      try
      {
        MediaUploaderController.e(this.b);
        monitorexit;
        if (MediaUploaderController.j(this.b) >= MediaUploaderController.k(this.b).size())
        {
          i = 1;
          if (i != 0)
            continue;
          MediaUploaderController.l(this.b);
          if (i == 0)
            continue;
          a();
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      int i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController.MediaUploaderAppSessionListener
 * JD-Core Version:    0.6.0
 */
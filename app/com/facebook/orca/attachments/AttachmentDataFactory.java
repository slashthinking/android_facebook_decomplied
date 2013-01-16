package com.facebook.orca.attachments;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.webkit.MimeTypeMap;
import com.facebook.orca.audio.AudioClipDurationUtil;
import com.facebook.orca.auth.AuthDataStore;
import com.facebook.orca.auth.FacebookCredentials;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.facebook.orca.file.TempFileManager;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.media.MediaResource.Type;
import com.facebook.orca.share.ShareMedia;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.TitanAttachmentInfo;
import com.facebook.orca.threads.TitanAttachmentInfo.ImageData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Provider;

public class AttachmentDataFactory
{
  private static final Pattern a = Pattern.compile("_[ts]\\.jpg$");
  private static final Pattern b = Pattern.compile("\\/[ts]([^/]+\\.jpg)$");
  private final Provider<PlatformAppHttpConfig> c;
  private final AuthDataStore d;
  private final Context e;
  private final TempFileManager f;

  public AttachmentDataFactory(Provider<PlatformAppHttpConfig> paramProvider, AuthDataStore paramAuthDataStore, Context paramContext, TempFileManager paramTempFileManager)
  {
    this.c = paramProvider;
    this.d = paramAuthDataStore;
    this.e = paramContext;
    this.f = paramTempFileManager;
  }

  private Uri a(String paramString, TitanAttachmentInfo paramTitanAttachmentInfo)
  {
    Uri.Builder localBuilder = ((PlatformAppHttpConfig)this.c.b()).a();
    localBuilder.appendEncodedPath("method/messaging.getAttachment");
    localBuilder.appendQueryParameter("mid", paramString);
    if (paramTitanAttachmentInfo != null)
      localBuilder.appendQueryParameter("aid", paramTitanAttachmentInfo.a());
    while (true)
    {
      localBuilder.appendQueryParameter("access_token", this.d.c().a());
      localBuilder.appendQueryParameter("format", "binary");
      return localBuilder.build();
      localBuilder.appendQueryParameter("aid", "1");
    }
  }

  private ImageAttachmentData a(MediaResource paramMediaResource)
  {
    return new ImageAttachmentDataBuilder().a(paramMediaResource.c()).b(paramMediaResource.c()).f();
  }

  private ImageAttachmentData a(Message paramMessage, TitanAttachmentInfo paramTitanAttachmentInfo)
  {
    MediaResource localMediaResource;
    if (!paramMessage.y().isEmpty())
    {
      localMediaResource = (MediaResource)paramMessage.y().get(0);
      if (localMediaResource.b() != MediaResource.Type.PHOTO);
    }
    for (Uri localUri1 = localMediaResource.c(); ; localUri1 = null)
    {
      Uri localUri2 = a(paramMessage.a(), paramTitanAttachmentInfo);
      ImageAttachmentDataBuilder localImageAttachmentDataBuilder = new ImageAttachmentDataBuilder().b(localUri2).a(localUri2).c(localUri1);
      if ((paramTitanAttachmentInfo != null) && (paramTitanAttachmentInfo.f() != null))
      {
        TitanAttachmentInfo.ImageData localImageData = paramTitanAttachmentInfo.f();
        localImageAttachmentDataBuilder = localImageAttachmentDataBuilder.a(localImageData.a()).b(localImageData.b());
      }
      return localImageAttachmentDataBuilder.f();
    }
  }

  private boolean a(TitanAttachmentInfo paramTitanAttachmentInfo)
  {
    String str = paramTitanAttachmentInfo.c();
    if ((str != null) && (str.startsWith("image/")));
    for (int i = 1; ; i = 0)
      return i;
  }

  private AudioAttachmentData b(Message paramMessage, TitanAttachmentInfo paramTitanAttachmentInfo)
  {
    Uri localUri = a(paramMessage.a(), paramTitanAttachmentInfo);
    return new AudioAttachmentData(AudioClipDurationUtil.a(paramTitanAttachmentInfo.d()), localUri);
  }

  private ImageAttachmentData b(ShareMedia paramShareMedia)
  {
    Uri localUri1 = c(paramShareMedia);
    Uri localUri2 = d(paramShareMedia);
    return new ImageAttachmentDataBuilder().a(localUri1).b(localUri2).f();
  }

  private OtherAttachmentData b(MediaResource paramMediaResource)
  {
    File localFile = this.f.a("mms_media", MimeTypeMap.getSingleton().getExtensionFromMimeType(paramMediaResource.d()), Boolean.valueOf(true));
    ByteStreams.a(this.e.getContentResolver().openInputStream(paramMediaResource.c()), new FileOutputStream(localFile));
    return new OtherAttachmentData(paramMediaResource.e(), Ints.a(localFile.length()), paramMediaResource.d(), Uri.fromFile(localFile));
  }

  private boolean b(TitanAttachmentInfo paramTitanAttachmentInfo)
  {
    String str1 = paramTitanAttachmentInfo.c();
    String str2 = paramTitanAttachmentInfo.d();
    if ((str1 != null) && (str1.startsWith("audio/")) && (str2 != null) && (str2.startsWith("audioclip-")));
    for (int i = 1; ; i = 0)
      return i;
  }

  private Uri c(ShareMedia paramShareMedia)
  {
    return Uri.parse(paramShareMedia.d());
  }

  private OtherAttachmentData c(Message paramMessage, TitanAttachmentInfo paramTitanAttachmentInfo)
  {
    Uri localUri = a(paramMessage.a(), paramTitanAttachmentInfo);
    return new OtherAttachmentData(paramTitanAttachmentInfo.d(), paramTitanAttachmentInfo.e(), paramTitanAttachmentInfo.c(), localUri);
  }

  private boolean c(TitanAttachmentInfo paramTitanAttachmentInfo)
  {
    if ((!b(paramTitanAttachmentInfo)) && (!a(paramTitanAttachmentInfo)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private Uri d(ShareMedia paramShareMedia)
  {
    String str = paramShareMedia.d();
    Matcher localMatcher1 = a.matcher(str);
    if (localMatcher1.find())
      str = localMatcher1.replaceFirst("_n.jpg");
    Matcher localMatcher2 = b.matcher(str);
    if (localMatcher2.find())
      str = localMatcher2.replaceFirst("/n" + localMatcher2.group(1));
    return Uri.parse(str);
  }

  public Uri a(ThreadSummary paramThreadSummary)
  {
    if (paramThreadSummary.s());
    Uri.Builder localBuilder;
    for (Uri localUri = paramThreadSummary.r(); ; localUri = localBuilder.build())
    {
      return localUri;
      localBuilder = ((PlatformAppHttpConfig)this.c.b()).a();
      localBuilder.appendEncodedPath("method/messaging.getAttachment");
      localBuilder.appendQueryParameter("tid", paramThreadSummary.a());
      localBuilder.appendQueryParameter("hash", paramThreadSummary.p());
      localBuilder.appendQueryParameter("access_token", this.d.c().a());
      localBuilder.appendQueryParameter("format", "binary");
    }
  }

  public ImageAttachmentData a(ShareMedia paramShareMedia)
  {
    if ("photo".equals(paramShareMedia.c()));
    for (ImageAttachmentData localImageAttachmentData = b(paramShareMedia); ; localImageAttachmentData = null)
      return localImageAttachmentData;
  }

  public boolean a(Message paramMessage)
  {
    int i;
    if (paramMessage.r() == 4)
      i = 1;
    while (true)
    {
      return i;
      if ((paramMessage.m().isEmpty()) && (paramMessage.l().isEmpty()) && (paramMessage.n().isEmpty()) && (paramMessage.y().isEmpty()))
      {
        i = 0;
        continue;
      }
      Iterator localIterator1 = paramMessage.m().iterator();
      while (true)
        if (localIterator1.hasNext())
        {
          String str = ((TitanAttachmentInfo)localIterator1.next()).c();
          if ((str == null) || (!str.startsWith("image/")))
            continue;
          i = 1;
          break;
        }
      Iterator localIterator2 = paramMessage.l().iterator();
      while (true)
        if (localIterator2.hasNext())
        {
          MediaResource localMediaResource = (MediaResource)localIterator2.next();
          if (!MediaResource.Type.PHOTO.equals(localMediaResource.b()))
            continue;
          i = 1;
          break;
        }
      if (!paramMessage.y().isEmpty())
      {
        Iterator localIterator3 = paramMessage.y().iterator();
        while (true)
          if (localIterator3.hasNext())
          {
            if (((MediaResource)localIterator3.next()).b() != MediaResource.Type.PHOTO)
              continue;
            i = 1;
            break;
          }
      }
      i = 0;
    }
  }

  public ImmutableList<ImageAttachmentData> b(Message paramMessage)
  {
    ImmutableList localImmutableList;
    if (paramMessage.r() == 4)
      localImmutableList = ImmutableList.a(a(paramMessage, null));
    while (true)
    {
      return localImmutableList;
      if ((paramMessage.m().isEmpty()) && (paramMessage.l().isEmpty()) && (paramMessage.n().isEmpty()) && (paramMessage.y().isEmpty()))
      {
        localImmutableList = ImmutableList.d();
        continue;
      }
      ImmutableList.Builder localBuilder = ImmutableList.e();
      Iterator localIterator1 = paramMessage.m().iterator();
      while (localIterator1.hasNext())
      {
        TitanAttachmentInfo localTitanAttachmentInfo = (TitanAttachmentInfo)localIterator1.next();
        String str = localTitanAttachmentInfo.c();
        if ((str == null) || (!str.startsWith("image/")))
          continue;
        localBuilder.b(a(paramMessage, localTitanAttachmentInfo));
      }
      Iterator localIterator2 = paramMessage.l().iterator();
      while (localIterator2.hasNext())
      {
        MediaResource localMediaResource = (MediaResource)localIterator2.next();
        if (!MediaResource.Type.PHOTO.equals(localMediaResource.b()))
          continue;
        localBuilder.b(a(localMediaResource));
      }
      if ((paramMessage.m().isEmpty()) && (paramMessage.l().isEmpty()) && (!paramMessage.y().isEmpty()))
      {
        Iterator localIterator3 = paramMessage.y().iterator();
        while (localIterator3.hasNext())
          localBuilder.b(a((MediaResource)localIterator3.next()));
      }
      localImmutableList = localBuilder.b();
    }
  }

  public boolean c(Message paramMessage)
  {
    ImmutableList localImmutableList = paramMessage.m();
    int i = localImmutableList.size();
    boolean bool = false;
    if (i != 1);
    while (true)
    {
      return bool;
      bool = b((TitanAttachmentInfo)localImmutableList.get(0));
    }
  }

  public boolean d(Message paramMessage)
  {
    List localList = paramMessage.y();
    int i = localList.size();
    int j = 0;
    if (i != 1)
      return j;
    if (((MediaResource)localList.get(0)).b() == MediaResource.Type.AUDIO);
    for (int k = 1; ; k = 0)
    {
      j = k;
      break;
    }
  }

  public AudioAttachmentData e(Message paramMessage)
  {
    AudioAttachmentData localAudioAttachmentData;
    if (c(paramMessage))
      localAudioAttachmentData = b(paramMessage, (TitanAttachmentInfo)paramMessage.m().get(0));
    while (true)
    {
      return localAudioAttachmentData;
      if (d(paramMessage))
      {
        localAudioAttachmentData = new AudioAttachmentData(((MediaResource)paramMessage.y().get(0)).f(), null);
        continue;
      }
      localAudioAttachmentData = null;
    }
  }

  public boolean f(Message paramMessage)
  {
    int i;
    if ((paramMessage.m().isEmpty()) && (paramMessage.l().isEmpty()))
      i = 0;
    while (true)
    {
      return i;
      Iterator localIterator1 = paramMessage.m().iterator();
      while (true)
        if (localIterator1.hasNext())
        {
          TitanAttachmentInfo localTitanAttachmentInfo = (TitanAttachmentInfo)localIterator1.next();
          localTitanAttachmentInfo.c();
          if (a(localTitanAttachmentInfo))
            continue;
          i = 1;
          break;
        }
      Iterator localIterator2 = paramMessage.l().iterator();
      while (true)
        if (localIterator2.hasNext())
        {
          MediaResource localMediaResource = (MediaResource)localIterator2.next();
          if (MediaResource.Type.PHOTO.equals(localMediaResource.b()))
            continue;
          i = 1;
          break;
        }
      i = 0;
    }
  }

  public ImmutableList<OtherAttachmentData> g(Message paramMessage)
  {
    if ((paramMessage.m().isEmpty()) && (paramMessage.l().isEmpty()));
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      localBuilder = ImmutableList.e();
      Iterator localIterator1 = paramMessage.m().iterator();
      while (localIterator1.hasNext())
      {
        TitanAttachmentInfo localTitanAttachmentInfo = (TitanAttachmentInfo)localIterator1.next();
        if (a(localTitanAttachmentInfo))
          continue;
        localBuilder.b(c(paramMessage, localTitanAttachmentInfo));
      }
      Iterator localIterator2 = paramMessage.l().iterator();
      while (localIterator2.hasNext())
      {
        MediaResource localMediaResource = (MediaResource)localIterator2.next();
        if (MediaResource.Type.PHOTO.equals(localMediaResource.b()))
          continue;
        try
        {
          localBuilder.b(b(localMediaResource));
        }
        catch (IOException localIOException)
        {
        }
      }
    }
  }

  public boolean h(Message paramMessage)
  {
    int i;
    if (paramMessage.m().isEmpty())
      i = 0;
    while (true)
    {
      return i;
      Iterator localIterator = paramMessage.m().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          if (!c((TitanAttachmentInfo)localIterator.next()))
            continue;
          i = 1;
          break;
        }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.AttachmentDataFactory
 * JD-Core Version:    0.6.0
 */
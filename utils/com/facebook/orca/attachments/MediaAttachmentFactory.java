package com.facebook.orca.attachments;

import android.content.Context;
import android.net.Uri;
import com.facebook.orca.media.MediaResource;

public class MediaAttachmentFactory
{
  private static final Class<?> a = MediaAttachmentFactory.class;
  private final Context b;

  public MediaAttachmentFactory(Context paramContext)
  {
    this.b = paramContext;
  }

  public MediaAttachment a(MediaResource paramMediaResource)
  {
    Uri localUri = paramMediaResource.c();
    String str = localUri.getScheme();
    if (("content".equals(str)) || ("file".equals(str)))
      return new MediaAttachment(this.b, paramMediaResource);
    throw new UnknownAttachmentTypeException(localUri);
  }

  public MediaAttachment b(MediaResource paramMediaResource)
  {
    Object localObject = null;
    if (paramMediaResource != null)
    {
      Uri localUri = paramMediaResource.c();
      localObject = null;
      if (localUri != null)
        break label19;
    }
    while (true)
    {
      return localObject;
      try
      {
        label19: MediaAttachment localMediaAttachment = a(paramMediaResource);
        localObject = localMediaAttachment;
      }
      catch (UnknownAttachmentTypeException localUnknownAttachmentTypeException)
      {
        localObject = null;
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.MediaAttachmentFactory
 * JD-Core Version:    0.6.2
 */
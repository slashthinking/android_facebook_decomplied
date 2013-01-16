package com.facebook.orca.attachments;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.media.MediaResource;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MediaAttachment
{
  private final Class<?> a = MediaAttachment.class;
  private final Context b;
  private final MediaResource c;

  public MediaAttachment(Context paramContext, MediaResource paramMediaResource)
  {
    this.b = paramContext;
    this.c = paramMediaResource;
    String str = this.c.c().getScheme();
    if ((Objects.equal("content", str)) || (Objects.equal("file", str)));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }

  public MediaResource a()
  {
    return this.c;
  }

  public InputStream b()
  {
    String str = this.c.c().getScheme();
    if (Objects.equal("content", str));
    for (Object localObject = this.b.getContentResolver().openInputStream(a().c()); ; localObject = new FileInputStream(a().c().getPath()))
    {
      return localObject;
      if (!Objects.equal("file", str))
        break;
    }
    throw new RuntimeException("Unexpected scheme");
  }

  public InputSupplier<? extends InputStream> c()
  {
    String str = this.c.c().getScheme();
    if (Objects.equal("content", str));
    for (Object localObject = new MediaAttachment.1(this); ; localObject = Files.a(new File(a().c().getPath())))
    {
      return localObject;
      if (!Objects.equal("file", str))
        break;
    }
    throw new RuntimeException("Unexpected scheme");
  }

  public String d()
  {
    switch (MediaAttachment.2.a[this.c.b().ordinal()])
    {
    default:
      BLog.b(this.a, "Unexpected attachment type");
      throw new UnsupportedOperationException("Unexpected attachment type");
    case 1:
    case 2:
      for (String str = "me/photos"; ; str = "me/videos")
        return str;
    case 3:
    }
    BLog.b(this.a, "Audio shares are not implemented");
    throw new UnsupportedOperationException("Audio shares are not implemented");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.MediaAttachment
 * JD-Core Version:    0.6.2
 */
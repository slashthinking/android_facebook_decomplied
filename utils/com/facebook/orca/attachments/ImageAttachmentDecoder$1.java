package com.facebook.orca.attachments;

import android.content.Context;
import com.google.common.io.OutputSupplier;
import java.io.File;
import java.io.OutputStream;

class ImageAttachmentDecoder$1
  implements OutputSupplier<OutputStream>
{
  ImageAttachmentDecoder$1(ImageAttachmentDecoder paramImageAttachmentDecoder, File paramFile)
  {
  }

  public OutputStream a()
  {
    return ImageAttachmentDecoder.a(this.b).openFileOutput(this.a.getName(), 0);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.ImageAttachmentDecoder.1
 * JD-Core Version:    0.6.2
 */
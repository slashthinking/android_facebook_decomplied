package com.facebook.orca.attachments;

import android.net.Uri;

public class UnknownAttachmentTypeException extends Exception
{
  private final Uri uri;

  UnknownAttachmentTypeException(Uri paramUri)
  {
    super("Unknown attachment type: " + paramUri);
    this.uri = paramUri;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.UnknownAttachmentTypeException
 * JD-Core Version:    0.6.2
 */
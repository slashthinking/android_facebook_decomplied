package com.facebook.orca.sms;

import com.facebook.orca.media.MediaResource;

class MmsContentResolverHandler$MmsPart
{
  final String a;
  final MediaResource b;

  private MmsContentResolverHandler$MmsPart(String paramString, MediaResource paramMediaResource)
  {
    this.a = paramString;
    this.b = paramMediaResource;
  }

  static MmsPart a(MediaResource paramMediaResource)
  {
    return new MmsPart(null, paramMediaResource);
  }

  static MmsPart a(String paramString)
  {
    return new MmsPart(paramString, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsContentResolverHandler.MmsPart
 * JD-Core Version:    0.6.0
 */
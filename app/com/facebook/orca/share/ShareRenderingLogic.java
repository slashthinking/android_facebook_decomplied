package com.facebook.orca.share;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.threads.Message;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public class ShareRenderingLogic
{
  public Share a(Message paramMessage)
  {
    Share localShare;
    if (paramMessage.n().isEmpty())
      localShare = null;
    while (true)
    {
      return localShare;
      localShare = (Share)paramMessage.n().get(0);
      if (!StringUtil.a(localShare.a()))
        continue;
      localShare = null;
    }
  }

  public ShareMedia a(Share paramShare)
  {
    Iterator localIterator = paramShare.d().iterator();
    ShareMedia localShareMedia;
    if (localIterator.hasNext())
    {
      localShareMedia = (ShareMedia)localIterator.next();
      if (!"link".equals(localShareMedia.c()));
    }
    while (true)
    {
      return localShareMedia;
      if ("photo".equals(localShareMedia.c()))
        continue;
      if (!"video".equals(localShareMedia.c()))
        break;
      continue;
      localShareMedia = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareRenderingLogic
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.threads;

import android.content.res.Resources;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.media.MediaResource.Type;
import java.util.List;

public class ThreadSnippetUtil
{
  Resources a;

  public ThreadSnippetUtil(Resources paramResources)
  {
    this.a = paramResources;
  }

  public String a(Message paramMessage)
  {
    List localList;
    String str;
    if (((!paramMessage.i()) || ((paramMessage.i()) && (paramMessage.h().length() == 0))) && (paramMessage.w() != null) && (paramMessage.w().equals("mms")))
    {
      localList = paramMessage.l();
      if (localList.size() > 0)
        if (localList.size() > 1)
        {
          Resources localResources3 = this.a;
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = paramMessage.f().d();
          str = localResources3.getString(2131362733, arrayOfObject3);
        }
    }
    while (true)
    {
      return str;
      MediaResource localMediaResource = (MediaResource)localList.get(0);
      if (MediaResource.Type.PHOTO.equals(localMediaResource.b()))
      {
        Resources localResources2 = this.a;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = paramMessage.f().d();
        str = localResources2.getString(2131362734, arrayOfObject2);
        continue;
      }
      Resources localResources1 = this.a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramMessage.f().d();
      str = localResources1.getString(2131362735, arrayOfObject1);
      continue;
      str = paramMessage.g();
      if (!StringUtil.a(str))
        continue;
      str = paramMessage.h();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadSnippetUtil
 * JD-Core Version:    0.6.0
 */
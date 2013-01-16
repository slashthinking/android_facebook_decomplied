package com.facebook.katana.service.method;

import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import com.facebook.katana.model.FacebookUserWithLargeProfilePic;
import com.facebook.katana.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ContactRemoteInfoFetcher$ContactObserverSessionListener extends AppSessionListener
{
  private ContactRemoteInfoFetcher$ContactObserverSessionListener(ContactRemoteInfoFetcher paramContactRemoteInfoFetcher)
  {
  }

  public void f(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookPhonebookContact> paramList)
  {
    Log.e(ContactRemoteInfoFetcher.b(), "PhonebookLookup API responded");
    if ((!paramString1.equals(ContactRemoteInfoFetcher.a(this.a))) || (ContactRemoteInfoFetcher.b(this.a) == null));
    while (true)
    {
      return;
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FacebookPhonebookContact localFacebookPhonebookContact1 = (FacebookPhonebookContact)localIterator.next();
        if ((localFacebookPhonebookContact1 == null) || (localFacebookPhonebookContact1.isFriend))
          continue;
        if (localFacebookPhonebookContact1.userId == 0L)
        {
          FacebookPhonebookContact localFacebookPhonebookContact2 = (FacebookPhonebookContact)ContactRemoteInfoFetcher.b(this.a).get(Long.valueOf(localFacebookPhonebookContact1.recordId));
          if (localFacebookPhonebookContact2 == null)
            continue;
          localFacebookPhonebookContact1.name = localFacebookPhonebookContact2.name;
          if ((localFacebookPhonebookContact1.email == null) && (localFacebookPhonebookContact1.phone == null))
            continue;
          localHashMap2.put(Long.valueOf(localFacebookPhonebookContact1.recordId), localFacebookPhonebookContact1);
          continue;
        }
        localHashMap1.put(Long.valueOf(localFacebookPhonebookContact1.userId), localFacebookPhonebookContact1);
      }
      ContactRemoteInfoFetcher.a(this.a, localHashMap2);
      ContactRemoteInfoFetcher.b(this.a, localHashMap1);
      this.a.a(paramInt, paramString2, paramException);
    }
  }

  public void h(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookUser> paramList)
  {
    Log.e(ContactRemoteInfoFetcher.b(), "PhonebookLookup FQL responded");
    if ((!paramString1.equals(ContactRemoteInfoFetcher.c(this.a))) || (ContactRemoteInfoFetcher.d(this.a) == null));
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FacebookUser localFacebookUser = (FacebookUser)localIterator.next();
        if ((localFacebookUser instanceof FacebookUserWithLargeProfilePic))
        {
          FacebookUserWithLargeProfilePic localFacebookUserWithLargeProfilePic = (FacebookUserWithLargeProfilePic)localFacebookUser;
          if ((localFacebookUserWithLargeProfilePic.mUserId <= 0L) || (StringUtils.c(localFacebookUserWithLargeProfilePic.mDisplayName)))
            continue;
          FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)ContactRemoteInfoFetcher.d(this.a).get(Long.valueOf(localFacebookUserWithLargeProfilePic.mUserId));
          if (localFacebookPhonebookContact == null)
            continue;
          localArrayList.add(new FacebookPhonebookContactUser(localFacebookPhonebookContact, localFacebookUserWithLargeProfilePic));
          continue;
        }
        Assert.b(false);
      }
      ContactRemoteInfoFetcher.a(this.a, localArrayList);
      this.a.b(paramInt, paramString2, paramException);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ContactRemoteInfoFetcher.ContactObserverSessionListener
 * JD-Core Version:    0.6.0
 */
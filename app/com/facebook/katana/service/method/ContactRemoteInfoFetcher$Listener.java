package com.facebook.katana.service.method;

import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import java.util.List;
import java.util.Map;

public abstract interface ContactRemoteInfoFetcher$Listener
{
  public abstract void a(List<FacebookPhonebookContactUser> paramList, int paramInt, String paramString, Exception paramException);

  public abstract void a(Map<Long, FacebookPhonebookContact> paramMap);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ContactRemoteInfoFetcher.Listener
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.service.method;

import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import java.util.List;
import java.util.Map;

public class ContinuousImport$ContactRemoteInfoFetcherListener extends AppSessionListener
  implements ContactRemoteInfoFetcher.Listener
{
  protected ContinuousImport$ContactRemoteInfoFetcherListener(ContinuousImport paramContinuousImport)
  {
  }

  public void a(List<FacebookPhonebookContactUser> paramList, int paramInt, String paramString, Exception paramException)
  {
    Log.e(ContinuousImport.m(), "Friends are ready");
    ContinuousImport.a(this.a, paramList);
    if ((paramInt == 200) && (paramException == null))
    {
      this.a.a(ContinuousImport.b(this.a).values());
      this.a.b(ContinuousImport.c(this.a).values());
    }
    this.a.j();
    this.a.a(this.a, paramInt, paramString, paramException);
  }

  public void a(Map<Long, FacebookPhonebookContact> paramMap)
  {
    Log.e(ContinuousImport.m(), "Invites are ready");
    ContinuousImport.a(this.a, paramMap);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ContinuousImport.ContactRemoteInfoFetcherListener
 * JD-Core Version:    0.6.0
 */
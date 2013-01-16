package com.facebook.katana.activity.findfriends;

import android.os.AsyncTask;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.util.PhonebookUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FindFriendsActivity$GetPhoneBookTask extends AsyncTask<Void, Void, List<FacebookPhonebookContact>>
{
  private FindFriendsActivity$GetPhoneBookTask(FindFriendsActivity paramFindFriendsActivity)
  {
  }

  protected List<FacebookPhonebookContact> a(Void[] paramArrayOfVoid)
  {
    return FindFriendsActivity.i(this.a).a();
  }

  protected void a(List<FacebookPhonebookContact> paramList)
  {
    FindFriendsActivity.b(this.a, new HashMap());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)localIterator.next();
      FindFriendsActivity.j(this.a).put(Long.valueOf(localFacebookPhonebookContact.recordId), localFacebookPhonebookContact);
    }
    this.a.A();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.FindFriendsActivity.GetPhoneBookTask
 * JD-Core Version:    0.6.0
 */
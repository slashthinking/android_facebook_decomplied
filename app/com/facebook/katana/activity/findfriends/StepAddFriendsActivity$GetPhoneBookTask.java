package com.facebook.katana.activity.findfriends;

import android.os.AsyncTask;
import android.os.SystemClock;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.util.PhonebookUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class StepAddFriendsActivity$GetPhoneBookTask extends AsyncTask<Void, Void, List<FacebookPhonebookContact>>
{
  private StepAddFriendsActivity$GetPhoneBookTask(StepAddFriendsActivity paramStepAddFriendsActivity)
  {
  }

  protected List<FacebookPhonebookContact> a(Void[] paramArrayOfVoid)
  {
    return StepAddFriendsActivity.f(this.a).a();
  }

  protected void a(List<FacebookPhonebookContact> paramList)
  {
    StepAddFriendsActivity.a(this.a, new HashMap());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)localIterator.next();
      StepAddFriendsActivity.g(this.a).put(Long.valueOf(localFacebookPhonebookContact.recordId), localFacebookPhonebookContact);
    }
    StepAddFriendsActivity.j(this.a).a(new FindFriendsAnalyticsEvent("add_friends").i("phonebook").c(StepAddFriendsActivity.i(this.a)).b(SystemClock.elapsedRealtime() - StepAddFriendsActivity.h(this.a)).a(StepAddFriendsActivity.g(this.a).size()));
    this.a.o();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepAddFriendsActivity.GetPhoneBookTask
 * JD-Core Version:    0.6.0
 */
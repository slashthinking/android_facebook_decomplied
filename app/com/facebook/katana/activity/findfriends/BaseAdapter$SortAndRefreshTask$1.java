package com.facebook.katana.activity.findfriends;

import com.facebook.katana.model.FacebookPhonebookContact;
import java.util.Comparator;

class BaseAdapter$SortAndRefreshTask$1
  implements Comparator<FacebookPhonebookContact>
{
  public int a(FacebookPhonebookContact paramFacebookPhonebookContact1, FacebookPhonebookContact paramFacebookPhonebookContact2)
  {
    return paramFacebookPhonebookContact1.name.toLowerCase().compareTo(paramFacebookPhonebookContact2.name.toLowerCase());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.BaseAdapter.SortAndRefreshTask.1
 * JD-Core Version:    0.6.0
 */
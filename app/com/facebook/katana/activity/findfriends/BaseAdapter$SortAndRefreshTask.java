package com.facebook.katana.activity.findfriends;

import android.os.AsyncTask;
import com.facebook.katana.model.FacebookPhonebookContact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class BaseAdapter$SortAndRefreshTask extends AsyncTask<List<? extends FacebookPhonebookContact>, Void, List<? extends FacebookPhonebookContact>>
{
  private BaseAdapter$SortAndRefreshTask(BaseAdapter paramBaseAdapter)
  {
  }

  protected List<? extends FacebookPhonebookContact> a(List<? extends FacebookPhonebookContact>[] paramArrayOfList)
  {
    BaseAdapter.SortAndRefreshTask.1 local1 = new BaseAdapter.SortAndRefreshTask.1(this);
    ArrayList localArrayList = new ArrayList(paramArrayOfList[0]);
    Collections.sort(localArrayList, local1);
    return localArrayList;
  }

  protected void a(List<? extends FacebookPhonebookContact> paramList)
  {
    List localList = b(paramList);
    this.a.a = new ArrayList(paramList);
    this.a.c = localList;
    this.a.e.clear();
    this.a.j();
  }

  protected List<BaseAdapter.FirstLetterFriendSection> b(List<? extends FacebookPhonebookContact> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramList.size() == 0);
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = localArrayList1)
    {
      return localArrayList2;
      Iterator localIterator = paramList.iterator();
      int i = 0;
      int j = -1;
      Object localObject = "";
      int k = -1;
      while (localIterator.hasNext())
      {
        FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)localIterator.next();
        k++;
        String str = localFacebookPhonebookContact.name.substring(0, 1).toUpperCase();
        if (((String)localObject).equals(str))
        {
          i++;
          continue;
        }
        if (j >= 0)
          localArrayList1.add(new BaseAdapter.FirstLetterFriendSection((String)localObject, j, i));
        i = 1;
        j = k;
        localObject = str;
      }
      localArrayList1.add(new BaseAdapter.FirstLetterFriendSection((String)localObject, j, i));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.BaseAdapter.SortAndRefreshTask
 * JD-Core Version:    0.6.0
 */
package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LocalBroadcastManager
{
  private static final Object f = new Object();
  private static LocalBroadcastManager g;
  private final Context a;
  private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap();
  private final HashMap<String, ArrayList<LocalBroadcastManager.ReceiverRecord>> c = new HashMap();
  private final ArrayList<LocalBroadcastManager.BroadcastRecord> d = new ArrayList();
  private final Handler e;

  private LocalBroadcastManager(Context paramContext)
  {
    this.a = paramContext;
    this.e = new LocalBroadcastManager.1(this, paramContext.getMainLooper());
  }

  public static LocalBroadcastManager a(Context paramContext)
  {
    synchronized (f)
    {
      if (g == null)
        g = new LocalBroadcastManager(paramContext.getApplicationContext());
      LocalBroadcastManager localLocalBroadcastManager = g;
      return localLocalBroadcastManager;
    }
  }

  private void a()
  {
    while (true)
    {
      int j;
      synchronized (this.b)
      {
        int i = this.d.size();
        if (i <= 0)
          return;
        LocalBroadcastManager.BroadcastRecord[] arrayOfBroadcastRecord = new LocalBroadcastManager.BroadcastRecord[i];
        this.d.toArray(arrayOfBroadcastRecord);
        this.d.clear();
        j = 0;
        if (j >= arrayOfBroadcastRecord.length)
          continue;
        LocalBroadcastManager.BroadcastRecord localBroadcastRecord = arrayOfBroadcastRecord[j];
        int k = 0;
        if (k < localBroadcastRecord.b.size())
        {
          ((LocalBroadcastManager.ReceiverRecord)localBroadcastRecord.b.get(k)).b.onReceive(this.a, localBroadcastRecord.a);
          k++;
        }
      }
      j++;
    }
  }

  public void a(BroadcastReceiver paramBroadcastReceiver)
  {
    while (true)
    {
      int j;
      synchronized (this.b)
      {
        ArrayList localArrayList1 = (ArrayList)this.b.remove(paramBroadcastReceiver);
        if (localArrayList1 != null)
          break label179;
        break label178;
        if (i >= localArrayList1.size())
          continue;
        IntentFilter localIntentFilter = (IntentFilter)localArrayList1.get(i);
        j = 0;
        if (j >= localIntentFilter.countActions())
          break label200;
        String str = localIntentFilter.getAction(j);
        ArrayList localArrayList2 = (ArrayList)this.c.get(str);
        if (localArrayList2 == null)
          break label194;
        k = 0;
        if (k >= localArrayList2.size())
          continue;
        if (((LocalBroadcastManager.ReceiverRecord)localArrayList2.get(k)).b == paramBroadcastReceiver)
        {
          localArrayList2.remove(k);
          m = k - 1;
          break label185;
          if (localArrayList2.size() > 0)
            break label194;
          this.c.remove(str);
          break label194;
        }
      }
      int m = k;
      break label185;
      label178: return;
      label179: int i = 0;
      continue;
      label185: int k = m + 1;
      continue;
      label194: j++;
      continue;
      label200: i++;
    }
  }

  public void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.b)
    {
      LocalBroadcastManager.ReceiverRecord localReceiverRecord = new LocalBroadcastManager.ReceiverRecord(paramIntentFilter, paramBroadcastReceiver);
      ArrayList localArrayList1 = (ArrayList)this.b.get(paramBroadcastReceiver);
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList(1);
        this.b.put(paramBroadcastReceiver, localArrayList1);
      }
      localArrayList1.add(paramIntentFilter);
      for (int i = 0; i < paramIntentFilter.countActions(); i++)
      {
        String str = paramIntentFilter.getAction(i);
        ArrayList localArrayList2 = (ArrayList)this.c.get(str);
        if (localArrayList2 == null)
        {
          localArrayList2 = new ArrayList(1);
          this.c.put(str, localArrayList2);
        }
        localArrayList2.add(localReceiverRecord);
      }
      return;
    }
  }

  public boolean a(Intent paramIntent)
  {
    int j;
    while (true)
    {
      int k;
      int n;
      synchronized (this.b)
      {
        String str1 = paramIntent.getAction();
        String str2 = paramIntent.resolveTypeIfNeeded(this.a.getContentResolver());
        Uri localUri = paramIntent.getData();
        String str3 = paramIntent.getScheme();
        Set localSet = paramIntent.getCategories();
        if ((0x8 & paramIntent.getFlags()) == 0)
          break label523;
        i = 1;
        if (i == 0)
          continue;
        Log.v("LocalBroadcastManager", "Resolving type " + str2 + " scheme " + str3 + " of intent " + paramIntent);
        ArrayList localArrayList = (ArrayList)this.c.get(paramIntent.getAction());
        if (localArrayList == null)
          continue;
        if (i == 0)
          continue;
        Log.v("LocalBroadcastManager", "Action list: " + localArrayList);
        continue;
        if (k >= localArrayList.size())
          break label564;
        LocalBroadcastManager.ReceiverRecord localReceiverRecord = (LocalBroadcastManager.ReceiverRecord)localArrayList.get(k);
        if (i == 0)
          continue;
        Log.v("LocalBroadcastManager", "Matching against filter " + localReceiverRecord.a);
        if (!localReceiverRecord.c)
          continue;
        if (i == 0)
          break label529;
        Log.v("LocalBroadcastManager", "  Filter's target already added");
        localObject3 = localObject2;
        continue;
        n = localReceiverRecord.a.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
        if (n < 0)
          continue;
        if (i == 0)
          continue;
        Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(n));
        if (localObject2 != null)
          continue;
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localReceiverRecord);
        localReceiverRecord.c = true;
      }
      Object localObject2 = localObject3;
      continue;
      label523: int i = 0;
      continue;
      label529: Object localObject3 = localObject2;
      continue;
      String str4 = "action";
      continue;
      str4 = "category";
      continue;
      str4 = "data";
      continue;
      str4 = "type";
      continue;
      label564: if (localObject2 == null)
        continue;
      int m = 0;
    }
    return j;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.content.LocalBroadcastManager
 * JD-Core Version:    0.6.0
 */
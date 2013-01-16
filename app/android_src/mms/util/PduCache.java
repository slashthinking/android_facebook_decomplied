package android_src.mms.util;

import android.content.ContentUris;
import android.content.UriMatcher;
import android.net.Uri;
import android_src.provider.Telephony.Mms;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class PduCache extends AbstractCache<Uri, PduCacheEntry>
{
  private static final UriMatcher a = new UriMatcher(-1);
  private static final HashMap<Integer, Integer> b;
  private static PduCache c;
  private final HashMap<Integer, HashSet<Uri>> d = new HashMap();
  private final HashMap<Long, HashSet<Uri>> e = new HashMap();

  static
  {
    a.addURI("mms", null, 0);
    a.addURI("mms", "#", 1);
    a.addURI("mms", "inbox", 2);
    a.addURI("mms", "inbox/#", 3);
    a.addURI("mms", "sent", 4);
    a.addURI("mms", "sent/#", 5);
    a.addURI("mms", "drafts", 6);
    a.addURI("mms", "drafts/#", 7);
    a.addURI("mms", "outbox", 8);
    a.addURI("mms", "outbox/#", 9);
    a.addURI("mms-sms", "conversations", 10);
    a.addURI("mms-sms", "conversations/#", 11);
    b = new HashMap();
    b.put(Integer.valueOf(2), Integer.valueOf(1));
    b.put(Integer.valueOf(4), Integer.valueOf(2));
    b.put(Integer.valueOf(6), Integer.valueOf(3));
    b.put(Integer.valueOf(8), Integer.valueOf(4));
  }

  private void a(long paramLong)
  {
    HashSet localHashSet = (HashSet)this.e.remove(Long.valueOf(paramLong));
    if (localHashSet != null)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        Uri localUri = (Uri)localIterator.next();
        PduCacheEntry localPduCacheEntry = (PduCacheEntry)super.b(localUri);
        if (localPduCacheEntry == null)
          continue;
        c(localUri, localPduCacheEntry);
      }
    }
  }

  private void a(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      HashSet localHashSet = (HashSet)this.d.remove(paramInteger);
      if (localHashSet != null)
      {
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext())
        {
          Uri localUri = (Uri)localIterator.next();
          PduCacheEntry localPduCacheEntry = (PduCacheEntry)super.b(localUri);
          if (localPduCacheEntry == null)
            continue;
          b(localUri, localPduCacheEntry);
        }
      }
    }
  }

  public static final PduCache b()
  {
    monitorenter;
    try
    {
      if (c == null)
        c = new PduCache();
      PduCache localPduCache = c;
      monitorexit;
      return localPduCache;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private PduCacheEntry b(Uri paramUri)
  {
    PduCacheEntry localPduCacheEntry = (PduCacheEntry)super.b(paramUri);
    if (localPduCacheEntry != null)
    {
      b(paramUri, localPduCacheEntry);
      c(paramUri, localPduCacheEntry);
    }
    while (true)
    {
      return localPduCacheEntry;
      localPduCacheEntry = null;
    }
  }

  private void b(Uri paramUri, PduCacheEntry paramPduCacheEntry)
  {
    HashSet localHashSet = (HashSet)this.e.get(Long.valueOf(paramPduCacheEntry.c()));
    if (localHashSet != null)
      localHashSet.remove(paramUri);
  }

  private Uri c(Uri paramUri)
  {
    switch (a.match(paramUri))
    {
    case 2:
    case 4:
    case 6:
    case 8:
    default:
    case 1:
    case 3:
    case 5:
    case 7:
    case 9:
    }
    String str;
    for (paramUri = null; ; paramUri = Uri.withAppendedPath(Telephony.Mms.a, str))
    {
      return paramUri;
      str = paramUri.getLastPathSegment();
    }
  }

  private void c(Uri paramUri, PduCacheEntry paramPduCacheEntry)
  {
    HashSet localHashSet = (HashSet)this.e.get(Long.valueOf(paramPduCacheEntry.b()));
    if (localHashSet != null)
      localHashSet.remove(paramUri);
  }

  public PduCacheEntry a(Uri paramUri)
  {
    monitorenter;
    try
    {
      int i = a.match(paramUri);
      PduCacheEntry localPduCacheEntry;
      switch (i)
      {
      default:
        localPduCacheEntry = null;
      case 1:
      case 3:
      case 5:
      case 7:
      case 9:
      case 0:
      case 10:
      case 2:
      case 4:
      case 6:
      case 8:
      case 11:
      }
      while (true)
      {
        return localPduCacheEntry;
        localPduCacheEntry = b(paramUri);
        continue;
        String str = paramUri.getLastPathSegment();
        localPduCacheEntry = b(Uri.withAppendedPath(Telephony.Mms.a, str));
        continue;
        a();
        localPduCacheEntry = null;
        continue;
        a((Integer)b.get(Integer.valueOf(i)));
        localPduCacheEntry = null;
        continue;
        a(ContentUris.parseId(paramUri));
        localPduCacheEntry = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a()
  {
    monitorenter;
    try
    {
      super.a();
      this.d.clear();
      this.e.clear();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean a(Uri paramUri, PduCacheEntry paramPduCacheEntry)
  {
    monitorenter;
    while (true)
    {
      HashSet localHashSet1;
      try
      {
        int i = paramPduCacheEntry.b();
        localHashSet1 = (HashSet)this.d.get(Integer.valueOf(i));
        if (localHashSet1 == null)
        {
          HashSet localHashSet2 = new HashSet();
          this.d.put(Integer.valueOf(i), localHashSet2);
          localHashSet3 = localHashSet2;
          long l = paramPduCacheEntry.c();
          HashSet localHashSet4 = (HashSet)this.e.get(Long.valueOf(l));
          if (localHashSet4 != null)
            continue;
          localHashSet4 = new HashSet();
          this.e.put(Long.valueOf(l), localHashSet4);
          Uri localUri = c(paramUri);
          boolean bool = super.a(localUri, paramPduCacheEntry);
          if (!bool)
            continue;
          localHashSet3.add(localUri);
          localHashSet4.add(localUri);
          monitorexit;
          return bool;
        }
      }
      finally
      {
        localObject = finally;
        monitorexit;
        throw localObject;
      }
      HashSet localHashSet3 = localHashSet1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.PduCache
 * JD-Core Version:    0.6.0
 */
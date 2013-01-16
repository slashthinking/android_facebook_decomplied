package com.facebook.orca.prefs;

import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;

public class OrcaSharedPreferencesImpl
  implements OrcaSharedPreferences
{
  private static final Class<?> a = OrcaSharedPreferences.class;
  private static final String[] b = { "key", "type", "value" };
  private static final Object t = new Object();
  private final Context c;
  private final ContentResolver d;
  private final AndroidThreadUtil e;
  private final OrcaSharedPreferencesContract f;
  private SharedPreferences g;
  private final TreeMap<PrefKey, Object> h;
  private final Map<PrefKey, Object> i;
  private final Set<String> j;
  private final Set<String> k;
  private final Map<OrcaSharedPreferences.OnSharedPreferenceChangeListener, Integer> l;
  private final List<Runnable> m;
  private boolean n;
  private boolean o;
  private final Object p = new Object();
  private boolean q;
  private final SharedPreferences.OnSharedPreferenceChangeListener r;
  private final BroadcastReceiver s;

  public OrcaSharedPreferencesImpl(Context paramContext, ContentResolver paramContentResolver, AndroidThreadUtil paramAndroidThreadUtil, SharedPreferences paramSharedPreferences, OrcaSharedPreferencesContract paramOrcaSharedPreferencesContract)
  {
    Tracer localTracer = Tracer.a("OrcaSharedPreferences.ctor");
    this.c = paramContext;
    this.d = paramContentResolver;
    this.e = paramAndroidThreadUtil;
    this.f = paramOrcaSharedPreferencesContract;
    this.h = Maps.d();
    this.i = Maps.a();
    this.j = Sets.a();
    this.k = Sets.a();
    this.l = new WeakHashMap();
    this.m = Lists.a();
    this.g = paramSharedPreferences;
    this.r = new OrcaSharedPreferencesImpl.1(this);
    this.s = new OrcaSharedPreferencesImpl.2(this);
    localTracer.a();
  }

  private ImmutableMap<PrefKey, Object> a(Map<PrefKey, Object> paramMap1, Map<PrefKey, Object> paramMap2)
  {
    MapDifference localMapDifference = Maps.a(paramMap1, paramMap2);
    Map localMap1 = localMapDifference.a();
    Map localMap2 = localMapDifference.b();
    Map localMap3 = localMapDifference.d();
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Iterator localIterator1 = localMap1.keySet().iterator();
    while (localIterator1.hasNext())
      localBuilder.b((PrefKey)localIterator1.next(), t);
    Iterator localIterator2 = localMap2.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
      localBuilder.b(localEntry2.getKey(), localEntry2.getValue());
    }
    Iterator localIterator3 = localMap3.entrySet().iterator();
    while (localIterator3.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator3.next();
      localBuilder.b(localEntry1.getKey(), ((MapDifference.ValueDifference)localEntry1.getValue()).b());
    }
    return localBuilder.b();
  }

  private void a(SharedPreferences.Editor paramEditor, Map<PrefKey, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      PrefKey localPrefKey = (PrefKey)localEntry.getKey();
      Object localObject = localEntry.getValue();
      if (localObject == t)
      {
        paramEditor.remove(localPrefKey.a());
        continue;
      }
      if (localObject == null)
        continue;
      if ((localObject instanceof String))
      {
        paramEditor.putString(localPrefKey.a(), (String)localObject);
        continue;
      }
      if ((localObject instanceof Boolean))
      {
        paramEditor.putBoolean(localPrefKey.a(), ((Boolean)localObject).booleanValue());
        continue;
      }
      if ((localObject instanceof Integer))
      {
        paramEditor.putInt(localPrefKey.a(), ((Integer)localObject).intValue());
        continue;
      }
      if ((localObject instanceof Long))
      {
        paramEditor.putLong(localPrefKey.a(), ((Long)localObject).longValue());
        continue;
      }
      if (!(localObject instanceof Float))
        continue;
      paramEditor.putFloat(localPrefKey.a(), ((Float)localObject).floatValue());
    }
  }

  private void a(String paramString)
  {
    monitorenter;
    try
    {
      this.k.add(paramString);
      monitorexit;
      g();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(List<String> paramList)
  {
    monitorenter;
    try
    {
      this.j.addAll(paramList);
      monitorexit;
      g();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(Map<PrefKey, Object> paramMap)
  {
    monitorenter;
    try
    {
      ImmutableSet localImmutableSet = ImmutableSet.a(this.l.keySet());
      monitorexit;
      Iterator localIterator1 = paramMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        PrefKey localPrefKey = (PrefKey)localIterator1.next();
        Iterator localIterator2 = localImmutableSet.iterator();
        while (localIterator2.hasNext())
        {
          OrcaSharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (OrcaSharedPreferences.OnSharedPreferenceChangeListener)localIterator2.next();
          if (localOnSharedPreferenceChangeListener == null)
            continue;
          localOnSharedPreferenceChangeListener.a(this, localPrefKey);
        }
      }
    }
    finally
    {
      monitorexit;
    }
  }

  // ERROR //
  private void a(Map<PrefKey, Object> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 291 1 0
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_1
    //   13: invokeinterface 184 1 0
    //   18: invokeinterface 164 1 0
    //   23: astore 4
    //   25: aload 4
    //   27: invokeinterface 170 1 0
    //   32: ifeq +77 -> 109
    //   35: aload 4
    //   37: invokeinterface 174 1 0
    //   42: checkcast 186	java/util/Map$Entry
    //   45: astore 5
    //   47: aload 5
    //   49: invokeinterface 189 1 0
    //   54: checkcast 176	com/facebook/orca/prefs/PrefKey
    //   57: astore 6
    //   59: aload 5
    //   61: invokeinterface 192 1 0
    //   66: astore 7
    //   68: aload 7
    //   70: getstatic 66	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:t	Ljava/lang/Object;
    //   73: if_acmpne +21 -> 94
    //   76: aload_0
    //   77: getfield 91	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:h	Ljava/util/TreeMap;
    //   80: aload 6
    //   82: invokevirtual 296	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: goto -61 -> 25
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    //   94: aload_0
    //   95: getfield 91	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:h	Ljava/util/TreeMap;
    //   98: aload 6
    //   100: aload 7
    //   102: invokevirtual 300	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: goto -81 -> 25
    //   109: iload_2
    //   110: ifeq +17 -> 127
    //   113: aload_0
    //   114: getfield 96	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:i	Ljava/util/Map;
    //   117: aload_1
    //   118: invokeinterface 303 2 0
    //   123: aload_0
    //   124: invokespecial 274	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:g	()V
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_0
    //   130: getfield 82	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:e	Lcom/facebook/orca/common/util/AndroidThreadUtil;
    //   133: new 305	com/facebook/orca/prefs/OrcaSharedPreferencesImpl$4
    //   136: dup
    //   137: aload_0
    //   138: aload_1
    //   139: invokespecial 307	com/facebook/orca/prefs/OrcaSharedPreferencesImpl$4:<init>	(Lcom/facebook/orca/prefs/OrcaSharedPreferencesImpl;Ljava/util/Map;)V
    //   142: invokeinterface 312 2 0
    //   147: goto -138 -> 9
    //
    // Exception table:
    //   from	to	target	type
    //   12	92	89	finally
    //   94	129	89	finally
  }

  private void a(Set<String> paramSet, Map<PrefKey, Object> paramMap)
  {
    String str1;
    Cursor localCursor;
    label50: String str2;
    PrefKey localPrefKey;
    if (paramSet != null)
    {
      str1 = "key IN " + SqlUtil.b(paramSet);
      localCursor = this.d.query(this.f.b(), b, str1, null, null);
      try
      {
        while (localCursor.moveToNext())
        {
          str2 = localCursor.getString(0);
          switch (localCursor.getInt(1))
          {
          case 1:
            paramMap.put(new PrefKey(str2), localCursor.getString(2));
          case 2:
          case 3:
          case 4:
          case 5:
          }
        }
      }
      finally
      {
        localCursor.close();
      }
      localPrefKey = new PrefKey(str2);
      if (localCursor.getInt(2) == 0)
        break label299;
    }
    label299: for (boolean bool = true; ; bool = false)
    {
      paramMap.put(localPrefKey, Boolean.valueOf(bool));
      break label50;
      paramMap.put(new PrefKey(str2), Integer.valueOf(localCursor.getInt(2)));
      break label50;
      paramMap.put(new PrefKey(str2), Long.valueOf(localCursor.getLong(2)));
      break label50;
      paramMap.put(new PrefKey(str2), Float.valueOf(localCursor.getFloat(2)));
      break label50;
      localCursor.close();
      return;
      str1 = null;
      break;
      break label50;
    }
  }

  private void b(Map<PrefKey, Object> paramMap)
  {
    if (paramMap.isEmpty());
    while (true)
    {
      return;
      ArrayList localArrayList = Lists.a();
      ContentValues localContentValues = new ContentValues();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        PrefKey localPrefKey = (PrefKey)localEntry.getKey();
        Object localObject = localEntry.getValue();
        Uri localUri = this.f.b();
        if (localObject == t)
        {
          localArrayList.add(ContentProviderOperation.newDelete(Uri.withAppendedPath(localUri, "key/" + Uri.encode(localPrefKey.a()))).build());
          continue;
        }
        localContentValues.put("key", localPrefKey.a());
        if ((localObject instanceof String))
        {
          localContentValues.put("type", Integer.valueOf(1));
          localContentValues.put("value", (String)localObject);
        }
        while (true)
        {
          localArrayList.add(ContentProviderOperation.newInsert(localUri).withValues(localContentValues).build());
          break;
          if ((localObject instanceof Boolean))
          {
            localContentValues.put("type", Integer.valueOf(2));
            if (((Boolean)localObject).booleanValue());
            for (int i1 = 1; ; i1 = 0)
            {
              localContentValues.put("value", Integer.valueOf(i1));
              break;
            }
          }
          if ((localObject instanceof Integer))
          {
            localContentValues.put("type", Integer.valueOf(3));
            localContentValues.put("value", (Integer)localObject);
            continue;
          }
          if ((localObject instanceof Long))
          {
            localContentValues.put("type", Integer.valueOf(4));
            localContentValues.put("value", (Long)localObject);
            continue;
          }
          if (!(localObject instanceof Float))
            continue;
          localContentValues.put("type", Integer.valueOf(5));
          localContentValues.put("value", (Float)localObject);
        }
      }
      try
      {
        this.d.applyBatch(this.f.a(), localArrayList);
      }
      catch (Exception localException)
      {
      }
    }
    throw new RuntimeException(localException);
  }

  private Map<PrefKey, Object> c(Map<String, ?> paramMap)
  {
    HashMap localHashMap = Maps.a();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(new PrefKey((String)localEntry.getKey()), localEntry.getValue());
    }
    return localHashMap;
  }

  private SortedMap<PrefKey, Object> c(PrefKey paramPrefKey)
  {
    monitorenter;
    try
    {
      m();
      SortedMap localSortedMap = PrefKeyUtil.a(this.h, paramPrefKey);
      monitorexit;
      return localSortedMap;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void f()
  {
    a(null, this.h);
  }

  private void g()
  {
    monitorenter;
    try
    {
      boolean bool = this.o;
      if (bool);
      while (true)
      {
        return;
        this.e.c(new OrcaSharedPreferencesImpl.5(this));
        this.o = true;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void h()
  {
    synchronized (this.p)
    {
      if (!this.q)
      {
        l();
        this.q = true;
        this.g.registerOnSharedPreferenceChangeListener(this.r);
      }
      ImmutableMap localImmutableMap1 = i();
      b(localImmutableMap1);
      ImmutableMap localImmutableMap2 = j();
      a(localImmutableMap2, false);
      SharedPreferences.Editor localEditor = this.g.edit();
      a(localEditor, localImmutableMap1);
      a(localEditor, localImmutableMap2);
      localEditor.commit();
      a(k(), true);
      return;
    }
  }

  private ImmutableMap<PrefKey, Object> i()
  {
    monitorenter;
    try
    {
      ImmutableMap localImmutableMap1;
      if (this.i.isEmpty())
      {
        ImmutableMap localImmutableMap2 = ImmutableMap.j();
        localImmutableMap1 = localImmutableMap2;
      }
      while (true)
      {
        return localImmutableMap1;
        localImmutableMap1 = ImmutableMap.a(this.i);
        this.i.clear();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private ImmutableMap<PrefKey, Object> j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 103	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:j	Ljava/util/Set;
    //   6: invokeinterface 498 1 0
    //   11: ifeq +13 -> 24
    //   14: invokestatic 491	com/google/common/collect/ImmutableMap:j	()Lcom/google/common/collect/ImmutableMap;
    //   17: astore 9
    //   19: aload_0
    //   20: monitorexit
    //   21: goto +119 -> 140
    //   24: aload_0
    //   25: getfield 103	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:j	Ljava/util/Set;
    //   28: invokestatic 501	com/google/common/collect/Sets:a	(Ljava/lang/Iterable;)Ljava/util/HashSet;
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 103	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:j	Ljava/util/Set;
    //   36: invokeinterface 502 1 0
    //   41: invokestatic 94	com/google/common/collect/Maps:a	()Ljava/util/HashMap;
    //   44: astore_3
    //   45: aload_2
    //   46: invokeinterface 164 1 0
    //   51: astore 4
    //   53: aload 4
    //   55: invokeinterface 170 1 0
    //   60: ifeq +57 -> 117
    //   63: new 176	com/facebook/orca/prefs/PrefKey
    //   66: dup
    //   67: aload 4
    //   69: invokeinterface 174 1 0
    //   74: checkcast 53	java/lang/String
    //   77: invokespecial 356	com/facebook/orca/prefs/PrefKey:<init>	(Ljava/lang/String;)V
    //   80: astore 5
    //   82: aload_0
    //   83: getfield 91	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:h	Ljava/util/TreeMap;
    //   86: aload 5
    //   88: invokevirtual 505	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: astore 6
    //   93: aload 6
    //   95: ifnull -42 -> 53
    //   98: aload_3
    //   99: aload 5
    //   101: aload 6
    //   103: invokeinterface 357 3 0
    //   108: pop
    //   109: goto -56 -> 53
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    //   117: aload_0
    //   118: monitorexit
    //   119: invokestatic 94	com/google/common/collect/Maps:a	()Ljava/util/HashMap;
    //   122: astore 8
    //   124: aload_0
    //   125: aload_2
    //   126: aload 8
    //   128: invokespecial 458	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:a	(Ljava/util/Set;Ljava/util/Map;)V
    //   131: aload_0
    //   132: aload_3
    //   133: aload 8
    //   135: invokespecial 507	com/facebook/orca/prefs/OrcaSharedPreferencesImpl:a	(Ljava/util/Map;Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;
    //   138: astore 9
    //   140: aload 9
    //   142: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	115	112	finally
    //   117	119	112	finally
  }

  private ImmutableMap<PrefKey, Object> k()
  {
    monitorenter;
    while (true)
    {
      ImmutableMap.Builder localBuilder;
      Map localMap;
      String str;
      PrefKey localPrefKey;
      try
      {
        if (!this.k.isEmpty())
          continue;
        ImmutableMap localImmutableMap2 = ImmutableMap.j();
        localObject2 = localImmutableMap2;
        return localObject2;
        HashSet localHashSet = Sets.a(this.k);
        this.k.clear();
        localBuilder = ImmutableMap.k();
        localMap = this.g.getAll();
        Iterator localIterator = localHashSet.iterator();
        if (!localIterator.hasNext())
          break label183;
        str = (String)localIterator.next();
        localPrefKey = new PrefKey(str);
        if (!localMap.containsKey(str))
        {
          if (!this.h.containsKey(localPrefKey))
            continue;
          localBuilder.b(localPrefKey, t);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      Object localObject3 = localMap.get(str);
      if (Objects.equal(this.h.get(localPrefKey), localObject3))
        continue;
      localBuilder.b(localPrefKey, localObject3);
      continue;
      label183: ImmutableMap localImmutableMap1 = localBuilder.b();
      Object localObject2 = localImmutableMap1;
    }
  }

  private void l()
  {
    monitorenter;
    try
    {
      HashMap localHashMap = Maps.a(this.h);
      monitorexit;
      ImmutableMap localImmutableMap = a(c(this.g.getAll()), localHashMap);
      SharedPreferences.Editor localEditor = this.g.edit();
      a(localEditor, localImmutableMap);
      localEditor.commit();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void m()
  {
    Preconditions.checkState(this.n, "OrcaSharedPreferences used before initialized");
  }

  public int a(PrefKey paramPrefKey, int paramInt)
  {
    monitorenter;
    try
    {
      m();
      Integer localInteger = (Integer)this.h.get(paramPrefKey);
      if (localInteger != null)
      {
        int i1 = localInteger.intValue();
        paramInt = i1;
      }
      monitorexit;
      return paramInt;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public long a(PrefKey paramPrefKey, long paramLong)
  {
    monitorenter;
    try
    {
      m();
      Long localLong = (Long)this.h.get(paramPrefKey);
      if (localLong != null)
      {
        long l1 = localLong.longValue();
        paramLong = l1;
      }
      monitorexit;
      return paramLong;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public String a(PrefKey paramPrefKey, String paramString)
  {
    monitorenter;
    try
    {
      m();
      String str = (String)this.h.get(paramPrefKey);
      if (str != null)
        return str;
      str = paramString;
    }
    finally
    {
      monitorexit;
    }
  }

  public void a(OrcaSharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    monitorenter;
    try
    {
      this.l.put(paramOnSharedPreferenceChangeListener, Integer.valueOf(1));
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

  public void a(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      if (this.n)
      {
        this.e.d(paramRunnable);
        return;
      }
      this.m.add(paramRunnable);
    }
    finally
    {
      monitorexit;
    }
  }

  public void a(Set<PrefKey> paramSet)
  {
    OrcaSharedPreferences.Editor localEditor = b();
    SharedPreferences.Editor localEditor1 = this.g.edit();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      PrefKey localPrefKey = (PrefKey)localIterator.next();
      localEditor.b(localPrefKey);
      localEditor1.remove(localPrefKey.a());
    }
    localEditor.a();
    localEditor1.commit();
  }

  public boolean a()
  {
    monitorenter;
    try
    {
      boolean bool = this.n;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean a(PrefKey paramPrefKey)
  {
    monitorenter;
    try
    {
      m();
      boolean bool = this.h.containsKey(paramPrefKey);
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean a(PrefKey paramPrefKey, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      m();
      Boolean localBoolean = (Boolean)this.h.get(paramPrefKey);
      if (localBoolean != null)
      {
        boolean bool = localBoolean.booleanValue();
        paramBoolean = bool;
      }
      monitorexit;
      return paramBoolean;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public OrcaSharedPreferences.Editor b()
  {
    m();
    return new OrcaSharedPreferencesImpl.EditorImpl(this);
  }

  public SortedSet<PrefKey> b(PrefKey paramPrefKey)
  {
    monitorenter;
    try
    {
      TreeSet localTreeSet = Sets.b(c(paramPrefKey).keySet());
      monitorexit;
      return localTreeSet;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void b(OrcaSharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    monitorenter;
    try
    {
      this.l.remove(paramOnSharedPreferenceChangeListener);
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

  public void c()
  {
    monitorenter;
    try
    {
      Tracer localTracer1 = Tracer.a("OrcaSharedPreferences.initialize");
      this.n = true;
      Tracer localTracer2 = Tracer.a("#register");
      IntentFilter localIntentFilter = new IntentFilter(this.f.c());
      String str = this.f.e();
      if (str != null)
        this.c.registerReceiver(this.s, localIntentFilter, str, null);
      while (true)
      {
        localTracer2.a();
        Tracer localTracer3 = Tracer.a("#loadInitialValues");
        f();
        localTracer3.a();
        g();
        localTracer1.a();
        this.e.b(new OrcaSharedPreferencesImpl.3(this));
        return;
        this.c.registerReceiver(this.s, localIntentFilter);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void d()
  {
    m();
    Iterator localIterator = this.h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      BLog.a(a, "Pref: " + localEntry.getKey() + ": " + localEntry.getValue());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesImpl
 * JD-Core Version:    0.6.0
 */
package com.facebook.dalvik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProcSelfMaps
{
  private final List<ProcSelfMaps.Mapping> a;

  private ProcSelfMaps(List<ProcSelfMaps.Mapping> paramList)
  {
    this.a = paramList;
  }

  public static ProcSelfMaps a()
  {
    return a(new File("/proc/self/maps"));
  }

  public static ProcSelfMaps a(File paramFile)
  {
    FileReader localFileReader = new FileReader(paramFile);
    ArrayList localArrayList;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      localArrayList = new ArrayList();
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          break;
        localArrayList.add(str);
      }
    }
    finally
    {
      localFileReader.close();
    }
    ProcSelfMaps localProcSelfMaps = a(localArrayList);
    localFileReader.close();
    return localProcSelfMaps;
  }

  public static ProcSelfMaps a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(b((String)localIterator.next()));
    return new ProcSelfMaps(localArrayList);
  }

  private static boolean a(char paramChar1, char paramChar2, String paramString)
  {
    if (paramChar1 == paramChar2);
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      if (paramChar1 != '-')
        break;
    }
    throw c(paramString);
  }

  private static ProcSelfMaps.Mapping b(String paramString)
  {
    int i = 1;
    String[] arrayOfString1 = paramString.split(" +", 6);
    if (arrayOfString1.length != 6)
      throw c(paramString);
    String[] arrayOfString2 = arrayOfString1[0].split("-");
    if (arrayOfString2.length != 2)
      throw c(paramString);
    long l1;
    long l2;
    try
    {
      l1 = Long.parseLong(arrayOfString2[0], 16);
      l2 = Long.parseLong(arrayOfString2[1], 16);
      if (arrayOfString1[i].length() != 4)
        throw c(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw c(paramString);
    }
    boolean bool1 = a(arrayOfString1[i].charAt(0), 'r', paramString);
    boolean bool2 = a(arrayOfString1[i].charAt(i), 'w', paramString);
    if (arrayOfString1[i].charAt(3) == 'p');
    while (true)
    {
      return new ProcSelfMaps.Mapping(l1, l2, bool1, bool2, i, arrayOfString1[5]);
      int j = 0;
    }
  }

  private static IllegalArgumentException c(String paramString)
  {
    return new IllegalArgumentException("Invalid /proc/self/maps line: '" + paramString + "'");
  }

  public ProcSelfMaps.Mapping a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    ProcSelfMaps.Mapping localMapping;
    do
    {
      if (!localIterator.hasNext())
        break;
      localMapping = (ProcSelfMaps.Mapping)localIterator.next();
    }
    while (!localMapping.d().contains(paramString));
    while (true)
    {
      return localMapping;
      localMapping = null;
    }
  }

  public ProcSelfMaps b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ProcSelfMaps.Mapping localMapping = (ProcSelfMaps.Mapping)localIterator.next();
      if (localMapping.c())
        localArrayList.add(localMapping);
    }
    return new ProcSelfMaps(localArrayList);
  }

  public long[] c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    long l1 = -1L;
    long l2 = -1L;
    if (localIterator.hasNext())
    {
      ProcSelfMaps.Mapping localMapping = (ProcSelfMaps.Mapping)localIterator.next();
      long l3;
      if (l2 == -1L)
      {
        l2 = localMapping.a();
        l3 = localMapping.b();
      }
      while (true)
      {
        l1 = l3;
        break;
        if (localMapping.a() == l1)
        {
          l3 = localMapping.b();
        }
        else
        {
          localArrayList.add(Long.valueOf(l2));
          localArrayList.add(Long.valueOf(l1));
          l2 = localMapping.a();
          l3 = localMapping.b();
        }
      }
    }
    if (l2 != -1L)
    {
      localArrayList.add(Long.valueOf(l2));
      localArrayList.add(Long.valueOf(l1));
    }
    long[] arrayOfLong = new long[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++)
      arrayOfLong[i] = ((Long)localArrayList.get(i)).longValue();
    return arrayOfLong;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.dalvik.ProcSelfMaps
 * JD-Core Version:    0.6.2
 */
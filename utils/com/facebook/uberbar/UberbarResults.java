package com.facebook.uberbar;

import android.net.Uri;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.data.uberbar.UberbarJsonResult;
import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.ipc.data.uberbar.UberbarResult.FriendStatus;
import com.facebook.ipc.data.uberbar.UberbarResult.Type;
import com.facebook.ipc.data.uberbar.UberbarResultBuilder;
import com.facebook.ipc.data.uberbar.UberbarResultParserException;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UberbarResults
{
  public static UberbarResult a(UberbarJsonResult paramUberbarJsonResult)
  {
    return a(paramUberbarJsonResult.category, paramUberbarJsonResult.friendshipStatus, paramUberbarJsonResult.nativeAndroidUrl, paramUberbarJsonResult.path, paramUberbarJsonResult.photo, paramUberbarJsonResult.subtext, paramUberbarJsonResult.text, paramUberbarJsonResult.type, paramUberbarJsonResult.uid);
  }

  private static UberbarResult a(UberbarResult paramUberbarResult1, UberbarResult paramUberbarResult2)
  {
    return UberbarResult.newBuilder().a(paramUberbarResult1.a).a(paramUberbarResult1.b).a(paramUberbarResult1.c).b(paramUberbarResult1.d).c(paramUberbarResult1.e).b(paramUberbarResult2.f).c(paramUberbarResult1.g).a(paramUberbarResult1.h).a(paramUberbarResult1.i).a(paramUberbarResult1.j).a();
  }

  public static UberbarResult a(String paramString1, String paramString2, long paramLong)
  {
    return UberbarResult.newBuilder().a("").a(null).a(null).b(null).c(Uri.parse(paramString1)).b("").c(paramString2).a(UberbarResult.Type.PAGE).a(paramLong).a(null).a();
  }

  public static UberbarResult a(String paramString1, String paramString2, long paramLong, List<String> paramList)
  {
    return UberbarResult.newBuilder().a("").a(UberbarResult.FriendStatus.ARE_FRIENDS).a(null).b(null).c(Uri.parse(paramString1)).b("").c(paramString2).a(UberbarResult.Type.USER).a(paramLong).a(paramList).a();
  }

  public static UberbarResult a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    Object localObject1;
    Uri localUri1;
    Uri localUri2;
    Uri localUri3;
    Object localObject2;
    if (paramString2 == null)
    {
      localObject1 = null;
      localUri1 = b(paramString3);
      localUri2 = b(paramString4);
      localUri3 = b(paramString5);
      if (paramString8 != null)
        break label146;
      localObject2 = null;
    }
    while (true)
    {
      while (true)
      {
        long l = Long.parseLong(paramString9);
        return UberbarResult.newBuilder().a(paramString1).a((UberbarResult.FriendStatus)localObject1).a(localUri1).b(localUri2).c(localUri3).b(paramString6).c(paramString7).a((UberbarResult.Type)localObject2).a(l).a(null).a();
        try
        {
          UberbarResult.FriendStatus localFriendStatus = UberbarResult.FriendStatus.valueOf(paramString2.toUpperCase());
          localObject1 = localFriendStatus;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          throw new UberbarResultParserException("FriendStatus: " + paramString2 + " invalid");
        }
      }
      try
      {
        label146: UberbarResult.Type localType = UberbarResult.Type.valueOf(paramString8.toUpperCase());
        localObject2 = localType;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
      }
    }
    throw new UberbarResultParserException("Type: " + paramString8 + " is invalid");
  }

  public static List<UberbarResult> a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    List localList1 = JMParser.b(new JsonFactory().createJsonParser(paramString), UberbarJsonResult.class);
    if (localList1 == null)
      throw new UberbarResultParserException("This is not a proper UberbarResult JSON array: " + paramString);
    List localList2 = a(localList1);
    if (localList2 == null)
      throw new UberbarResultParserException("This is not a proper UberbarResult JSON array: " + paramString);
    return localList2;
  }

  public static List<UberbarResult> a(List<UberbarJsonResult> paramList)
  {
    Preconditions.checkNotNull(paramList);
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localBuilder.b(a((UberbarJsonResult)localIterator.next()));
    return localBuilder.b();
  }

  public static List<UberbarResult> a(List<UberbarResult> paramList1, List<UberbarResult> paramList2, List<UberbarResult> paramList3)
  {
    Preconditions.checkNotNull(paramList1);
    Preconditions.checkNotNull(paramList2);
    Preconditions.checkNotNull(paramList3);
    ImmutableMap localImmutableMap = b(paramList1);
    ArrayList localArrayList = Lists.a(paramList2);
    localArrayList.addAll(paramList3);
    HashSet localHashSet = Sets.a();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      UberbarResult localUberbarResult2 = (UberbarResult)localIterator1.next();
      localHashSet.add(Long.valueOf(localUberbarResult2.i));
      UberbarResult localUberbarResult3 = (UberbarResult)localImmutableMap.get(Long.valueOf(localUberbarResult2.i));
      if (localUberbarResult3 != null)
        localUberbarResult2 = a(localUberbarResult2, localUberbarResult3);
      localBuilder.b(localUberbarResult2);
    }
    Iterator localIterator2 = paramList1.iterator();
    while (localIterator2.hasNext())
    {
      UberbarResult localUberbarResult1 = (UberbarResult)localIterator2.next();
      if (!localHashSet.contains(Long.valueOf(localUberbarResult1.i)))
        localBuilder.b(localUberbarResult1);
    }
    return localBuilder.b();
  }

  private static Uri b(String paramString)
  {
    Uri localUri;
    if (Strings.emptyToNull(paramString) == null)
      localUri = null;
    while (true)
    {
      return localUri;
      if (paramString.startsWith("/"))
        localUri = Uri.parse("http://www.facebook.com" + paramString);
      else
        localUri = Uri.parse(paramString);
    }
  }

  private static ImmutableMap<Long, UberbarResult> b(List<UberbarResult> paramList)
  {
    ImmutableMap.Builder localBuilder = new ImmutableMap.Builder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      UberbarResult localUberbarResult = (UberbarResult)localIterator.next();
      localBuilder.b(Long.valueOf(localUberbarResult.i), localUberbarResult);
    }
    return localBuilder.b();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.UberbarResults
 * JD-Core Version:    0.6.2
 */
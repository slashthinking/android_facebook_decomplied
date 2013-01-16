package com.facebook.katana.rollout;

import android.content.Context;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import java.util.HashMap;
import java.util.Map;

public class Rollout
{
  public static Map<Class<? extends Enum<?>>, String> a = new Rollout.1();
  private static Map<String, String> b = new HashMap();
  private static ManagedDataStore<String, String> c;

  private static ManagedDataStore<String, String> a(Context paramContext)
  {
    if (c == null)
      c = new ManagedDataStore(Rollout.RolloutClient.INSTANCE, ManagedDataStore.Mode.SINGLE_REQUEST_BY_KEY, paramContext);
    return c;
  }

  public static <T extends Enum<T>> T a(Context paramContext, Class<T> paramClass)
  {
    if (!a.containsKey(paramClass))
      throw new IllegalStateException("You must register this enum:" + paramClass.getName());
    Object localObject;
    if (b.get(paramClass.getSimpleName()) != null)
      localObject = Enum.valueOf(paramClass, (String)b.get(paramClass.getSimpleName()));
    while (true)
    {
      return localObject;
      String str = (String)a(paramContext).a(paramClass.getSimpleName());
      if (str == null)
      {
        localObject = null;
        continue;
      }
      try
      {
        Enum localEnum = Enum.valueOf(paramClass, str);
        localObject = localEnum;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ErrorReporting.a("rollout", "The condition name sent down from the server '" + str + "' does not " + "match any enum value in the enum class '" + paramClass.getSimpleName() + "'. Please make sure the rollout definition in www matches the " + "enum definition in your code.", localIllegalArgumentException);
        localObject = null;
      }
    }
  }

  public static void a(Class<? extends Enum<?>> paramClass, String paramString)
  {
    if (!b(paramClass, paramString))
      throw new IllegalArgumentException("Rollout condition '" + paramString + "' is not part of rollout definition in " + paramClass.getSimpleName());
    b.put(paramClass.getSimpleName(), paramString);
  }

  private static boolean b(Class<? extends Enum<?>> paramClass, String paramString)
  {
    Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
    int i = arrayOfEnum.length;
    int j = 0;
    if (j < i)
      if (!arrayOfEnum[j].toString().equals(paramString));
    for (int k = 1; ; k = 0)
    {
      return k;
      j++;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.rollout.Rollout
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.features.faceweb;

import com.facebook.base.BuildConstants;
import com.facebook.common.json.jsonmirror.JMDynamicKeysDictDestination;
import com.facebook.common.json.jsonmirror.types.JMForcedString;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class FacewebComponentsStore$LiberalDeserializer extends ObjectInputStream
{
  private static final Class<?> a = LiberalDeserializer.class;

  public FacewebComponentsStore$LiberalDeserializer(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
  {
    while (true)
    {
      Object localObject1;
      try
      {
        Class localClass2 = super.resolveClass(paramObjectStreamClass);
        localObject1 = localClass2;
        return localObject1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
      }
      try
      {
        String str1 = BuildConstants.b();
        String str2 = paramObjectStreamClass.getName();
        label58: Class localClass1;
        StringBuilder localStringBuilder;
        if ((str1 + ".features.faceweb.FacewebComponentsStore").equals(str2))
        {
          localObject1 = FacewebComponentsStore.class;
          localClass1 = a;
          localStringBuilder = new StringBuilder().append("failed in retrieving ").append(str2).append("; replacing with ");
          if (localObject1 != null)
            break label300;
        }
        label300: String str3;
        for (Object localObject2 = "(null)"; ; localObject2 = str3)
        {
          Log.d(localClass1, (String)localObject2);
          if (localObject1 != null)
            break;
          throw localClassNotFoundException;
          if ((str1 + ".features.faceweb.FacewebComponentsStore$Skeleton").equals(str2))
          {
            localObject1 = FacewebComponentsStore.Skeleton.class;
            break label58;
          }
          if ((str1 + ".features.faceweb.FacewebComponentsStore$FacewebSkeletonPalCall").equals(str2))
          {
            localObject1 = FacewebComponentsStore.FacewebSkeletonPalCall.class;
            break label58;
          }
          if ((str1 + ".features.faceweb.FacewebComponentsStore$FacewebComponentsRule").equals(str2))
          {
            localObject1 = FacewebComponentsStore.FacewebComponentsRule.class;
            break label58;
          }
          if ((str1 + ".util.jsonmirror.JMDynamicKeysDictDestination").equals(str2))
          {
            localObject1 = JMDynamicKeysDictDestination.class;
            break label58;
          }
          boolean bool = (str1 + ".util.jsonmirror.types.JMForcedString").equals(str2);
          localObject1 = null;
          if (!bool)
            break label58;
          localObject1 = JMForcedString.class;
          break label58;
          str3 = ((Class)localObject1).getCanonicalName();
        }
      }
      catch (Throwable localThrowable)
      {
        while (true)
          ErrorReporting.a(a.getSimpleName(), "exception in bandaid", localThrowable);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.faceweb.FacewebComponentsStore.LiberalDeserializer
 * JD-Core Version:    0.6.0
 */
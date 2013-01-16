package com.facebook.common.json.jsonmirror;

import com.facebook.common.util.ReflectionUtils.Filter;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;

final class JMStaticKeysDictDestination$Encoder$1
  implements ReflectionUtils.Filter<JMStaticKeysDictDestination.Encoder.SerializableJsonObject>
{
  public JMStaticKeysDictDestination.Encoder.SerializableJsonObject a(AccessibleObject paramAccessibleObject)
  {
    Annotation[] arrayOfAnnotation = paramAccessibleObject.getDeclaredAnnotations();
    int i = arrayOfAnnotation.length;
    int j = 0;
    Annotation localAnnotation;
    if (j < i)
    {
      localAnnotation = arrayOfAnnotation[j];
      if (!(localAnnotation instanceof JMStaticKeysDictDestination.Encoder.SerializableJsonObject));
    }
    for (JMStaticKeysDictDestination.Encoder.SerializableJsonObject localSerializableJsonObject = (JMStaticKeysDictDestination.Encoder.SerializableJsonObject)localAnnotation; ; localSerializableJsonObject = null)
    {
      return localSerializableJsonObject;
      j++;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder.1
 * JD-Core Version:    0.6.0
 */
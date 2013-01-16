package com.facebook.common.json.jsonmirror;

import com.facebook.common.util.ReflectionUtils.Filter;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;

final class JMAutogen$1
  implements ReflectionUtils.Filter<Annotation>
{
  public Annotation a(AccessibleObject paramAccessibleObject)
  {
    Annotation[] arrayOfAnnotation = paramAccessibleObject.getDeclaredAnnotations();
    int i = arrayOfAnnotation.length;
    int j = 0;
    Object localObject = null;
    while (j < i)
    {
      Annotation localAnnotation = arrayOfAnnotation[j];
      if (((localAnnotation instanceof JMAutogen.InferredType)) || ((localAnnotation instanceof JMAutogen.ExplicitType)) || ((localAnnotation instanceof JMAutogen.ListType)) || ((localAnnotation instanceof JMAutogen.DynamicKeyDictType)) || ((localAnnotation instanceof JMAutogen.EscapedObjectType)))
      {
        if (localObject != null)
          throw new JMFatalException(this.a.getName() + ":" + paramAccessibleObject.toString() + " has more than one JM annotation");
        localObject = localAnnotation;
      }
      j++;
    }
    return localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.JMAutogen.1
 * JD-Core Version:    0.6.0
 */
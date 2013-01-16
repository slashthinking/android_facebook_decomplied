package com.google.inject.internal;

import com.google.common.base.Function;
import java.lang.annotation.Annotation;
import java.util.Collection;

class Annotations$AnnotationChecker$1
  implements Function<Class<? extends Annotation>, Boolean>
{
  public Boolean a(Class<? extends Annotation> paramClass)
  {
    Annotation[] arrayOfAnnotation = paramClass.getAnnotations();
    int i = arrayOfAnnotation.length;
    int j = 0;
    if (j < i)
    {
      Annotation localAnnotation = arrayOfAnnotation[j];
      if (!Annotations.AnnotationChecker.a(this.a).contains(localAnnotation.annotationType()));
    }
    for (Boolean localBoolean = Boolean.valueOf(true); ; localBoolean = Boolean.valueOf(false))
    {
      return localBoolean;
      j++;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.internal.Annotations.AnnotationChecker.1
 * JD-Core Version:    0.6.0
 */
package com.google.inject;

import com.google.common.base.Preconditions;
import java.lang.annotation.Annotation;

class Key$AnnotationInstanceStrategy
  implements Key.AnnotationStrategy
{
  final Annotation a;

  Key$AnnotationInstanceStrategy(Annotation paramAnnotation)
  {
    this.a = ((Annotation)Preconditions.checkNotNull(paramAnnotation, "annotation"));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AnnotationInstanceStrategy));
    AnnotationInstanceStrategy localAnnotationInstanceStrategy;
    for (boolean bool = false; ; bool = this.a.equals(localAnnotationInstanceStrategy.a))
    {
      return bool;
      localAnnotationInstanceStrategy = (AnnotationInstanceStrategy)paramObject;
    }
  }

  public Annotation getAnnotation()
  {
    return this.a;
  }

  public Class<? extends Annotation> getAnnotationType()
  {
    return this.a.annotationType();
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.Key.AnnotationInstanceStrategy
 * JD-Core Version:    0.6.0
 */
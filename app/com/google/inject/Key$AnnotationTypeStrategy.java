package com.google.inject;

import com.google.common.base.Preconditions;
import java.lang.annotation.Annotation;

class Key$AnnotationTypeStrategy
  implements Key.AnnotationStrategy
{
  final Class<? extends Annotation> a;
  final Annotation b;

  Key$AnnotationTypeStrategy(Class<? extends Annotation> paramClass, Annotation paramAnnotation)
  {
    this.a = ((Class)Preconditions.checkNotNull(paramClass, "annotation type"));
    this.b = paramAnnotation;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AnnotationTypeStrategy));
    AnnotationTypeStrategy localAnnotationTypeStrategy;
    for (boolean bool = false; ; bool = this.a.equals(localAnnotationTypeStrategy.a))
    {
      return bool;
      localAnnotationTypeStrategy = (AnnotationTypeStrategy)paramObject;
    }
  }

  public Annotation getAnnotation()
  {
    return this.b;
  }

  public Class<? extends Annotation> getAnnotationType()
  {
    return this.a;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public String toString()
  {
    return "@" + this.a.getName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.Key.AnnotationTypeStrategy
 * JD-Core Version:    0.6.0
 */
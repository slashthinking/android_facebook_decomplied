package com.google.inject;

import java.lang.annotation.Annotation;

abstract interface Key$AnnotationStrategy
{
  public abstract Annotation getAnnotation();

  public abstract Class<? extends Annotation> getAnnotationType();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.Key.AnnotationStrategy
 * JD-Core Version:    0.6.0
 */
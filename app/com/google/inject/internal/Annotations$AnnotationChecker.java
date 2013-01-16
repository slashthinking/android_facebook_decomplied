package com.google.inject.internal;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;

class Annotations$AnnotationChecker
{
  final Map<Class<? extends Annotation>, Boolean> a = new MapMaker().f().a(this.c);
  private final Collection<Class<? extends Annotation>> b;
  private Function<Class<? extends Annotation>, Boolean> c = new Annotations.AnnotationChecker.1(this);

  Annotations$AnnotationChecker(Collection<Class<? extends Annotation>> paramCollection)
  {
    this.b = paramCollection;
  }

  boolean a(Class<? extends Annotation> paramClass)
  {
    return ((Boolean)this.a.get(paramClass)).booleanValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.internal.Annotations.AnnotationChecker
 * JD-Core Version:    0.6.0
 */
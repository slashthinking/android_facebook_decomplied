package com.google.inject.internal;

import com.google.inject.BindingAnnotation;
import com.google.inject.ScopeAnnotation;
import com.google.inject.name.Names;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import javax.inject.Qualifier;
import javax.inject.Scope;

public class Annotations
{
  private static final Annotations.AnnotationChecker a = new Annotations.AnnotationChecker(Arrays.asList(new Class[] { ScopeAnnotation.class, Scope.class }));
  private static final Annotations.AnnotationChecker b = new Annotations.AnnotationChecker(Arrays.asList(new Class[] { BindingAnnotation.class, Qualifier.class }));

  public static Annotation a(Annotation paramAnnotation)
  {
    if ((paramAnnotation instanceof javax.inject.Named))
      paramAnnotation = Names.a(((javax.inject.Named)paramAnnotation).value());
    return paramAnnotation;
  }

  public static boolean a(Class<? extends Annotation> paramClass)
  {
    if (paramClass.getDeclaredMethods().length == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean b(Class<? extends Annotation> paramClass)
  {
    return b.a(paramClass);
  }

  public static Class<? extends Annotation> c(Class<? extends Annotation> paramClass)
  {
    if (paramClass == javax.inject.Named.class)
      paramClass = com.google.inject.name.Named.class;
    return paramClass;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.internal.Annotations
 * JD-Core Version:    0.6.0
 */
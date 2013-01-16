package com.google.inject;

import java.lang.annotation.Annotation;

 enum Key$NullAnnotationStrategy
  implements Key.AnnotationStrategy
{
  static
  {
    NullAnnotationStrategy[] arrayOfNullAnnotationStrategy = new NullAnnotationStrategy[1];
    arrayOfNullAnnotationStrategy[0] = INSTANCE;
    $VALUES = arrayOfNullAnnotationStrategy;
  }

  public Annotation getAnnotation()
  {
    return null;
  }

  public Class<? extends Annotation> getAnnotationType()
  {
    return null;
  }

  public boolean hasAttributes()
  {
    return false;
  }

  public String toString()
  {
    return "[none]";
  }

  public Key.AnnotationStrategy withoutAttributes()
  {
    throw new UnsupportedOperationException("Key already has no attributes.");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.Key.NullAnnotationStrategy
 * JD-Core Version:    0.6.0
 */
package android_src.mms.dom.smil.parser;

import android_src.mms.dom.smil.SmilDocumentImpl;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.smil.SMILDocument;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SmilContentHandler extends DefaultHandler
{
  private SMILDocument a;
  private Node b;

  public void a()
  {
    this.a = new SmilDocumentImpl();
    this.b = this.a;
  }

  public SMILDocument b()
  {
    return this.a;
  }

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.b = this.b.getParentNode();
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    Element localElement = this.a.createElement(paramString2);
    if (paramAttributes != null)
      for (int i = 0; i < paramAttributes.getLength(); i++)
        localElement.setAttribute(paramAttributes.getLocalName(i), paramAttributes.getValue(i));
    this.b.appendChild(localElement);
    this.b = localElement;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.parser.SmilContentHandler
 * JD-Core Version:    0.6.0
 */
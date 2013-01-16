package android_src.mms.dom.smil.parser;

import android_src.mms.MmsException;
import java.io.InputStream;
import org.w3c.dom.smil.SMILDocument;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SmilXmlParser
{
  private XMLReader a;
  private SmilContentHandler b;

  public SmilXmlParser()
  {
    System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
    try
    {
      this.a = XMLReaderFactory.createXMLReader();
      this.b = new SmilContentHandler();
      this.a.setContentHandler(this.b);
      return;
    }
    catch (SAXException localSAXException)
    {
    }
    throw new MmsException(localSAXException);
  }

  private void a(SMILDocument paramSMILDocument)
  {
    paramSMILDocument.c();
    paramSMILDocument.d();
  }

  public SMILDocument a(InputStream paramInputStream)
  {
    this.b.a();
    this.a.parse(new InputSource(paramInputStream));
    SMILDocument localSMILDocument = this.b.b();
    a(localSMILDocument);
    return localSMILDocument;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.parser.SmilXmlParser
 * JD-Core Version:    0.6.0
 */
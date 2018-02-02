package org.joinfaces.richfaces.example.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@Named("cdsParser")
@ApplicationScoped
public class CDParser
{

    private List<CDXmlDescriptor> cdsList;
    
    @XmlRootElement(name = "CATALOG")
    private static final class CDsHolder {
        
        private List<CDXmlDescriptor> cds;
        
        @XmlElement(name = "CD")
        public List<CDXmlDescriptor> getCds() {
            return cds;
        }
        
        @SuppressWarnings("unused")
        public void setCds(List<CDXmlDescriptor> cds) {
            this.cds = cds;
        }
    }
    
    public synchronized List<CDXmlDescriptor> getCdsList() {
        if (cdsList == null) {
            cdsList = new ArrayList<CDXmlDescriptor>();
            cdsList.add(new CDXmlDescriptor("Empire Burlesque", "Bob Dylan", "USA", "Columbia", 10.90f, 1985));
            cdsList.add(new CDXmlDescriptor("Hide your heart", "Bonnie Tylor", "United Kingdom", "CBS Records", 9.90f, 1988));
            cdsList.add(new CDXmlDescriptor("Greatest Hits", "Dolly Parton", "USA", "RCA", 9.90f, 1982));
        }
        return cdsList;
    }
}

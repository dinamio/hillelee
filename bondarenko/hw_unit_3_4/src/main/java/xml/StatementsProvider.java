package xml;

import dao.Entity;
import dao.Operation;
import dao.Vendor;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatementsProvider {

    private static StatementsProvider provider;

    private List<TemplateNode> nodes;

    private StatementsProvider() {
        try {
            nodes = SqlTemplateParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StatementsProvider getProvider(){
        if (provider == null){
            synchronized (StatementsProvider.class){
                if (provider == null){
                    provider = new StatementsProvider();
                }
            }
        }
        return provider;
    }

    //Todo optimaze for tree
    public Map<Operation, String> getStatements(Vendor vendor, Entity entity){
        return nodes.stream()
                    .filter(node -> node.getVendor() == vendor)
                    .filter(node -> node.getEntity() == entity)
                    .collect(Collectors.toMap(TemplateNode::getOperation, TemplateNode::getStatement));
    }


}

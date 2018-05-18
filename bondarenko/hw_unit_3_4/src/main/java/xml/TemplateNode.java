package xml;

import dao.Entity;
import dao.Operation;
import dao.Vendor;


//Todo rewrite on tree node
public class TemplateNode {

    private Vendor vendor;
    private Entity entity;
    private Operation operation;
    private String statement;

    public TemplateNode(Vendor vendor, Entity entity, Operation operation, String statement) {
        this.vendor = vendor;
        this.entity = entity;
        this.operation = operation;
        this.statement = statement;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}

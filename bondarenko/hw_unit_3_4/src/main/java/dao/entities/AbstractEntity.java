package dao.entities;

import connection.ConnectionUtil;
import dao.Entity;
import dao.Operation;
import dao.Vendor;
import logging.Log;
import utils.JdbcUtils;
import xml.StatementsProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class AbstractEntity {

    private StatementsProvider provider;

    private Vendor vendor;

    private Entity entity;

    public AbstractEntity(Vendor vendor, Entity entity) {
        this.vendor = vendor;
        this.entity = entity;
        provider = StatementsProvider.getProvider();
    }

    protected Map<Operation, String> getStatements() {
        return provider.getStatements(vendor, entity);
    }

    public void delete(String par) {
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Deleting is running...");
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.DELETE));
            ps.setLong(1, Long.valueOf(par));
            JdbcUtils.transactionExecution(connection, ps);
            Log.writeInfo("Deleting finished");
        } catch (SQLException e) {
            Log.writeError(String.format("Deleting error. User name: {%s}", par));
        }
    }

}

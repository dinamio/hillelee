package dao;

public final class SqlDocumentLoader {

    private static SqlDocumentLoader instance;

    private SqlDocumentLoader() {
    }

    public static SqlDocumentLoader getInstance(){
        if (instance == null){
            synchronized (SqlDocumentLoader.class){
                if (instance == null){
                    instance = new SqlDocumentLoader();
                }
            }
        }
        return instance;
    }
}

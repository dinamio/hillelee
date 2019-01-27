package entity;

public enum Pages {
    FIST_PAGE("index.jsp"),
    REGISTRATION_PAGE("Registration.jsp"),
    ERROR_PAGE("Error.jsp"),
    SHOW_ALL_PAGE("/show_all"),
    AUTHORIZATION_PAGE("Authorization.jsp");

    private final String page;

    Pages(String claim) {
        this.page = claim;
    }

    public String getPage() {
        return page;
    }


    @Override
    public String toString() {
        return this.getPage();
    }
}
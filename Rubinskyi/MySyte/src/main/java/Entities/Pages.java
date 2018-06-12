package Entities;

public enum Pages {
    FIST_PAGE("index.jsp"),
    REGISTRATION_PAGE("Registration.jsp"),
    ERROR_PAGE("Error.jsp"),
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
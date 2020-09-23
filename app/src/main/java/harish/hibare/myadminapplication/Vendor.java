package harish.hibare.myadminapplication;

public class Vendor {
    private String organisation;
    private String email;
    private String status;

    public Vendor(String organisation, String email, String status) {
        this.organisation = organisation;
        this.email = email;
        this.status = status;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }
}

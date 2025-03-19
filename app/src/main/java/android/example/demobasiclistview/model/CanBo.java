package android.example.demobasiclistview.model;

public class CanBo {
    private int id;
    private String name;
    private String role;
    private String phoneNumber;
    private String email;
    private String donVi;

    public CanBo(String name, String role, String phoneNumber, String email, String donvi) {
        this.name = name;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.donVi = donvi;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDonvi() {
        return donVi;
    }

    public void setDonvi(String donvi) {
        this.donVi = donvi;
    }
}

class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = isValidName(firstName) ? firstName : "";
    }

    public void setLastName(String lastName) {
        this.lastName = isValidName(lastName) ? lastName : "";
    }

    public String getFullName() {
        String fullName = (this.firstName + " " + this.lastName).trim();
        return fullName.isEmpty() ? "Unknown" : fullName;
    }

    private boolean isValidName(String name) {
        return name != null && !"".equals(name);
    }
}
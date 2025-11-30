package manager;

import java.io.Serializable;

public class Customer implements Serializable{

    private String cusCode, name, phone, email;

    public Customer() {
    }

    public Customer(String cusCode, String name, String phone, String email) {
        this.cusCode = cusCode;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Customer(String customerCode) {
        this.cusCode = customerCode;
    }

    @Override
    public boolean equals(Object obj) {
        Customer c = (Customer) obj;
        return this.cusCode.equals(c.cusCode);
    }

    public String getCustomerCode() {
        return cusCode;
    }

    public void setCustomerCode(String customerCode) {
        this.cusCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String formateName() {
        String trimName = name.replaceAll("\\s+", " ").trim();
        int lastSpaceIndex = trimName.lastIndexOf(" ");

        if (lastSpaceIndex == -1) {
            return trimName;
        }

        String lastName = trimName.substring(lastSpaceIndex + 1).trim();
        String remainName = trimName.substring(0, lastSpaceIndex).trim();

        return lastName + ", " + remainName;
    }
    @Override
    public String toString() {
        return "Customer Code: " + cusCode + ", Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

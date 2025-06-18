package com.oopproject.model.customer;

import java.time.LocalDate;

public class Customer {
    private String fullName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private DocumentType documentType;
    private Long documentNumber;
    private Occupation occupation;
    private Address address;

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", documentType=" + documentType +
                ", documentNumber=" + documentNumber +
                ", occupation=" + occupation +
                ", address=" + address +
                '}';
    }
}

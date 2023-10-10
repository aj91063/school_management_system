package com.aj.mvc1.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class Contact extends BaseEntity {
    private int contactId;
    @NotBlank(message = "Name must be blank required")
    @Size(min = 3, message = "Name must be at least 3 character.")
    private String name;

    @NotBlank(message = "Mobile number must be blank required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits.")
    private String mobileNum;

    @NotBlank(message = "Email must be blank required")
    @Email(message = "Please provide a valid email.")
    private String email;

    @NotBlank(message = "Subject must be blank required")
    private String subject;

    @NotBlank(message = "Message must be blanck required")
    String message;
    private String status;
}

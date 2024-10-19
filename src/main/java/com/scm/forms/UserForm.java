package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

  @NotBlank(message = "Name Required")
  @Size(min = 3, message = "Min 3 letter req")
  private String name;

  @NotBlank(message = "Email Required")
  @Email(message = "Invalid email")
  private String email;

  @NotBlank(message = "Password is req")
  @Size(min = 6, message = "Min 6 character req")
  private String password;

  @NotBlank(message = "about is req")
  private String about;

  @NotBlank(message = "phone number req")
  @Size(min = 10, max = 12, message = "Invalid Phone Number")
  private String phonenumber;
}

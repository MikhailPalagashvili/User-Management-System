package com.grantcs.usermanagementsystem.domain;

import com.grantcs.usermanagementsystem.GroupOrder.ValidGroup1;
import com.grantcs.usermanagementsystem.GroupOrder.ValidGroup2;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {
    @NotBlank(groups = ValidGroup1.class)
    @Email(groups = ValidGroup2.class)
    private String userId;
    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 4, max = 100, groups = ValidGroup2.class)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
    private String password;
    @NotBlank(groups = ValidGroup1.class)
    private String userName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(groups = ValidGroup1.class)
    private Date birthday;
    @Min(value = 20, groups = ValidGroup1.class)
    @Max(value = 100, groups = ValidGroup1.class)
    private Integer age;
    @NotNull(groups = ValidGroup1.class)
    private Integer gender;
    @NumberFormat(pattern = "#,###")
    private Integer salary;
}

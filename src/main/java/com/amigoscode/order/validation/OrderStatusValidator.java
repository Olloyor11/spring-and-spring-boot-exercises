package com.amigoscode.order.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

// TODO: 4 - Implement the ConstraintValidator for @ValidOrderStatus:
//  - Implement ConstraintValidator<ValidOrderStatus, String>
//  - Define a List of valid statuses: PENDING, SHIPPED, DELIVERED, CANCELLED
//  - In isValid(), return true if value is null (let @NotBlank handle null) or if value is in the list
public class OrderStatusValidator implements ConstraintValidator<ValidOrderStatus, String> {

    public static final List<String> VALIDATORS = List.of("PENDING", "SHIPPED", "DELIVERED", "CANCELLED");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || VALIDATORS.contains(value);
    }
}

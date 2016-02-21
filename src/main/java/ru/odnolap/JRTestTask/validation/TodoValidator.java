package ru.odnolap.JRTestTask.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.odnolap.JRTestTask.domain.Todo;

@Component
public class TodoValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Todo.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descr", "required.descr", "Description is required!");
    }
}

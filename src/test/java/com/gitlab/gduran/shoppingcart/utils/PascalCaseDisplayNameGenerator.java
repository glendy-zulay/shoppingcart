package com.gitlab.gduran.shoppingcart.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayNameGenerator;
import java.lang.reflect.Method;

public class PascalCaseDisplayNameGenerator  implements DisplayNameGenerator {
    @Override
    public String generateDisplayNameForClass(final Class<?> aClass) {
        return pascalCaseToSpaceSeparatedPascalCase(aClass.getSimpleName());
    }

    @Override
    public String generateDisplayNameForNestedClass(final Class<?> aClass) {
        return pascalCaseToSpaceSeparatedPascalCase(aClass.getSimpleName());
    }

    @Override
    public String generateDisplayNameForMethod(final Class<?> aClass, Method method) {
        return pascalCaseToSpaceSeparatedPascalCase(method.getName());
    }

    private static String pascalCaseToSpaceSeparatedPascalCase(final String name){
        return StringUtils.capitalize(
                String.join(" ", StringUtils.splitByCharacterTypeCamelCase(name)).toLowerCase());
    }
}

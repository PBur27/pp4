package pl.PBur27.creditcard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
public class AssertjTest {

    @Test
    void helloAssert(){
        var hello = "Hello world";
        assertThat(hello).containsOnlyDigits();
    }

    @Test
    void testSomeListExpression() {
        var names = Collections.singleton("Paweł");

        assertThat(names)
                .isUnmodifiable()
                .hasSize(1)
                .containsAll(Arrays.asList("Paweł"));
    }
}


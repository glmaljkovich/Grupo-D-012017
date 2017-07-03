package grupod.desapp.unq.edu.ar.model;

import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.reflections.ReflectionUtils.*;

/**
 * Created by gabriel on 09/06/17.
 */

public class IntegrationTest {

    @Test
    public void testAllPublicMethodsInServicesAreTransactional(){
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("grupod.desapp.unq.edu.ar"))
                .filterInputsBy(new FilterBuilder().exclude("grupod.desapp.unq.edu.ar.security.*"))
                .setScanners(new SubTypesScanner(),
                        new TypeAnnotationsScanner(),
                        new MethodAnnotationsScanner()));

        Set<Class<?>> services = reflections.getTypesAnnotatedWith(Service.class);

        for (Class<?> service : services) {
            Set<Method> transactionalMethods = getAllMethods(service, withAnnotation(Transactional.class));
            Set<Method> publicMethods = getAllMethods(service, withModifier(Modifier.PUBLIC));

            assertTrue(transactionalMethods.containsAll(publicMethods));
        }
    }
}

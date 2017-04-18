package org.apache.syncope.core.rest.cxf;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedWebappClassLoader;
import org.springframework.util.ClassUtils;

public final class JavaDocUtils {

    public static URL[] getJavaDocURLs() {
        URL[] result = null;

        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();

        if (classLoader instanceof TomcatEmbeddedWebappClassLoader) {
            classLoader = classLoader.getParent();
        }

        if (classLoader instanceof URLClassLoader) {
            List<URL> javaDocURLs = new ArrayList<>();
            for (URL url : ((URLClassLoader) classLoader).getURLs()) {
                String filename = StringUtils.substringAfterLast(url.toExternalForm(), "/");
                if (filename.startsWith("syncope-") && filename.endsWith("-javadoc.jar")) {
                    javaDocURLs.add(url);
                }
            }
            if (!javaDocURLs.isEmpty()) {
                result = javaDocURLs.toArray(new URL[javaDocURLs.size()]);
            }
        }

        return result;
    }

    private JavaDocUtils() {
        // private constructor for static utility class
    }
}
